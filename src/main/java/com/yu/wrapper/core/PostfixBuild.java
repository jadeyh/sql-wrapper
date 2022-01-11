package com.yu.wrapper.core;

public interface PostfixBuild<ImplClass> {
    default ImplClass groupBy(String column) {
        return groupBy(true, column);
    }

    /**
     * 分组
     */
    ImplClass groupBy(boolean condition, String column);

    default ImplClass groupBy(String... columns) {
        return groupBy(true, columns);
    }

    /**
     * 分组
     */
    ImplClass groupBy(boolean condition, String... columns);

    default ImplClass orderBy(boolean isAsc, String column) {
        return orderBy(true, isAsc, column);
    }

    /**
     * 排序
     */
    ImplClass orderBy(boolean condition, boolean isAsc, String column);

    default ImplClass orderBy(boolean isAsc, String... columns) {
        return orderBy(true, isAsc, columns);
    }

    /**
     * 排序
     */
    ImplClass orderBy(boolean condition, boolean isAsc, String... columns);

    default ImplClass having(String sqlHaving, Object... params) {
        return having(true, sqlHaving, params);
    }

    /**
     * HAVING
     */
    ImplClass having(boolean condition, String sqlHaving, Object... params);
}
