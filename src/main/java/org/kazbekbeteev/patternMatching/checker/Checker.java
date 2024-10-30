package org.kazbekbeteev.patternMatching.checker;

abstract public class Checker<Val, Return> {
    private final ReturnFunction<Return> returnFunc;

    Checker(ReturnFunction<Return> returnFunc) {
        this.returnFunc = returnFunc;
    }

    abstract public Boolean isEqual(Val val);

    public ReturnFunction<Return> getReturnFunc() {
        return returnFunc;
    }
}
