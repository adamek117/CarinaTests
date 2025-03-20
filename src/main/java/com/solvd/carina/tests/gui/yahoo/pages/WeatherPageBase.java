package com.solvd.carina.tests.gui.yahoo.pages;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class WeatherPageBase extends AbstractPage {

    public abstract WeatherPageBase chooseCity(String cityName);

    public WeatherPageBase(WebDriver driver) {
        super(driver);
    }

}
