package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.components.ProductItem;
import com.solvd.carina.tests.gui.ebay.pages.common.SubSubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubSubcategoryProductsPageBase.class)
public class SubSubcategoryProductsPage extends SubSubcategoryProductsPageBase {
    private static final Logger LOGGER = LogManager.getLogger(SubSubcategoryProductsPage.class);

    @FindBy(className = "brwrvr__item-results brwrvr__item-results--list")
    private List<ProductItem> products;

    public SubSubcategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductInfoPageBase selectProduct(String productTitle) {
        for (ExtendedWebElement product : products) {
            throw new UnsupportedOperationException("Unimplemented method 'selectProduct'");
        }
                return null;
    }
}
