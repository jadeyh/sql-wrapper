package com.yu.wrapper.core.wrapper;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.yu.wrapper.core.PostfixBuild;
import com.yu.wrapper.core.WhereBuild;
import com.yu.wrapper.core.lambda.LambdaWhereBuild;
import com.yu.wrapper.core.toolkits.Constants;
import com.yu.wrapper.core.toolkits.mybatisToolkits.MybatisKeyword;
import com.yu.wrapper.core.toolkits.sqlToolkits.ParamMap;
import com.yu.wrapper.core.toolkits.sqlToolkits.SqlKeyword;
import com.yu.wrapper.core.toolkits.sqlToolkits.SqlSegments;
import com.yu.wrapper.core.toolkits.sqlToolkits.SqlString;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

public class LambdaSelectWrapper implements LambdaWhereBuild<LambdaSelectWrapper>, PostfixBuild<LambdaSelectWrapper> {
    protected SqlSegments sqlSegments = new SqlSegments();

    protected ParamMap paramMap = new ParamMap(Constants.WRAPPER + Constants.DOT + Constants.PARAM_MAP + Constants.DOT);

    @Override
    public LambdaSelectWrapper eq(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.EQ, toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper ne(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.NE, toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper gt(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.GT, toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper ge(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.GE, toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper lt(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.LT, toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper le(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.BETWEEN, toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper between(boolean condition, String column, Object val1, Object val2) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.BETWEEN,
                    toSqlString(paramMap.putAndGetKey(val1)), SqlKeyword.AND, toSqlString(paramMap.putAndGetKey(val2)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper notBetween(boolean condition, String column, Object val1, Object val2) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.NOT_BETWEEN,
                    toSqlString(paramMap.putAndGetKey(val1)), SqlKeyword.AND, toSqlString(paramMap.putAndGetKey(val2)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper like(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.LIKE, toSqlString(paramMap.putAndGetKey(MybatisKeyword.PERCENT + val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper notLike(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.NOT_LIKE, toSqlString(paramMap.putAndGetKey(MybatisKeyword.PERCENT + val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper likeLeft(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.LIKE, toSqlString(paramMap.putAndGetKey(MybatisKeyword.PERCENT + val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper likeStringRight(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.LIKE, toSqlString(paramMap.putAndGetKey(val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper isNull(boolean condition, String column) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.IS_NULL);
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper isNotNull(boolean condition, String column) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.IS_NOT_NULL);
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper in(boolean condition, String column, Collection<?> values) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.IN, toSqlString(values));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper in(boolean condition, String column, Object... values) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.IN, toSqlString(values));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper notIn(boolean condition, String column, Collection<?> values) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.NOT_IN, toSqlString(values));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper notIn(boolean condition, String column, Object... values) {
        if(condition) {
            sqlSegments.add(toSqlString(column), SqlKeyword.NOT_IN, toSqlString(values));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper and(boolean condition, Consumer<WhereBuild> consumer) {
        if(condition) {
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper or(boolean condition, Consumer<WhereBuild> consumer) {
        return null;
    }

    @Override
    public LambdaSelectWrapper or(boolean condition) {
        return null;
    }

    @Override
    public LambdaSelectWrapper nested(boolean condition, Consumer<WhereBuild> consumer) {
        return null;
    }

    @Override
    public LambdaSelectWrapper not(boolean condition, Consumer<WhereBuild> consumer) {
        return null;
    }

    @Override
    public LambdaSelectWrapper applySql(boolean condition, String applySql, Object... values) {
        return null;
    }

    @Override
    public LambdaSelectWrapper groupBy(boolean condition, String column) {
        return null;
    }

    @Override
    public LambdaSelectWrapper groupBy(boolean condition, String... columns) {
        return null;
    }

    @Override
    public LambdaSelectWrapper orderBy(boolean condition, boolean isAsc, String column) {
        return null;
    }

    @Override
    public LambdaSelectWrapper orderBy(boolean condition, boolean isAsc, String... columns) {
        return null;
    }

    @Override
    public LambdaSelectWrapper having(boolean condition, String sqlHaving, Object... params) {
        return null;
    }

    protected SqlString toSqlString(String s) {
        return () -> s;
    }

    /**
     * 集合获取in表达式 包含括号
     */
    protected SqlString toSqlString(Collection<?> values) {
        if (CollectionUtil.isEmpty(values)) {
            return () -> "()";
        }
        return () -> values.stream().map(i -> paramMap.putAndGetKey(i))
                .collect(joining(Constants.COMMA, Constants.LEFT_BRACKET, Constants.RIGHT_BRACKET));
    }

    /**
     * 数组获取in表达式 包含括号
     */
    protected SqlString toSqlString(Object[] values) {
        if (ArrayUtil.isEmpty(values)) {
            return () -> "()";
        }
        return toSqlString(Arrays.asList(values));
    }
}
