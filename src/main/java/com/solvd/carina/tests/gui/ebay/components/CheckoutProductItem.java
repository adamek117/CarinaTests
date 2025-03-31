package com.solvd.carina.tests.gui.ebay.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class CheckoutProductItem extends AbstractUIObject {

    @FindBy(xpath = "//div[contains(@data-test-id, 'CART_DETAILS_ITEM')]/div/div/div/h3/div/span")
    private ExtendedWebElement itemTitle;

    @FindBy(xpath = "//div[contains(@data-test-id, 'CART_DETAILS_ITEM')]/div/div/div[2]/div/div/span/span")
    private ExtendedWebElement itemPrice;

    public CheckoutProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readItemTitle() {
        assertElementPresent(itemTitle);
        return itemTitle.getText();
    }

    public String readItemPrice() {
        assertElementPresent(itemPrice);
        return itemPrice.getText();
    }

}
