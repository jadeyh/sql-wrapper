/*
 * Copyright (c) 2011-2022, baomidou (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yu.wrapper.core.toolkits.utils;

import cn.hutool.core.util.StrUtil;
import com.yu.wrapper.core.toolkits.Constants;
import com.yu.wrapper.core.toolkits.mybatisToolkits.MybatisKeyword;

/**
 * sql 脚本工具类
 */
public abstract class SqlScriptUtils {
    /**
     * 安全入参:  #{入参}
     */
    public static String safeParam(String param) {
        return safeParam(param, null);
    }

    /**
     * 安全入参:  #{入参,mapping}
     */
    public static String safeParam(String param, String mapping) {
        String target = MybatisKeyword.SAFE_PLACEHOLDER_LEFT + param;
        if (StrUtil.isBlank(mapping)) {
            return target + MybatisKeyword.PLACEHOLDER_RIGHT;
        }
        return target + Constants.COMMA + mapping + MybatisKeyword.PLACEHOLDER_RIGHT;
    }

    /**
     * 非安全入参:  ${入参}
     */
    public static String unSafeParam(String param) {
        return MybatisKeyword.SAFE_PLACEHOLDER_LEFT + param + MybatisKeyword.PLACEHOLDER_RIGHT;
    }
}
