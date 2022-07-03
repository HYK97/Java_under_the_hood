package thread.objectMethod;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Run r = new Run();
        r.run();
    }

    void run() throws InterruptedException {
        PrintString print = new PrintString();
        Target t1 = new Target(print);
        Target t2 = new Target(print);
        System.out.println("t1 state = " + t1.getState());
        System.out.println("t2 state = " + t2.getState());
        t1.start();
        t2.start();
        System.out.println("t1 state = " + t1.getState());
        System.out.println("t2 state = " + t2.getState());


        Thread.sleep(1000);
        synchronized (print) {
            print.notify();
        }

        Thread.sleep(1000);
        t1.join();
        System.out.println("t1 state = " + t1.getState());
        t2.join();
        System.out.println("t2 state = " + t2.getState());

    }
}
