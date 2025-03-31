package com.solvd.carina.tests.gui.ebay.pages.common;

import org.openqa.selenium.WebDriver;

import com.solvd.carina.tests.gui.ebay.components.ProductItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ProductInfoPageBase extends AbstractPage {


    public ProductInfoPageBase(WebDriver driver) {
        super(driver);
    }

    /*public abstract String readPrice();

    public abstract String readDescription();

    public abstract String readTitle();*/
    public  abstract ProductItem getProduct();

    public abstract void addToChart();

    public abstract CartPageBase clickInChartButton();

}
