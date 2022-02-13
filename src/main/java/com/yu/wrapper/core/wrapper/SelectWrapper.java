package com.yu.wrapper.core.wrapper;

import com.yu.wrapper.core.SelectBuild;

public class SelectWrapper implements SelectBuild<SelectWrapper> {
    @Override
    public SelectWrapper select(String... columns) {
//        if (ArrayUtils.isNotEmpty(columns)) {
//            this.sqlSelect.setStringValue(String.join(StringPool.COMMA, columns));
//        }
//        return typedThis;
        return null;
    }

    @Override
    public String getSqlSelect() {
        return null;
    }
}
