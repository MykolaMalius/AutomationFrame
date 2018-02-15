package com.webelement.elementrelease;

import com.webelement.Button;
import com.webelement.ElementImpl;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by M.Malyus on 2/15/2018.
 */
public class ButtonImpl extends ElementImpl implements Button{
    final static Logger LOG = Logger.getLogger(ButtonImpl.class);

    public ButtonImpl(WebElement element) {
        super(element);
    }


    @Override
    public void clickByJS(WebDriver webDriver, ButtonImpl button) {
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].click",button);
    }
    @Override
    public void clickWithWait(WebDriver webDriver, ButtonImpl button) {
        try {
            Wait wait = new WebDriverWait(webDriver, 5, 1000);
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        }
        catch (StaleElementReferenceException e){
            LOG.error("Element is not clickable");
            e.printStackTrace();
        }
    }
    @Override
    public void removeAttribute(WebDriver webDriver, ButtonImpl button,String attribute) {
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].removeAttribute('" + attribute + "','" + attribute + "'" ,button);
    }

    @Override
    public void click() {
        super.click();
    }

    @Override
    public Dimension getSize() {
        return super.getSize();
    }

    @Override
    public boolean isSelected() {
        return super.isSelected();
    }



}
