package thread.support;

public class SleepThread extends Thread {
    long sleepTime;

    public SleepThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public SleepThread(ThreadGroup group, String name, long sleepTime) {
        super(group, name);
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            //interrupt 실험
            //while (true) {
            System.out.println("sleeping = " + sleepTime + " " + getName());
            Thread.sleep(sleepTime);
            System.out.println("stopping= " + getName());
            //}
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
