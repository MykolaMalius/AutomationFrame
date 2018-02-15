package com.webelement.elementrelease;

import com.webelement.ElementImpl;
import com.webelement.UploadInput;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

/**
 * Created by M.Malyus on 2/15/2018.
 */
public class UploadImpl extends ElementImpl implements UploadInput {
    public UploadImpl(WebElement element) {
        super(element);
    }

    @Override
    public void uploadBySenKeys(UploadImpl upload,String path) {
        upload.sendKeys((new File(path)).getAbsolutePath());
    }

    /*This metho crete post method  for sending by api image code.
    * But its not universal script, sometimes it need update for
    * api updating
    *
    * @param
    *
    *
    * */
    @Override
    public void uploadByJSInjection(WebDriver webDriver, UploadImpl upload, String path, String attributeName, String baseURL) {
        String elem = "document.body.innerHTML += \"<form method=post " +
                "action='"+ baseURL + "api/identification/set'enctype='multipart/form-data'> " +
                "<input name='" + attributeName + "' " +  "type='file'><input type=submit></form>;\"";
        ((JavascriptExecutor) webDriver).executeScript(elem);
        upload.sendKeys((new  File(path).getAbsolutePath()));
    }
}
