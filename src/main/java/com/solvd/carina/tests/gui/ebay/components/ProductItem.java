package com.solvd.carina.tests.gui.ebay.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;


public class ProductItem extends AbstractUIObject{

    private ExtendedWebElement productLink;

    private ExtendedWebElement productLabel;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ProductInfoPageBase openModelPage() {
        productLink.click();
        return initPage(driver, ProductInfoPageBase.class);
    }

    public String readModel(){
        return productLabel.getText();
    }
   
}
