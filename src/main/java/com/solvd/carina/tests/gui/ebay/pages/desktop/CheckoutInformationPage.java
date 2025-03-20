package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.pages.common.CheckoutInformationPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class CheckoutInformationPage extends CheckoutInformationPageBase {

    @FindBy(css = "span")
    private ExtendedWebElement itemTitle;

    @FindBy(css = "span.item-price")
    private ExtendedWebElement itemPrice;

    private ExtendedWebElement itemDescription;

    @FindBy(css = "span.BOLD.POSITIVE")
    private ExtendedWebElement delivery;

    //@FindBy(id = "country")
    @FindBy(css = "country > option")
    private List<ExtendedWebElement> countries;

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

    @FindBy(css = "#phoneCountryCode > span > span.btn__text > span > span.custom-phone-field__dial-code")
    private ExtendedWebElement phoneCountryCode;

    @FindBy(id = "phoneNumber")
    private ExtendedWebElement phoneNumber;

    @FindBy(css = "button.btn.btn--primary")
    private ExtendedWebElement doneButton;

    @FindBy(css = "div.render-summary--primary")
    private List<ExtendedWebElement> paymentMethods;

    @FindBy(css = "#page-form > div > button")
    private ExtendedWebElement confirmButton;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public void chooseCountry(String country) {
        
    }

    @Override
    public void insertFirstName(String firstName) {
        this.firstName.click();
        this.firstName.type(firstName);
    }

    @Override
    public void insertLastName(String lastName) {
        this.lastName.click();
        this.lastName.type(lastName);
    }

    @Override
    public void insertStreetAddress(String addreess) {
        this.streetAddres.click();
        this.streetAddres.type(addreess);
    }

    @Override
    public void insertOptionalStreetAddress(String address) {
        this.streetAddres2.click();
        this.streetAddres2.type(address);
    }

    @Override
    public void insertCity(String city) {
       this.city.click();
       this.city.type(city);
    }

    @Override
    public void chooseState(String state) {
       this.stateOrProvince.click();
       this.stateOrProvince.type(state);
    }

    @Override
    public void insertZIPCode(String ZIPCode) {
        this.postalCode.click();
        this.postalCode.type(ZIPCode);
    }

    @Override
    public void insertEmail(String email) {
       this.email.click();
       this.email.type(email);
    }

    @Override
    public void insertConfirmEmail(String email) {
       this.emailConfirm.click();
       this.emailConfirm.type(email);
    }

    @Override
    public void chooseCountryCode(String countryCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseCountryCode'");
    }

    @Override
    public void insertPhoneNumber(String phoneNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertPhoneNumber'");
    }

    @Override
    public void clickDoneButton() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clickDoneButton'");
    }

    @Override
    public void choosePaymentMethod() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'choosePaymentMethod'");
    }

}
