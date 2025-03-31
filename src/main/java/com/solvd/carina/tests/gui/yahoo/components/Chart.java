package com.solvd.carina.tests.gui.yahoo.components;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class Chart extends AbstractUIObject {

    @FindBy(xpath = "//*[@data-testid='tabs-container']//button")
    private List<ExtendedWebElement> periodFilter;

    @FindBy(xpath = ".//canvas")
    private ExtendedWebElement chartCanvas;

    public Chart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectPeriod(String chartPeriodName) {
        for (ExtendedWebElement period : periodFilter) {
            String current = period.getText();
            if (current.equalsIgnoreCase(chartPeriodName)) {
                period.click();
            }
        }
    }

    public void hoverChartAndClickOnPoint(double xPercent, double yPercent) {
        
        waitUntil(ExpectedConditions.and(
            ExpectedConditions.presenceOfElementLocated(chartCanvas.getBy()),
            ExpectedConditions.visibilityOf(chartCanvas.getElement())
        ), 10);

        chartCanvas.scrollTo();
        pause(1.0);

        Point pointOnChart = getCoordinates(chartCanvas.getElement(), xPercent, yPercent);

        try {
            Robot robot = new Robot();
            robot.mouseMove(pointOnChart.x, pointOnChart.y);

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            pause(5);

        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
    private Point getCoordinates(WebElement element, double xPercent, double yPercent) {

        Rectangle rect = element.getRect();
        Long scrollY = (Long) ((JavascriptExecutor) driver)
                .executeScript("return window.scrollY;");

        Long windowY = (Long) ((JavascriptExecutor) driver)
                .executeScript("return window.screenY;");

        int targetX = rect.getX() + (int) (rect.getWidth() * xPercent);
        int targetY = rect.getY() - scrollY.intValue() + windowY.intValue() + (int) (rect.getHeight() * yPercent);
        return new Point(targetX, targetY);
    }
}
