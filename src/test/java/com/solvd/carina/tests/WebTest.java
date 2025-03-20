package com.solvd.carina.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solvd.carina.tests.gui.ebay.ShipData;
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
import com.solvd.carina.tests.gui.ebay.pages.desktop.CheckoutInformationPage;
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
                softAssert.assertEquals(productInfoPage.readTitle(),
                                Product.LAPTOP_REPLACEMENT_PARTS.getProductNames()[0]);
                softAssert.assertEquals(productInfoPage.readPrice(),
                                Product.LAPTOP_REPLACEMENT_PARTS.getProductPrices()[0]);
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
                foundMatchingResults(searchPage);

                searchPage = searchPage.clickBuyFormat("Buy It Now");
                foundMatchingResults(searchPage);

                searchPage = searchPage.clickCondition("New");
                foundMatchingResults(searchPage);

                SoftAssert softAssert = new SoftAssert();
                ProductInfoPageBase productInfoPageBase = searchPage.choseProduct(
                                "NEW E30 Bmw e30 Under dash kick panel E30 51451917353-51451884247- 51451917351");
                WindowUtils.switchToNewTabAndCloseOld(getDriver());
                softAssert.assertEquals(productInfoPageBase.readTitle(),
                                "NEW E30 Bmw e30 Under dash kick panel E30 51451917353-51451884247- 51451917351");
                softAssert.assertEquals(productInfoPageBase.readPrice(), "US $85.00");
                productInfoPageBase.addToChart();
                CartPageBase cartPageBase = productInfoPageBase.clickInChartButton();
                cartPageBase = cartPageBase.clickCheckout();
                CheckoutInformationPageBase checkoutInformationPageBase = cartPageBase.clickGuestButtton();
                //softAssert.assertTrue(checkoutInformationPageBase.isPageOpened());
                checkoutInformationPageBase.fillShipInformations(ShipData.SHIPDATA1);
                Assert.assertEquals(checkoutInformationPageBase.getCity(), ShipData.SHIPDATA1.getCity());
                checkoutInformationPageBase.clickDoneButton();
                checkoutInformationPageBase.choosePaymentMethod("PayPal");
                softAssert.assertAll();
        }

        private void foundMatchingResults(SearchPageBase searchPageBase) {
                SoftAssert softAssert = new SoftAssert();
                List<ExtendedWebElement> searchResults = searchPageBase.getSerchedItems();
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                wait.until(driver -> searchResults.size() > 0);
                softAssert.assertTrue(searchResults.size() > 0, "No results!");
                /*
                 * boolean foundMatchingResult = searchResults.stream()
                 * .anyMatch(result ->
                 * result.getText().toLowerCase().contains("bmw e30".toLowerCase()));
                 * Assert.assertTrue(foundMatchingResult,
                 * "No matched results to searched parted: " + "bmw e30");
                 */
                softAssert.assertAll();
        }

}
