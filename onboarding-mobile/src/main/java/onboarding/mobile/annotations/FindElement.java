package onboarding.mobile.annotations;


import onboarding.mobile.element.MobileLocatorType;
import onboarding.ui.element.WaitStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface FindElement {
    MobileLocatorType type()  default MobileLocatorType.ID;

    String value();

    WaitStrategy waitUntil()  default WaitStrategy.VISIBILITY;

}
