package com.tandt53.automation.web.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Safari {

//    String value() default Constants.BROWSER_CHROME;
//
//    String remoteUrl() default "";
//
//    String capabilities() default "";
//
//    String service() default "";
}
