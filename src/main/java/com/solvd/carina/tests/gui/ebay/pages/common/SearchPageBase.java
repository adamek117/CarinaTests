package com.solvd.carina.tests.gui.ebay.pages.common;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SearchPageBase extends AbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchPageBase clickBuyFormat(String buyingFormat);
    public abstract SearchPageBase clickCondition(String condition);
    public abstract List<ExtendedWebElement> getSerchedItems();
    public abstract ProductInfoPageBase choseProduct(String productName);

}
