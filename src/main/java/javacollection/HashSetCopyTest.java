package javacollection;

import java.util.HashSet;
import java.util.Set;

public class HashSetCopyTest {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("data1");
        set.add("data2");
        HashSet<String> set2 = new HashSet<>(set);
        System.out.println("set2 = " + set2);

        /**
         * 책에서는 데이터들은 복제하지 않는다고 되어있으나 잘 복제된다. ?? 질문거리
         * */
        HashSet<String> clone = (HashSet<String>) set2.clone();
        clone.add("data3");
        System.out.println("clone = " + clone);

    }
}
