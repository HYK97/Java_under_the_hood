package deadlock;

public class test {


    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new ThreadSync(obj1, obj2), "t1");
        Thread t2 = new Thread(new ThreadSync(obj2, obj3), "t2");
        Thread t3 = new Thread(new ThreadSync(obj3, obj1), "t3");

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();

    }

}

class ThreadSync implements Runnable {
    private final Object obj1;
    private final Object obj2;

    public ThreadSync(Object o1, Object o2) {
        this.obj1 = o1;
        this.obj2 = o2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("스레드 " + name + "이 " + obj1 + "락 획득 시도");
        synchronized (obj1) {
            System.out.println("스레드 " + name + "이 " + obj1 + "락 획득 성공");
            work();
            System.out.println("스레드 " + name + "이 " + obj2 + "락 획득 시도");
            synchronized (obj2) {
                System.out.println("스레드 " + name + "이 " + obj2 + "락 획득 성공");
                work();
            }
            System.out.println("스레드 " + name + "이 " + obj2 + "락 반납");
        }
        System.out.println("스레드 " + name + "이 " + obj1 + "락 반납");
        System.out.println(name + "스레드 종료");
    }

    private void work() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
