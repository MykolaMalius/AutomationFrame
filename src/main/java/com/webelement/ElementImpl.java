package com.webelement;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.util.List;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public class ElementImpl implements Element {

    private final WebElement element;

    public ElementImpl(final WebElement element) {
        this.element = element;
    }

    @Override
    public boolean elementWired() {
        return false;
    }

    @Override
    public void click() {
     element.click();
    }

    @Override
    public void submit() {
     element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
     element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
     element.clear();
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }

    @Override
    public WebElement getWrappedElement() {
        return null;
    }
}
