package tandt.web;

import tandt.web.annotations.FindElement;
import tandt.web.element.*;
//import tandt.web.page.BaseWebPage;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class ElementFactory {

    public static <T extends BaseWebPage<?>> void initElements(final T page) {
        try {
            Class<?> objectClass = page.getClass();
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(FindElement.class)) {
                    LocatorType type = getLocatorType(field);
                    String value = getLocatorValue(field);
                    String name = field.getName();
                    WaitStrategy waitUntil = getWaitStrategy(field);
                    if (type != null && value != null) {
                        ElementInfo elementInfo = new ElementInfo();
                        elementInfo.setName(name);
                        elementInfo.setLocatorType(type);
                        elementInfo.setLocatorValue(value);
                        elementInfo.setStrategy(waitUntil);

                        Object baseElement = (BaseWebElement) Proxy.newProxyInstance(BaseWebElement.class.getClassLoader(),
                                new Class[]{BaseWebElement.class}, new ElementInvocationHandler(elementInfo));
                        field.set(page, baseElement);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static WaitStrategy getWaitStrategy(Field field) {
        return field.getAnnotation(FindElement.class).waitUntil();
    }

    private static String getLocatorValue(Field field) {
        return field.getAnnotation(FindElement.class).value();
    }

    private static LocatorType getLocatorType(Field field) {
        return field.getAnnotation(FindElement.class).type();
    }
}
