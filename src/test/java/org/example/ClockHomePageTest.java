package org.example;

import org.example.core.MyLogger;
import org.junit.jupiter.api.Test;

public class ClockHomePageTest extends BaseTest {
    private static final String BASE_ACTIVITY = "com.android.deskclock.DeskClock";

    @Test
    public void testClockHomePage() {
        startActivity(BASE_ACTIVITY);
        MyLogger.log.info("Clock home page is opened");
    }
}
