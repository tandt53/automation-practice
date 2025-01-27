package onboarding.mobile;

import io.appium.java_client.AppiumDriver;
import onboarding.mobile.annotations.FindElement;
import onboarding.mobile.element.ElementInvocationHandler;
import onboarding.mobile.element.MobileElementInfo;
import onboarding.mobile.element.MobileLocatorType;
import onboarding.mobile.page.BasePage;
import onboarding.ui.element.Element;
import onboarding.ui.element.WaitStrategy;
import onboarding.ui.exception.ElementActionException;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class ElementFactory {

    private ElementFactory(){}

    public static <T extends BasePage<?>> void initElements(AppiumDriver driver, T page) {
        try {
            Class<?> objectClass = page.getClass();
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(FindElement.class)) {
                    MobileLocatorType type = getLocatorType(field);
                    String value = getLocatorValue(field);
                    String name = field.getName();
                    WaitStrategy waitUntil = getWaitStrategy(field);
                    if (type != null && value != null) {
                        MobileElementInfo mobileElementInfo = new MobileElementInfo();
                        mobileElementInfo.setName(name);
                        mobileElementInfo.setType(type);
                        mobileElementInfo.setValue(value);
                        mobileElementInfo.setStrategy(waitUntil);

                        Element baseElement = (Element) Proxy.newProxyInstance(Element.class.getClassLoader(),
                                new Class[]{Element.class}, new ElementInvocationHandler(driver, mobileElementInfo));
                        field.set(page, baseElement);
                    }
                }
            }
        } catch (Exception e) {
            throw new ElementActionException("Element does not work as expected.", e);
        }
    }

    private static WaitStrategy getWaitStrategy(Field field) {
        return field.getAnnotation(FindElement.class).waitUntil();
    }

    private static String getLocatorValue(Field field) {
        return field.getAnnotation(FindElement.class).value();
    }

    private static MobileLocatorType getLocatorType(Field field) {
        return field.getAnnotation(FindElement.class).type();
    }
}
