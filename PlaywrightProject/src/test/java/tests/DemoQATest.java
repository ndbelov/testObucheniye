package tests;

import com.codeborne.selenide.Configuration;
import com.microsoft.playwright.*;
import framework.browser.BrowserManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQATest {

    @Test
    public void demoQATestPlaywright() {
        try (Playwright playwright = Playwright.create()) {
                    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    Page page = browser.newPage();

                    // Открываем Google
                    page.navigate("http://10.3.6.92:8080");


            // Вводим запрос в поиск
                    page.fill("input[name='user']", "nd.belov");
                    page.fill("input[name='password']", "Deydarax9");

                    //Locator authbutton = page.locator(".button.btn btn-lg btn-block btn-primary");
                    //authbutton.waitFor(new Locator.WaitForOptions().setTimeout(5000));
                    page.locator("//div[@class='login__fieldset']").click();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                   // Assert.assertTrue(page.locator("//div[contains(@class, 'inventory') and contains(@class, 'list')]").isVisible(), "Labs item page is not visible");
                   // Assert.assertTrue(page.locator("(//div[contains(@class, 'inventory') and contains(@class, 'label')])[1]").isVisible(), "first item is not visible");
        }

    }

    @Test
    public void demoQATestSelenide() {
        Configuration.browserSize = "1920x1080";
        open("https://www.google.com");
        // Вводим запрос и нажимаем Enter
        $("input[name='q']").setValue("Selenide").pressEnter();

        // Проверяем, что в результатах есть сайт Selenide
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    public void demoQATestFrameWorkPlaywright() {
        try (Playwright playwright = Playwright.create()) {
            BrowserManager.initializeWebDriver(playwright);
            BrowserManager.getPage().navigate("https://www.google.com");

        }
    }

}