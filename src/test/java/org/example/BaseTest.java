package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Platform;

public class BaseTest {
    public static final String APP_ID = "com.google.android.deskclock";
    private static AppiumDriverLocalService service;
    protected static AndroidDriver driver;

    private static final Platform platform = Platform.ANDROID;

    @BeforeAll
    public static void beforeClass() {
        service = new DefaultAppiumService().get();
        service.start();
        driver = (AndroidDriver) new DriverManager(service, new DefaultCapabilitiesSupplier(platform)).getDriver();
    }

    @AfterAll
    public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }

    public static void startActivity(String name) {
        driver.executeScript(
                "mobile: startActivity",
                ImmutableMap.of(
                        "component", String.format("%s/%s", APP_ID, name)
                ));
    }
}
