package com.yu.wrapper.core.lambda;

import com.yu.wrapper.core.PostfixBuild;
import com.yu.wrapper.core.utils.lambdaUtils.SFunction;

public interface LambdaPostfixBuild extends PostfixBuild, GetByLambda {
    default <T> PostfixBuild groupBy(SFunction<T, ?> column) {
        return groupBy(true, column);
    }

    /**
     * 分组
     */
    default <T> PostfixBuild groupBy(boolean condition, SFunction<T, ?> column) {
        return groupBy(condition, getColumnName(column));
    }

    default <T> PostfixBuild groupBy(SFunction<T, ?>... columns) {
        return groupBy(true, getColumnNames(columns));
    }

    /**
     * 分组
     */
    default <T> PostfixBuild groupBy(boolean condition, SFunction<T, ?>... columns) {
        return groupBy(condition, getColumnNames(columns));
    }

    default <T> PostfixBuild orderBy(boolean isAsc, SFunction<T, ?> column) {
        return orderBy(true, isAsc, column);
    }

    /**
     * 排序
     */
    default <T> PostfixBuild orderBy(boolean condition, boolean isAsc, SFunction<T, ?> column) {
        return orderBy(condition, isAsc, getColumnName(column));
    }

    default <T> PostfixBuild orderBy(boolean isAsc, SFunction<T, ?>... columns) {
        return orderBy(true, isAsc, columns);
    }

    /**
     * 排序
     */
    default <T> PostfixBuild orderBy(boolean condition, boolean isAsc, SFunction<T, ?>... columns) {
        return orderBy(condition, isAsc, getColumnNames(columns));
    }
}
