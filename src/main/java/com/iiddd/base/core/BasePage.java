package com.iiddd.base.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class is used to store methods, required for all com.iiddd.base.pages
 */

public class BasePage<T extends BasePage> {

    private static final int TIMEOUT_1_SEC = 1000;
    private static final int TIMEOUT_10_SEC = 10000;

    public T waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) DriverHolder.getDriver())
                .executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(TIMEOUT_1_SEC);
            WebDriverWait wait = new WebDriverWait(DriverHolder.getDriver(), TIMEOUT_10_SEC);
            wait.until(expectation);
        } catch (Throwable error) {
            fail("Timeout waiting for Page Load Request to complete.");
        }
        return (T) this;
    }

    // this wait is needed in case it's not handy to use conditions
    public T waitForSomeTime(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Throwable error) {
        }
        return (T) this;
    }

    public void navigateTo(String url) {
        DriverHolder.getDriver().get(url);
    }
}