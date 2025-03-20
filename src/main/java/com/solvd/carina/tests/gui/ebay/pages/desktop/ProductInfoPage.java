package com.solvd.carina.tests.gui.ebay.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.pages.common.CartPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductInfoPageBase.class)
public class ProductInfoPage extends ProductInfoPageBase {

    // private static final Logger LOGGER =
    // LogManager.getLogger(ProductInfoPage.class);

    @FindBy(css = ".x-bin-price__content .ux-textspans")
    private ExtendedWebElement displayPrice;
    @FindBy(css = ".x-item-title__mainTitle .ux-textspans.ux-textspans--BOLD")
    private ExtendedWebElement displayTitle;
    @FindBy(css = "span.ux-textspans.ux-textspans--ITALIC")
    private ExtendedWebElement displayDescription;
    @FindBy(css = "#atcBtn_btn_1 > span > span")
    private ExtendedWebElement chartItem;
    @FindBy(css ="span.ux-call-to-action__text")
    private ExtendedWebElement seeInChartButton;

    public ProductInfoPage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }

    @Override
    public String readPrice() {
        assertElementPresent(displayPrice);
        return displayPrice.getText();
    }

    @Override
    public String readDescription() {
        assertElementPresent(displayDescription);
        return displayDescription.getText();
    }

    @Override
    public String readTitle() {
        assertElementPresent(displayTitle);
        return displayTitle.getText();
    }

     @Override
    public CartPageBase clickInChartButton() {
       seeInChartButton.click();
       return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public void addToChart() {
        chartItem.click();
    }

}
