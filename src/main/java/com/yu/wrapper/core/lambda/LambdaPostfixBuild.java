package com.yu.wrapper.core.lambda;

import com.yu.wrapper.core.PostfixBuild;
import com.yu.wrapper.core.toolkits.utils.lambdaUtils.BeanColumnFieldUtil;
import com.yu.wrapper.core.toolkits.utils.lambdaUtils.SFunction;

public interface LambdaPostfixBuild<ImplClass> extends PostfixBuild<ImplClass> {
    default <T> ImplClass groupBy(SFunction<T, ?> column) {
        return groupBy(true, column);
    }

    /**
     * 分组（带泛型的vararg可能导致不安全，推荐使用BeanColumnFieldUtil.getColumnNamesByLambdas）
     */
    default <T> ImplClass groupBy(boolean condition, SFunction<T, ?> column) {
        return groupBy(condition, BeanColumnFieldUtil.getColumnNameByLambda(column));
    }

    default <T> ImplClass orderBy(boolean isAsc, SFunction<T, ?> column) {
        return orderBy(true, isAsc, column);
    }

    /**
     * 排序（带泛型的vararg可能导致不安全，推荐使用BeanColumnFieldUtil.getColumnNamesByLambdas）
     */
    default <T> ImplClass orderBy(boolean condition, boolean isAsc, SFunction<T, ?> column) {
        return orderBy(condition, isAsc, BeanColumnFieldUtil.getColumnNameByLambda(column));
    }
}
