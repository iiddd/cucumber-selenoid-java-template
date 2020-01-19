package com.iiddd.base.core;

import com.iiddd.base.utils.AllureUtils;
import cucumber.api.event.ConcurrentEventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestStepFinished;
import io.qameta.allure.Allure;

public class TestListener implements ConcurrentEventListener {

    AllureUtils allureUtils = new AllureUtils();
    private String testUuid;

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::onStepFinish);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onTestStart);
    }

    public void onStepFinish(TestStepFinished event) {
        if (event.result.getStatus().name().equals("FAILED")) {
            allureUtils.attachScreenshot(testUuid);
        }
    }

    public void onTestStart(TestCaseStarted event) {
        testUuid = Allure.getLifecycle().getCurrentTestCase().get();
    }
}