package com.solvd.carina.tests.gui.yahoo.pages.desktop;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.yahoo.pages.common.SubSubcategoryFinancePageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.SubcategoryFinancePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubcategoryFinancePageBase.class)
public class SubcategoryFinancePage extends SubcategoryFinancePageBase {

    @FindBy(css = "#ybar-navigation > div > ul > li > a > span")
    private List<ExtendedWebElement> categories;

    @FindBy(css = "#ybar-navigation > div > ul > li:nth-child(3) > div > ul > li > a > div")
    private List<ExtendedWebElement> allMarketsSubcategories;

    public SubcategoryFinancePage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }

    @Override
    public SubSubcategoryFinancePageBase selectMarketsSubSubcategory(String subSubcategory) {
        Optional<ExtendedWebElement> marketsCategory = categories.stream()
                .filter(category -> "markets".equalsIgnoreCase(category.getText().trim())).findFirst();
        if (marketsCategory.isPresent()) {
            marketsCategory.get().hover();
            for (ExtendedWebElement subSubcategoryElement : allMarketsSubcategories) {
                String currentSubsubcategoryElement = subSubcategoryElement.getText();
                if (subSubcategory.equalsIgnoreCase(currentSubsubcategoryElement)) {
                    subSubcategoryElement.click();
                    return initPage(getDriver(), SubSubcategoryFinancePageBase.class);
                }
            }
        } else {
            throw new NoSuchElementException("Category 'markets' not found.");
        }
        throw new NoSuchElementException("Finance subcategory ${subSubCategory} not found.");
    }
}
