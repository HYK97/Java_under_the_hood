package thread.synchronize;

public class RunSync {
    public static void main(String[] args) {
        runCommonCalculate();

    }

    private static void runCommonCalculate() {
        CommonCalculate comm = new CommonCalculate();
        ModifyAmountThread t1 = new ModifyAmountThread(comm, false);
        ModifyAmountThread t2 = new ModifyAmountThread(comm, false);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("comm.getAmount() = " + comm.getAmount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
