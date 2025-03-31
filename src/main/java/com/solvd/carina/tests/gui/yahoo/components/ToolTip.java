package com.solvd.carina.tests.gui.yahoo.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class ToolTip extends AbstractUIObject {
    
    @FindBy(xpath = ".//tr[1]/td[1]")
    private ExtendedWebElement dateField;

    @FindBy(xpath = "//tr[2]/td[1]")
    private ExtendedWebElement closeField;

    @FindBy(xpath = "//tr[3]/td[1]")
    private ExtendedWebElement openField;

    @FindBy(xpath = "//tr[4]/td[1]")
    private ExtendedWebElement highField;

    @FindBy(xpath = "//tr[5]/td[1]")
    private ExtendedWebElement lowField;

    @FindBy(xpath = "//tr[6]/td[1]")
    private ExtendedWebElement volumeField;

    public ToolTip(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getDateFieldName() {
        return dateField.getText();
    }

    public String getCloseFieldName() {
        return closeField.getText();
    }

    public String getOpenFieldName() {
        return openField.getText();
    }

    public String getHighFieldName() {
        return highField.getText();
    }

    public String getLowFieldName() {
        return lowField.getText();
    }

    public String getVolumeFieldName() {
        return volumeField.getText();
    }
}
