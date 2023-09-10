package org.example.java_multi_thread.thread_join;

import lombok.Getter;

import java.math.BigInteger;
import java.util.List;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = List.of(99999L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);

        List<FactorialThread> threads = inputNumbers.stream()
                .map(FactorialThread::new)
                .toList();

        threads.forEach(Thread::start);

        // 모든 스레드 기다리기
        for (FactorialThread thread : threads) {
            //thread.join();
            // 2000ms 동안 기다려도 안끝나면 강제종료
            thread.join(400); // 이게 길면 계산 중으로 나옴 interrupt를 n초 후에 진행 하기 때문에
            thread.interrupt();
        }

        //Thread.sleep(2000); 이렇게 해주면 join이 길어도 상관없음.

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("계산 끝  " + inputNumbers.get(i) + " 결과 :  " + factorialThread.getResult());
            } else {
                System.out.println("계산 중... " + inputNumbers.get(i) + " ");
            }
        }

    }
}
