package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CategoryProductsPageBase extends AbstractPage {

    public CategoryProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SubcategoryProductsPageBase selectSubcategory(String subcategory);

    public abstract SubcategoryProductsPageBase selectSubcategoriesWithPhoto(String subcategory);
}
