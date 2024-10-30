package org.kazbekbeteev.patternMatching.checker;

public class CheckerFuncImpl<Val, Return> extends Checker<Val, Return> {
    private final CheckFunction<Val> func;

    public CheckerFuncImpl(CheckFunction<Val> func, ReturnFunction<Return> returnFunction) {
        super(returnFunction);

        this.func = func;
    }

    @Override
    public Boolean isEqual(Val val) {
        return this.func.func(val);
    }
}
