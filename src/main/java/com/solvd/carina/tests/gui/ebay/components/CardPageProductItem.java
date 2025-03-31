package com.solvd.carina.tests.gui.ebay.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class CardPageProductItem  extends AbstractUIObject{

    @FindBy(xpath = "//*[@class='grid-item-title']//a")
    private ExtendedWebElement productTitle;
    @FindBy(xpath = "//*[@class='item-price font-title-3']/span/span/span")
    private ExtendedWebElement productPrice;

    public CardPageProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    
    }

    public String readProductPrice(){
        assertElementPresent(productPrice);
        return productPrice.getText();

    }

    public String readProductTitle(){
        assertElementPresent(productTitle);
        return productTitle.getText();

    }

}
    
