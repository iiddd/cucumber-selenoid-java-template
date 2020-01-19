package com.iiddd.base.pages;

import com.iiddd.base.core.BasePage;

import static com.iiddd.base.core.DriverHolder.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleResultsPage extends BasePage<GoogleResultsPage> {

    private static final String GOOGLE_RESULTS_URL = "";

    public GoogleResultsPage checkUserIsOnSearchResultsPage() {
        assertEquals(getDriver().getCurrentUrl(), GOOGLE_RESULTS_URL);
        return this;
    }

    public GoogleResultsPage checkSearchResultIsDisplayed(String name) {
        return this;
    }
}
