package org.kazbekbeteev.patternMatching.checker;

public class CheckerValueImpl<Val, Return> extends Checker<Val, Return> {
    private final Val value;

    public CheckerValueImpl(Val value, ReturnFunction<Return> returnFunction) {
        super(returnFunction);

        this.value = value;
    }

    @Override
    public Boolean isEqual(Val checkVal) {
        return this.value == checkVal;
    }
}
