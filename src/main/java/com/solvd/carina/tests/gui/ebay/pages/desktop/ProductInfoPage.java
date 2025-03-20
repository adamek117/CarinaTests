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

    @FindBy(css = "#mainContent > div.vim.d-vi-evo-region > div.vim.x-price-section.mar-t-20 > div.vim.x-bin-price > div > div.x-price-primary > span")
    private ExtendedWebElement displayPrice;
    @FindBy(css = ".x-item-title__mainTitle .ux-textspans.ux-textspans--BOLD")
    private ExtendedWebElement displayTitle;
    @FindBy(css = "span.ux-textspans.ux-textspans--ITALIC")
    private ExtendedWebElement displayDescription;
    @FindBy(css = "#atcBtn_btn_1 > span > span")
    private ExtendedWebElement chartItem;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/div[7]/ul/li[2]/div[1]/div/div[2]/div[3]/div/div/div[1]/div[2]/div/div/div[2]/a/span/span")
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
