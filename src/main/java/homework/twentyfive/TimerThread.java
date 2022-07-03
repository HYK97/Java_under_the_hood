package homework.twentyfive;

import java.time.LocalDateTime;

public class TimerThread extends Thread {
    @Override
    public void run() {
        prntCurrentTime();
    }

    private void prntCurrentTime() {
        for (int i = 0; i < 10; i++) {
            System.out.println(LocalDateTime.now() + "  " + (System.currentTimeMillis() - (System.currentTimeMillis() % 1000)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
