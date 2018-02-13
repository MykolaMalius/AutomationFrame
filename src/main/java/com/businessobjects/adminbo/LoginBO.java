package com.businessobjects.adminbo;

import com.pageobject.Page;
import com.pages.adminpages.AdminDashboardPage;
import com.pages.adminpages.AdminLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public class LoginBO extends Page{
    protected AdminLoginPage adminLoginPage = PageFactory.initElements(webDriver,AdminLoginPage.class);

    public LoginBO(WebDriver webDriver) {
        super(webDriver);
    }
    public AdminDashboardPage login(){
        adminLoginPage.writeLogin("test@test.com");
        adminLoginPage.writePassword("pass");
        adminLoginPage.clickOnSubmitButton();
        return PageFactory.initElements(webDriver,AdminDashboardPage.class);
    }
}
