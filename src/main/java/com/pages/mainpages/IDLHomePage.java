package com.pages.mainpages;

import com.pageobject.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by M.Malyus on 11/7/2017.
 */
public class IDLHomePage extends Page {
    final static Logger LOG = Logger.getLogger(IDLHomePage.class);

    @FindBy(xpath = "//div[@class=\"nav-list\"]//ul[@class=\"nav navbar-nav navbar-right\"]//li[1]")
    private WebElement pricingButton;

    @FindBy(xpath = "//div//div[@class=\"row why\"][1]")
    private WebElement presentsOfHomePage;

    @FindBy(xpath = "//div[@class=\"nav-list\"]//ul[@class=\"nav navbar-nav navbar-right\"]//li[2]")
    private WebElement faqButton;

    public IDLHomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public boolean IsLoaded() throws Exception {
        return IsPageLoaded(faqButton);
    }
    @Step
    public PricingPage clickOnPricingButton() {
        LOG.info("Click");
        pricingButton.click();
        return PageFactory.initElements(webDriver,PricingPage.class);
    }


}
