package tests;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Selenide {

    @Test
    public void testSelenide() {
        // Setup WebDriver
        Configuration.headless = false;
        open("https://example.com");

        // Navigation
        refresh();
        back();
        forward();

        // Tabs/Window management
        switchTo().frame($("iframe-selector"));
        switchTo().defaultContent();

        // Alerts management
        switchTo().alert().accept();
        switchTo().alert().dismiss();

        // Switch to another tab
        String mainWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        switchTo().window(1);
        switchTo().window(mainWindow);

        // Browser capabilities
        Configuration.browserCapabilities.setCapability("someCapability", true);

        // Headless mode
        Configuration.headless = true;

        // Driver instance setup and destruction
        WebDriverRunner.getWebDriver().close();

        // Basic authentication
        open("https://user:password@example.com");

        // Locating elements
        SelenideElement element = $(By.id("elementId"));
        ElementsCollection elements = $$(By.className("className"));
        SelenideElement xpathElement = $(By.xpath("//button[text()='Click']"));
        SelenideElement cssElement = $(By.cssSelector(".button-class"));

        // Click interactions
        element.click();
        element.doubleClick();
        actions().contextClick(element).perform();

        // Get attributes
        String attribute = element.getAttribute("href");
        String text = element.getText();

        // Sending text
        element.setValue("Some text");

        // Built-in waits
        element.shouldBe(visible);

        // Cookies
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().addCookie(new Cookie("session", "abc123"));
        driver.manage().deleteAllCookies();

        // Relative locators
        SelenideElement aboveElement = $(By.id("reference")).preceding(0);

        // Optimized locator chaining
        SelenideElement optimizedLocator = $("div.container").find("button.submit");
        optimizedLocator.click();

        //waiting
        $("#elementId").shouldBe(Condition.visible);
        $("#elementId").shouldBe(Condition.enabled).click();



        //closing webdriver
        closeWebDriver();
    }

    @Test
    public void testSelenideRun() {
        // Setup WebDriver
        Configuration.headless = true;
        open("https://www.saucedemo.com/");
        $(By.id("user-name")).setValue("standard_user");
        $(By.id("password")).setValue("secret_sauce");
        $(By.id("login-button")).click();
        Assert.assertTrue($(By.xpath("//div[contains(@class, 'inventory') and contains(@class, 'list')]")).isDisplayed(), "Labs item page is not visible");
        Assert.assertTrue($(By.xpath("(//div[contains(@class, 'inventory') and contains(@class, 'label')])[1]")).isDisplayed(), "first item is not visible");
    }
}
