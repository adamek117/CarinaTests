package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.tests.gui.ebay.components.CardPageProductItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CartPageBase extends AbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickCheckout();

    public abstract CheckoutInformationPageBase clickGuestButtton();

    public abstract CardPageProductItem getCartPageProductItem(int index);

}
