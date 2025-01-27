package onboarding.commontest;

import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import onboarding.commontest.configuration.Configuration;

import java.lang.reflect.Field;

public class PropTypeListener implements TypeListener {
    protected Configuration configuration;

    public PropTypeListener(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
        Class<? super I> clazz = type.getRawType();
        for (Field field : clazz.getDeclaredFields()) {
            Prop prop = field.getAnnotation(Prop.class);
            if (prop == null)
                continue;
            encounter.register(new PropertyInjector<>(prop, field));
        }
    }

    class PropertyInjector<I> implements MembersInjector<I> {
        private Prop prop;
        private final Field field;

        public PropertyInjector(Prop prop, Field field) {
            this.prop = prop;
            this.field = field;
        }

        @Override
        public void injectMembers(I instance) {
            try {
                Object value = configuration.get(prop.value());
                field.setAccessible(true);
                field.set(instance, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
