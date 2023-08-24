package volatile_test;

import org.junit.jupiter.api.Test;


public class Test2 {
    static long value;

    private void add() {
        for (long i = 0; i < 1000000000L; i++) {
            value++;
        }
        System.out.println(Thread.currentThread().getName() + " 종료");
    }

    @Test
    void start() throws InterruptedException {
        Thread a = new Thread(this::add, "a");
        Thread b = new Thread(this::add, "b");
        Thread c = new Thread(this::add, "c");
        Thread d = new Thread(this::add, "d");
        Thread e = new Thread(this::add, "e");
        Thread f = new Thread(this::add, "f");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();

        a.join();
        b.join();
        c.join();
        d.join();
        e.join();
        f.join();

        Thread.sleep(1000);
        System.out.println("value = " + value);
    }
}
