package streamapi.example2;


import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class StreamApiOperationMethod {
    public static void main(String[] args) {
        /**
         * Stream 을 리턴하는 메서드(builder) -> Intermediate Operation Method
         * Stream 이외에 타입을 리턴하는 메서드 -> Terminal Operation Method
         * */

        //toList -> List형태로 가져오기
        Stream.of(1, 2, 3, 4, 5)
                .filter(i -> i > 2) // filter -> Intermediate 
                .map(i -> i * 2) //map -> Intermediate
                .map(i -> "#" + i + " ")
                .collect(toList())      //collect -> Terminal
                .forEach(c -> System.out.println("toList = " + c));

        //toSet -> set 형태로 가져오기
        Stream.of(1, 1, 3, 3, 4)
                .filter(i -> i > 2) // filter -> Intermediate
                .map(i -> i * 2) //map -> Intermediate
                .map(i -> "#" + i + " ")
                .collect(toSet())       //collect -> Terminal
                .forEach(c -> System.out.println("toSet = " + c));

        //joining -> delimiter 만 사용
        System.out.println("joining = " + Stream.of(1, 1, 2, 2, 3)
                .filter(i -> i > 2) // filter -> Intermediate
                .map(i -> i * 2) //map -> Intermediate
                .map(i -> "#" + i + " ")
                .collect(joining(",")));     //collect -> Terminal


        //joining -> delimiter suffix prefix 사용
        System.out.println("joining = " + Stream.of(1, 1, 2, 2, 3)
                .filter(i -> i > 2) // filter -> Intermediate
                .map(i -> i * 2) //map -> Intermediate
                .map(i -> "#" + i + " ")
                .collect(joining(",", "처음에 들어갈 문자 ", "마지막에 들어갈 문자")));     //collect -> Terminal


        //distinct -> 중복제거
        Stream.of(1, 1, 3, 3, 4)
                .filter(i -> i > 2) // filter -> Intermediate
                .map(i -> i * 2) //map -> Intermediate
                .map(i -> "#" + i + " ")
                .distinct() //distinct -> Intermediate   //중복제거
                .collect(toList())
                .forEach(c -> System.out.println("distinct = " + c));


        /**
         * ==, equals 차이점
         * == -> 참조값 즉 메모리의 주소를 비교해서 객체자체를 비교함
         * equals -> 객체가 가지고 있는 값 내용을 비교
         * Stream.of(int형,int형) -> stream 객체로 만들면서 int형을 integer 로 boxing하게 된다
         * 자바가 이렇게 boxing 할때 valueOf라는 메서드를 사용하는데 이때
         * valueOf는 이전에 공부했듯이 특정 범위의 값은 캐싱한 배열에서 리턴해주기 때문에 계속 같은 값을 리턴해준다.
         * 즉 특정 범위 안의 값은 같은 값을 가르키고있기때문에 filter(i - > i==Integer.valueOf(3))은 ture가 되지만
         * 특정범위를 벗어난 Integer 값이 들어간다면 false가 반환 되므로 == 가아닌 equals를 이용하여 비교하도록하자.
         **/
        System.out.println(
                Stream.of(1, 2, 3, 4, 5) //캐싱한 값이 캐싱한 배열을 넘어서면 ==로 확인하면 서로 다른 값이라고 나옴
                        .filter(i -> i.equals(3))  //[1,2,3,4,5] 리스트는 Integer 객체로 auto boxing되기 때문에 == 은 이용하면 안됨 eqauls를 이용해야함.
                        //현재는 범위를 가르키고 있기때문에 true를 리턴함
                        .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 300)
                        .filter(i -> i == Integer.valueOf(300)) // 다음과 같이 valueOf 캐싱범위를 넘어가면 false를 반환함
                        .findFirst()
        );
        //

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 300)
                        .filter(i -> i.equals(Integer.valueOf(300))) //eqauls로해야지 제대로 작동함
                        .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 400)
                        .filter(i -> i > (Integer.valueOf(300)))
                        .findFirst()
        );


        //Stream은 internalIterator이다.
        Stream.of(1, 2, 3, 4, 5, 400)
                .filter(i -> i > (Integer.valueOf(2)))
                .forEach(i -> System.out.println("internalIterator = " + i));

        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 400)
                .filter(i -> i > (Integer.valueOf(2)))
                .collect(toList());
        //externalIterator
        for (Integer integer : collect) {
            System.out.println("externalIterator = " + integer);

        }
    }

}
