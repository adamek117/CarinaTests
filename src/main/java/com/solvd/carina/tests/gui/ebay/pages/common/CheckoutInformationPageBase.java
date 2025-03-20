package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.tests.gui.ebay.ShipData;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import lombok.Getter;

@Getter
public abstract class CheckoutInformationPageBase extends AbstractPage {

    public CheckoutInformationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillShipInformations(String country, String firstName, String lastName, String addreess,
            String optionalAddreess, String city, String state, String ZIPCode, String email, String emailConfirm,
            String countryCode, String phoneNumber);

    public abstract void fillShipInformations(ShipData shipData);

    public abstract void clickDoneButton();

    public abstract void choosePaymentMethod(String paymentMethod);

    public abstract String getCity();

}
