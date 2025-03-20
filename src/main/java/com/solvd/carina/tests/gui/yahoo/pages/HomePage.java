package com.solvd.carina.tests.gui.yahoo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);


    @FindBy(xpath="//*[@id='grid-layout']/div[2]/a")
    private ExtendedWebElement seeMoreWeather;
    
    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(seeMoreWeather);
        waitForJSToLoad();
    }

    @Override
    public WeatherPageBase clickSeeMore() {
        seeMoreWeather.click();
        return(initPage(getDriver(), WeatherPageBase.class));
    }

}
