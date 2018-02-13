package com.pages.adminpages;

import com.pageobject.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public class AdminLoginPage extends Page {
    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn-main']")
    private WebElement submitButton;

    public AdminLoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public void writeLogin(String login){
        loginInput.sendKeys(login);
    }
    @Step
    public void writePassword(String password){
        passwordInput.sendKeys(password);
    }
    @Step
    public void clickOnSubmitButton(){
        submitButton.click();
    }
}
