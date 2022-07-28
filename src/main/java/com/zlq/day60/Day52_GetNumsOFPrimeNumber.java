package com.zlq.day60;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day52_GetNumsOFPrimeNumber
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/6 3:05 下午
 */
public class Day52_GetNumsOFPrimeNumber {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        getPrimeNumber(2, 200000);
        long end = System.currentTimeMillis();
        System.out.println("times :" + (end - start));

        long startTime = System.currentTimeMillis();
        getPrimeNumberByMultiply();
        long endTime = System.currentTimeMillis();
        System.out.println("times for multiply:" + (endTime - startTime));
    }

    public static int getPrimeNumber(int start, int end) {
        int count = 0;
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;

    }

    public static boolean isPrime(int num) {
        for (int j = 2; j <= num / 2; j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void getPrimeNumberByMultiply() throws ExecutionException, InterruptedException {

        final int myCpuCoreNums = 8;
        ExecutorService service = Executors.newFixedThreadPool(myCpuCoreNums);
        MyTask t1 = new MyTask(2, 50000);
        MyTask t2 = new MyTask(50001, 100000);
        MyTask t3 = new MyTask(100001, 150000);
        MyTask t4 = new MyTask(150001, 200000);
        Future<?> f1 = service.submit(t1);
        Future<?> f2 = service.submit(t2);
        Future<?> f3 = service.submit(t3);
        Future<?> f4 = service.submit(t4);
        f1.get();
        f2.get();
        f3.get();
        f4.get();
    }

    static class MyTask implements Runnable {
        private int start;
        private int end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            getPrimeNumber(start, end);
        }

    }

}
