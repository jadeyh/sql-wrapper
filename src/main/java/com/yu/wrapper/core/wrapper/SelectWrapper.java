package com.yu.wrapper.core.wrapper;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.yu.wrapper.Form;
import com.yu.wrapper.core.lambda.LambdaPostfixBuild;
import com.yu.wrapper.core.lambda.LambdaWhereBuild;
import com.yu.wrapper.core.toolkits.Constants;
import com.yu.wrapper.core.toolkits.mybatisToolkits.MybatisKeyword;
import com.yu.wrapper.core.toolkits.sqlToolkits.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class SelectWrapper implements LambdaWhereBuild<SelectWrapper>, LambdaPostfixBuild<SelectWrapper>, SqlString {
    protected SqlSegments sqlSegments = new SqlSegments();

    protected ParamMap paramMap;

    public SelectWrapper() {
        this.paramMap = new ParamMap(Constants.WRAPPER + Constants.DOT + Constants.PARAM_MAP + Constants.DOT);
    }

    public SelectWrapper(ParamMap paramMap) {
        this.paramMap = paramMap;
    }

    @Override
    public SelectWrapper eq(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.EQ, SqlStringFactory.toSqlString(putParamMapAndGetKey(val)));
        }
        return this;
    }

    @Override
    public SelectWrapper ne(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.NE, SqlStringFactory.toSqlString(putParamMapAndGetKey(val)));
        }
        return this;
    }

    @Override
    public SelectWrapper gt(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.GT, SqlStringFactory.toSqlString(putParamMapAndGetKey(val)));
        }
        return this;
    }

    @Override
    public SelectWrapper ge(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.GE, SqlStringFactory.toSqlString(putParamMapAndGetKey(val)));
        }
        return this;
    }

    @Override
    public SelectWrapper lt(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.LT, SqlStringFactory.toSqlString(putParamMapAndGetKey(val)));
        }
        return this;
    }

    @Override
    public SelectWrapper le(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.BETWEEN, SqlStringFactory.toSqlString(putParamMapAndGetKey(val)));
        }
        return this;
    }

    @Override
    public SelectWrapper between(boolean condition, String column, Object val1, Object val2) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.BETWEEN,
                    SqlStringFactory.toSqlString(putParamMapAndGetKey(val1)), SqlKeyword.AND, SqlStringFactory.toSqlString(putParamMapAndGetKey(val2)));
        }
        return this;
    }

    @Override
    public SelectWrapper notBetween(boolean condition, String column, Object val1, Object val2) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.NOT_BETWEEN,
                    SqlStringFactory.toSqlString(putParamMapAndGetKey(val1)), SqlKeyword.AND, SqlStringFactory.toSqlString(putParamMapAndGetKey(val2)));
        }
        return this;
    }

    @Override
    public SelectWrapper like(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.LIKE, SqlStringFactory.toSqlString(putParamMapAndGetKey(MybatisKeyword.PERCENT + val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public SelectWrapper notLike(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.NOT_LIKE, SqlStringFactory.toSqlString(putParamMapAndGetKey(MybatisKeyword.PERCENT + val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public SelectWrapper likeLeft(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.LIKE, SqlStringFactory.toSqlString(putParamMapAndGetKey(MybatisKeyword.PERCENT + val)));
        }
        return this;
    }

    @Override
    public SelectWrapper likeStringRight(boolean condition, String column, Object val) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.LIKE, SqlStringFactory.toSqlString(putParamMapAndGetKey(val + MybatisKeyword.PERCENT)));
        }
        return this;
    }

    @Override
    public SelectWrapper isNull(boolean condition, String column) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.IS_NULL);
        }
        return this;
    }

    @Override
    public SelectWrapper isNotNull(boolean condition, String column) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.IS_NOT_NULL);
        }
        return this;
    }

    @Override
    public SelectWrapper in(boolean condition, String column, Collection<?> values) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.IN, SqlStringFactory.toSqlString(values, i -> putParamMapAndGetKey(i)));
        }
        return this;
    }

    @Override
    public SelectWrapper in(boolean condition, String column, Object... values) {
        return in(condition, column, Arrays.asList(values));
    }

    @Override
    public SelectWrapper notIn(boolean condition, String column, Collection<?> values) {
        if(condition) {
            addSqlSegments(SqlStringFactory.toSqlString(column), SqlKeyword.NOT_IN, SqlStringFactory.toSqlString(values, i -> putParamMapAndGetKey(i)));
        }
        return this;
    }

    @Override
    public SelectWrapper notIn(boolean condition, String column, Object... values) {
        return notIn(condition, column, Arrays.asList(values));
    }

    @Override
    public SelectWrapper and(boolean condition, Consumer<SelectWrapper> consumer) {
        return and(condition).nested(condition, consumer);
    }

    @Override
    public SelectWrapper and(boolean condition) {
        if (condition) {
            addSqlSegments(SqlKeyword.AND);
        }
        return this;
    }

    @Override
    public SelectWrapper or(boolean condition, Consumer<SelectWrapper> consumer) {
        return or(condition).nested(condition, consumer);
    }

    @Override
    public SelectWrapper or(boolean condition) {
        if (condition) {
            addSqlSegments(SqlKeyword.OR);
        }
        return this;
    }

    @Override
    public SelectWrapper nested(boolean condition, Consumer<SelectWrapper> consumer) {
        if (condition) {
            SelectWrapper selectWrapper = new SelectWrapper(paramMap);
            consumer.accept(selectWrapper);
            addSqlSegments(SqlKeyword.APPLY, selectWrapper);
        }
        return this;
    }

    @Override
    public SelectWrapper not(boolean condition, Consumer<SelectWrapper> consumer) {
        return not(condition).nested(condition, consumer);
    }

    @Override
    public SelectWrapper not(boolean condition) {
        if (condition) {
            addSqlSegments(SqlKeyword.NOT);
        }
        return this;
    }

    @Override
    public SelectWrapper apply(boolean condition, String applySql, Object... values) {
        if(condition) {
            addSqlSegments(SqlKeyword.APPLY, SqlStringFactory.toSqlString(formatSqlParam(applySql, null, values)));
        }
        return this;
    }

    @Override
    public SelectWrapper groupBy(boolean condition, List<String> columns) {
        if(condition) {
            addSqlSegments(SqlKeyword.GROUP_BY, SqlStringFactory.toSqlString(columns));
        }
        return this;
    }

    @Override
    public SelectWrapper orderBy(boolean condition, boolean isAsc, List<String> columns) {
        if(condition) {
            addSqlSegments(SqlKeyword.ORDER_BY, SqlStringFactory.toSqlString(columns));
        }
        return this;
    }

    @Override
    public SelectWrapper having(boolean condition, String havingSql, Object... params) {
        if(condition) {
            addSqlSegments(SqlKeyword.HAVING, SqlStringFactory.toSqlString(formatSqlParam(havingSql, null, params)));
        }
        return null;
    }


    @Override
    public String getSqlString() {
        return sqlSegments.getSqlString();
    }

    /**
     *  新增sql片段，如果要修改保存sql片段的实现方式可以重写该函数
     */
    protected void addSqlSegments(SqlString... sqlStrings) {
        sqlSegments.add(sqlStrings);
    }

    /**
     *  设置变量值并且返回变量对应占位符
     */
    protected String putParamMapAndGetKey(Object param) {
        return paramMap.putAndGetKey(param);
    }

    /**
     *  设置变量值并且返回变量对应占位符
     */
    protected String putParamMapAndGetKey(Object param, String mapping) {
        return paramMap.putAndGetKey(param, mapping);
    }

    /**
     * 传入参数序号，输出apply等语句需要的参数占位符名称
     */
    public static String getSqlParamTarget(Integer i) {
        return Constants.LEFT_BRACE + i + Constants.RIGHT_BRACE;
    }

    /**
     *  把apply等函数传入的参数格式化进sql中
     */
    protected String formatSqlParam(String sqlStr, String mapping, Object... params) {
        if (StrUtil.isBlank(sqlStr)) {
            return null;
        }
        if (ArrayUtil.isNotEmpty(params)) {
            for (int i = 0; i < params.length; ++i) {
                String target = getSqlParamTarget(i);
                sqlStr = sqlStr.replace(target, putParamMapAndGetKey(params[i], mapping));
            }
        }
        return sqlStr;
    }

    public static void main(String[] args) {
        SelectWrapper selectWrapper = new SelectWrapper();
        selectWrapper.eq(Form::getId, "a").in(Form::getName, "b", "c")
//                .nested(sw -> sw.eq(Form::getId, "1"))
                .groupBy(Form::getCode).groupBy(Form::getName);
        selectWrapper.orderBy(true, Form::getCode, Form::getId);
        selectWrapper.not(i -> i.or().eq("d", "e"));
        System.out.println(selectWrapper.getSqlString());
    }
}
