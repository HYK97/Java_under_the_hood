package thread.group;

import thread.support.SleepThread;

public class RunGroupThreads {
    public static void main(String[] args) throws InterruptedException {
        RunGroupThreads rg = new RunGroupThreads();
        rg.threadGroup();
    }

    public void threadGroup() throws InterruptedException {
        /**
         * tg -> tg2 의 부모 그룹
         * run1 , 2 의 스레드인 t1 ,t2 는 tg에 속함
         * run3 , 4 는 tg2 그룹에 속함
         * tg -> t1,t2
         * 하위 tg2 -> run3 run4
         * tg - active 실행중인 count는 총 4개
         * enumerate(list, true) true 를 줌으로써 하위group thread 까지 목록에 포함시킴
         * */
        ThreadGroup tg = new ThreadGroup("group1");
        ThreadGroup tg2 = new ThreadGroup(tg, "group2");

        SleepThread run1 = new SleepThread(5000);
        SleepThread run2 = new SleepThread(5000);
        SleepThread run3 = new SleepThread(tg2, "tgGroupThread1", 5000);
        SleepThread run4 = new SleepThread(tg2, "tgGroupThread2", 5000);

        Thread t1 = new Thread(tg, run1);
        Thread t2 = new Thread(tg, run2);

        t1.start();
        t2.start();
        run3.start();
        run4.start();
        Thread.sleep(1000);
        //총 활성화된 Thread수
        int activeCount = tg.activeCount();
        //그룹수
        int activeGroupCountCount = tg.activeGroupCount();
        System.out.println("activeGroupCountCount = " + activeGroupCountCount);
        System.out.println("activeCount = " + activeCount);
        tg.list();
        Thread[] list = new Thread[activeCount];
        int result = tg.enumerate(list, true);
        System.out.println("result = " + result);
        for (Thread thread : list) {
            System.out.println("list = " + thread);
        }
    }
}
