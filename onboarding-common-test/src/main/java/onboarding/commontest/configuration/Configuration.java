package onboarding.commontest.configuration;

import java.util.HashMap;
import java.util.Map;

public abstract class Configuration {
    protected Map<String, Object> caps = new HashMap<>();

    public abstract Configuration load();

    public Map<String, Object> getConfigs() {
        return caps;
    }

    public Configuration add(String key, Object value) {
        caps.put(key, value);
        return this;
    }

    public Configuration add(Map<String, Object> configs) {
        caps.putAll(configs);
        return this;
    }

    public Configuration add(Configuration config) {
        add(config.getConfigs());
        return this;
    }

    public Configuration remove(String key) {
        caps.remove(key);
        return this;
    }

    public Configuration removeAll(){
        caps.clear();
        return this;
    }

    public Object get(String key) {
        return caps.get(key);
    }

}
