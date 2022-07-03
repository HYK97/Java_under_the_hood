package thread.objectMethod;

public class Target extends Thread {

    private PrintString print = new PrintString();

    public Target(PrintString print) {
        this.print = print;
    }

    public void run() {

        System.out.println("run target");

        synchronized (print) {
            try {
                print.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("wating end");
        print.print();


    }

}
