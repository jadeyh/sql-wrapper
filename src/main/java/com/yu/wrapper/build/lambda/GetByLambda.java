package com.yu.wrapper.build.lambda;

import com.yu.wrapper.lambda.SFunction;

public interface GetByLambda {
    <T> String getColumnName(SFunction<T, ?> func);

    <T> String getColumnNames(SFunction<T, ?>... funcs);
}
