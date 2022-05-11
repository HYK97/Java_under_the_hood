package method_reference.example1;

import customfunctioninterface.example.DiscountMovie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class MethodReference {
    public static void main(String[] args) {

        Arrays.asList(1,2,3,4)
                .forEach(i-> System.out.println("i = " + i));

        Arrays.asList(1,2,3,4)
                .forEach(System.out::println);

        System.out.println(
                Arrays.asList(new BigDecimal("10"),new BigDecimal("5"),new BigDecimal("30"))
                        .stream()
                        //.sorted((b1,b2) -> b1.compareTo(b2))
                        //.sorted(BigDecimalUtils::compare)//static MethodReference
                        .sorted(BigDecimal::compareTo)//Object의 member method를 사용할 때
                        //얘는 값이 정해지지않음
                        .collect(toList())
        );
        System.out.println(

        Arrays.asList("a","b","c","d")
                .stream()
                //.anyMatch(x->x.equals("c"))
                //.anyMatch(String::equals) 오류
                //.anyMatch(x->"c".equals(x)) // 는 첫번째와 같은것
                .anyMatch("c"::equals) //다음과 같이 사용가능 특정한 Object의 메서드를 사용하겠다는 뜻
                //얘는 값이 정해져있음
        );


    }
}

class BigDecimalUtils {
    public static int compare(BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2);
    }
}
