package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.pages.common.SubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.CategoryProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CategoryProductsPageBase.class)
public class CategoryProductsPage extends CategoryProductsPageBase {
    private static final Logger LOGGER = LogManager.getLogger(CategoryProductsPage.class);
    
    @FindBy(css = "ul.brwel__items > li")
    private List<ExtendedWebElement> subcategories;

    @FindBy(css= "ul.seoel__items > li")
    private List<ExtendedWebElement> subcategoriesWithPhoto;

    public CategoryProductsPage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }

    @Override
    public SubcategoryProductsPageBase selectSubcategory(String subcategory) {
        LOGGER.info("selecting " + subcategory + " category...");
        for (ExtendedWebElement cat : subcategories) {
            String currentCategory = cat.getText().trim();
            LOGGER.info("current category: " + currentCategory);
            if(subcategory.equalsIgnoreCase(currentCategory)){
                cat.click();
                return initPage(getDriver(), SubcategoryProductsPageBase.class);
            }

        }
        return null;
    }

    @Override
    public SubcategoryProductsPageBase selectSubcategoriesWithPhoto(String subcategory) {
        LOGGER.info("selecting " + subcategory + " category...");
        for (ExtendedWebElement cat : subcategoriesWithPhoto) {
            String currentCategory = cat.getText().trim();
            LOGGER.info("current category: " + currentCategory);
            if(subcategory.equalsIgnoreCase(currentCategory)){
                cat.click();
                return initPage(getDriver(), SubcategoryProductsPageBase.class);
            }

        }
        return null;
    }

}
