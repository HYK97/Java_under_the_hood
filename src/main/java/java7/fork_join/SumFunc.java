package java7.fork_join;

import java.util.concurrent.RecursiveTask;

public class SumFunc extends RecursiveTask<Long> {
    private long from, to;

    public SumFunc(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {

        long gap = to - from;
        if (gap <= 100000000) {
            long sum = 0;
            for (long i = from; i <= to; i++) {
                sum += i;
                //log("Return ! " + from + " ~ " + to + " = " + sum);
            }
            return sum;
        }

        long middle = (from + to) / 2;
        SumFunc sumPre = new SumFunc(from, middle);
        //log("PRE  from = " + from + " , to = " + middle);
        sumPre.fork();
        SumFunc sumPost = new SumFunc(middle + 1, to);
        //log("Post  from = " + middle + 1 + " , to = " + to);
        Long compute = sumPost.compute();
        Long join = sumPre.join();
        return compute + join;
    }

    public void log(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 이 처리 중 :" + message);
    }
}
