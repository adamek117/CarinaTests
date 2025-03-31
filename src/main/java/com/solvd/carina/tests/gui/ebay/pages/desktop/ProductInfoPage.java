package com.solvd.carina.tests.gui.ebay.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.components.ProductItem;
import com.solvd.carina.tests.gui.ebay.pages.common.CartPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductInfoPageBase.class)
public class ProductInfoPage extends ProductInfoPageBase {

    @FindBy(xpath = "//*[@id='mainContent']")
    private ProductItem productDetails;
    @FindBy(css = "#atcBtn_btn_1 > span > span")
    private ExtendedWebElement chartItem;
    @FindBy(css = "#mainContent > div > div.vim.vi-evo-row-gap > ul > li:nth-child(2) > div.vim.x-atc-action.overlay-placeholder.atcv3modal > div > div.lightbox-dialog__window.lightbox-dialog__window--animate.keyboard-trap--active > div.lightbox-dialog__main > div > div > div.x-atc-layer-v3--details > div.ux-section-module__container > div > div > div > div:nth-child(2) > a > span > span")
    private ExtendedWebElement seeInChartButton;

    public ProductInfoPage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }
    
    @Override
    public ProductItem getProduct(){
        return productDetails;
    }

   /*  @Override
    public String readPrice() {
        ExtendedWebElement displayPrice = productDetails.getProductPrice();
        assertElementPresent(displayPrice);
        return displayPrice.getText();
    }

    @Override
    public String readDescription() {
        ExtendedWebElement displayDescription = productDetails.getProductDescription();
        if (displayDescription.isDisplayed()) {
            assertElementPresent(displayDescription);
            return displayDescription.getText();
        } else {
            return null;
        }
    }

    @Override
    public String readTitle() {
        ExtendedWebElement displayTitle = productDetails.getProductTitle();
        assertElementPresent(displayTitle);
        return displayTitle.getText();
    }*/

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
