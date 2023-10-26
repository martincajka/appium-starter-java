package org.example;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DefaultAppiumService {
    private final int port;
    private final String ipAddress;
    private final DesiredCapabilities serverCapabilities;

    public DefaultAppiumService(int port, String ipAddress, DesiredCapabilities serverCapabilities) {
        this.port = port;
        this.ipAddress = ipAddress;
        this.serverCapabilities = serverCapabilities;
    }

    public DefaultAppiumService() {
        this(4723, "127.0.0.1", getDefaultServerCapabilities());
    }

    public AppiumDriverLocalService get() {
        return new AppiumServiceBuilder()
                .withIPAddress(ipAddress)
                .usingPort(port)
                .withCapabilities(serverCapabilities)
                .build();
    }

    private static DesiredCapabilities getDefaultServerCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:" + MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        capabilities.setCapability("appium:wdaStartupRetries", 3);
        capabilities.setCapability("appium:wdaStartupRetryInterval", 20000);
        return capabilities;
    }
}
