package com.webelement;

/**
 * Created by M.Malyus on 2/13/2018.
 */
public interface CheckBox extends Element {
   void toggle();
   void check();
   void uncheck();
   boolean isChecked();
}
