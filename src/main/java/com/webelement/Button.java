package com.webelement;

import com.webelement.elementrelease.ButtonImpl;
import org.openqa.selenium.*;

/**
 * Created by M.Malyus on 2/15/2018.
 */
public interface Button extends Element {
    void clickByJS(WebDriver webDriver,ButtonImpl button);
    void clickWithWait(WebDriver webDriver,ButtonImpl button);
    void removeAttribute(WebDriver webDriver,ButtonImpl button,String attribute);
}
