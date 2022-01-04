package com.yu.wrapper.build;

public interface PostfixBuild {
    default PostfixBuild groupBy(String column) {
        return groupBy(true, column);
    }

    /**
     * 分组
     */
    PostfixBuild groupBy(boolean condition, String column);

    default PostfixBuild groupBy(String... columns) {
        return groupBy(true, columns);
    }

    /**
     * 分组
     */
    PostfixBuild groupBy(boolean condition, String... columns);

    default PostfixBuild orderBy(boolean isAsc, String column) {
        return orderBy(true, isAsc, column);
    }

    /**
     * 排序
     */
    PostfixBuild orderBy(boolean condition, boolean isAsc, String column);

    default PostfixBuild orderBy(boolean isAsc, String... columns) {
        return orderBy(true, isAsc, columns);
    }

    /**
     * 排序
     */
    PostfixBuild orderBy(boolean condition, boolean isAsc, String... columns);

    default PostfixBuild having(String sqlHaving, Object... params) {
        return having(true, sqlHaving, params);
    }

    /**
     * HAVING
     */
    PostfixBuild having(boolean condition, String sqlHaving, Object... params);
}
