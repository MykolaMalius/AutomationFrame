package com.webelement;

import com.webelement.elementrelease.UploadImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by M.Malyus on 2/15/2018.
 */
public interface UploadInput {
    void uploadBySenKeys(UploadImpl upload, String path);
    void uploadByJSInjection(WebDriver webDriver,UploadImpl upload, String path, String attribute, String baseURL);
}
