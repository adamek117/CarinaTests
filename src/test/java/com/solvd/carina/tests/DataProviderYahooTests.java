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
                { "TUID: DAY1", "C", WeatherForecast.THURSDAY },
                { "TUID: DAY2", "C", WeatherForecast.FRIDAY },
                { "TUID: DAY3", "C", WeatherForecast.SATURDAY },
                { "TUID: DAY4", "C", WeatherForecast.SUNDAY },
                { "TUID: DAY5", "C", WeatherForecast.MONDAY },
                { "TUID: DAY6", "C", WeatherForecast.TUESDAY },
                { "TUID: DAY7", "C", WeatherForecast.WEDNESDAY },
                { "TUID: DAY8", "C", WeatherForecast.NEXT_THURSDAY },
                { "TUID: DAY9", "C", WeatherForecast.NEXT_FRIDAY },
                { "TUID: DAY10", "C", WeatherForecast.NEXT_SATURDAY },
                { "TUID: DAY11", "C", WeatherForecast.NEXT_SUNDAY },
                { "TUID: DAY1", "F", WeatherForecast.THURSDAY },
                { "TUID: DAY2", "F", WeatherForecast.FRIDAY },
                { "TUID: DAY3", "F", WeatherForecast.SATURDAY },
                { "TUID: DAY4", "F", WeatherForecast.SUNDAY },
                { "TUID: DAY5", "F", WeatherForecast.MONDAY },
                { "TUID: DAY6", "F", WeatherForecast.TUESDAY },
                { "TUID: DAY7", "F", WeatherForecast.WEDNESDAY },
                { "TUID: DAY8", "F", WeatherForecast.NEXT_THURSDAY },
                { "TUID: DAY9", "F", WeatherForecast.NEXT_FRIDAY },
                { "TUID: DAY10", "F", WeatherForecast.NEXT_SATURDAY },
                { "TUID: DAY11", "F", WeatherForecast.NEXT_SUNDAY }
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
