package method_reference.example1;

import java.util.ArrayList;
import java.util.Arrays;

public class MethodReference {
    public static void main(String[] args) {

        Arrays.asList(1,2,3,4)
                .forEach(i-> System.out.println("i = " + i));

        Arrays.asList(1,2,3,4)
                .forEach(System.out::println);
    }
}
