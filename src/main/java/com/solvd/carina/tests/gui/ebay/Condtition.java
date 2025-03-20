package com.solvd.carina.tests.gui.ebay;

public enum Condtition {
    NEW("New"),
    USED("Used"),
    NOT_SPECIFIED("Not Specified");

    private final String conditionName;

    private Condtition(String conditionName) {
        this.conditionName = conditionName;
    }

}
