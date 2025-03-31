package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.components.CardPageProductItem;
import com.solvd.carina.tests.gui.ebay.pages.common.CartPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.CheckoutInformationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/div/ul")
    private List<CardPageProductItem> productsInCart;

    @FindBy(xpath = "//div[contains(@data-test-id, 'LOGISTICS_SERVICE_DISPLAY')]/span/span")
    private ExtendedWebElement delivery;

    @FindBy(css = ".cart-summary-call-to-action")
    private ExtendedWebElement checkoutButton;

    @FindBy(id = "gxo-btn")
    private ExtendedWebElement guestButton;

    public CartPage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }

    @Override
    public void clickCheckout() {
        checkoutButton.click();
    }

    @Override
    public CheckoutInformationPageBase clickGuestButtton() {
        guestButton.click();
        return initPage(
                getDriver(), CheckoutInformationPageBase.class);
    }

    @Override
    public CardPageProductItem getCartPageProductItem(int index) {
        return productsInCart.get(index);
    }

}
