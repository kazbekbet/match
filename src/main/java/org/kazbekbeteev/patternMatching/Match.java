package org.kazbekbeteev.patternMatching;

import org.kazbekbeteev.patternMatching.checker.*;

import java.util.*;

public class Match<Val, Return> {
    private final Val value;
    private final List<Checker<Val, Return>> checkers;
    private Return otherwiseVal;

    private Match(Val initialValue) {
        value = initialValue;
        checkers = new ArrayList<>();
    }

    public Match<Val, Return> when(Val valueToCheck, ReturnFunction<Return> func) {
        checkers.add(new CheckerValueImpl<>(valueToCheck, func));

        return this;
    }

    public Match<Val, Return> when(CheckFunction<Val> checkFunc, ReturnFunction<Return> func) {
        checkers.add(new CheckerFuncImpl<>(checkFunc, func));

        return this;
    }

    public Return check() throws Exception {
        for (Checker<Val, Return> checker : checkers) {
            if (checker.isEqual(this.value)) {
                return checker.getReturnFunc().func();
            }
        }

        if (otherwiseVal == null) {
            throw new Exception("Value not matched, otherwise not called");
        }

        return otherwiseVal;
    }

    public Match<Val, Return> otherwise(Return otherwiseVal) {
        this.otherwiseVal = otherwiseVal;

        return this;
    }

    public static <Val, Return> Match<Val, Return> of(Val initialValue) {
        return new Match<>(initialValue);
    }
}
