package com.solvd.carina.tests.gui.yahoo.pages.common;


import org.openqa.selenium.WebDriver;

import com.solvd.carina.tests.gui.yahoo.components.Chart;
import com.solvd.carina.tests.gui.yahoo.components.ToolTip;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class StockPageBase extends AbstractPage{

    public StockPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Chart getChart();
    public abstract ToolTip getTooltip();
}
 