package com.solvd.carina.tests.gui.yahoo.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = WeatherPageBase.class)
public class WeatherPage extends WeatherPageBase {
    private static final Logger LOGGER = LogManager.getLogger(WeatherPageBase.class);

    @FindBy(css = "#module-weather-popular-locations > ul > a")
    private List<ExtendedWebElement> cities;
    

    public WeatherPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public WeatherPageBase chooseCity(String cityName) {
        for (ExtendedWebElement city : cities) {
            String currentCity = city.getText().trim();
            LOGGER.info("current category: " + currentCity);
            if (cityName.equalsIgnoreCase(currentCity)) {
                city.click();
                return initPage(getDriver(), WeatherPageBase.class);
            }
        }
        return null;
    }

}
