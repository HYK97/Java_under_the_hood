package thread;

public class RunThread {
    public static void main(String[] args) {
        //runBasic();
        runMultiThread();
    }

    public static void runBasic() {
        RunnableSample runnable = new RunnableSample();
        new Thread(runnable).start();
        ThreadSample thread = new ThreadSample();
        thread.start();
        System.out.println(" run basic ");

    }

    public static void runMultiThread() {
        RunnableSample[] runnable = new RunnableSample[5];
        ThreadSample[] thread = new ThreadSample[5];
        for (int loop = 0; loop < 5; loop++) {
            runnable[loop] = new RunnableSample();
            thread[loop] = new ThreadSample();
            new Thread(runnable[loop]).start();
            thread[loop].start();
        }
        System.out.println("RunMultiThreads.runMultiThread() method is ended.");
    }
}
