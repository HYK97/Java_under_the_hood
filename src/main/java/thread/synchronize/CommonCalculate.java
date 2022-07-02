package thread.synchronize;

public class CommonCalculate {
    private int amount;

    private Object lock = new Object();

    public CommonCalculate() {
        amount = 0;
    }

    /**
     * 메소드 synchronized
     */
    public synchronized void plus(int value) {
        amount += value;
    }

    /**
     * statements synchronized  -> 성능측면에서 더유리함 꼭 필요한 부분만 동시접근이안되도록 변경
     */
    public void minus(int value) {
        synchronized (lock) {

            amount -= value;
        }
    }

    public int getAmount() {
        return amount;
    }
}
