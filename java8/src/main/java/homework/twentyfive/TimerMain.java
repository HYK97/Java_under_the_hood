package homework.twentyfive;

public class TimerMain {
    public static void main(String[] args) {
        TimerThread th = new TimerThread();
        th.start();
    }
}
