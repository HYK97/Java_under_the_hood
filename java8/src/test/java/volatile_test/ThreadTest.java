package volatile_test;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    private volatile static boolean BOOL = true;

    private static void button() {
        BOOL = false;
    }

    @Test
    void test1() throws InterruptedException {
        Print print = new Print();
        print.start();
        Thread.sleep(5000);
        button();
        System.out.println(BOOL);
        print.join();
    }

    static class Print extends Thread {
        @Override
        public void run() {
            while (BOOL) {
            }
            System.out.println("출력!!!!!!");
        }
    }
}


