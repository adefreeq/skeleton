package context;


import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> contextData = new HashMap<>();

    public void set(String key, Object value) {
        contextData.put(key, value);
    }

    public Object get(String key) {
        return contextData.get(key);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(contextData.get(key));
    }

    public boolean contains(String key) {
        return contextData.containsKey(key);
    }

    public void clear() {
        contextData.clear();
    }
}