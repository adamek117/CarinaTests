package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.components.ProductItem;
import com.solvd.carina.tests.gui.ebay.pages.common.CartPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.CheckoutInformationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(css = ".cart-bucket")
    private List<ProductItem> productsInCart;
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
        //return initPage(getDriver(), CartPageBase.class); // czy to potrzebne?
    }

    @Override
    public CheckoutInformationPageBase clickGuestButtton() {
        guestButton.click();
        return initPage(
                getDriver(), CheckoutInformationPageBase.class);
    }

}
