package com.solvd.carina.tests.gui.yahoo.pages.desktop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.yahoo.components.Chart;
import com.solvd.carina.tests.gui.yahoo.components.ToolTip;
import com.solvd.carina.tests.gui.yahoo.pages.common.StockPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = StockPageBase.class)
public class StockPage extends StockPageBase{
  
    @FindBy(xpath = "//*[@data-testid='chart-container']")
    private Chart chart;
    
    @FindBy(xpath = "//table[contains(@class, 'hu-tooltip')]")
    private ToolTip tooltip;

    public StockPage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }

    @Override
    public Chart getChart() {
        return chart;
    }

    @Override
    public ToolTip getTooltip() {
        return tooltip;
    }
    
}
