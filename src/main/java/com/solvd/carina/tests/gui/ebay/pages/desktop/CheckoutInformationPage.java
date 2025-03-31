package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.components.CheckoutProductItem;
import com.solvd.carina.tests.gui.ebay.components.DeliveryForm;
import com.solvd.carina.tests.gui.ebay.enums.ShipData;
import com.solvd.carina.tests.gui.ebay.pages.common.CheckoutInformationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutInformationPageBase.class)
public class CheckoutInformationPage extends CheckoutInformationPageBase {
    private static final Logger LOGGER = LogManager.getLogger(CheckoutInformationPage.class);

    @FindBy(xpath = "//div[contains(@data-test-id, 'CART_DETAILS_SELLER_BUCKET')]")
    private CheckoutProductItem checkoutItem;

    @FindBy(xpath = "//div[contains(@data-test-id, 'SHIPPING')]")
    private DeliveryForm deliveryForm;

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
    public void clickDoneButton() {
        deliveryForm.clickDoneButton();
    }

    @Override
    public void fillShipInformations(ShipData shipData) {
        deliveryForm.fillAllInformation(shipData);
    }

    @Override
    public void choosePaymentMethod(String paymentMethod) {
        for (ExtendedWebElement paymentMethodElement : paymentMethods) {
            String currentPaymentMethod = paymentMethodElement.getText();
            LOGGER.info("Metoda płatności:", currentPaymentMethod);
            if (currentPaymentMethod.equalsIgnoreCase(paymentMethod)) {
                LOGGER.info("Metoda płatności:", currentPaymentMethod);
                paymentMethodElement.click();
                continueSelectPaymet.click();
            }
        }
    }

    @Override
    public CheckoutProductItem getCheckoutProductItem() {
        return checkoutItem;
    }

}
