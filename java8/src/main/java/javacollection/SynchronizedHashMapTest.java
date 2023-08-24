package javacollection;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedHashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "baeldung");
        map.put(2, "HashMap");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        int test = 0;
        while (iterator.hasNext()) {
            map.put(3 + test, "Modification_" + test);
            System.out.println(iterator.next());
            test++;
        }
        System.out.println("map.size() = " + map.size());
    }

}
