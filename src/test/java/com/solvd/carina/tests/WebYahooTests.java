package com.solvd.carina.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.tests.gui.yahoo.pages.HomePageBase;
import com.solvd.carina.tests.gui.yahoo.pages.WeatherPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class WebYahooTests implements IAbstractTest{
 
    @Test
    @MethodOwner(owner = "adam")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testWeather(){

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        WeatherPageBase weatherPage = homePage.clickSeeMore();
        weatherPage = weatherPage.chooseCity("New York");

    }
}
