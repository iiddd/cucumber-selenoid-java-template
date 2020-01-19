package com.iiddd.steps;

import com.iiddd.base.core.DriverHolder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;

import java.util.concurrent.TimeUnit;

import static com.iiddd.base.core.DriverHolder.getDriver;

public class Hooks {

    @Before
    public void beforeAnyTest() {
        BasicConfigurator.configure(new NullAppender());
        DriverHolder.initDriver();
        getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void afterTest() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
