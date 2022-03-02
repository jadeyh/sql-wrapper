package com.yu.wrapper.core.wrapper;

import com.yu.wrapper.core.UpdateBuild;
import com.yu.wrapper.core.toolkits.sqlToolkits.ParamMap;

public class UpdateWrapper extends WhereWrapper<UpdateWrapper> implements UpdateBuild<UpdateWrapper> {
    public UpdateWrapper() {

    }

    public UpdateWrapper(ParamMap paramMap) {
        super(paramMap);
    }

    @Override
    public UpdateWrapper update(String... columns) {
        return null;
    }

    @Override
    public String getSqlUpdate() {
        return null;
    }

    @Override
    protected UpdateWrapper children() {
        return new UpdateWrapper(paramMap);
    }
}
