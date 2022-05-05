package streamapi.example3.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class App {
    public static void main(String[] args) {

        final BigDecimal THIRTY = new BigDecimal("30");
        final List<Product> products =
                Arrays.asList(
                        new Product(1L, "A", new BigDecimal("100.50")),
                        new Product(2L, "B", new BigDecimal("23.00")),
                        new Product(3L, "C", new BigDecimal("31.45")),
                        new Product(4L, "D", new BigDecimal("80.20")),
                        new Product(5L, "E", new BigDecimal("7.50"))
                );

        /**
         * joining
         * 30달러 이상 제품 filtering
         * */
        System.out.println("toList : " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(THIRTY) >= 0)
                        .collect(toList())
        );

        System.out.println("=================================");

        /**
         * joining
         * 30달러 이상 제품을 String으로 나열하기
         * */
        System.out.println("joining(\"\\n\") : " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(THIRTY) >= 0)
                        .map(function -> function.toString())
                        .collect(joining("\n"))
        );
        System.out.println("=================================");
        System.out.println("IntStream.sum" +
                IntStream.of(1, 2, 3, 4, 5)
                        .sum());

        System.out.println("=================================");

        //stream 객체를 덧셈하는것 reduce
        /**
         * stream reduce
         * -> 마지막 객체가 하나만 남게 하도록 하는 메서드
         * .reduce(BigDecimal.ZERO,(price1,price2)->price1.add(price2))
         *          ->초기값        ->이전값, 다음값       -> operation
         * */
        System.out.println("stream.reduce ->product.price: " +
                products.stream()
                        .map(price -> price.getPrice())
                        .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );
        System.out.println("=================================");

        /**
         * 실수하지말자 이렇게 짜면안된다
         * */
        System.out.println("stream.reduce ->product : " +
                products.stream()
                        .reduce(new Product(0L, "null", BigDecimal.ZERO), (price1, price2) -> new Product(0L, "null", price1.getPrice().add(price2.getPrice()))
                        ));

        System.out.println("=================================");


        /**
         * 30 달러 이상인 제품들 가격합
         * */
        System.out.println("Total Price: " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(THIRTY) >= 0)
                        .map(price -> price.getPrice())
                        .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );
        System.out.println("=================================");
        /**
         * 30 달러 이상인 제품 갯수
         * */
        System.out.println("Product Count: " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(THIRTY) >= 0)
                        .count()
        );
        ;
        System.out.println("=================================");


        /**
         * totalPrice 테스트
         * */
        final OrderedItem item1 = new OrderedItem(1L, products.get(0), 1);
        final OrderedItem item2 = new OrderedItem(2L, products.get(2), 3);
        final OrderedItem item3 = new OrderedItem(3L, products.get(4), 10);

        final Order order = new Order(1L, Arrays.asList(item1, item2, item3));

        System.out.println("order.totalPrice() = " + order.totalPrice());

        System.out.println("=================================");

    }
}
