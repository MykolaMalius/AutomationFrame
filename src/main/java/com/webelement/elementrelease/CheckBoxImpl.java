package com.webelement.elementrelease;

import com.webelement.CheckBox;
import com.webelement.ElementImpl;
import org.openqa.selenium.WebElement;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public class CheckBoxImpl extends ElementImpl implements CheckBox {

    public CheckBoxImpl(WebElement element) {
        super(element);
    }

    @Override
    public void toggle() {
        getWrappedElement().click();
    }

    @Override
    public void check() {
        if(!isChecked()){
            toggle();
        }
    }

    @Override
    public void uncheck() {
        if(isChecked()){
            toggle();
        }
    }

    @Override
    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }
}
