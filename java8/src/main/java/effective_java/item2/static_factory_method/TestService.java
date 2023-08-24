package effective_java.item2.static_factory_method;

import java.util.HashMap;
import java.util.Map;

public interface TestService {
    static Map<Integer, TestService> cache = new HashMap<>();

    static TestService newInstance(int data) {
        if (data <= 10) {
            return new implServiceOne();
        } else {
            return new implServiceTwo();
        }
    }


    static TestService getInstance(int data) {
        if (!cache.containsKey(data)) {
            TestService ts = null;
            if (data <= 10) {
                ts = new implServiceOne();
            } else {
                ts = new implServiceTwo();
            }
            cache.put(data, ts);
            return ts;
        } else {
            return cache.get(data);
        }
    }


}
