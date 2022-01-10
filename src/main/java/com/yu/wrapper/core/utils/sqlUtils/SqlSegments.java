package com.yu.wrapper.core.utils.sqlUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlSegments {
    private List<SqlString> whereSql = new ArrayList<>();

    private List<SqlString> groupBySql = new ArrayList<>();

    private List<SqlString> havingSql = new ArrayList<>();

    private List<SqlString> orderBySql = new ArrayList<>();

    public void add(SqlString... sqlStrings) {
        List<SqlString> list = Arrays.asList(sqlStrings);
        SqlString firstSqlString = list.get(0);
        if (SqlMatch.ORDER_BY.match(firstSqlString)) {
            orderBySql.addAll(list);
        } else if (SqlMatch.GROUP_BY.match(firstSqlString)) {
            groupBySql.addAll(list);
        } else if (SqlMatch.HAVING.match(firstSqlString)) {
            havingSql.addAll(list);
        } else {
            whereSql.addAll(list);
        }
    }
}
