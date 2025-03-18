package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SubSubcategoryProductsPageBase extends AbstractPage{

     public SubSubcategoryProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductInfoPageBase selectProduct(String productTitle);


}
