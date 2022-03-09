package com.yu.wrapper.core.lambda;

import com.yu.wrapper.core.UpdateBuild;
import com.yu.wrapper.core.toolkits.utils.lambdaUtils.BeanColumnFieldUtil;
import com.yu.wrapper.core.toolkits.utils.lambdaUtils.SFunction;

public interface LambdaUpdateBuild<ImplClass> extends UpdateBuild<ImplClass> {
    default <T> ImplClass update(SFunction<T, ?> column, Object val) {
        return update(true, column, val);
    }

    default <T> ImplClass update(boolean condition, SFunction<T, ?> column, Object val) {
        return update(condition, column, val, null);
    }

    default <T> ImplClass update(SFunction<T, ?> column, Object val, String mapping) {
        return update(true, column, val, mapping);
    }

    /**
     * 查询字段（带泛型的vararg可能导致不安全，推荐使用BeanColumnFieldUtil.getColumnNamesByLambdas）
     */
    default <T> ImplClass update(boolean condition, SFunction<T, ?> column, Object val, String mapping) {
        return update(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val, mapping);
    }
}
