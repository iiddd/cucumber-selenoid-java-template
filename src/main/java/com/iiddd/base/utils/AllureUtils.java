package com.iiddd.base.utils;

import com.iiddd.base.core.DriverHolder;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static com.iiddd.base.utils.DateUtils.getCurrentDateAsString;

public class AllureUtils {

    public static final String ALLURE_RESULTS_DIRECTORY = "./allure-results/";

    public void attachScreenshot(String testUuid) {
        String screenshotName = doScreenshot();
        Allure.getLifecycle().updateTestCase(testUuid, testResult ->
                testResult.getSteps().get(testResult.getSteps().size() - 1).setAttachments(
                        Collections.singletonList(new Attachment()
                                .setType(null)
                                .setSource(screenshotName)
                                .setName(getCurrentDateAsString()))));
    }

    private String doScreenshot() {
        WebDriver augmentedDriver = new Augmenter().augment(DriverHolder.getDriver());
        Screenshot screenshot = new AShot().takeScreenshot(augmentedDriver);
        String screenshotName = UUID.randomUUID() + "-attachment";
        try {
            ImageIO.write(screenshot.getImage(), "png", prepareScreenshotFile(screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotName;
    }

    private File prepareScreenshotFile(String screenshotName) {
        File dir = new File(ALLURE_RESULTS_DIRECTORY);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return new File(String.format(ALLURE_RESULTS_DIRECTORY + "%s", screenshotName));
    }
}