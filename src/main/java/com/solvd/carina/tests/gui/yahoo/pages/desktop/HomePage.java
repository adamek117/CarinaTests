package com.solvd.carina.tests.gui.yahoo.pages.desktop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.yahoo.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.SubcategoryFinancePageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.WeatherPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(css = "#ybar-l1-nav > li > button > span")
    private ExtendedWebElement moreCategory;
    
    @FindBy(xpath = "//*[@id='grid-layout']/div[2]/a")
    private ExtendedWebElement seeWeatherDetails;

    //@FindBy(css = "#ybar-l1-more-menu > ul > li> ul > li > a") // general subCategories
    @FindBy(css = "#ybar-l1-more-menu > ul > li:nth-child(4) > ul > li > a")  // Finance subCategories
    private List<ExtendedWebElement> subCategories;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(seeWeatherDetails);
        setUiLoadedMarker(moreCategory);
        waitForJSToLoad();
    }

    @Override
    public WeatherPageBase clickSeeMore() {
        seeWeatherDetails.click();
        return (initPage(getDriver(), WeatherPageBase.class));
    }

    @Override
    public SubcategoryFinancePageBase chooseFinanceSubcategory(String subcategory) {
        moreCategory.hover();
        for (ExtendedWebElement subcategoryElement : subCategories) {
            String currentSubcategoryElement = subcategoryElement.getText();
            if (subcategory.equalsIgnoreCase(currentSubcategoryElement)) {
                subcategoryElement.click();
                return initPage(getDriver(), SubcategoryFinancePageBase.class, subcategory);
            }
        }
        return null;
    }

}
