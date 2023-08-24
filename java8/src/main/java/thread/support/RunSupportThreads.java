package thread.support;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads th = new RunSupportThreads();
        th.checkThreadState1();
    }

    public void checkThreadState1() {
        SleepThread thread = new SleepThread(2000);
        try {
            System.out.println("thread.getState() = " + thread.getState());
            thread.start();
            System.out.println("thread statue -> start = " + thread.getState());
            Thread.sleep(1000);
            System.out.println("thread statue -> sleep after 1sec = " + thread.getState());

            //  thread.interrupt();
            thread.join();
            System.out.println("thread statue -> join= " + thread.getState());
            thread.interrupt();
            System.out.println("thread statue -> interrupt= " + thread.getState());


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
