package com.tandt.automation.web.annotations;



import com.tandt.automation.web.element.LocatorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface FindElement {
    LocatorType type();

    String value();

}
