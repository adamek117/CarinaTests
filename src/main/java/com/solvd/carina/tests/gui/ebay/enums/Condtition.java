package com.solvd.carina.tests.gui.ebay.enums;

public enum Condtition {
    NEW("New"),
    USED("Used"),
    NOT_SPECIFIED("Not Specified");

    private final String conditionName;

    private Condtition(String conditionName) {
        this.conditionName = conditionName;
    }
    
    public String getConditionName(){
        return conditionName;
    }
}
