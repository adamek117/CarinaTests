package com.solvd.carina.tests;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solvd.carina.tests.gui.ebay.pages.common.CategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubSubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.desktop.CategoryProductsPage;
import com.solvd.carina.tests.gui.ebay.pages.desktop.ProductInfoPage;
import com.solvd.carina.tests.gui.ebay.pages.desktop.SubSubcategoryProductsPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.config.Configuration;



public class WebTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "adam")
    //@TestPriority(Priority.P3)
    //@TestLabel(name = "feature", value = { "web", "regression" })
    public void testProductSpecs() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CategoryProductsPageBase categoryProductsPage = homePage.selectCategory("Electronics");

        SubcategoryProductsPageBase subcategoryProductsPageBase = categoryProductsPage.selectSubcategory( "Computers/Tablets & Networking");
        
        SubSubcategoryProductsPageBase subSubcategoryProductsPage = subcategoryProductsPageBase.selectSubSubcategory("Components and parts");

        ProductInfoPageBase productInfoPage = subSubcategoryProductsPage.selectProduct("OEM Genuine Apple MacBook Pro A1990 2018 2019 15\" LCD Screen Display Assembly");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readTitle(),"OEM Genuine Apple MacBook Pro A1990 2018 2019 15\" LCD Screen Display Assembly" );
        softAssert.assertEquals(productInfoPage.readPrice(), "US $199.99");
        softAssert.assertEquals(productInfoPage.readDescription(),"OEM Genuine Parts! Please Read Description and See Photos for Condition Guide. Tested to be 100%");
        softAssert.assertAll();
       /* // Select phone brand
        BrandModelsPageBase productsPage = homePage.selectBrand("Samsung");
        // Select phone model
        ModelInfoPageBase productInfoPage = productsPage.selectModel("Galaxy A04");
        // Verify phone specifications
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
        softAssert.assertEquals(productInfoPage.readCamera(), "50MP", "Invalid camera info!");
        softAssert.assertEquals(productInfoPage.readRam(), "3-8GB RAM", "Invalid ram info!");
        softAssert.assertEquals(productInfoPage.readBattery(), "5000mAh", "Invalid battery info!");
        softAssert.assertAll();*/
    }

    @Test
    @MethodOwner(owner = "adam")
    public void testBuyNewProduct(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

    }
}
