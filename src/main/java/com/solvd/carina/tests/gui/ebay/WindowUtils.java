package com.solvd.carina.tests.gui.ebay;

import org.openqa.selenium.WebDriver;

public class WindowUtils {

    public static void switchToNewTabAndCloseOld(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.switchTo().window(originalWindow).close();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            break;
        }
    }
}