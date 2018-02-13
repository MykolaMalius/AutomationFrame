package com.webelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public interface Element extends WebElement, WrapsElement, Locatable {
    boolean elementWired();
}
