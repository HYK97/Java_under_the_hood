package thread.interrupt;

public class FirstThread extends Thread {
    private SynchronizedClass sync;

    public FirstThread(SynchronizedClass sync) {
        super("firstT");
        this.sync = sync;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sync.dataPlus();
            //sync.data2Plus();
            System.out.println("hi ");
        }
    }
}
