package streamapi.example4;

import customfunctioninterface.example.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ParallelPerformance2 {

    private static final String[] Price = {"105.2", "92.15", "50.33", "65.33", "44.87", "26.44"};
    private static final BigDecimal[] testPrice = {new BigDecimal("36.4"), new BigDecimal("55.4"), new BigDecimal("42.4"), new BigDecimal("82.42"), new BigDecimal("63.24")};
    private static final Random randomPrice = new Random(444);
    private static final Random testRandomPrice = new Random(111);
    private static final List<Product> products = new ArrayList<Product>();

    static {
        final int length = 8_000_000;
        for (int i = 0; i < length; i++) {
            products.add(new Product((long) i, new BigDecimal(Price[randomPrice.nextInt(6)])));
        }
    }

    private static BigDecimal foreach(List<Product> products, Predicate<Product> predicate) {
        BigDecimal result = BigDecimal.ZERO;
        for (Product product : products) {
            if (predicate.test(product)) {
                result = result.add(product.getPrice());
            }
        }
        return result;
    }

    private static BigDecimal stream(Stream<Product> products, Predicate<Product> predicate) {
        return products.filter(predicate).map(i -> i.getPrice()).reduce((p1, p2) -> p1.add(p2)).get();

    }

    private static void foreachTest(BigDecimal random) {
        final long start = System.currentTimeMillis();
        System.out.println("일반 for문 시작 ============================\n");

        BigDecimal foreach = foreach(products, i -> i.getPrice().compareTo(random) >= 0);
        System.out.println("계산값 = " + foreach);
        System.out.println(System.currentTimeMillis() - start + " 초");
        System.out.println("============================================\n");

    }

    private static void streamTest(BigDecimal random) {
        final long start = System.currentTimeMillis();
        System.out.println("stream 시작 ============================\n");
        BigDecimal stream = stream(products.stream(), i -> i.getPrice().compareTo(random) >= 0);
        System.out.println("계산값 = " + stream);
        System.out.println(System.currentTimeMillis() - start + " 초");
        System.out.println("============================================\n");

    }

    private static void parallelStreamTest(BigDecimal random) {
        final long start = System.currentTimeMillis();
        System.out.println("병렬 Stream 시작 ============================\n");
        BigDecimal stream = stream(products.parallelStream(), i -> i.getPrice().compareTo(random) >= 0);
        System.out.println("계산값 = " + stream);
        System.out.println(System.currentTimeMillis() - start + " 초");
        System.out.println("============================================\n");

    }


    public static void main(String[] args) {

        final BigDecimal bigDecimal = testPrice[testRandomPrice.nextInt(5)];
        foreachTest(bigDecimal);
        streamTest(bigDecimal);
        parallelStreamTest(bigDecimal);

        System.out.println("========================================여기서부터 시작 =====================\n\n");
        for (int i = 0; i < 5; i++) {
            final BigDecimal random = testPrice[testRandomPrice.nextInt(5)];
            foreachTest(random);
            streamTest(random);
            parallelStreamTest(random);
        }


    }
}
