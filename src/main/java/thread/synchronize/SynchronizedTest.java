package thread.synchronize;

public class SynchronizedTest {
    final Object lock = new Object();

    public static void main(String[] args) {
        SynchronizedTest t = new SynchronizedTest();
        Runnable a = t::printTest1;
        Runnable b = t::printTest1;
        Runnable c = t::printTest2;
        Runnable d = t::printTest2;
        Runnable e = t::printTest3;
        new Thread(a, "Thread-1").start();
        new Thread(b, "Thread-2").start();
        //new Thread(c, "Thread-3").start();
        // new Thread(d, "Thread-4").start();
        new Thread(e, "Thread-5").start();
    }

    public synchronized void printTest3() {
        System.out.println(" print 3");
    }

    public void printTest1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this);
            System.out.println("printTest1  :  " + Thread.currentThread().getName());
        }
    }

    public void printTest2() {
        synchronized (lock) {
            System.out.println(lock);
            System.out.println("printTest2  :  " + Thread.currentThread().getName());
        }
    }
}
