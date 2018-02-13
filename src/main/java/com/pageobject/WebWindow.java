package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.Set;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public class WebWindow extends Page {
    private String handle;
    private WebDriver driver;
    private String name;
    private String parentHandle;
    private static int instanceCount = 0;

    public WebWindow(WebDriver webDriver, String url) {
        super(webDriver);
        this.driver = webDriver;
        parentHandle = driver.getWindowHandle();
        name = createUniqueName();
        handle = createWindow(url);
        /*Switch to window and load URL*/
        switchToWindow().get(url);
    }

    public String getWindowHandle() {
        return handle;
    }
    public String getParentHandle() {
        return parentHandle;
    }
    /*Close current and back to the parent window*/
    public void close() {
        switchToWindow().close();
        handle = "";
        //Switch back to the parent window
        driver.switchTo().window(parentHandle);
    }
    private static String createUniqueName() {
        return "a_Web_Window_" + instanceCount++;
    }
    public WebDriver switchToWindow() {
        checkForClosed();
        return driver.switchTo().window(handle);
    }
    public WebDriver switchToParent() {
        checkForClosed();
        return driver.switchTo().window(parentHandle);
    }
    private String createWindow(String url) {
        //Record old handles
        Set< String > oldHandles = driver.getWindowHandles();
        parentHandle = driver.getWindowHandle();
        //Inject an anchor element
        ((JavascriptExecutor) driver).
                executeScript(
                        injectAnchorTag(name, url)
                );
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",  driver.findElement(By.id(name)));
        handle = getNewHandle(oldHandles);
        return handle;
    }
    private String getNewHandle(Set < String > oldHandles) {
        Set < String > newHandles = driver.getWindowHandles();
        newHandles.removeAll(oldHandles);
        //Find the new window
        for (String handle: newHandles)
            return handle;
        return null;
    }
    private void checkForClosed() {
        if (handle == null || handle.equals(""))
            throw new WebDriverException("Web Window closed or not initialized");
    }
    private String injectAnchorTag(String id, String url) {
        return String.format("var anchorTag = document.createElement('a'); " +
                        "anchorTag.appendChild(document.createTextNode('nwh'));" +
                        "anchorTag.setAttribute('id', '%s');" +
                        "anchorTag.setAttribute('href', '%s');" +
                        "anchorTag.setAttribute('target', '_blank');" +
                        "anchorTag.setAttribute('style', 'display:block;');" +
                        "document.getElementsByTagName('body')[0].appendChild(anchorTag);",
                id, url
        );
    }
    /*Number of window starts from 0 like array*/
    public  void createAndOpenNewWindow(String url,int numberOfWindow){
        /*Open new second window tab*/
        ((JavascriptExecutor) driver)
                .executeScript("window.open(argument[0])",url);
          /*Here we switch to new opened window
        * We take a Set of opened browser windows and switch to
        * what we want*/
        Set<String> newHandles = driver.getWindowHandles();
        driver.switchTo().window((String) newHandles.toArray()[numberOfWindow]);
    }
}
