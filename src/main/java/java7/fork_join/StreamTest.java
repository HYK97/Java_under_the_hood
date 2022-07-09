package java7.fork_join;

import java.util.stream.LongStream;

public class StreamTest {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        forLoop();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " 차이 ");

        long startTime2 = System.currentTimeMillis();
        parallelStream();
        long endTime2 = System.currentTimeMillis();
        System.out.println((endTime2 - startTime2) + " 차이 ");
    }

    private static void parallelStream() {
        LongStream longStream = LongStream.rangeClosed(0, 1000000000);
        long sum = longStream.parallel().reduce(0, Long::sum); //sum()
        System.out.println(sum);
    }

    private static void forLoop() {
        long sum = 0;
        for (long i = 0; i <= 1000000000; i++) {
            sum += i;
        }
        System.out.println(sum);
    }


}
