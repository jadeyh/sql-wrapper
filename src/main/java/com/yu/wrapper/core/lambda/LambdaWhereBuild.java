package com.yu.wrapper.core.lambda;

import com.yu.wrapper.core.WhereBuild;
import com.yu.wrapper.core.toolkits.utils.lambdaUtils.BeanColumnFieldUtil;
import com.yu.wrapper.core.toolkits.utils.lambdaUtils.SFunction;

import java.util.Collection;

public interface LambdaWhereBuild<ImplClass extends LambdaWhereBuild<ImplClass>> extends WhereBuild<ImplClass> {
    default <T> ImplClass eq(SFunction<T, ?> column, Object val) {
        return eq(true, column, val);
    }

    /**
     * 等于
     */
    default <T> ImplClass eq(boolean condition, SFunction<T, ?> column, Object val) {
        return eq(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass ne(SFunction<T, ?> column, Object val) {
        return ne(true, column, val);
    }

    /**
     * 不等于
     */
    default <T> ImplClass ne(boolean condition, SFunction<T, ?> column, Object val) {
        return ne(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass gt(SFunction<T, ?> column, Object val) {
        return gt(true, column, val);
    }

    /**
     * 大于
     */
    default <T> ImplClass gt(boolean condition, SFunction<T, ?> column, Object val) {
        return gt(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass ge(SFunction<T, ?> column, Object val) {
        return ge(true, column, val);
    }

    /**
     * 大于等于
     */
    default <T> ImplClass ge(boolean condition, SFunction<T, ?> column, Object val) {
        return ge(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass lt(SFunction<T, ?> column, Object val) {
        return lt(true, column, val);
    }

    /**
     * 小于
     */
    default <T> ImplClass lt(boolean condition, SFunction<T, ?> column, Object val) {
        return lt(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass le(SFunction<T, ?> column, Object val) {
        return le(true, column, val);
    }

    /**
     * 小于等于
     */
    default <T> ImplClass le(boolean condition, SFunction<T, ?> column, Object val) {
        return le(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass between(SFunction<T, ?> column, Object val1, Object val2) {
        return between(true, column, val1, val2);
    }

    /**
     * BETWEEN 值1 AND 值2
     */
    default <T> ImplClass between(boolean condition, SFunction<T, ?> column, Object val1, Object val2) {
        return between(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val1, val2);
    }

    default <T> ImplClass notBetween(SFunction<T, ?> column, Object val1, Object val2) {
        return notBetween(true, column, val1, val2);
    }

    /**
     * NOT BETWEEN 值1 AND 值2
     */
    default <T> ImplClass notBetween(boolean condition, SFunction<T, ?> column, Object val1, Object val2) {
        return notBetween(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val1, val2);
    }

    default <T> ImplClass like(SFunction<T, ?> column, Object val) {
        return like(true, column, val);
    }

    /**
     * LIKE '%值%'
     */
    default <T> ImplClass like(boolean condition, SFunction<T, ?> column, Object val) {
        return like(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass notLike(SFunction<T, ?> column, Object val) {
        return notLike(true, column, val);
    }

    /**
     * NOT LIKE '%值%'
     */
    default <T> ImplClass notLike(boolean condition, SFunction<T, ?> column, Object val) {
        return notLike(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass likeLeft(SFunction<T, ?> column, Object val) {
        return likeLeft(true, column, val);
    }

    /**
     * LIKE '%值'
     */
    default <T> ImplClass likeLeft(boolean condition, SFunction<T, ?> column, Object val) {
        return likeLeft(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass likeStringight(SFunction<T, ?> column, Object val) {
        return likeStringight(true, column, val);
    }

    /**
     * LIKE '值%'
     */
    default <T> ImplClass likeStringight(boolean condition, SFunction<T, ?> column, Object val) {
        return likeRight(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), val);
    }

    default <T> ImplClass isNull(SFunction<T, ?> column) {
        return isNull(true, column);
    }

    /**
     * 字段 IS NULL
     */
    default <T> ImplClass isNull(boolean condition, SFunction<T, ?> column) {
        return isNull(condition, BeanColumnFieldUtil.getColumnNameByLambda(column));
    }

    default <T> ImplClass isNotNull(SFunction<T, ?> column) {
        return isNotNull(true, column);
    }

    /**
     * 字段 IS NOT NULL
     */
    default <T> ImplClass isNotNull(boolean condition, SFunction<T, ?> column) {
        return isNotNull(condition, BeanColumnFieldUtil.getColumnNameByLambda(column));
    }

    default <T> ImplClass in(SFunction<T, ?> column, Collection<?> coll) {
        return in(true, column, coll);
    }

    /**
     * 字段 IN (value.get(0), value.get(1), ...)
     * 例: in("id", Arrays.asList(1, 2, 3, 4, 5))
     *
     * 注意！集合为空若存在逻辑错误，请在 condition 条件中判断
     * 如果集合为 empty 则不会进行 sql 拼接
     *
     */
    default <T> ImplClass in(boolean condition, SFunction<T, ?> column, Collection<?> coll) {
        return in(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), coll);
    }

    default <T> ImplClass in(SFunction<T, ?> column, Object... values) {
        return in(true, column, values);
    }

    /**
     * 字段 IN (v0, v1, ...)
     * 例: in("id", 1, 2, 3, 4, 5)
     *
     * 注意！数组为空若存在逻辑错误，请在 condition 条件中判断
     * 如果动态数组为 empty 则不会进行 sql 拼接
     */
    default <T> ImplClass in(boolean condition, SFunction<T, ?> column, Object... values) {
        return in(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), values);
    }

    default <T> ImplClass notIn(SFunction<T, ?> column, Collection<?> coll) {
        return notIn(true, column, coll);
    }

    /**
     * 字段 NOT IN (value.get(0), value.get(1), ...)
     * 例: notIn("id", Arrays.asList(1, 2, 3, 4, 5))
     */
    default <T> ImplClass notIn(boolean condition, SFunction<T, ?> column, Collection<?> coll) {
        return notIn(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), coll);
    }

    default <T> ImplClass notIn(SFunction<T, ?> column, Object... value) {
        return notIn(true, column, value);
    }

    /**
     * 字段 NOT IN (v0, v1, ...)
     * 例: notIn("id", 1, 2, 3, 4, 5)
     */
    default <T> ImplClass notIn(boolean condition, SFunction<T, ?> column, Object... values) {
        return notIn(condition, BeanColumnFieldUtil.getColumnNameByLambda(column), values);
    }
}
