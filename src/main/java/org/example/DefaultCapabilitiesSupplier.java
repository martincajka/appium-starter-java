package org.example;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.Platform;

import java.util.function.Supplier;

public class DefaultCapabilitiesSupplier implements Supplier<BaseOptions> {
    private final Platform platform;

    public DefaultCapabilitiesSupplier(Platform platform) {
        this.platform = platform;
    }


    @Override
    public BaseOptions get() {
        BaseOptions capabilities = new BaseOptions();
        capabilities.setPlatformName(platform.name());
        if (platform.is(Platform.ANDROID)) {
            capabilities.setCapability(BaseOptions.toW3cName("deviceName"), "Android Emulator");
            capabilities.setCapability(BaseOptions.toW3cName("automationName"), "UiAutomator2");
            capabilities.setCapability(BaseOptions.toW3cName("avd"), "Pixel_6_API_34");
            return new UiAutomator2Options(capabilities);
        } else if (platform.is(Platform.IOS)) {
            capabilities.setCapability(BaseOptions.toW3cName("deviceName"), "iPhone 14");
            capabilities.setCapability(BaseOptions.toW3cName("automationName"), "XCUITest");
            capabilities.setCapability(BaseOptions.toW3cName("platformVersion"), "16.4");
            capabilities.setCapability(BaseOptions.toW3cName("bundleId"), "com.apple.reminders");
            return new UiAutomator2Options(capabilities);
        } else {
            throw new IllegalArgumentException("Unknown platform: " + platform);
        }
    }
}
