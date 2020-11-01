package com.tandt53.automation.web;

import com.tandt53.automation.web.annotations.FindElement;
import com.tandt53.automation.web.element.Element;
import com.tandt53.automation.web.element.ElementInvocationHandler;
import com.tandt53.automation.web.element.LocatorType;
import com.tandt53.automation.web.element.model.ElementInfo;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class PageFactory {

    public static <T extends BasePage<?>> void initElements(final T page, WebDriverWait wait){
        try {
            Class<?> objectClass = page.getClass();
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(FindElement.class)) {
                    LocatorType type = getLocatorType(field);
                    String value = getLocatorValue(field);
                    String name = field.getName();

                    if (type != null && value != null) {
                        ElementInfo elementInfo = new ElementInfo();
                        elementInfo.setName(name);
                        elementInfo.setLocatorType(type);
                        elementInfo.setLocatorValue(value);

                        Object baseElement = (Element) Proxy.newProxyInstance(Element.class.getClassLoader(),
                                new Class[]{Element.class}, new ElementInvocationHandler(elementInfo, wait));
                        field.set(page, baseElement);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getLocatorValue(Field field) {
        return field.getAnnotation(FindElement.class).value();
    }

    private static LocatorType getLocatorType(Field field) {
        return field.getAnnotation(FindElement.class).type();
    }
}