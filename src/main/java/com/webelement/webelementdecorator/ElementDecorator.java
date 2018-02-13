package com.webelement.webelementdecorator;

import com.webelement.elementrelease.CheckBoxImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public class ElementDecorator extends DefaultFieldDecorator {

    public ElementDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if(WebElement.class.isAssignableFrom(field.getType())){
            return super.decorate(loader,field);
        }
        else {
            if(CheckBoxImpl.class.isAssignableFrom(field.getType())){
                ElementLocator elementLocator = factory.createLocator(field);
                CheckBoxImpl checkBox = new CheckBoxImpl(proxyForLocator(loader,elementLocator));
                return checkBox;
            }
        }
        return super.decorate(loader, field);
    }
}
