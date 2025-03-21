package com.solvd.carina.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.tests.gui.yahoo.enums.WeatherForecast;
import com.solvd.carina.tests.gui.yahoo.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.StockPageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.SubSubcategoryFinancePageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.SubcategoryFinancePageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.WeatherPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class WebYahooTests implements IAbstractTest {

    @Test
    @MethodOwner(owner = "adam")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testWeather() {

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        WeatherPageBase weatherPage = homePage.clickSeeMore();
        Assert.assertTrue(weatherPage.isForecastFrameVisible());

        weatherPage.chooseCity("New York");
        Assert.assertTrue(weatherPage.isForecastFrameVisible());
        Assert.assertEquals(weatherPage.getCurrentCityName(), "New York");

        List<Map<String, String>> forecastData = weatherPage.getForecastData();
        String activeUnit = weatherPage.getActiveTemperatureUnit(getDriver());

        List<Map<String, String>> expectedData = new ArrayList<>();
        for (WeatherForecast forecast : WeatherForecast.values()) {
            Map<String, String> data = new HashMap<>();
            data.put("day", forecast.getDay());
            // data.put("weatherCondition", forecast.getWeatherCondition());
            data.put("precipitation", forecast.getPrecipitation());

            if ("Celsius".equalsIgnoreCase(activeUnit)) {
                data.put("highTemperature", forecast.getCelsiusHighTemp());
                data.put("lowTemperature", forecast.getCelsiusLowTemp());
            } else if ("Fahrenheit".equalsIgnoreCase(activeUnit)) {
                data.put("highTemperature", forecast.getFahrenheitHighTemp());
                data.put("lowTemperature", forecast.getFahrenheitLowTemp());
            } else {
                throw new IllegalArgumentException("Invalid temperature unit: " + activeUnit);
            }
            expectedData.add(data);
        }

        for (int i = 0; i < expectedData.size(); i++) {
            Map<String, String> expected = expectedData.get(i);
            Map<String, String> actual = forecastData.get(i);

            Assert.assertEquals(expected.get("day"), actual.get("day"));
            // Assert.assertEquals(expected.get("weatherCondition"),
            // actual.get("weatherCondition"));
            Assert.assertEquals(expected.get("precipitation"), actual.get("precipitation"));
            Assert.assertEquals(expected.get("highTemperature"), actual.get("highTemperature"));
            Assert.assertEquals(expected.get("lowTemperature"), actual.get("lowTemperature"));
        }

        /*
         * weatherPage.chooseTemperatureType("C");
         * Assert.assertEquals(activeUnit,"Celsius","Active unit wrong understanded");
         */
        // System.out.println("Active Temperature Unit: " + activeUnit);

    }

    @Test
    @MethodOwner(owner = "adam")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testPopData() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SubcategoryFinancePageBase subcategoryFinancePageBase = homePage.chooseFinanceSubcategory("Markets");
        SubSubcategoryFinancePageBase subSubcategoryFinancePageBase = subcategoryFinancePageBase.selectMarketsSubSubcategory("Stocks: Most Actives");
        StockPageBase stockPageBase = subSubcategoryFinancePageBase.chooseStock("TSLA");
    }
}
