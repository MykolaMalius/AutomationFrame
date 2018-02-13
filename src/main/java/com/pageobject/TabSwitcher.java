package com.pageobject;

import com.businessobjects.adminbo.LoginBO;
import com.driver.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

/**
 * Created by M.Malyus on 2/13/2018.
 */
/*This class open AdminPanel in a new tab
* and switch to it*/
public class TabSwitcher extends Page {
    protected  WebDriver driver = WebDriverFactory.getSetDriver();

    public TabSwitcher(WebDriver webDriver) {
        super(webDriver);
    }
    public LoginBO openAdminPanelInNewWindowAndSwitch() {
        ((JavascriptExecutor) driver)
                .executeScript("window.open(arguments[0])", Page.ADMIN_URL);
        Set < String > newHandles = driver.getWindowHandles();
        driver.switchTo().window((String) newHandles.toArray()[1]);
        return PageFactory.initElements(webDriver,LoginBO.class);
    }

}
