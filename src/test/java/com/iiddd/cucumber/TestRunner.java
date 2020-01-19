package com.iiddd.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "com.iiddd.steps",
        stepNotifications = true,
        plugin = {"pretty", "html:target/cucumber", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "com.iiddd.base.core.TestListener"}
)

public class TestRunner {
}