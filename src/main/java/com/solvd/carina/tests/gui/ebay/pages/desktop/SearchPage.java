package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SearchPageBase;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {
    private static final Logger LOGGER = LogManager.getLogger(SearchPage.class);

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    // css = "#x-refine__group__3 > ul > li > div > a > div > div > div >
    // span.cbx.x-refine__multi-select-cbx")
    @FindBy(css = "#x-refine__group__3 > ul > li > div > a > div > div > div > span.cbx.x-refine__multi-select-cbx")
    private List<ExtendedWebElement> conditions;
    @FindBy(css = "#x-refine__group__4 > ul > li > div > a > div > div > span.cbx.x-refine__multi-select-cbx")
    private List<ExtendedWebElement> buyingFormats;
    @FindBy(css = "div.s-item__info.clearfix > a > div > span")
    private List<ExtendedWebElement> searchedItems;
    //*[@id="item2b7a309fb6"]/div/div[2]/a/div/span
    public SearchPage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }

    @Override
    public List<ExtendedWebElement> getSerchedItems() {
        return searchedItems;
    }

    @Override
    public SearchPageBase clickBuyFormat(String buyingFormat) {
        for (ExtendedWebElement format : buyingFormats) {
            String currentFormat = format.getText();
            LOGGER.info("current format: " + currentFormat);
            if (buyingFormat.equalsIgnoreCase(currentFormat)) {
                format.click();
                return initPage(getDriver(), SearchPageBase.class);
            }
        }
        return null;
    }

    @Override
    public SearchPageBase clickCondition(String condition) {
        for (ExtendedWebElement condit : conditions) {
            String currentCondition = condit.getText();
            LOGGER.info("current condition: " + currentCondition);
            if (currentCondition.contains(condition)) {
                condit.click();
                return initPage(getDriver(), SearchPageBase.class);
            }
        }
        return null;
    }

    @Override
    public ProductInfoPageBase choseProduct(String productName) {
        LOGGER.info("selecting " + productName + " product...");
        for (ExtendedWebElement item : searchedItems) {
            waitUntil(ExpectedConditions.visibilityOf(item), 5);
            LOGGER.info("selecting " + item.getText() + " item...");
            String currentItem = item.getText().trim();
            if (productName.equalsIgnoreCase(currentItem)) {
                item.click();
                return initPage(getDriver(), ProductInfoPageBase.class);
            }
        }
        throw new RuntimeException("No chosen product");
    }
}
