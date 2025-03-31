package com.solvd.carina.tests.gui.ebay.pages.desktop;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.ebay.enums.Country;
import com.solvd.carina.tests.gui.ebay.pages.common.CategoryProductsPageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.HomePageBase;
import com.solvd.carina.tests.gui.ebay.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Localized;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @Localized
    @FindBy(xpath = "//*[@id=\"gh\"]/nav/div[1]/span[1]/span")
    private ExtendedWebElement welcomeText;

    @FindBy(id = "gh-ac")
    private ExtendedWebElement searchBox;

    @FindBy(id = "gh-search-btn")
    private ExtendedWebElement searchButton;

    @FindBy(css = "li.vl-flyout-nav__js-tab > a")
    private List<ExtendedWebElement> categories;

    @FindBy(css = "#glbfooter > footer > div > div> div > div > div > button > div")
    private ExtendedWebElement languageButton;

    @FindBy(css = "#s0-1-6-1-1-18\\[2\\[4\\]\\]-7-dialog > div > ul > li > a > span")
    private List<ExtendedWebElement> languageList;


    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchBox);
        setUiLoadedMarker(searchButton);
        waitForJSToLoad();
    }

    @Override
    public void chooseLanguagePage() {
        openLaguageList();
        if (!languageList.isEmpty()) {
            for (ExtendedWebElement languageElement : languageList) {
                String localeString = Configuration.getRequired(WebDriverConfiguration.Parameter.LOCALE);
                Locale locale = parseLocale(localeString);
                String country = Country.getCountryNameByCode(locale.getCountry());
                if (languageElement.getText().equalsIgnoreCase(country)) {
                    languageElement.click();
                    break;
                }

            }
        }

    }

    @Override
    public String getSearchButtonText() {
        assertElementPresent(searchButton);
        return searchButton.getText();
    }

    @Override
    public String getWelcomeText() {
        if (welcomeText.isPresent()) {
            return welcomeText.getText();
        }
        throw new NoSuchElementException("Welcome Text is not present");
    }

    @Override
    public CategoryProductsPageBase selectCategory(String category) {
        LOGGER.info("selecting " + category + " category...");
        for (ExtendedWebElement categ : categories) {
            String currentCategory = categ.getText().trim();
            LOGGER.info("current category: " + currentCategory);
            if (category.equalsIgnoreCase(currentCategory)) {
                categ.click();
                return initPage(getDriver(), CategoryProductsPageBase.class);
            }

        }
        return null;
    }

    @Override
    public SearchPageBase searchProduct(String product) {
        LOGGER.info("selecting " + product + " product...");
        searchBox.click();
        searchBox.type(product);
        searchButton.click();
        return initPage(getDriver(), SearchPageBase.class);
    }

    private void openLaguageList() {
        languageButton.hover();
    }

    private Locale parseLocale(String localeToParse) {
        String[] localeSetttings = localeToParse.trim().split("_");
        String lang, country = "";
        lang = localeSetttings[0];
        if (localeSetttings.length > 1) {
            country = localeSetttings[1];
        }

        return Locale.of(lang, country);
    }

    /*
     * @Override
     * public SubcategoryProductsPageBase selectSubcategory(String subcategory) {
     * LOGGER.info("selecting " + subcategory + " subcategory...");
     * for (ExtendedWebElement subcateg : subcategories) {
     * String currentSubCategory = subcateg.getText();
     * LOGGER.info("current subcategory: " + subcategory);
     * if (subcategory.equalsIgnoreCase(currentSubCategory)) {
     * subcateg.click();
     * return initPage(getDriver(), SubcategoryProductsPageBase.class);
     * }
     * 
     * }
     * throw new RuntimeException("Unable to open subcategory: " + subcategory);
     * }
     */

}
