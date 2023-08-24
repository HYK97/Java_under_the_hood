package thread.synchronize;

public class CommonCalculate {
    private int amount;

    private Object lock = new Object();

    public CommonCalculate() {
        amount = 0;
    }

    public synchronized void plus(int value) {
        amount += value;
    }


    public void minus(int value) {
        synchronized (lock) {

            amount -= value;
        }
    }

    public int getAmount() {
        return amount;
    }
}
