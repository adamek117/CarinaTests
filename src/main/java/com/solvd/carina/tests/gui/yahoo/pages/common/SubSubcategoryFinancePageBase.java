package com.solvd.carina.tests.gui.yahoo.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SubSubcategoryFinancePageBase extends AbstractPage{

    public SubSubcategoryFinancePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract StockPageBase chooseStock(String stockName);
    

}
