package com.yu.wrapper.core.Wrapper;

import com.yu.wrapper.core.PostfixBuild;
import com.yu.wrapper.core.WhereBuild;
import com.yu.wrapper.core.lambda.LambdaPostfixBuild;
import com.yu.wrapper.core.lambda.LambdaWhereBuild;

import java.util.Collection;
import java.util.function.Consumer;

public class LambdaSelectWrapper implements LambdaWhereBuild, LambdaPostfixBuild {
    @Override
    public WhereBuild eq(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild ne(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild gt(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild ge(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild lt(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild le(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild between(boolean condition, String column, Object val1, Object val2) {
        return null;
    }

    @Override
    public WhereBuild notBetween(boolean condition, String column, Object val1, Object val2) {
        return null;
    }

    @Override
    public WhereBuild like(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild notLike(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild likeLeft(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild likeStringight(boolean condition, String column, Object val) {
        return null;
    }

    @Override
    public WhereBuild isNull(boolean condition, String column) {
        return null;
    }

    @Override
    public WhereBuild isNotNull(boolean condition, String column) {
        return null;
    }

    @Override
    public WhereBuild in(boolean condition, String column, Collection<?> coll) {
        return null;
    }

    @Override
    public WhereBuild in(boolean condition, String column, Object... values) {
        return null;
    }

    @Override
    public WhereBuild notIn(boolean condition, String column, Collection<?> coll) {
        return null;
    }

    @Override
    public WhereBuild notIn(boolean condition, String column, Object... values) {
        return null;
    }

    @Override
    public WhereBuild and(boolean condition, Consumer<WhereBuild> consumer) {
        return null;
    }

    @Override
    public WhereBuild or(boolean condition, Consumer<WhereBuild> consumer) {
        return null;
    }

    @Override
    public WhereBuild or(boolean condition) {
        return null;
    }

    @Override
    public WhereBuild nested(boolean condition, Consumer<WhereBuild> consumer) {
        return null;
    }

    @Override
    public WhereBuild not(boolean condition, Consumer<WhereBuild> consumer) {
        return null;
    }

    @Override
    public WhereBuild applySql(boolean condition, String applySql, Object... values) {
        return null;
    }

    @Override
    public PostfixBuild groupBy(boolean condition, String column) {
        return null;
    }

    @Override
    public PostfixBuild groupBy(boolean condition, String... columns) {
        return null;
    }

    @Override
    public PostfixBuild orderBy(boolean condition, boolean isAsc, String column) {
        return null;
    }

    @Override
    public PostfixBuild orderBy(boolean condition, boolean isAsc, String... columns) {
        return null;
    }

    @Override
    public PostfixBuild having(boolean condition, String sqlHaving, Object... params) {
        return null;
    }
}
