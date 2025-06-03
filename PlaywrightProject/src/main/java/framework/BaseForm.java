package framework;

import framework.elements.BaseElement;
import framework.utils.LoggerUtils;

public class BaseForm {

    private BaseElement element;
    private  String name;

    protected BaseForm(BaseElement element, String name) {
        this.element = element;
        this.name = name;
    }

    public boolean isFormOpen() {
        LoggerUtils.makeLog("Check that " + name + " is opened");
        return element.isElementDisplayed();
    }
    public void waitForFormOpen() {
        LoggerUtils.makeLog("Wait for opening " + name);
        element.waitForDisplayed();
    }
}