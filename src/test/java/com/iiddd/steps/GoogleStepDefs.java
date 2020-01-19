package com.iiddd.steps;

import com.iiddd.base.pages.GooglePage;
import com.iiddd.base.pages.GoogleResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.iiddd.base.core.DriverHolder.getDriver;

public class GoogleStepDefs {

    private static final String GOOGLE_URL = "http://www.google.com/";
    private GooglePage googlePage = new GooglePage();
    private GoogleResultsPage resultsPage = new GoogleResultsPage();

    @Given("navigate to Google website")
    public void navigateToGoogleWebsite() {
        getDriver().get(GOOGLE_URL);
    }

    @Given("check that user is on Google main page")
    public void userIsOnGoogleMainPage() {
        googlePage
                .checkUserIsOnGooglePage();
    }

    @When("User enters \"(.*)\" to search field")
    public void userEntersTextToSearchField(String text) {
        googlePage
                .waitForPageToLoad()
                .inputTextToSearchField(text)
                .clickSearchButton();
    }

    @When("User enters random string to search field")
    public void userEntersRandomStringToSearchField() {
//        throw new io.cucumber.java.PendingException();
    }

    @When("User clicks search button")
    public void userClicksButton() {
        googlePage.clickSearchButton();
    }

    @Then("\"(.*)\" element is in the list")
    public void checkElementIsInTheListByName(String name) {
        resultsPage
                .checkSearchResultIsDisplayed(name);
    }

    @Then("User is on results page")
    public void userIsOnResultsPage() {
        resultsPage
                .waitForPageToLoad()
                .checkUserIsOnSearchResultsPage();
    }

    @Then("No results found")
    public void noResultsFound() {
//        throw new io.cucumber.java.PendingException();
    }
}
