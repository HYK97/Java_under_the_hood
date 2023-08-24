package thread.interrupt;

public class DemonThread extends Thread {
    private SynchronizedClass sync;

    public DemonThread(SynchronizedClass sync) {
        super("demon");
        this.sync = sync;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);

            }
            sync.dataPlus();
            System.out.println("hi demon");
        }
    }
}
