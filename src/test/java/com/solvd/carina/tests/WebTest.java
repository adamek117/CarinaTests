package com.solvd.carina.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;

import static com.solvd.carina.tests.intefaces.TestData.EbayTestData.*;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solvd.carina.tests.gui.ebay.enums.Product;
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
        @TestLabel(name = "feature", value = { "web", "regression" })
        public void testProductSpecs() {

                HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
                homePage.open();
                assertTrue(homePage.isPageOpened(), "Home page is not opened");

                CategoryProductsPageBase categoryProductsPage = homePage.selectCategory(CATEGORY);
                SubcategoryProductsPageBase subcategoryProductsPageBase = categoryProductsPage
                                .selectSubcategory(SUBCATEGORY);
                SubSubcategoryProductsPageBase subSubcategoryProductsPage = subcategoryProductsPageBase
                                .selectSubSubcategory(SUBSUBCATEGORY);
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
                assertTrue(homePage.isPageOpened(), "Home page is not opened");

                SearchPageBase searchPage = homePage.searchProduct(SEARCH_DATA);
                foundMatchingResults(searchPage);

                searchPage = searchPage.clickBuyFormat(BUYING_FORMAT);
                foundMatchingResults(searchPage);

                searchPage = searchPage.clickCondition(CONDITION);
                foundMatchingResults(searchPage);

                SoftAssert softAssert = new SoftAssert();
                ProductInfoPageBase productInfoPageBase = searchPage.choseProduct(PRODUCT_NAME);

                softAssert.assertEquals(productInfoPageBase.readTitle(),PRODUCT_NAME);
                softAssert.assertEquals(productInfoPageBase.readPrice(), PRODUCT_PRICE);
                productInfoPageBase.addToChart();
                CartPageBase cartPageBase = productInfoPageBase.clickInChartButton();
                cartPageBase.clickCheckout();
                CheckoutInformationPageBase checkoutInformationPageBase = cartPageBase.clickGuestButtton();
                checkoutInformationPageBase.fillShipInformations(SHIP_DATA);
                assertEquals(checkoutInformationPageBase.getCity(), SHIP_DATA.getCity());
                checkoutInformationPageBase.clickDoneButton();
                checkoutInformationPageBase.choosePaymentMethod(PAYMENT_METHOD);
                softAssert.assertAll();
        }

        private void foundMatchingResults(SearchPageBase searchPageBase) {
                SoftAssert softAssert = new SoftAssert();
                List<ExtendedWebElement> searchResults = searchPageBase.getSerchedItems();
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                wait.until(driver -> searchResults.size() > 0);
                softAssert.assertTrue(searchResults.size() > 0, "No results!");
                softAssert.assertAll();
                /*
                 * boolean foundMatchingResult = searchResults.stream()
                 * .anyMatch(result ->
                 * result.getText().toLowerCase().contains("bmw e30".toLowerCase()));
                 * Assert.assertTrue(foundMatchingResult,
                 * "No matched results to searched parted: " + "bmw e30");
                 */

        }

}
