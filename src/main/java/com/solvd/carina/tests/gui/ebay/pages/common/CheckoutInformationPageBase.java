package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CheckoutInformationPageBase extends AbstractPage {

    public CheckoutInformationPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void chooseCountry(String country);

    public abstract void insertFirstName(String firstName);

    public abstract void insertLastName(String lastName);

    public abstract void insertStreetAddress(String addreess);

    public abstract void insertOptionalStreetAddress(String address);

    public abstract void insertCity(String city);

    public abstract void chooseState(String state);

    public abstract void insertZIPCode(String ZIPCode);

    public abstract void insertEmail(String email);

    public abstract void insertConfirmEmail(String email);

    public abstract void chooseCountryCode(String countryCode);

    public abstract void insertPhoneNumber(String phoneNumber);

    public abstract void clickDoneButton();

    public abstract void choosePaymentMethod();
}
