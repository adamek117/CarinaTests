package com.solvd.carina.tests.intefaces;

import com.solvd.carina.tests.gui.ebay.enums.BuyingFormat;
import com.solvd.carina.tests.gui.ebay.enums.Condition;
import com.solvd.carina.tests.gui.ebay.enums.Product;
import com.solvd.carina.tests.gui.ebay.enums.ShipData;



public interface TestData {
    interface EbayTestData {
        String CATEGORY = "Electronics";
        String SUBCATEGORY = "Computers/Tablets & Networking";
        String SUBSUBCATEGORY = "Components and parts";
        String SEARCH_DATA = "bmw e30";
        String PRODUCT_NAME = "NEW E30 Bmw e30 Under dash kick panel E30 51451917353-51451884247- 51451917351";
        String PRODUCT_PRICE = "US $85.00";
        String PAYMENT_METHOD = "PayPal";
        String BUYING_FORMAT = BuyingFormat.BUY_IT_NOW.getFormatName();
        String CONDITION = Condition.NEW.getConditionName();
        ShipData SHIP_DATA = ShipData.SHIPDATA1;
        Product SELECTED_PRODUCT_TYPE = Product.LAPTOP_REPLACEMENT_PARTS;
    }
    interface YahooTestData {
        String CITY_NAME = "New York";
        String TEMPERATURE_UNIT = "C";
        String FINANCE_SUBCATEGORY = "Markets";
        String MARKETS_SUBCATEGORY = "Stocks: Most Actives";
        String STOCK_NAME = "TSLA";    
    }
}
