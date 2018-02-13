package com.mainpagetest;

import com.pages.adminpages.AdminDashboardPage;
import com.pages.mainpages.PricingPage;
import com.testbase.TestBase;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static org.testng.Assert.assertTrue;

/**
 * Created by M.Malyus on 11/7/2017.
 */
public class MainPageTest extends TestBase {

    @TestCaseId("1")
    @Test(groups = {"main"})
    public void checkIfUserRedirectedToPricingScreenFromHomeAndReturnBack(){
        PricingPage pricingPage = homePage.clickOnPricingButton();
        assertTrue(pricingPage.checkPresentsOfPricingPage(),"PricingPage is not displayed");
    }
    @TestCaseId("2")
    @Test(groups = {"main"})
    public void checkWindowHandle(){
      PricingPage pricingPage = homePage.clickOnPricingButton();
      tabSwitcher.openAdminPanelInNewWindowAndSwitch();
      AdminDashboardPage adminDashboardPage = loginBO.login();
      assertTrue(adminDashboardPage.checkPresentsOfDashboardPage(),"DashboardPage is not displayed after authorization!");
    }
}
