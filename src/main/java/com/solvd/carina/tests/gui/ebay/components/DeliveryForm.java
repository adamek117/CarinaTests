package com.solvd.carina.tests.gui.ebay.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.enums.ShipData;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;


public class DeliveryForm extends AbstractUIObject {

    @FindBy(id = "country")
    private ExtendedWebElement countryButton;

    @FindBy(id = "firstName")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "lastName")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "addressLine1")
    private ExtendedWebElement streetAddresInput;

    @FindBy(id = "addressLine2")
    private ExtendedWebElement streetAddresInput2;

    @FindBy(id = "city")
    private ExtendedWebElement cityInput;

    @FindBy(id = "stateOrProvince")
    private ExtendedWebElement stateOrProvinceSelect;

    @FindBy(id = "postalCode")
    private ExtendedWebElement postalCodeInput;

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "emailConfirm")
    private ExtendedWebElement emailConfirmInput;

    @FindBy(id = "phoneCountryCode")
    private ExtendedWebElement countryCodeButton;

    @FindBy(id = "phoneCountryCode")
    private ExtendedWebElement phoneCountryCodes;

    @FindBy(id = "phoneNumber")
    private ExtendedWebElement phoneNumberInput;

    @FindBy(css = "#mainContent > div.two-column.container.no-gutters > div > div.left-column.col-7.col-lg-8 > section.module.shipping-address.auto-address-container > div > div > div > div > div.address-form > div > form > div > div > div > button")
    private ExtendedWebElement doneButton;

    public DeliveryForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void fillAllInformation(ShipData shipData) {
        chooseCountry(shipData.getCountry());
        insertFirstName(shipData.getFirstName());
        insertlastName(shipData.getLastName());
        insertStreetAddres(shipData.getAddress());
        insertOptionalStreetAddres(shipData.getOptionalAddress());
        insertCity(shipData.getCity());
        selectState(shipData.getState());
        insertZIPCode(shipData.getZipCode());
        insertEmail(shipData.getEmail());
        insertConfirmEmail(shipData.getEmailConfirm());
        insertPhoneNumber(shipData.getPhoneNumber());
    }

    public void clickDoneButton() {
        doneButton.click();
    }

    private void chooseCountry(String country) {
        countryButton.select(country);
    }

    private void insertFirstName(String firstName) {
        firstNameInput.click();
        firstNameInput.type(firstName);
    }

    private void insertlastName(String lastName) {
        lastNameInput.click();
        lastNameInput.type(lastName);
    }

    private void insertStreetAddres(String addreess) {
        streetAddresInput.click();
        streetAddresInput.type(addreess);
    }

    private void insertOptionalStreetAddres(String address) {
        streetAddresInput2.click();
        streetAddresInput2.type(address);
    }

    private void insertCity(String city) {
        cityInput.click();
        cityInput.type(city);
    }

    private void selectState(String state) {
        stateOrProvinceSelect.select(state);
    }

    private void insertZIPCode(String ZIPCode) {
        postalCodeInput.click();
        postalCodeInput.type(ZIPCode);
    }

    private void insertEmail(String email) {
        emailInput.click();
        emailInput.type(email);
    }

    private void insertConfirmEmail(String email) {
        emailConfirmInput.click();
        emailConfirmInput.type(email);
    }

    private void insertPhoneNumber(String phoneNumber) {
        phoneNumberInput.click();
        phoneNumberInput.type(phoneNumber);
    }

}
