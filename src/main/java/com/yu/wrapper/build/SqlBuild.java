package com.yu.wrapper.build;

public interface SqlBuild {
    String getTargetSql();

    String getSqlSegment();

    String getParamAlias();
}
