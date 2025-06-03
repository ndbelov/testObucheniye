package framework.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class BrowserFactory {

    private BrowserFactory() {
    }

    public static Browser createDriver(DriverManagerType driverType, Playwright playwright) {
            switch (driverType) {
                case CHROME: {
                    return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                }
                case FIREFOX: {
                    return null;
                }
                default:
                    throw new IllegalArgumentException(
                            "The specified type of browser is not supported.");
            }

    }
}