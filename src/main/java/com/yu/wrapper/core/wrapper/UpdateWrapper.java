package com.yu.wrapper.core.wrapper;

import cn.hutool.core.collection.CollectionUtil;
import com.yu.wrapper.core.lambda.LambdaUpdateBuild;
import com.yu.wrapper.core.toolkits.Constants;
import com.yu.wrapper.core.toolkits.sqlToolkits.ParamMap;
import com.yu.wrapper.core.toolkits.sqlToolkits.SqlKeyword;

import java.util.ArrayList;
import java.util.List;

public class UpdateWrapper extends WhereWrapper<UpdateWrapper> implements LambdaUpdateBuild<UpdateWrapper> {
    /**
     * SQL 更新字段内容，例如：name='1', age=2
     */
    private final List<String> sqlUpdate = new ArrayList<>();

    public UpdateWrapper() {

    }

    public UpdateWrapper(ParamMap paramMap) {
        super(paramMap);
    }

    @Override
    public UpdateWrapper update(boolean condition, String column, Object val, String mapping) {
        if(condition) {
            sqlUpdate.add(column + Constants.SPACE + SqlKeyword.EQ  + Constants.SPACE + putParamMapAndGetKey(val, mapping));
        }
        return typedThis;
    }

    @Override
    public String getUpdateSegment() {
        if (CollectionUtil.isEmpty(sqlUpdate)) {
            return null;
        }
        return String.join(Constants.COMMA, sqlUpdate);
    }

    @Override
    protected UpdateWrapper children() {
        return new UpdateWrapper(paramMap);
    }
}
