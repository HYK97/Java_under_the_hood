package thread.interrupt;

public class SynchronizedClass {
    int data;
    int data2;
    Object ob1 = new Object();
    Object ob2 = new Object();
    ;


    public void dataPlus() {
        synchronized (ob1) {
            data++;
            System.out.printf("name : %s , count : %d \n", Thread.currentThread().getName(), data);
        }
    }

    public void data2Plus() {
        synchronized (ob2) {
            data2++;
            System.out.printf("name : %s , count : %d \n", Thread.currentThread().getName(), data2);
        }
    }
}
