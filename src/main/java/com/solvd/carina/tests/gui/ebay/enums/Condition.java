package com.solvd.carina.tests.gui.ebay.enums;

public enum Condition {
    NEW("New"),
    USED("Used"),
    NOT_SPECIFIED("Not Specified");

    private final String conditionName;

    private Condition(String conditionName) {
        this.conditionName = conditionName;
    }
    
    public String getConditionName(){
        return conditionName;
    }
}
