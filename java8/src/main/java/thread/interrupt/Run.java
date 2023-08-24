package thread.interrupt;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedClass synchronizedClass = new SynchronizedClass();
        /*
         * 데몬도 똑같이 interrupt 에 종료됌
         * */
        DemonThread demon = new DemonThread(synchronizedClass);
        demon.setDaemon(true);
        demon.start();
        //demon.interrupt();


        FirstThread thread = new FirstThread(synchronizedClass);
        thread.start();


    }
}
