package volatile_test;

public class TestRun {
    volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        new TestRun().test();
    }

    public void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            long counter = 0;
            while (running) {
                counter++;
            }
            System.out.println("스레드 1 상태 종료 " + counter);
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println("스레드 2 종료");
            running = false;
        });
        t1.start();
        t2.start();
    }
}