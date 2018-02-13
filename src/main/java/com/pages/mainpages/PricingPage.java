package com.pages.mainpages;

import com.pageobject.Page;
import com.pageobject.WebWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public class PricingPage extends Page {

    @FindBy(xpath = "//div[@class='row price']//div[@class='col-sm-6 col-md-6 col-lg-3 price-block'][1]")
    private WebElement presentsOfPricingPage;

    public PricingPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public boolean checkPresentsOfPricingPage(){
        return presentsOfPricingPage.isDisplayed();
    }
    @Step
    public void createAndSwitch(){
        WebWindow webWindow = new WebWindow(webDriver,"http://10.10.0.77/idl/admin");
        webWindow.switchToWindow();
        webWindow.switchToParent();
    }
}
