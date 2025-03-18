package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;


public abstract class HomePageBase extends AbstractPage {
    //private ExtendedWebElement acceptCokkies;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract CategoryProductsPageBase selectCategory(String category);
    public abstract SubcategoryProductsPageBase selectSubcategory(String subcategory);
    public abstract SearchPageBase searchProduct(String product);
    
    @Override
    public void open(){
        super.open();
       // acceptCokkies.clickIfPresent(3);
    }

}
