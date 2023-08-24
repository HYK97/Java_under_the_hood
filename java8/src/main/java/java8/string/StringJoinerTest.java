package java8.string;

import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        StringJoiner str = new StringJoiner(",", "(", ")");
        for (int datum : data) {
            str.add(String.valueOf(datum));
        }
        System.out.println(str);
    }
}
