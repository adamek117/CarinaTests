package com.solvd.carina.tests.gui.yahoo.pages.common;


import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SubcategoryFinancePageBase extends AbstractPage {

    
    public SubcategoryFinancePageBase(WebDriver driver) {
        super(driver);
        
    }

    public abstract SubSubcategoryFinancePageBase selectMarketsSubSubcategory(String subSubcategory);

}
