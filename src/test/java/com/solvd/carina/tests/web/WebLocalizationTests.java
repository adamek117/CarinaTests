package com.solvd.carina.tests.web;

import java.util.Locale;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

import com.solvd.carina.tests.gui.ebay.pages.common.HomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.resources.L10N;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;

public class WebLocalizationTests extends AbstractTest {

    @BeforeClass
    public void testLocaleLoad() {
        Locale locale = L10N.getLocale();
        String loadedLocale = locale.getLanguage() + "_" + locale.getCountry();
        String configLocale = Configuration.getRequired(WebDriverConfiguration.Parameter.LOCALE);
        assertEquals(loadedLocale, configLocale);
    }

    @Test
    @MethodOwner(owner = "adam")
    @TestLabel(name = "feature", value ="l10n")
    public void testElementsSearchWithL10n(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.chooseLanguagePage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getWelcomeText(),L10N.getText("EbayPage.welcomeText"));
        softAssert.assertEquals(homePage.getSearchButtonText(),L10N.getText("EbayPage.buttonText"));
        softAssert.assertAll();

    }

}
