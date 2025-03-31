package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.tests.gui.ebay.components.CheckoutProductItem;
import com.solvd.carina.tests.gui.ebay.enums.ShipData;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CheckoutInformationPageBase extends AbstractPage {

    public CheckoutInformationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillShipInformations(ShipData shipData);

    public abstract void choosePaymentMethod(String paymentMethod);

    public abstract void clickDoneButton();

    public abstract CheckoutProductItem getCheckoutProductItem();

}
