package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.enums.ShipData;
import com.solvd.carina.tests.gui.ebay.pages.common.CheckoutInformationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutInformationPageBase.class)
public class CheckoutInformationPage extends CheckoutInformationPageBase {
    private static final Logger LOGGER = LogManager.getLogger(CheckoutInformationPage.class);

    @FindBy(css = "span")
    private ExtendedWebElement itemTitle;

    @FindBy(css = "span.item-price")
    private ExtendedWebElement itemPrice;

    private ExtendedWebElement itemDescription; // add css 

    @FindBy(css = "span.BOLD.POSITIVE")
    private ExtendedWebElement delivery;

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

    @FindBy(id = "payment-selection-fieldset")
    private List<ExtendedWebElement> paymentMethods;

    @FindBy(css = "#page-form > div > button")
    private ExtendedWebElement confirmButton;
    @FindBy(css = "#mainContent > div.currency-dialog > div > div > div.lightbox-dialog__window.lightbox-dialog__window--fade.keyboard-trap--active > div.lightbox-dialog__main > div.currency-footer > div > button.btn.currency-cta-container__primary.btn--primary")
    private ExtendedWebElement continueSelectPaymet;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }


    @Override
    public void fillShipInformations(ShipData shipData) {
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

    @Override
    public void clickDoneButton() {
        this.doneButton.click();
    }

    @Override
    public void choosePaymentMethod(String paymentMethod) {
        for (ExtendedWebElement paymentMethodElement : paymentMethods) {
            String currentPaymentMethod = paymentMethodElement.getText();
            if (currentPaymentMethod.equalsIgnoreCase(paymentMethod)) {
                LOGGER.info("Metoda płatności:", currentPaymentMethod);
                paymentMethodElement.click();
                continueSelectPaymet.click();
            }
        }
    }

    @Override
    public String getCity() {
        assertElementPresent(cityInput);
        return cityInput.getAttribute("value");
    }

    private void chooseCountry(String country) {
        this.countryButton.select(country);
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
