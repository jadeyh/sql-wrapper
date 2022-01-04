package com.yu.wrapper.conditions;

import java.util.Collection;
import java.util.function.Consumer;

public interface LambdaWhereWrapper extends WhereWrapper {
    default WhereWrapper eq(String column, Object val) {
        return eq(true, column, val);
    }

    WhereWrapper eq(boolean condition, String column, Object val);

    default WhereWrapper ne(String column, Object val) {
        return ne(true, column, val);
    }

    /**
     * 不等于
     */
    WhereWrapper ne(boolean condition, String column, Object val);

    default WhereWrapper gt(String column, Object val) {
        return gt(true, column, val);
    }

    /**
     * 大于
     */
    WhereWrapper gt(boolean condition, String column, Object val);

    default WhereWrapper ge(String column, Object val) {
        return ge(true, column, val);
    }

    /**
     * 大于等于
     */
    WhereWrapper ge(boolean condition, String column, Object val);

    default WhereWrapper lt(String column, Object val) {
        return lt(true, column, val);
    }

    /**
     * 小于
     */
    WhereWrapper lt(boolean condition, String column, Object val);

    default WhereWrapper le(String column, Object val) {
        return le(true, column, val);
    }

    /**
     * 小于等于
     */
    WhereWrapper le(boolean condition, String column, Object val);

    default WhereWrapper between(String column, Object val1, Object val2) {
        return between(true, column, val1, val2);
    }

    /**
     * BETWEEN 值1 AND 值2
     */
    WhereWrapper between(boolean condition, String column, Object val1, Object val2);

    default WhereWrapper notBetween(String column, Object val1, Object val2) {
        return notBetween(true, column, val1, val2);
    }

    /**
     * NOT BETWEEN 值1 AND 值2
     */
    WhereWrapper notBetween(boolean condition, String column, Object val1, Object val2);

    default WhereWrapper like(String column, Object val) {
        return like(true, column, val);
    }

    /**
     * LIKE '%值%'
     */
    WhereWrapper like(boolean condition, String column, Object val);

    default WhereWrapper notLike(String column, Object val) {
        return notLike(true, column, val);
    }

    /**
     * NOT LIKE '%值%'
     */
    WhereWrapper notLike(boolean condition, String column, Object val);

    default WhereWrapper likeLeft(String column, Object val) {
        return likeLeft(true, column, val);
    }

    /**
     * LIKE '%值'
     */
    WhereWrapper likeLeft(boolean condition, String column, Object val);

    default WhereWrapper likeStringight(String column, Object val) {
        return likeStringight(true, column, val);
    }

    /**
     * LIKE '值%'
     */
    WhereWrapper likeStringight(boolean condition, String column, Object val);

    default WhereWrapper isNull(String column) {
        return isNull(true, column);
    }

    /**
     * 字段 IS NULL
     */
    WhereWrapper isNull(boolean condition, String column);

    default WhereWrapper isNotNull(String column) {
        return isNotNull(true, column);
    }

    /**
     * 字段 IS NOT NULL
     */
    WhereWrapper isNotNull(boolean condition, String column);

    default WhereWrapper in(String column, Collection<?> coll) {
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
    WhereWrapper in(boolean condition, String column, Collection<?> coll);

    default WhereWrapper in(String column, Object... values) {
        return in(true, column, values);
    }

    /**
     * 字段 IN (v0, v1, ...)
     * 例: in("id", 1, 2, 3, 4, 5)
     *
     * 注意！数组为空若存在逻辑错误，请在 condition 条件中判断
     * 如果动态数组为 empty 则不会进行 sql 拼接
     */
    WhereWrapper in(boolean condition, String column, Object... values);

    default WhereWrapper notIn(String column, Collection<?> coll) {
        return notIn(true, column, coll);
    }

    /**
     * 字段 NOT IN (value.get(0), value.get(1), ...)
     * 例: notIn("id", Arrays.asList(1, 2, 3, 4, 5))
     */
    WhereWrapper notIn(boolean condition, String column, Collection<?> coll);

    default WhereWrapper notIn(String column, Object... value) {
        return notIn(true, column, value);
    }

    /**
     * 字段 NOT IN (v0, v1, ...)
     * 例: notIn("id", 1, 2, 3, 4, 5)
     */
    WhereWrapper notIn(boolean condition, String column, Object... values);

    default WhereWrapper and(Consumer<WhereWrapper> consumer) {
        return and(true, consumer);
    }

    /**
     * AND 嵌套
     * 例: and(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    WhereWrapper and(boolean condition, Consumer<WhereWrapper> consumer);

    default WhereWrapper or(Consumer<WhereWrapper> consumer) {
        return or(true, consumer);
    }

    /**
     * OR 嵌套
     * 例: or(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    WhereWrapper or(boolean condition, Consumer<WhereWrapper> consumer);

    default WhereWrapper or() {
        return or(true);
    }

    /**
     * 拼接 OR
     */
    WhereWrapper or(boolean condition);

    default WhereWrapper nested(Consumer<WhereWrapper> consumer) {
        return nested(true, consumer);
    }

    /**
     * 正常嵌套 不带 AND 或者 OR
     * 例: nested(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    WhereWrapper nested(boolean condition, Consumer<WhereWrapper> consumer);

    default WhereWrapper not(Consumer<WhereWrapper> consumer) {
        return not(true, consumer);
    }

    /**
     * not嵌套
     * 例: not(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    WhereWrapper not(boolean condition, Consumer<WhereWrapper> consumer);

    default WhereWrapper applySql(String applySql, Object... values) {
        return applySql(true, applySql, values);
    }

    /**
     * 拼接 sql
     * 会有 sql 注入风险
     * 例1: apply("id = 1")
     * 例2: apply("date_format(dateColumn,'%Y-%m-%d') = '2008-08-08'")
     * 例3: apply("date_format(dateColumn,'%Y-%m-%d') = {0}", LocalDate.now())
     */
    WhereWrapper applySql(boolean condition, String applySql, Object... values);
}
