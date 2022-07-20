package streamapi.practice;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;


public class StreamPractice1 {

    private static List<Product> productList =
            Arrays.asList(new Product(23, "potatoes"),
                    new Product(14, "orange"),
                    new Product(13, "lemon"),
                    new Product(23, "bread"),
                    new Product(13, "sugar"));


    public static void main(String[] args) {
        generagte();
        flatMap1();
        match();
        groupingBy();
        summarizingInt();


    }

    /**
     * methodName : summarizingInt
     * author : HyKim
     * description : Collectors.summarizingInt -> 합계 , 최댓값 , 최솟값 , 평균 , 카운트를 한번에 구해준다.
     */
    private static void summarizingInt() {
        System.out.println("\n=============================== summarizingInt ==============================\n");
        IntSummaryStatistics info =
                productList.stream()
                        .collect(Collectors.summarizingInt(Product::getAmount));
        System.out.println("info.getAverage() = " + info.getAverage());
        System.out.println("info.getSum() = " + info.getSum());
        System.out.println("info.getMax() = " + info.getMax());
        System.out.println("info.getCount() = " + info.getCount());
        System.out.println("info.getMin() = " + info.getMin());
    }

    /**
     * methodName : groupingBy
     * author : HyKim
     * description : groupingBy -> Collectors.groupingBy(기준이되는값)  이 기준이 되는 값으로 그룹핑을 해서 Map 으로넘겨줌
     */
    private static void groupingBy() {
        System.out.println("\n=============================== groupingBy ==============================\n");
        Map<Integer, List<Product>> map =
                productList.stream()
                        .collect(Collectors.groupingBy(Product::getAmount));
        Set<Map.Entry<Integer, List<Product>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Product>> entry : entries) {
            System.out.println("키 : " + entry.getKey() + " 값 : " + entry.getValue());
        }
    }


    /**
     * methodName : match
     * author : HyKim
     * description :
     * anyMatch 하나라도 만족
     * allMatch 모든 컬렉션 요소가 만족
     * noneMatch 모든 컬렉션 요소가 만족하지 않음
     */
    private static void match() {
        System.out.println("\n=============================== match ==============================\n");
        List<String> names = Arrays.asList("Eric", "Elena", "Java");
        boolean anyMatch = names.stream()
                .anyMatch(name -> name.contains("a"));
        System.out.println("anyMatch = " + anyMatch);
        boolean allMatch = names.stream()
                .allMatch(name -> name.length() > 3);
        System.out.println("allMatch = " + allMatch);
        boolean noneMatch = names.stream()
                .noneMatch(name -> name.endsWith("s"));
        System.out.println("noneMatch = " + noneMatch);
    }

    /**
     * methodName : flatMap1
     * author : HyKim
     * description : flatMap -> collection 안에 있는 collection을 꺼내서 stream으로 반환해줌
     * 여기서는 두개의 유저 컬렉션을 각각의 stream으로 만들어 반환한 다음 -> 각각의 stream에 map 을 이용해 평균을 구함
     */
    private static void flatMap1() {
        System.out.println("\n=============================== flatMap1 ==============================\n");
        List<User> user1 = new ArrayList<>();
        user1.add(new User(10, 10));
        user1.add(new User(20, 20));
        user1.add(new User(30, 30));
        List<User2> user2 = new ArrayList<>();
        user2.add(new User2(10, 10));
        user2.add(new User2(20, 20));
        user2.add(new User2(30, 30));

        List<List<? extends Students>> lists = asList(user1, user2);
        OptionalDouble average = lists.stream().flatMap(Collection::stream).mapToInt(Students::average).average();
        System.out.println("average = " + average);
    }


    /**
     * methodName : generagte
     * author : HyKim
     * description : stream 직접 생성
     */
    private static void generagte() {
        System.out.println("\n=============================== generagte ==============================\n");

        Stream.generate(() -> "test").limit(5).forEach(System.out::println);
        //숫자 무한생성하기
        //Stream.iterate(0, i -> i + 1).forEach(System.out::println);

    }


    interface Students {
        /**
         * methodName : average
         * author : HyKim
         * description :
         *
         * @return int
         */
        int average();

    }

    /**
     * The type User.
     */
    @Data
    @AllArgsConstructor
    static class User implements Students {

        int kor;

        int math;

        @Override
        public int average() {
            return (kor + math) / 2;
        }
    }


    @Data
    @AllArgsConstructor
    static class User2 implements Students {

        int eng;

        int han;

        @Override
        public int average() {
            return (eng + han) / 2;
        }
    }


    @Data
    @AllArgsConstructor
    static class Product {

        int amount;

        String name;
    }
}
