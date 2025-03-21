package com.solvd.carina.tests.gui.yahoo.pages.common;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class WeatherPageBase extends AbstractPage {


    public WeatherPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void chooseCity(String cityName);
    public abstract boolean isForecastFrameVisible();
    public abstract void chooseTemperatureType(String type);
    public abstract String getActiveTemperatureUnit(WebDriver driver);
    public abstract List<Map<String, String>> getForecastData();
    public abstract String getCurrentCityName();
    public abstract String getActiveTemperatureUnit();
}
