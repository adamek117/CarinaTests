package com.solvd.carina.tests.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.solvd.carina.tests.intefaces.TestData.YahooTestData.*;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.solvd.carina.tests.gui.yahoo.components.Chart;
import com.solvd.carina.tests.gui.yahoo.components.ToolTip;
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
        assertTrue(homePage.isPageOpened(), "Home page is not opened");

        WeatherPageBase weatherPage = homePage.clickSeeMore();
        assertTrue(weatherPage.isForecastFrameVisible());

        weatherPage.chooseCity(CITY_NAME);
        assertTrue(weatherPage.isForecastFrameVisible());
        assertEquals(weatherPage.getCurrentCityName(),CITY_NAME);

        List<Map<String, String>> forecastData = weatherPage.getForecastData();
        String activeUnit = weatherPage.getActiveTemperatureUnit();

        List<Map<String, String>> expectedData = new ArrayList<>();
        for (WeatherForecast forecast : WeatherForecast.values()) {
            Map<String, String> data = new HashMap<>();
            data.put("day", forecast.getDay());
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

            assertEquals(expected.get("day"), actual.get("day"));
            assertEquals(expected.get("precipitation"), actual.get("precipitation"));
            assertEquals(expected.get("highTemperature"), actual.get("highTemperature"));
            assertEquals(expected.get("lowTemperature"), actual.get("lowTemperature"));
        }
    }

    @Test
    @MethodOwner(owner = "adam")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testPopData() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SubcategoryFinancePageBase subcategoryFinancePageBase = homePage.chooseFinanceSubcategory(FINANCE_SUBCATEGORY);
        assertTrue(subcategoryFinancePageBase.isUrlAsExpected("https://finance.yahoo.com/calendar/"));
        SubSubcategoryFinancePageBase subSubcategoryFinancePageBase = subcategoryFinancePageBase.selectMarketsSubSubcategory(MARKETS_SUBCATEGORY);
        StockPageBase stockPageBase = subSubcategoryFinancePageBase.chooseTeslaStock();
        Chart chart =stockPageBase.getChart();
        chart.selectPeriod(CHART_PERIOD_NAME);
        chart.hoverChartAndClickOnPoint(X_PERCENT, Y_PERCENT);
        ToolTip tooltip = stockPageBase.getTooltip();

        assertTrue(tooltip.getDateFieldName().equalsIgnoreCase(DATE));
        assertTrue(tooltip.getCloseFieldName().equalsIgnoreCase(CLOSE));
        assertTrue(tooltip.getOpenFieldName().equalsIgnoreCase(OPEN));
        assertTrue(tooltip.getHighFieldName().equalsIgnoreCase(HIGH));
        assertTrue(tooltip.getLowFieldName().equalsIgnoreCase(LOW));
        assertTrue(tooltip.getVolumeFieldName().equalsIgnoreCase(VOLUME));
        
    }
} 
