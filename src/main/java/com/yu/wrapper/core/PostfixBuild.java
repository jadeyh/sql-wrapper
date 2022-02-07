package com.yu.wrapper.core;

import java.util.Arrays;
import java.util.List;

public interface PostfixBuild<ImplClass> {
    default ImplClass groupBy(String... columns) {
        return groupBy(true, columns);
    }

    default ImplClass groupBy(boolean condition, String... columns) {
        return groupBy(condition, Arrays.asList(columns));
    }

    default ImplClass groupBy(List<String> columns) {
        return groupBy(true, columns);
    }

    /**
     * 分组
     */
    ImplClass groupBy(boolean condition, List<String> columns);

    default ImplClass orderBy(boolean isAsc, String... columns) {
        return orderBy(true, isAsc, columns);
    }

    default ImplClass orderBy(boolean condition, boolean isAsc, String... columns) {
        return orderBy(condition, isAsc, Arrays.asList(columns));
    }

    default ImplClass orderBy(boolean isAsc, List<String> columns) {
        return orderBy(true, isAsc, columns);
    }

    /**
     * 排序
     */
    ImplClass orderBy(boolean condition, boolean isAsc, List<String> columns);

    default ImplClass having(String havingSql, Object... params) {
        return having(true, havingSql, params);
    }

    /**
     * HAVING
     */
    ImplClass having(boolean condition, String havingSql, Object... params);
}
