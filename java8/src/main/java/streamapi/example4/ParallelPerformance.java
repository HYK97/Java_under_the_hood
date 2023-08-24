package streamapi.example4;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelPerformance {

    /**
     * 일부러 interrupt 주는 메서드
     */
    private static void slowDown() {
        try {
            TimeUnit.MILLISECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
            slowDown();
        }
        return result;
    }
    /**
     * pick ,foreach 차이 둘다 반복하는것은 같음
     * pick -> Stream이 끝나지 않고 계속 이어짐 근데 retrun 값은없는 걸로 : Intermediate Operation Method
     * foreach ->Stream이 끝남 :Terminal Operation Method
     *
     * 즉 연산과정에 peek을 중간에 껴서 느리게 해줌.
     * */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).peek(i -> slowDown()).reduce(Long::sum).get();
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().peek(i -> slowDown()).reduce(Long::sum).get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).peek(i -> slowDown()).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().peek(i -> slowDown()).reduce(Long::sum).getAsLong();
    }


    /**
     * parallel stream 은 이전 값을 필요한 계산에는 성능저하가 있을수 있음 특히 순차적인 알고리즘.
     * 순서가 보장이 안됌.
     *
     * parallel stream 을 써야 하는경우
     * map이나 filter 중간 연산이 오래 걸리는 작업일때(시간이 오래걸리는 연산) 여기선 peek을 이용함
     * */

    public static void main(String[] args) {
        final long n = 1000;
        final long start = System.currentTimeMillis();
        //단순계산 알고리즘
        System.out.println((1 + n) * (n / 2));
        System.out.println("        Gauss 알고리즘: " + (System.currentTimeMillis() - start));
        final long start1 = System.currentTimeMillis();
        System.out.println("     iterativeSum(n): " + iterativeSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start1) + " ms\n");
        final long start2 = System.currentTimeMillis();
        System.out.println("    sequentialSum(n): " + sequentialSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start2) + " ms\n");
        final long start3 = System.currentTimeMillis();
        System.out.println("      parallelSum(n): " + parallelSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start3) + " ms\n");
        final long start4 = System.currentTimeMillis();
        System.out.println("        rangedSum(n): " + rangedSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start4) + " ms\n");
        final long start5 = System.currentTimeMillis();
        System.out.println("parallelRangedSum(n): " + parallelRangedSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start5) + " ms\n");
    }
}
