package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.ShipData;
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

    private ExtendedWebElement itemDescription;

    @FindBy(css = "span.BOLD.POSITIVE")
    private ExtendedWebElement delivery;

    @FindBy(id = "country")
    private ExtendedWebElement countryButton;

    @FindBy(id = "firstName")
    private ExtendedWebElement firstName;

    @FindBy(id = "lastName")
    private ExtendedWebElement lastName;

    @FindBy(id = "addressLine1")
    private ExtendedWebElement streetAddres;

    @FindBy(id = "addressLine2")
    private ExtendedWebElement streetAddres2;

    @FindBy(id = "city")
    private ExtendedWebElement city;

    @FindBy(id = "stateOrProvince")
    private ExtendedWebElement stateOrProvince;

    @FindBy(id = "postalCode")
    private ExtendedWebElement postalCode;

    @FindBy(id = "email")
    private ExtendedWebElement email;

    @FindBy(id = "emailConfirm")
    private ExtendedWebElement emailConfirm;

    @FindBy(id = "phoneCountryCode")
    private ExtendedWebElement countryCodeButton;

    @FindBy(id = "phoneCountryCode")
    private ExtendedWebElement phoneCountryCodes;

    @FindBy(id = "phoneNumber")
    private ExtendedWebElement phoneNumber;

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
    public void fillShipInformations(String country, String firstName, String lastName, String addreess,
            String optionalAddreess, String city, String state, String ZIPCode, String email, String emailConfirm,
            String countryCode, String phoneNumber) {
        chooseCountry(country);
        insertFirstName(firstName);
        insertLastName(lastName);
        insertStreetAddress(addreess);
        insertOptionalStreetAddress(optionalAddreess);
        insertCity(city);
        chooseState(state);
        insertZIPCode(ZIPCode);
        insertEmail(email);
        insertConfirmEmail(emailConfirm);
        chooseCountryCode(countryCode);
        insertPhoneNumber(phoneNumber);

    }

    @Override
    public void fillShipInformations(ShipData shipData) {
        chooseCountry(shipData.getCountry());
        insertFirstName(shipData.getFirstName());
        insertLastName(shipData.getLastName());
        insertStreetAddress(shipData.getAddress());
        insertOptionalStreetAddress(shipData.getOptionalAddress());
        insertCity(shipData.getCity());
        chooseState(shipData.getState());
        insertZIPCode(shipData.getZipCode());
        insertEmail(shipData.getEmail());
        insertConfirmEmail(shipData.getEmailConfirm());
        // chooseCountryCode(shipData.getCountryCode());
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
        assertElementPresent(city);
        return city.getAttribute("value");
    }

    private void chooseCountry(String country) {
        this.countryButton.select(country);
    }

    private void insertFirstName(String firstName) {
        this.firstName.click();
        this.firstName.type(firstName);
    }

    private void insertLastName(String lastName) {
        this.lastName.click();
        this.lastName.type(lastName);
    }

    private void insertStreetAddress(String addreess) {
        this.streetAddres.click();
        this.streetAddres.type(addreess);
    }

    private void insertOptionalStreetAddress(String address) {
        this.streetAddres2.click();
        this.streetAddres2.type(address);
    }

    private void insertCity(String city) {
        this.city.click();
        this.city.type(city);
    }

    private void chooseState(String state) {
        this.stateOrProvince.select(state);
    }

    private void insertZIPCode(String ZIPCode) {
        this.postalCode.click();
        this.postalCode.type(ZIPCode);
    }

    private void insertEmail(String email) {
        this.email.click();
        this.email.type(email);
    }

    private void insertConfirmEmail(String email) {
        this.emailConfirm.click();
        this.emailConfirm.type(email);
    }

    private void chooseCountryCode(String countryCode) {
        this.countryButton.select(countryCode);
    }

    private void insertPhoneNumber(String phoneNumber) {
        this.phoneNumber.click();
        this.phoneNumber.type(phoneNumber);
    }

}
