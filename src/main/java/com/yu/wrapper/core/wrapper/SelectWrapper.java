package com.yu.wrapper.core.wrapper;

import cn.hutool.core.util.ArrayUtil;
import com.yu.wrapper.core.lambda.LambdaSelectBuild;
import com.yu.wrapper.core.toolkits.Constants;
import com.yu.wrapper.core.toolkits.sqlToolkits.ParamMap;

public class SelectWrapper extends WhereWrapper<SelectWrapper> implements LambdaSelectBuild<SelectWrapper> {
    private String sqlSelect;

    public SelectWrapper() {

    }

    public SelectWrapper(ParamMap paramMap) {
        super(paramMap);
    }

    @Override
    public SelectWrapper select(String... columns) {
        if (ArrayUtil.isNotEmpty(columns)) {
            this.sqlSelect = String.join(Constants.COMMA, columns);
        }
        return typedThis;
    }

    @Override
    public String getSelectSegment() {
        return sqlSelect;
    }

    @Override
    protected SelectWrapper children() {
        return new SelectWrapper(paramMap);
    }
}
