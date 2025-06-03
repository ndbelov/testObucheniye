package framework.elements;

import framework.browser.BrowserManager;
import framework.utils.LoggerUtils;

public class CheckBox extends BaseElement{
    public CheckBox(String locator, String name) {
        super(locator, name);
    }

    public boolean isSelected(){
        LoggerUtils.makeLog("Check the status of " + name);
        BrowserManager.getPage().waitForSelector(locator);
        return find().isChecked();
    }

    public void select(){
        LoggerUtils.makeLog("Select " + name);
        BrowserManager.getPage().waitForSelector(locator);
        if(!find().isChecked()){
            find().click();
        }
    }

    public void unselect(){
        LoggerUtils.makeLog("Unselect " + name);
        BrowserManager.getPage().waitForSelector(locator);
        if(find().isChecked()){
            find().click();
        }
    }

    public void setState(boolean state){
        LoggerUtils.makeLog("Set " + state + " state for " + name);
        if(state){
            select();
        }
        else{
            unselect();
        }
    }
}
