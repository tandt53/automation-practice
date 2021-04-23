package tandt.mobile.element;

import tandt.common.Log;
import ui.annotations.Clocking;
import ui.element.Element;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class ElementInvocationHandler implements InvocationHandler {
    // ******************************
    // Fields
    // ******************************
    private Element element;
    Log log = new Log(Element.class);

    public ElementInvocationHandler(MobileElementInfo mobileElementInfo) {
        element = new BaseMobileElementImpl(mobileElementInfo);
    }

    // ******************************
    // Public methods
    // ******************************
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        Object returnObj = null;
        try {
            // If the annotation is not present, just redirect the method call to its
            // origin...
            if (!method.isAnnotationPresent(Clocking.class)) {
                return method.invoke(element, args);
            }

            // ... otherwise log the execution time of it.
            Instant start = Instant.now();
            returnObj = method.invoke(element, args);
            Instant end = Instant.now();

            log.info("Method " + method.getName() + " on element " + ((BaseMobileElementImpl) element).getElementInfo().getName()
                    + " executed in " + Duration.between(start, end).toMillis() + " ms.");
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
        }
        return returnObj;
    }
}
