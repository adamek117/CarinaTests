package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.pages.common.SubSubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubcategoryProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubcategoryProductsPageBase.class)
public class SubcategoryProductsPage extends SubcategoryProductsPageBase{

    private static final Logger LOGGER = LogManager.getLogger(SubcategoryProductsPage.class);

    @FindBy(css ="")
    private List<ExtendedWebElement> subSubcategories;

    public SubcategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SubSubcategoryProductsPageBase selectSubSubcategory(String subSubCategoryName) {
        LOGGER.info("selecting " + subSubCategoryName + " category...");
        for (ExtendedWebElement cat : subSubcategories) {
            String currentCategory = cat.getText();
            LOGGER.info("current category: " + currentCategory);
            if(subSubCategoryName.equalsIgnoreCase(currentCategory)){
                cat.click();
                return initPage(getDriver(), SubSubcategoryProductsPageBase.class);
            }

        }
        throw new RuntimeException("Unable to open category: " + subSubCategoryName);
    }

   
}

