package com.solvd.carina.tests.web.dataproviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import com.solvd.carina.tests.gui.ebay.components.ProductItem;
import com.solvd.carina.tests.gui.ebay.enums.Product;
import com.solvd.carina.tests.gui.ebay.pages.common.CategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.ProductInfoPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubSubcategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SubcategoryProductsPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class DataProviderEbayTests implements IAbstractTest {
    @DataProvider(name = "productData")
    public Object[][] productData() {
        return new Object[][] {
                { "TUID: PRODUCT1", "Electronics", "Computers/Tablets & Networking", "Components and parts",
                        Product.LAPTOP_REPLACEMENT_PARTS, 0 },
                { "TUID: PRODUCT2", "Electronics", "Computers/Tablets & Networking", "Components and parts",
                        Product.LAPTOP_REPLACEMENT_PARTS, 1 },
                { "TUID: PRODUCT3", "Electronics", "Computers/Tablets & Networking", "Components and parts",
                        Product.GPUS, 0 },
                { "TUID: PRODUCT4", "Electronics", "Computers/Tablets & Networking", "Components and parts",
                        Product.THERMAL_COMPOUNDS, 0 },
                { "TUID: PRODUCT5", "Electronics", "Computers/Tablets & Networking", "Components and parts",
                        Product.THERMAL_COMPOUNDS, 1 },
        };
    }

    @Test(dataProvider = "productData")
    public void testProductSpecs(String TUID, String category, String subcategory, String subSubcategory, Product product, Integer productIndex) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CategoryProductsPageBase categoryProductsPage = homePage.selectCategory(category);
        SubcategoryProductsPageBase subcategoryProductsPageBase = categoryProductsPage
                .selectSubcategory(subcategory);
        SubSubcategoryProductsPageBase subSubcategoryProductsPage = subcategoryProductsPageBase
                .selectSubSubcategory(subSubcategory);
        ProductInfoPageBase productInfoPage = subSubcategoryProductsPage
                .selectProduct(Product.LAPTOP_REPLACEMENT_PARTS.getProductNames()[productIndex]);

        ProductItem productItem = productInfoPage.getProduct();
        assertEquals(productItem.readProductTitle(), product.getProductNames()[productIndex]);
        assertEquals(productItem.readProductPrice(), product.getProductPrices()[productIndex]);

        String expectedDescription = product.getProductDescriptions().length > productIndex ? product.getProductDescriptions()[productIndex] : null;
        String actualDescription = productItem.readProductDescription();

        if (actualDescription != null && !expectedDescription.isEmpty() ) {
            assertEquals(actualDescription, expectedDescription, "Description mismatch for product: " + product.getProductNames()[productIndex]);
        } else {
            assertTrue(actualDescription == null || actualDescription.isEmpty(), "Description should be empty for product: " + product.getProductNames()[productIndex]);
        }
       
    }
}
