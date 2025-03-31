package com.solvd.carina.tests.gui.yahoo.pages.desktop;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.tests.gui.yahoo.pages.common.StockPageBase;
import com.solvd.carina.tests.gui.yahoo.pages.common.SubSubcategoryFinancePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubSubcategoryFinancePageBase.class)
public class SubSubcategoryFinancePage  extends SubSubcategoryFinancePageBase{


    @FindBy(xpath = "//*[@data-testid='table-container']//span[@class='symbol yf-1fqyif7']")
    private List<ExtendedWebElement> stocksElements;
    
    @FindBy(xpath = "//*[@id='2']/td[1]/span/div/a/div/span")
    private ExtendedWebElement teslaElement;
    
    public SubSubcategoryFinancePage(WebDriver driver) {
        super(driver);
        waitForJSToLoad();
    }


    @Override
    public StockPageBase chooseStock(String stockName) {
        for(ExtendedWebElement stockElement :stocksElements){
            stockElement.scrollTo();
            String currentStockElement = stockElement.getText();
            if(stockName.equalsIgnoreCase(currentStockElement)){
                stockElement.click();
                return initPage(getDriver(), StockPageBase.class);
            }
            throw new NoSuchElementException(stockName + " can't be found");
        }
        return null;
        
    }
   @Override
    public StockPageBase chooseTeslaStock() {
        teslaElement.click();
        return initPage(getDriver(), StockPageBase.class);
    }


}
