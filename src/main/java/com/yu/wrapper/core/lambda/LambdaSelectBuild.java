package com.yu.wrapper.core.lambda;

import com.yu.wrapper.core.SelectBuild;
import com.yu.wrapper.core.toolkits.utils.lambdaUtils.BeanColumnFieldUtil;
import com.yu.wrapper.core.toolkits.utils.lambdaUtils.SFunction;

import java.util.List;

public interface LambdaSelectBuild<ImplClass> extends SelectBuild<ImplClass> {
    /**
     * 查询字段（带泛型的vararg可能导致不安全，推荐使用BeanColumnFieldUtil.getColumnNamesByLambdas）
     */
    default <T> ImplClass select(List<SFunction<T, ?>> columns) {
        return select(BeanColumnFieldUtil.getColumnNamesByLambdas(columns));
    }
}
