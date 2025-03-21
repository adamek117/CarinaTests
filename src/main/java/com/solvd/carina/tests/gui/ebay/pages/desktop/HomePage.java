package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.pages.common.CategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(id = "gh-ac")
    private ExtendedWebElement searchBox;
    
    @FindBy(id = "gh-search-btn")
    private ExtendedWebElement searchButton;
  
    @FindBy(css = "li.vl-flyout-nav__js-tab > a")
    private List<ExtendedWebElement> categories;

    /*
     * //@FindBy(css = ".vl-flyout-nav__sub-cat-col")
     * 
     * @FindBy(className = "vl-flyout-nav__sub-cat-col")
     * private List<ExtendedWebElement> subcategories;
     */ // tu musi być inna implementacja

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchBox);
        setUiLoadedMarker(searchButton);
        waitForJSToLoad();
    }

    @Override
    public CategoryProductsPageBase selectCategory(String category) {
        LOGGER.info("selecting " + category + " category...");
        for (ExtendedWebElement categ : categories) {
            String currentCategory = categ.getText().trim();
            LOGGER.info("current category: " + currentCategory);
            if (category.equalsIgnoreCase(currentCategory)) {
                categ.click();
                return initPage(getDriver(), CategoryProductsPageBase.class);
            }

        }
        return null;
    }

    @Override
    public SearchPageBase searchProduct(String product) {
        LOGGER.info("selecting " + product + " product...");
        searchBox.click();
        searchBox.type(product);
        searchButton.click();
        return initPage(getDriver(), SearchPageBase.class);
    }

    /*
     * @Override
     * public SubcategoryProductsPageBase selectSubcategory(String subcategory) {
     * LOGGER.info("selecting " + subcategory + " subcategory...");
     * for (ExtendedWebElement subcateg : subcategories) {
     * String currentSubCategory = subcateg.getText();
     * LOGGER.info("current subcategory: " + subcategory);
     * if (subcategory.equalsIgnoreCase(currentSubCategory)) {
     * subcateg.click();
     * return initPage(getDriver(), SubcategoryProductsPageBase.class);
     * }
     * 
     * }
     * throw new RuntimeException("Unable to open subcategory: " + subcategory);
     * }
     */

}
