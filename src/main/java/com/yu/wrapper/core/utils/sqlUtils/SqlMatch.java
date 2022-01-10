package com.yu.wrapper.core.utils.sqlUtils;

import java.util.function.Predicate;

public enum SqlMatch {
    GROUP_BY(i -> i == SqlKeyword.GROUP_BY),
    ORDER_BY(i -> i == SqlKeyword.ORDER_BY),
    NOT(i -> i == SqlKeyword.NOT),
    AND(i -> i == SqlKeyword.AND),
    OR(i -> i == SqlKeyword.OR),
    AND_OR(i -> i == SqlKeyword.AND || i == SqlKeyword.OR),
    EXISTS(i -> i == SqlKeyword.EXISTS),
    HAVING(i -> i == SqlKeyword.HAVING)
    ;

    private final Predicate<SqlString> predicate;

    SqlMatch(Predicate<SqlString> predicate) {
        this.predicate = predicate;
    }

    Predicate<SqlString> getPredicate() {
        return this.predicate;
    }

    public boolean match(SqlString sqlString) {
        return getPredicate().test(sqlString);
    }
}
