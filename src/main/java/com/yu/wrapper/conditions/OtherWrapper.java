package com.yu.wrapper.conditions;

import java.util.List;

public interface OtherWrapper {
    
    default OtherWrapper groupBy(String column) {
        return groupBy(true, column);
    }

    /**
     * 分组
     */
    OtherWrapper groupBy(boolean condition, String column);



    /**
     * 分组
     */
    OtherWrapper groupBy(boolean condition, List<String> columns);

    default OtherWrapper groupBy(List<String> columns) {
        return groupBy(true, columns);
    }

    default OtherWrapper groupBy(String column, String... columns) {
        return groupBy(true, column, columns);
    }

    /**
     * 分组
     */
    OtherWrapper groupBy(boolean condition, String column, String... columns);

    /**
     * 排序 正序
     */
    default OtherWrapper orderByAsc(boolean condition, String column) {
        return orderBy(condition, true, column);
    }

    default OtherWrapper orderByAsc(String column) {
        return orderByAsc(true, column);
    }

    /**
     * 排序 正序
     */
    default OtherWrapper orderByAsc(boolean condition, List<String> columns) {
        return orderBy(condition, true, columns);
    }

    default OtherWrapper orderByAsc(List<String> columns) {
        return orderByAsc(true, columns);
    }

    default OtherWrapper orderByAsc(String column, String... columns) {
        return orderByAsc(true, column, columns);
    }

    /**
     * 排序 正序
     */
    default OtherWrapper orderByAsc(boolean condition, String column, String... columns) {
        return orderBy(condition, true, column, columns);
    }

    /**
     * 排序 倒序
     */
    default OtherWrapper orderByDesc(boolean condition, String column) {
        return orderBy(condition, false, column);
    }

    default OtherWrapper orderByDesc(String column) {
        return orderByDesc(true, column);
    }

    /**
     * 排序
     */
    default OtherWrapper orderByDesc(boolean condition, List<String> columns) {
        return orderBy(condition, false, columns);
    }

    default OtherWrapper orderByDesc(List<String> columns) {
        return orderByDesc(true, columns);
    }

    default OtherWrapper orderByDesc(String column, String... columns) {
        return orderByDesc(true, column, columns);
    }

    /**
     * 排序
     */
    default OtherWrapper orderByDesc(boolean condition, String column, String... columns) {
        return orderBy(condition, false, column, columns);
    }

    /**
     * 排序
     */
    OtherWrapper orderBy(boolean condition, boolean isAsc, String column);

    /**
     * 排序
     */
    OtherWrapper orderBy(boolean condition, boolean isAsc, List<String> columns);

    /**
     * 排序
     */
    OtherWrapper orderBy(boolean condition, boolean isAsc, String column, String... columns);

    default OtherWrapper having(String sqlHaving, Object... params) {
        return having(true, sqlHaving, params);
    }

    /**
     * HAVING
     */
    OtherWrapper having(boolean condition, String sqlHaving, Object... params);
}
