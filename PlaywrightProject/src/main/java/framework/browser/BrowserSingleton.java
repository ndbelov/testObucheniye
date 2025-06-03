package framework.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class BrowserSingleton {
    private static final BrowserSingleton instance = new BrowserSingleton();
    private Browser driver;

    private BrowserSingleton() {
    }

    public static BrowserSingleton getInstance() {
        return instance;
    }

    public Browser getDriver(Playwright playwright) {

        if (driver == null) {
            driver = BrowserFactory.createDriver(DriverManagerType.CHROME, playwright);
        }
        return driver;
    }

    public void setDriverNull() {
        driver = null;
    }
}