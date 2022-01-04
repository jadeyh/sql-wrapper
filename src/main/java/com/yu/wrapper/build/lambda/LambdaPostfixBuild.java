package com.yu.wrapper.build.lambda;

import com.yu.wrapper.build.PostfixBuild;
import com.yu.wrapper.lambda.SFunction;

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
