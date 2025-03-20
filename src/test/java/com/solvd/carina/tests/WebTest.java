package com.solvd.carina.tests;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solvd.carina.tests.gui.ebay.WindowUtils;
import com.solvd.carina.tests.gui.ebay.components.Product;
import com.solvd.carina.tests.gui.ebay.pages.common.CartPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.CategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.CheckoutInformationPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SearchPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubSubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubcategoryProductsPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class WebTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "adam")
    // @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testProductSpecs() {

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CategoryProductsPageBase categoryProductsPage = homePage.selectCategory("Electronics");
        SubcategoryProductsPageBase subcategoryProductsPageBase = categoryProductsPage
                .selectSubcategory("Computers/Tablets & Networking");
        SubSubcategoryProductsPageBase subSubcategoryProductsPage = subcategoryProductsPageBase
                .selectSubSubcategory("Components and parts");
        ProductInfoPageBase productInfoPage = subSubcategoryProductsPage
                .selectProduct(Product.LAPTOP_REPLACEMENT_PARTS.getProductNames()[0]);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readTitle(), Product.LAPTOP_REPLACEMENT_PARTS.getProductNames()[0]);
        softAssert.assertEquals(productInfoPage.readPrice(), Product.LAPTOP_REPLACEMENT_PARTS.getProductPrices()[0]);
        softAssert.assertEquals(productInfoPage.readDescription(),
                Product.LAPTOP_REPLACEMENT_PARTS.getProductDescriptions()[0]);
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "adam")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testBuySerchedNewProduct() {

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SearchPageBase searchPage = homePage.searchProduct("bmw e30");
        List<ExtendedWebElement> searchResults = searchPage.getSerchedItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchResults.size() > 0, "No results!");
        /*
         * boolean foundMatchingResult = searchResults.stream()
         * .anyMatch(result -> result.getText().contains("BMWe30"));
         * Assert.assertTrue(foundMatchingResult,
         * "No matched results to searched parted: " + "BMWe30");
         */

        searchPage = searchPage.clickBuyFormat("Buy It Now");
        List<ExtendedWebElement> newSearchResults = searchPage.getSerchedItems();
        softAssert.assertTrue(newSearchResults.size() > 0, "No results!");

        searchPage = searchPage.clickCondition("New");
        newSearchResults = searchPage.getSerchedItems();
        softAssert.assertTrue(newSearchResults.size() > 0, "No results!");

        /*
         * boolean newFoundMatchingResult = newSearchResults.stream()
         * .anyMatch(result -> result.getText().contains("BMWe30"));
         * Assert.assertTrue(newFoundMatchingResult,
         * "No matched results to searched parted: " + "BMWe30");
         */

        ProductInfoPageBase productInfoPageBase = 
        searchPage.choseProduct("NEW E30 Bmw e30 Under dash kick panel E30 51451917353-51451884247- 51451917351");
        WindowUtils.switchToNewTabAndCloseOld(getDriver());
        softAssert.assertEquals(productInfoPageBase.readTitle(),"NEW E30 Bmw e30 Under dash kick panel E30 51451917353-51451884247- 51451917351");
        softAssert.assertEquals(productInfoPageBase.readPrice(),"US $85.00");
        softAssert.assertAll();
        productInfoPageBase.addToChart();
        CartPageBase cartPageBase = productInfoPageBase.clickInChartButton();
        cartPageBase = cartPageBase.clickCheckout();
        CheckoutInformationPageBase checkoutInformationPageBase = cartPageBase.clickGuestButtton();
    }
   
}
