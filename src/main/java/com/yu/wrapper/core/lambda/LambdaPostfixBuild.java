package com.yu.wrapper.core.lambda;

import com.yu.wrapper.core.PostfixBuild;
import com.yu.wrapper.core.toolkits.lambdaUtils.SFunction;

public interface LambdaPostfixBuild<ImplClass> extends PostfixBuild<ImplClass>, GetByLambda {
    default <T> ImplClass groupBy(SFunction<T, ?> column) {
        return groupBy(true, column);
    }

    /**
     * 分组
     */
    default <T> ImplClass groupBy(boolean condition, SFunction<T, ?> column) {
        return groupBy(condition, getColumnName(column));
    }

    default <T> ImplClass groupBy(SFunction<T, ?>... columns) {
        return groupBy(true, getColumnNames(columns));
    }

    /**
     * 分组
     */
    default <T> ImplClass groupBy(boolean condition, SFunction<T, ?>... columns) {
        return groupBy(condition, getColumnNames(columns));
    }

    default <T> ImplClass orderBy(boolean isAsc, SFunction<T, ?> column) {
        return orderBy(true, isAsc, column);
    }

    /**
     * 排序
     */
    default <T> ImplClass orderBy(boolean condition, boolean isAsc, SFunction<T, ?> column) {
        return orderBy(condition, isAsc, getColumnName(column));
    }

    default <T> ImplClass orderBy(boolean isAsc, SFunction<T, ?>... columns) {
        return orderBy(true, isAsc, columns);
    }

    /**
     * 排序
     */
    default <T> ImplClass orderBy(boolean condition, boolean isAsc, SFunction<T, ?>... columns) {
        return orderBy(condition, isAsc, getColumnNames(columns));
    }
}
