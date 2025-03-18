package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.pages.common.SubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.CategoryProductsPageBase;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class CategoryProductsPage extends CategoryProductsPageBase {
    private static final Logger LOGGER = LogManager.getLogger(CategoryProductsPage.class);
    @FindBy(css = "section.brw-category-nav:nth-child(1) > div:nth-child(2) > ul")
    private List<ExtendedWebElement> subcategories;

    @FindBy(xpath = "//div[contains(@class='seoel__items')]")
    private List<ExtendedWebElement> subcategoriesWithPhoto;
    
    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SubcategoryProductsPageBase selectSubcategory(String subcategory) {
        LOGGER.info("selecting " + subcategory + " category...");
        for (ExtendedWebElement cat : subcategories) {
            String currentCategory = cat.getText();
            LOGGER.info("current category: " + currentCategory);
            if(subcategory.equalsIgnoreCase(currentCategory)){
                cat.click();
                return initPage(driver, SubcategoryProductsPageBase.class);
            }

        }
        throw new RuntimeException("Unable to open category: " + subcategory);
    }

    @Override
    public SubcategoryProductsPageBase subcategoriesWithPhoto(String subcategory) {
        LOGGER.info("selecting " + subcategory + " category...");
        for (ExtendedWebElement cat : subcategoriesWithPhoto) {
            String currentCategory = cat.getText();
            LOGGER.info("current category: " + currentCategory);
            if(subcategory.equalsIgnoreCase(currentCategory)){
                cat.click();
                return initPage(driver, SubcategoryProductsPageBase.class);
            }

        }
        throw new RuntimeException("Unable to open category: " + subcategory);
    }

}
