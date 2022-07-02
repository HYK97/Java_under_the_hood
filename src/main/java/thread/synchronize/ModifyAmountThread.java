package thread.synchronize;

public class ModifyAmountThread extends Thread {
    private CommonCalculate comm;
    private boolean addFlag;

    public ModifyAmountThread(CommonCalculate comm, boolean addFlag) {
        this.comm = comm;
        this.addFlag = addFlag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (addFlag) {
                comm.plus(1);
            } else {
                comm.minus(1);
            }
        }
    }
}
