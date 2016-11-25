package com.evgeny.utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static com.evgeny.utils.Config.DEFAULT_BROWSER;

public class Utils {

    @Before
    public void beforeScenario() throws Exception {
        Utils.initializeDriver();
    }

    @After
    public void after() {
        Utils.closeDriver();
    }

    public static WebDriver driver;

    public static void initializeDriver() throws Exception {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = DEFAULT_BROWSER;
        }
        switch (browser) {
            case "chrome" :
                driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
                break;
            case "firefox" :
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), DesiredCapabilities.firefox());
                break;
            default:
                throw new Exception();
        }
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
    }

    public static void delay() throws InterruptedException {
        Thread.sleep(1000);
    }
}
