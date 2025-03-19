package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.pages.common.SubSubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubSubcategoryProductsPageBase.class)
public class SubSubcategoryProductsPage extends SubSubcategoryProductsPageBase {
    private static final Logger LOGGER = LogManager.getLogger(SubSubcategoryProductsPage.class);

    //@FindBy(css = "ul.brwrvr__item-results brwrvr__item-results--list > li")
    @FindBy(css = "h3.textual-display.bsig__title__text")  // tu trzeba zamienić prawdopodobnie na ProductItem żeby wyciągnąć cały a nie tylko jego tytuł
    private List<ExtendedWebElement> products;


    public SubSubcategoryProductsPage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }

    @Override
    public ProductInfoPageBase selectProduct(String productTitle) {
        LOGGER.info("selecting " + productTitle + " category...");
        for(ExtendedWebElement catSub : products){
            String currentProduct = catSub.getText().trim();
            LOGGER.info("current category: " + currentProduct);
            if(productTitle.equalsIgnoreCase(currentProduct)){
                catSub.click();
                return initPage(getDriver(), ProductInfoPageBase.class);
            }
        }
        return null;
    }
}
