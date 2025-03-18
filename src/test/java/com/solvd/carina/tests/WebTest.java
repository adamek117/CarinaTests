package com.solvd.carina.tests;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solvd.carina.tests.gui.ebay.components.Product;
import com.solvd.carina.tests.gui.ebay.pages.common.CategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubSubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubcategoryProductsPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;




public class WebTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "adam")
    //@TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testProductSpecs() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CategoryProductsPageBase categoryProductsPage = homePage.selectCategory("Electronics");
        
        SubcategoryProductsPageBase subcategoryProductsPageBase = categoryProductsPage.selectSubcategory( "Computers/Tablets & Networking");
        SubSubcategoryProductsPageBase subSubcategoryProductsPage = subcategoryProductsPageBase.selectSubSubcategory("Components and parts");
        ProductInfoPageBase productInfoPage = subSubcategoryProductsPage.selectProduct(Product.LAPTOP_REPLACEMENT_PARTS.getProductNames()[0]);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readTitle(),Product.LAPTOP_REPLACEMENT_PARTS.getProductNames()[0] );
        softAssert.assertEquals(productInfoPage.readPrice(), "US $199.99");
        softAssert.assertEquals(productInfoPage.readDescription(),"OEM Genuine Parts! Please Read Description and See Photos for Condition Guide. Tested to be 100%");
        softAssert.assertAll();  

    /*@Test
    @MethodOwner(owner = "adam")
    public void testBuyNewProduct(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }*/
}
}
