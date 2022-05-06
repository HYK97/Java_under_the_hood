package streamapi.example4;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
/**
 * 병렬 처리시 주의할 점
 * 이미 sort 된 것들을 하면 오히려 싱글코어보다 느릴수있다.
 * orm 같은 기술을을 사용할때 fetching시 그 클래스가 하위 객체를 가지고있고 그하위 객체를 가져오는 방식이 지연 로딩일때는 병렬 처리를 사용하지 않는것이 바람직하다
 * 즉시로딩을 사용하자
 * */
public class Parallel {

    public static void main(String[] args) {

        final int[] sum = {0};
        IntStream.range(0, 100)
                .forEach(i -> sum[0] += i);
        System.out.println("sum = " + sum[0]);


        final int[] sum2 = {0};
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> sum2[0] += i);
        System.out.println("parallel sum 부작용 = " + sum2[0]);


        System.out.println("stream sum = " +
                IntStream.range(0, 100)
                        .sum()
        );

        System.out.println("parallel stream sum =" +
                IntStream.range(0, 100)
                        .parallel()
                        .sum()
        );

        /**
         * 병렬 프로그래밍의 장점
         * */

        /**
         * multi core
         * */
        final long start = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                }).forEach(i -> System.out.println("i = " + i));
        System.out.println(System.currentTimeMillis() - start);

        /**
         * single core
         * */
        /*final long start2 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4)
                .stream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                }).forEach(i -> System.out.println("i = " + i));
        System.out.println(System.currentTimeMillis() - start2);*/


        /**
         * 현재 cpu 코어수보다 많이하면 한번에 처리못하기때문에 시간이 좀더걸린다.
         * */
        final long start3 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                }).forEach(i -> System.out.println("i = " + i));
        System.out.println(System.currentTimeMillis() - start3);


        /**
         * system 코어 제한
         * System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","코어갯수")
         * 여기서 코어개수는 0 -> 1(singleCore), 1 -> 2, 3 -> 4, 7 -> 8
         * 즉 System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","3")으로하면
         * 4개코어가 사용된다는 뜻
         * */
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2");
        final long start4 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                }).forEach(i -> System.out.println("i = " + i));
        System.out.println(System.currentTimeMillis() - start4);

    }


}
