package com.iiddd.base.pages;

import com.iiddd.base.core.BasePage;
import com.iiddd.base.core.DriverHolder;
import com.iiddd.base.extensions.MyElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GooglePage extends BasePage<GooglePage> {

    private static final By SEARCH_FIELD_LOCATOR = By.xpath(".//input[@title='Search']");
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath(".//input[@value='Google Search']");
    private static final String URL = "https://www.google.com/";

    @Step("Navigate to Google page")
    public GooglePage navigateToGooglePage() {
        DriverHolder.getDriver().get(URL);
        return this;
    }

    @Step("Input text \"{value}\" to Search field")
    public GooglePage inputTextToSearchField(String value) {
        getSearchField().clearAndType(value);
        return this;
    }

    @Step("Click Search button")
    public GooglePage clickSearchButton() {
        waitForPageToLoad();
        getSearchButton().click();
        return this;
    }

    private MyElement getSearchField() {
        return new MyElement(SEARCH_FIELD_LOCATOR, DriverHolder.getDriver());
    }

    private MyElement getSearchButton() {
        return new MyElement(SEARCH_BUTTON_LOCATOR, DriverHolder.getDriver());
    }

    public GooglePage checkUserIsOnGooglePage() {
        assertTrue(getSearchField().isDisplayed());
//        Assert.assertEquals(getDriver().getCurrentUrl(), URL);
        return this;
    }
}
