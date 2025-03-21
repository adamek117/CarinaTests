package com.solvd.carina.tests.gui.yahoo.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = WeatherPageBase.class)
public class WeatherPage extends WeatherPageBase {
    private static final Logger LOGGER = LogManager.getLogger(WeatherPageBase.class);

    @FindBy(css = "#module-weather-popular-locations > ul > li > a")

    private List<ExtendedWebElement> cities;

    @FindBy(css = "#module-location-heading > div.M(10px) > div > div:nth-child(1) > h1")
    private ExtendedWebElement currentCityName;

    @FindBy(id = "module-weather-forecast")
    private ExtendedWebElement forecastFrame;

    @FindBy(id = "celsius")
    private ExtendedWebElement celsius;

    @FindBy(id = "fahrenheit")
    private ExtendedWebElement fahrenheit;

    @FindBy(css = "#module-weather-forecast > table > tbody > tr > td:nth-child(1) > button")
    private List<ExtendedWebElement> days;

    @FindBy(css = "#module-weather-forecast > table > tbody > tr > td.Ta(c).W(25%) > img")
    private List<ExtendedWebElement> forecastImages;

    @FindBy(css = "#module-weather-forecast > table > tbody > tr > td.W(25%).Fz(0.75rem).D(f).Jc(c) > img")
    private List<ExtendedWebElement> imagesOfPrecitipation;

    @FindBy(css = "#module-weather-forecast > table > tbody > tr > td.W\\(25\\%\\).Fz\\(0\\.75rem\\)\\.D\\(f\\)\\.Jc\\(c\\) > dl > dd")
    private List<ExtendedWebElement> percetangesOfPrecitipation;

    @FindBy(css = "#module-weather-forecast > table > tbody > tr> td.W\\(25\\%\\).D\\(f\\).Jc\\(fe\\).Ta\\(end\\) > dl > dd:nth-child(2)")
    private List<ExtendedWebElement> highTemperatureFahrenheit;

    @FindBy(css = "#module-weather-forecast > table > tbody > tr > td.W\\(25\\%\\).D\\(f\\).Jc\\(fe\\).Ta\\(end\\) > dl > dd:nth-child(4)")
    private List<ExtendedWebElement> highTemperatureCelsius;

    @FindBy(css = "#module-weather-forecast > table > tbody > tr> td.W\\(25\\%\\).D\\(f\\).Jc\\(fe\\).Ta\\(end\\) > dl > dd.Pstart\\(10px\\).C\\(\\$lowTemperatureColor\\).D\\(b\\).celsius_D\\(n\\).W\\(25px\\")
    private List<ExtendedWebElement> lowTemperatureFahrenheit;

    @FindBy(css = "#module-weather-forecast > table > tbody > tr> td.W\\(25\\%\\).D\\(f\\).Jc\\(fe\\).Ta\\(end\\) > dl > dd.Pstart\\(10px\\).C\\(\\$lowTemperatureColor\\).D\\(n\\).celsius_D\\(b\\).W\\(25px\\)")
    private List<ExtendedWebElement> lowTemperatureCelsius;

    public WeatherPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public void chooseCity(String cityName) {
        for (ExtendedWebElement city : cities) {
            String currentCity = city.getText().trim();
            LOGGER.info("current city: " + currentCity);
            if (cityName.equalsIgnoreCase(currentCity)) {
                city.click();
                break;
            }
        }
    }

    @Override
    public boolean isForecastFrameVisible() {
        return forecastFrame.isElementPresent() && forecastFrame.isVisible();
    }

    @Override
    public void chooseTemperatureType(String type) {
        if (type.equals(celsius.getText())) {
            celsius.click();
        } else {
            fahrenheit.click();
        }

    }

    @Override
    public String getActiveTemperatureUnit() {
        if ("true".equals(celsius.getAttribute("aria-selected")) || celsius.getAttribute("class").contains("active")) {
            return "Celsius";
        } else if ("true".equals(fahrenheit.getAttribute("aria-selected"))
                || fahrenheit.getAttribute("class").contains("active")) {
            return "Fahrenheit";
        }
        return "None is active";
    }

    @Override
    public String getActiveTemperatureUnit(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement activeElement = (WebElement) js.executeScript("return document.activeElement;");

        if (activeElement.equals(celsius.getElement())) {
            return "Celsius";
        } else {
            return "Fahrenheit";
        }
    }

    @Override
    public List<Map<String, String>> getForecastData() {
        List<Map<String, String>> allForecastData = new ArrayList<>();
        Integer rowCount = days.size() - 1;
        for (int i = 0; i < rowCount; i++) {
            Map<String, String> forecastData = new HashMap<>();
            forecastData.put("day", days.get(i).getText());
            if (getActiveTemperatureUnit(getDriver()) == "Celsius") {
                highTemperatureCelsius.get(i).waitUntil(ExpectedConditions.visibilityOf(highTemperatureCelsius.get(i)),
                        Duration.ofSeconds(10));
                forecastData.put("highTemperatureCelsius", highTemperatureCelsius.get(i).getText());
                lowTemperatureCelsius.get(i).waitUntil(ExpectedConditions.visibilityOf(lowTemperatureCelsius.get(i)),
                        Duration.ofSeconds(10));
                forecastData.put("lowTemperatureCelsius", lowTemperatureCelsius.get(i).getText());
                allForecastData.add(forecastData);
            } else {
                highTemperatureFahrenheit.get(i).waitUntil(
                        ExpectedConditions.visibilityOf(highTemperatureFahrenheit.get(i)),
                        Duration.ofSeconds(10));
                forecastData.put("highTemperatureCelsius", highTemperatureCelsius.get(i).getText());
                highTemperatureFahrenheit.get(i).waitUntil(
                        ExpectedConditions.visibilityOf(lowTemperatureCelsius.get(i)),
                        Duration.ofSeconds(10));
                forecastData.put("lowTemperatureCelsius", highTemperatureFahrenheit.get(i).getText());
            }
            allForecastData.add(forecastData);
        }
        return allForecastData;

    }

}
