package com.zlq.day80;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: ConstantPoolString
 * @description:
 * @author: LiQun
 * @CreateDate:2021/12/26 10:34 下午
 */
public class ConstantPoolString {
    public static void main(String[] args) {
        ConstantPoolStringEx constantPoolStringEx = new ConstantPoolStringEx();
        ConstantPoolStringA constantPoolStringA = new ConstantPoolStringA(constantPoolStringEx);
        constantPoolStringA.setName("A");
        ConstantPoolStringB constantPoolStringB = new ConstantPoolStringB(constantPoolStringEx);
        constantPoolStringB.setName("B");
        constantPoolStringB.start();
        constantPoolStringA.start();
    }
}

class ConstantPoolStringEx {
    public static void print(String string) {
        try {
            synchronized (string) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

class ConstantPoolStringA extends Thread {
    private ConstantPoolStringEx constantPoolStringEx;

    public ConstantPoolStringA(ConstantPoolStringEx constantPoolStringEx) {
        this.constantPoolStringEx = constantPoolStringEx;
    }

    @Override
    public void run() {
        constantPoolStringEx.print("AA");
    }
}

class ConstantPoolStringB extends Thread {
    private ConstantPoolStringEx constantPoolStringEx;

    public ConstantPoolStringB(ConstantPoolStringEx constantPoolStringEx) {
        this.constantPoolStringEx = constantPoolStringEx;
    }

    @Override
    public void run() {
        constantPoolStringEx.print("AA");
    }
}
