package javacollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new HashMap<>();
        /**
         * put의 리턴값은 새로운 키의 데이터가 저장되면 null을 반환하고
         * 기존의 키에 새로운값을 저장하려하면 기존데이터를 반환하고 새로운 값이 저장된다
         * */
        Integer data1 = map.put("data1", 2);
        Integer data2 = map.put("data1", 3);
        System.out.println("data1 = " + data1);
        System.out.println("data2 = " + data2);
        System.out.println("map.get(\"data1\") = " + map.get("data1"));
        /**
         * 다음과같이 map에 없는 key를 get으로 불러오면 null값이 리턴된다.
         * */
        System.out.println("map.get(\"data2\") = " + map.get("data2"));

        /**
         * entrySet 이라는 메서드로 조회하면 편하게 사용할수있다 참고로 set이기때문에 순서는 무작위
         * */
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("첫번쨰값 ", 1);
        map2.put("두번쨰값 ", 2);
        map2.put("세번쨰값 ", 3);
        map2.put("네번쨰값 ", 4);
        Set<Map.Entry<String, Integer>> entries = map2.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("키는 ? :  " + entry.getKey() + " , 값은 ? : " + entry.getValue());
        }

        Properties myProperties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries1 = myProperties.entrySet();
        for (Map.Entry<Object, Object> entry : entries1) {
            System.out.println(entry.getKey() + "  : " + entry.getValue());
        }
        System.out.println();
        System.out.println();
        System.out.println("========================properties 생성및 조회====================================");
        System.out.println();
        System.out.println();
        writeMyProperties();
        readMyProperties();

        mapEqualTest();
    }

    public static void writeMyProperties() throws IOException {
        String fileName = "myPro.properties";
        File pro = new File(fileName);
        FileOutputStream out = new FileOutputStream(pro);
        Properties myProperties = new Properties();
        myProperties.setProperty("data1", "first");
        myProperties.setProperty("data2", "second");
        myProperties.store(out, "this is comments");
        out.close();
    }

    public static void readMyProperties() throws IOException {
        String fileName = "myPro.properties";
        FileInputStream in = new FileInputStream(fileName);
        Properties myProperties = new Properties();
        myProperties.load(in);
        Set<Map.Entry<Object, Object>> entries = myProperties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "  : " + entry.getValue());
        }
    }


    /**
     * Map equal test.
     * map 내부의 key 와 value가 같다면 같은 객체로 확인
     */
    public static void mapEqualTest() {

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        Map<Character, Integer> map2 = new HashMap<>();
        map2.put('C', 3);
        map2.put('B', 2);
        map2.put('A', 1);

        System.out.println("map2.equals(map) = " + map2.equals(map));
    }
}
