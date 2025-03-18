package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SubcategoryProductsPageBase extends AbstractPage{

    
    public SubcategoryProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SubSubcategoryProductsPageBase selectSubSubcategory(String subSubCategoryName);

   
}
