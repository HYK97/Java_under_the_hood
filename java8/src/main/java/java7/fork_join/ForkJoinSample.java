package java7.fork_join;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {
    static final ForkJoinPool mainPool = new ForkJoinPool();


    public static void main(String[] args) {
        calculate();
    }

    public static void calculate() {
        long start = 0;
        long end = 1000000000;
        SumFunc sum = new SumFunc(start, end);
        long startTime = System.currentTimeMillis();
        Long result = mainPool.invoke(sum);
        long endTime = System.currentTimeMillis();
        System.out.println("result = " + result);
        System.out.println((endTime - startTime) + " 차이 ");


    }
}
