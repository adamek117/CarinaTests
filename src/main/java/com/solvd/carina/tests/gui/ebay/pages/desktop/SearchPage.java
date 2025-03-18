package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.components.ProductItem;
import com.solvd.carina.tests.gui.ebay.pages.common.SearchPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class SearchPage extends SearchPageBase {

    @FindBy(id = "x-refine__group__3")
    private List<ExtendedWebElement> conditions;

    @FindBy(id = "x-refine__group__4")
    private List<ExtendedWebElement> buyingFormats;

    @FindBy(css = ".srp-results")
    private List<ProductItem> searchedItems;
    
    public SearchPage(WebDriver driver) {
        super(driver);
    }

}
