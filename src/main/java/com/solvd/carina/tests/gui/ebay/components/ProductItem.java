package com.solvd.carina.tests.gui.ebay.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class ProductItem extends AbstractUIObject {

    @FindBy(css = "#mainContent > div.vim.d-vi-evo-region > div.vim.x-price-section.mar-t-20 > div.vim.x-bin-price > div > div.x-price-primary > span")
    private ExtendedWebElement productPrice;
    @FindBy(css = ".x-item-title__mainTitle .ux-textspans.ux-textspans--BOLD")
    private ExtendedWebElement productTitle;
    @FindBy(css = "span.ux-textspans.ux-textspans--ITALIC")
    private ExtendedWebElement productDescription;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
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

    public String readProductDescription(){
        assertElementPresent(productDescription);
        return productDescription.getText();

    }


}
