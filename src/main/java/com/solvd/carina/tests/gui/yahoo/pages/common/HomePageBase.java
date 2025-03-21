package com.solvd.carina.tests.gui.yahoo.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage {
    private ExtendedWebElement acceptCokkies;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public void open() {
        super.open();
        acceptCokkies.clickIfPresent(3);
    }

    public abstract WeatherPageBase clickSeeMore();

    public abstract SubcategoryFinancePageBase chooseFinanceSubcategory(String subcategory);

}
