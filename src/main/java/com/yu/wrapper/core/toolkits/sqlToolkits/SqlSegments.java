package com.yu.wrapper.core.toolkits.sqlToolkits;

import cn.hutool.core.util.ArrayUtil;
import com.yu.wrapper.core.toolkits.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class SqlSegments implements SqlString {
    private List<SqlString> whereSql = new ArrayList<>();

    private List<SqlString> groupBySql = new ArrayList<>();

    private List<SqlString> havingSql = new ArrayList<>();

    private List<SqlString> orderBySql = new ArrayList<>();

    public void add(SqlString... sqlStrings) {
        if (ArrayUtil.isEmpty(sqlStrings)) {
            return;
        }
        List<SqlString> list = Arrays.stream(sqlStrings).collect(Collectors.toList());
        SqlString firstSqlString = list.get(0);
        if (SqlKeyword.ORDER_BY.match(firstSqlString)) {
            list.remove(0);
            orderBySql.addAll(list);
        } else if (SqlKeyword.GROUP_BY.match(firstSqlString)) {
            list.remove(0);
            groupBySql.addAll(list);
        } else if (SqlKeyword.HAVING.match(firstSqlString)) {
            list.remove(0);
            havingSql.addAll(list);
        } else {
            SqlString listFirst = list.get(0);
            SqlString lastValue = !whereSql.isEmpty() ? whereSql.get(whereSql.size() - 1) : null;
            if (SqlKeyword.AND.match(listFirst) || SqlKeyword.OR.match(listFirst)) { //当前操作是是and或者or
                if (lastValue == null) { //前面没有别的sql不加and或者or
                    return;
                }
                if (SqlKeyword.AND.match(lastValue) || SqlKeyword.OR.match(lastValue)) { //上次操作也是and或者or的，如果跟这次不一样，则以这次的为准
                    if (lastValue != listFirst) {
                        list.remove(list.size() - 1);
                    }
                }
            } else if (SqlKeyword.APPLY.match(listFirst)) { //当前操作是是apply
                list.remove(0);
            } else {
                add(SqlKeyword.AND);
            }
            whereSql.addAll(list);
        }
    }

    @Override
    public String getSqlString() {
        return  whereSqlSegments() + groupBySqlSegments() + havingSqlSegments() + orderBySqlSegments();
    }

    protected String whereSqlSegments() {
        if (whereSql.isEmpty()) {
            return Constants.EMPTY;
        }
        //去除sql最后的and或or
        while (SqlKeyword.AND.match(whereSql.get(whereSql.size() - 1)) || SqlKeyword.OR.match(whereSql.get(whereSql.size() - 1))) {
            whereSql.remove(whereSql.size() - 1);
        }
        return whereSql.stream().map(SqlString::getSqlString).collect(Collectors.joining(Constants.SPACE, Constants.LEFT_BRACKET, Constants.RIGHT_BRACKET));
    }

    protected String groupBySqlSegments() {
        if (groupBySql.isEmpty()) {
            return Constants.EMPTY;
        }
        return groupBySql.stream().map(SqlString::getSqlString).collect(joining(Constants.COMMA, Constants.SPACE + SqlKeyword.GROUP_BY + Constants.SPACE, Constants.EMPTY));
    }

    protected String havingSqlSegments() {
        if (havingSql.isEmpty()) {
            return Constants.EMPTY;
        }
        return havingSql.stream().map(SqlString::getSqlString).collect(joining(Constants.SPACE, Constants.SPACE + SqlKeyword.HAVING + Constants.SPACE, Constants.EMPTY));
    }

    protected String orderBySqlSegments() {
        if (orderBySql.isEmpty()) {
            return Constants.EMPTY;
        }
        return orderBySql.stream().map(SqlString::getSqlString).collect(joining(Constants.COMMA, Constants.SPACE + SqlKeyword.ORDER_BY + Constants.SPACE, Constants.EMPTY));
    }
}
