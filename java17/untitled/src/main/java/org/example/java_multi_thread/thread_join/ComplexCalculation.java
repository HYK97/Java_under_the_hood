package org.example.java_multi_thread.thread_join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {
    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation complexCalculation = new ComplexCalculation();

        //멀티 스레트 -> 계산 데이터가 커질수록 빨라짐
        new Thread(() -> {
            try {
                long l = System.currentTimeMillis();
                System.out.println("complexCalculation1 = " +complexCalculation.calculateResult(BigInteger.valueOf(2),List.of(BigInteger.valueOf(100),BigInteger.valueOf(1000),BigInteger.valueOf(10000),BigInteger.valueOf(100000),BigInteger.valueOf(100000),BigInteger.valueOf(1000000),BigInteger.valueOf(1000000))));
                System.out.println("time1 = " + (System.currentTimeMillis() - l));
            } catch (InterruptedException e) {
            }
        }).start();


        //싱글스레드
        new Thread(() -> {
            BigInteger result=BigInteger.ZERO;
            BigInteger base = BigInteger.valueOf(5);
            List<BigInteger> bigIntegers = List.of(BigInteger.valueOf(100), BigInteger.valueOf(1000), BigInteger.valueOf(10000), BigInteger.valueOf(100000), BigInteger.valueOf(100000), BigInteger.valueOf(1000000), BigInteger.valueOf(1000000));
            long l = System.currentTimeMillis();
            for (BigInteger integer : bigIntegers) {
                result=result.add(base.pow(integer.intValue()));
            }
            System.out.println("complexCalculation2 = " + result);
            System.out.println("time2 = " + (System.currentTimeMillis() - l));
        }).start();

    }
    public BigInteger calculateResult(BigInteger base,List<BigInteger> power) throws InterruptedException {
        BigInteger result=BigInteger.ZERO;
        List<PowerCalculatingThread> threads =new ArrayList<>();

        for (BigInteger powers : power) {
            threads.add(new PowerCalculatingThread(base, powers));
        }

        for (PowerCalculatingThread thread : threads) {
            thread.start();
            thread.join();
        }

        for (PowerCalculatingThread thread : threads) {
            result = result.add(thread.getResult());
        }

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ZERO;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
            result=base.pow(power.intValue());
        }
    
        public BigInteger getResult() { return result; }
    }
}