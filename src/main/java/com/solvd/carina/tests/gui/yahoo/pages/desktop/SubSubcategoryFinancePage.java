package com.solvd.carina.tests.gui.yahoo.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.yahoo.pages.common.StockPageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.SubSubcategoryFinancePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubSubcategoryFinancePageBase.class)
public class SubSubcategoryFinancePage  extends SubSubcategoryFinancePageBase{


    @FindBy(css = "td > span > div > a > div > span")
    private List<ExtendedWebElement> stocksElements;


    public SubSubcategoryFinancePage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }


    @Override
    public StockPageBase chooseStock(String stockName) {
        for(ExtendedWebElement stockElement :stocksElements){
            String currentStockElement = stockElement.getText();
            if(stockName.equalsIgnoreCase(currentStockElement)){
                stockElement.click();
                return initPage(getDriver(), StockPageBase.class);
            }
        }
        return null;
    }

}
