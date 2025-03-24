package com.solvd.carina.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;
import java.util.Map;

import com.solvd.carina.tests.gui.yahoo.enums.WeatherForecast;
import com.solvd.carina.tests.gui.yahoo.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.WeatherPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class DataProviderYahooTests implements IAbstractTest {
    @DataProvider(name = "weatherForecastData")
    public Object[][] weatherForecastData() {
        return new Object[][] {
                { "TUID: DAY1", "C", WeatherForecast.DAY1 },
                { "TUID: DAY2", "C", WeatherForecast.DAY2 },
                { "TUID: DAY3", "C", WeatherForecast.DAY3 },
                { "TUID: DAY4", "C", WeatherForecast.DAY4 },
                { "TUID: DAY5", "C", WeatherForecast.DAY5},
                { "TUID: DAY6", "C", WeatherForecast.DAY6},
                { "TUID: DAY7", "C", WeatherForecast.DAY7 },
                { "TUID: DAY8", "C", WeatherForecast.DAY8 },
                { "TUID: DAY9", "C", WeatherForecast.DAY9},
                { "TUID: DAY10", "C", WeatherForecast.DAY10},
                { "TUID: DAY11", "C", WeatherForecast.DAY11},
                { "TUID: DAY1", "F", WeatherForecast.DAY1 },
                { "TUID: DAY2", "F", WeatherForecast.DAY2 },
                { "TUID: DAY3", "F", WeatherForecast.DAY3 },
                { "TUID: DAY4", "F", WeatherForecast.DAY4 },
                { "TUID: DAY5", "F", WeatherForecast.DAY5},
                { "TUID: DAY6", "F", WeatherForecast.DAY6},
                { "TUID: DAY7", "F", WeatherForecast.DAY7 },
                { "TUID: DAY8", "F", WeatherForecast.DAY8 },
                { "TUID: DAY9", "F", WeatherForecast.DAY9},
                { "TUID: DAY10", "F", WeatherForecast.DAY10},
                { "TUID: DAY11", "F", WeatherForecast.DAY11}
        };
    }

    @Test(dataProvider = "weatherForecastData")
    public void testWeather(String TUID, String temperatureUnit, WeatherForecast forecast) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");

        WeatherPageBase weatherPage = homePage.clickSeeMore();
        assertTrue(weatherPage.isForecastFrameVisible());

        weatherPage.chooseCity("New York");
        assertTrue(weatherPage.isForecastFrameVisible());
        // assertEquals(weatherPage.getCurrentCityName(), "New York");

        weatherPage.chooseTemperatureType(temperatureUnit);
        String activeUnit = weatherPage.getActiveTemperatureUnit();
        assertEquals(activeUnit, "Celsius", "Active unit wrong understanded");

        List<Map<String, String>> forecastData = weatherPage.getForecastData();
        if (forecastData.isEmpty()) {
            throw new AssertionError("Forecast data is empty");
        }
        
        assertEquals(forecast.getDay(), (forecastData.get(forecast.getIndex()).get("day")));
        assertEquals(forecast.getPrecipitation(), forecastData.get(forecast.getIndex()).get("precipitation"));
        if ("Celsius".equalsIgnoreCase(activeUnit)) {
            assertEquals(forecast.getCelsiusHighTemp(),
                    forecastData.get(forecast.getIndex()).get("celsiusHighTemp"));
            assertEquals(forecast.getCelsiusLowTemp(), forecastData.get(forecast.getIndex()).get("celsiusLowTemp"));
        } else if ("Fahrenheit".equalsIgnoreCase(activeUnit)) {
            assertEquals(forecast.getFahrenheitHighTemp(),
                    forecastData.get(forecast.getIndex()).get("fahrenheitHighTemp"));
            assertEquals(forecast.getFahrenheitLowTemp(),
                    forecastData.get(forecast.getIndex()).get("fahrenheitLowTemp"));
        } else {
            throw new IllegalArgumentException("Invalid temperature unit: " + activeUnit);
        }
    }

    /*
     * Map<String, String> data = new HashMap<>();
     * data.put("day", forecast.getDay());
     * data.put("precipitation", forecast.getPrecipitation());
     * if ("Celsius".equalsIgnoreCase(activeUnit)) {
     * data.put("celsiusHighTemp", forecast.getCelsiusHighTemp());
     * data.put("celsiusLowTemp", forecast.getCelsiusLowTemp());
     * } else if ("Fahrenheit".equalsIgnoreCase(activeUnit)) {
     * data.put("fahrenheitHighTemp", forecast.getFahrenheitHighTemp());
     * data.put("fahrenheitLowTemp", forecast.getFahrenheitLowTemp());
     * } else {
     * throw new IllegalArgumentException("Invalid temperature unit: " + activeUnit)
     * }
     */

}
