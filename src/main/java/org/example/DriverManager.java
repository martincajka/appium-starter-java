package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Platform;

import java.util.function.Supplier;

public class DriverManager {
    private final AppiumDriverLocalService appiumService;
    private final Supplier<BaseOptions> capabilitiesSupplier;

    public DriverManager(AppiumDriverLocalService appiumService, Supplier<BaseOptions> capabilitiesSupplier) {
        this.appiumService = appiumService;
        this.capabilitiesSupplier = capabilitiesSupplier;
    }


    public AppiumDriver getDriver() {
        appiumService.start();
        if (capabilitiesSupplier.get().getPlatformName().is(Platform.ANDROID)){
            return new AndroidDriver(appiumService.getUrl(), capabilitiesSupplier.get());
        }
        else if (capabilitiesSupplier.get().getPlatformName().is(Platform.IOS)){
            return new IOSDriver(appiumService.getUrl(), capabilitiesSupplier.get());
        }
        else {
            throw new IllegalArgumentException("Unknown platform: " + capabilitiesSupplier.get().getPlatformName());
        }
    }
}
