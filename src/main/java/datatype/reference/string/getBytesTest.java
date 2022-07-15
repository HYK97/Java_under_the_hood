package datatype.reference.string;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class getBytesTest {
    public static void main(String[] args) {

        String test = "test";
        String 테스트 = "테스트";
        byte[] bytes1 = test.getBytes(StandardCharsets.UTF_16);
        byte[] bytes2 = 테스트.getBytes(Charset.forName("EUC-KR"));

        String test1 = new String(bytes1);
        System.out.println("test1 = " + test1);
        String test2 = new String(bytes2);
        System.out.println("test2 = " + test2);
        String test3 = new String(bytes1, StandardCharsets.UTF_16);
        System.out.println("test3 = " + test3);
        String test4 = new String(bytes2, Charset.forName("EUC-KR"));
        System.out.println("test4 = " + test4);

    }
}
