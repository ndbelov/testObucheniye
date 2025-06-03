package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Cookie;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;
import java.util.List;

public class PlaywrightTest {

    public void testPlaywright() {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigation
            page.navigate("https://example.com");
            page.reload();
            page.goBack();
            page.goForward();

            // Tabs/Windows management
            Page newTab = context.newPage();
            newTab.navigate("https://example.com");
            newTab.close();

            // iFrame switching
            FrameLocator frame = page.frameLocator("iframe-selector");
            frame.locator("button").click();

            // Alerts management
            page.onceDialog(dialog -> {
                System.out.println("Dialog message: " + dialog.message());
                dialog.accept();
            });
            page.evaluate("alert('Hello!')");

            // Browser capabilities
            BrowserContext contextWithOptions = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(1280, 720));

            // Headless mode
            Browser headlessBrowser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));

            // WebDriver instance setup and destruction
            browser.close();

            // Basic authentication
            BrowserContext authContext = browser.newContext(new Browser.NewContextOptions()
                    .setHttpCredentials("user", "password"));
            authContext.newPage().navigate("https://example.com/protected");

            // Locating elements
            Locator element = page.locator("#elementId");
            Locator elements = page.locator(".className");
            Locator xpathElement = page.locator("xpath=//button[text()='Click']");
            Locator cssElement = page.locator("css=.button-class");

            // Click interactions
            element.click();
            element.dblclick();
            element.hover();

            // Get attributes
            String attribute = element.getAttribute("href");
            String text = element.textContent();

            // Sending text
            element.fill("Some text");

            // Auto-waiting
            page.waitForLoadState(LoadState.NETWORKIDLE);

            // Cookies
            Cookie cookie = new Cookie("session", "abc123");
            cookie.setDomain("example.com");
            cookie.setPath("/");
            context.addCookies(List.of(cookie));
            context.clearCookies();

            // Relative locators alternative using XPath
            Locator aboveElement = page.locator("xpath=//button[following-sibling::div[@id='reference']]");
            Locator belowElement = page.locator("xpath=//button[preceding-sibling::div[@id='reference']]");

            // Optimized locator chaining
            Locator optimizedLocator = page.locator("div.container >> button.submit");
            optimizedLocator.click();

            // File upload
            Locator fileInput = page.locator("input[type='file']");
            fileInput.setInputFiles(Paths.get("path/to/file.txt"));

            //waiting
            page.locator("#elementId").waitFor();
            Locator button = page.locator("#buttonId");
            button.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
            button.click();

            //closing webdriver

            browser.close();

        }

    }


}
