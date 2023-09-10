package org.example.java_multi_thread.thread_join;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class FactorialThread extends Thread {
    private long inputNumber;
    private BigInteger result;
    private boolean isFinished = false;

    public FactorialThread(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }

    public BigInteger factorial(long n) {
        BigInteger tempResult = BigInteger.ONE;
        for (long i = n; i > 0; i--) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("스레드 강제 종료");
                this.isFinished = true;
                return BigInteger.ZERO;
            }
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }
        return tempResult;
    }
}