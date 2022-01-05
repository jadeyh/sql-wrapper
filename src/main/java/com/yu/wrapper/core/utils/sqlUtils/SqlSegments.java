package com.yu.wrapper.core.utils.sqlUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlSegments {
    private List<String> whereSql = new ArrayList<>();

    private List<String> groupBySql = new ArrayList<>();

    private List<String> havingSql = new ArrayList<>();

    private List<String> orderBySql = new ArrayList<>();

    public void add(String... segments) {
        List<String> list = Arrays.asList(segments);
        String firstSegment = list.get(0);
        if (MatchSegment.ORDER_BY.match(firstSqlSegment)) {
            orderBy.addAll(list);
        } else if (MatchSegment.GROUP_BY.match(firstSqlSegment)) {
            groupBy.addAll(list);
        } else if (MatchSegment.HAVING.match(firstSqlSegment)) {
            having.addAll(list);
        } else {
            normal.addAll(list);
        }
        whereSql.add
        cacheSqlSegment = false;
    }
}
