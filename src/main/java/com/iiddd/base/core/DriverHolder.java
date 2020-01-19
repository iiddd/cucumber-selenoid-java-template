package com.iiddd.base.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class is used to init and store Webdriver
 */

public class DriverHolder {

    private static final String BROWSER_PROPERTY = "browser";
    private static final String FF_DRIVER_PROPERTY = "gecko";
    private static final String CHROME_DRIVER_PROPERTY = "chrome";
    private static final String HEADLESS_PROPERTY = "headless";
    private static final String HUB_URL = "http://localhost:4444";
    private static WebDriver driver;

    public static WebDriver initDriver() {
        if (getProfileBrowserProperty().equals(CHROME_DRIVER_PROPERTY)) {
            return getChromeDriver();
        }
        if (getProfileBrowserProperty().equals(FF_DRIVER_PROPERTY)) {
            return getFFDriver();
        }
        if (getProfileBrowserProperty().equals(CHROME_DRIVER_PROPERTY + "-remote")) {
            return getRemoteChromeDriver();
        }
        if (getProfileBrowserProperty().equals(FF_DRIVER_PROPERTY + "-remote")) {
            return getRemoteFFDriver();
        } else return getChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver getFFDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("intl.accept_languages", "en-GB");
        firefoxOptions.setProfile(firefoxProfile);
        firefoxOptions.setHeadless(isHeadless());
        driver = new FirefoxDriver(firefoxOptions);
        return driver;
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-GB");
        chromeOptions.setHeadless(isHeadless());
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    private static WebDriver getRemoteChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=zh");
        chromeOptions.setCapability("enableVNC", true);
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL + "/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver getRemoteFFDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("intl.accept_languages", "en-GB");
        firefoxOptions.setProfile(firefoxProfile);
        firefoxOptions.setHeadless(isHeadless());
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL + "/wd/hub"), firefoxOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;

    }

    private static String getProfileBrowserProperty() {
        return System.getProperty(BROWSER_PROPERTY);
    }

    private static boolean isHeadless() {
        return Boolean.parseBoolean(System.getProperty(HEADLESS_PROPERTY));
    }
}