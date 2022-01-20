package com.yu.wrapper.core.wrapper;

import com.yu.wrapper.core.PostfixBuild;
import com.yu.wrapper.core.lambda.LambdaWhereBuild;
import com.yu.wrapper.core.toolkits.Constants;
import com.yu.wrapper.core.toolkits.mybatisToolkits.MybatisKeyword;
import com.yu.wrapper.core.toolkits.sqlToolkits.*;

import java.util.Collection;
import java.util.function.Consumer;

public class LambdaSelectWrapper implements LambdaWhereBuild<LambdaSelectWrapper>, PostfixBuild<LambdaSelectWrapper>, SqlString {
    protected SqlSegments sqlSegments = new SqlSegments();

    protected ParamMap paramMap = new ParamMap(Constants.WRAPPER + Constants.DOT + Constants.PARAM_MAP + Constants.DOT);

    @Override
    public LambdaSelectWrapper eq(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.EQ, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper ne(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.NE, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper gt(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.GT, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper ge(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.GE, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper lt(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.LT, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper le(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.BETWEEN, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper between(boolean condition, String column, Object val1, Object val2) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.BETWEEN,
                    SqlStringFactory.toSqlString(paramMap.putAndGetKey(val1)), SqlKeyword.AND, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val2)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper notBetween(boolean condition, String column, Object val1, Object val2) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.NOT_BETWEEN,
                    SqlStringFactory.toSqlString(paramMap.putAndGetKey(val1)), SqlKeyword.AND, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val2)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper like(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.LIKE, SqlStringFactory.toSqlString(paramMap.putAndGetKey(MybatisKeyword.PERCENT + val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper notLike(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.NOT_LIKE, SqlStringFactory.toSqlString(paramMap.putAndGetKey(MybatisKeyword.PERCENT + val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper likeLeft(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.LIKE, SqlStringFactory.toSqlString(paramMap.putAndGetKey(MybatisKeyword.PERCENT + val)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper likeStringRight(boolean condition, String column, Object val) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.LIKE, SqlStringFactory.toSqlString(paramMap.putAndGetKey(val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper isNull(boolean condition, String column) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.IS_NULL);
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper isNotNull(boolean condition, String column) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.IS_NOT_NULL);
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper in(boolean condition, String column, Collection<?> values) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.IN, SqlStringFactory.toSqlString(values));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper in(boolean condition, String column, Object... values) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.IN, SqlStringFactory.toSqlString(values));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper notIn(boolean condition, String column, Collection<?> values) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.NOT_IN, SqlStringFactory.toSqlString(values));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper notIn(boolean condition, String column, Object... values) {
        if(condition) {
            sqlSegments.add(SqlStringFactory.toSqlString(column), SqlKeyword.NOT_IN, SqlStringFactory.toSqlString(values));
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper and(boolean condition, Consumer<LambdaSelectWrapper> consumer) {
        if(condition) {
            LambdaSelectWrapper lambdaSelectWrapper = new LambdaSelectWrapper();
            consumer.accept(lambdaSelectWrapper);
            sqlSegments.add(lambdaSelectWrapper);
        }
        return this;
    }

    @Override
    public LambdaSelectWrapper or(boolean condition, Consumer<LambdaSelectWrapper> consumer) {
        return null;
    }

    @Override
    public LambdaSelectWrapper or(boolean condition) {
        return null;
    }

    @Override
    public LambdaSelectWrapper nested(boolean condition, Consumer<LambdaSelectWrapper> consumer) {
        return null;
    }

    @Override
    public LambdaSelectWrapper not(boolean condition, Consumer<LambdaSelectWrapper> consumer) {
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

    @Override
    public String getSqlString() {
        return null;
    }
}
