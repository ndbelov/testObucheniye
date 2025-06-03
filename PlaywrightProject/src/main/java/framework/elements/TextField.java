package framework.elements;

import framework.browser.BrowserManager;
import framework.utils.LoggerUtils;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TextField extends BaseElement{

    public TextField(String locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        LoggerUtils.makeLog("Send " + text + " to " + name);
        BrowserManager.getPage().waitForSelector(locator);
        find().fill(text == null? "" : text);
    }

    public void clearText() {
        LoggerUtils.makeLog("Clear text from  " + name);
        BrowserManager.getPage().waitForSelector(locator);
        find().clear();
    }

//    public void clearTextWithKeys() {
//        LoggerUtils.makeLog("Clear text with ctrl+a+backspace from " + name);
//        BrowserManager.getPage().waitForSelector(locator);
//        click();
//        find().fill(Keys.CONTROL + "a");
//        find().fill(Keys.BACK_SPACE);
//    }

    public void sendTextWithClipboard(String text) {
        LoggerUtils.makeLog("Send " + text + " via clipboard to " + name);
        BrowserManager.getPage().waitForSelector(locator);
        find().click();
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        find().fill(Keys.CONTROL + "v");
    }
}
