package com.pages.adminpages;

import com.pageobject.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public class AdminDashboardPage extends Page {

    @FindBy(xpath = "//div[@class='row diagram sales_overview']//h3[@class='diagram-header'][1]")
    private WebElement presentsOfDashboardPage;

    public AdminDashboardPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public boolean checkPresentsOfDashboardPage(){
        return presentsOfDashboardPage.isDisplayed();
    }
}
