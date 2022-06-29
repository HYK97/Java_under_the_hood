package javacollection;

import java.util.ArrayList;
import java.util.List;

/**
 * toArray 는 넘겨준 크기만큼의 배열을 생성후에 list에 데이터를 복사한다 만약 칸이 남으면 null로 채워준다.
 */
public class CollectionTest {
    public static void main(String[] args) {

        toArray();
        remove();

    }

    private static List<Integer> listInit() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }

    private static void toArray() {
        System.out.println(" ===================================toArray");
        List<Integer> list = listInit();
        Integer[] integers = list.toArray(new Integer[5]);
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
    }

    public static void remove() {
        System.out.println(" ===================================clear");
        List<Integer> list = listInit();
        list.clear();
        for (Integer data : list) {
            System.out.println("data = " + data);
        }
        System.out.println(" ===================================index remove : 0");
        list = listInit();
        list.remove(0);
        for (Integer data : list) {
            System.out.println("data = " + data);
        }
        System.out.println(" ===================================object remove : 2");
        list = listInit();
        list.remove(new Integer(2));
        for (Integer data : list) {
            System.out.println("data = " + data);
        }
        System.out.println(" =================================== removeAll 1,24");
        list = listInit();
        List<Integer> list2 = listInit();
        list2.remove(2);
        list.removeAll(list2);
        for (Integer data : list) {
            System.out.println("data = " + data);
        }

    }
}
