package com.zlq.day90;

import com.zlq.common.TreeNode;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: SynchronizedLook
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/3 11:26 下午
 */
public class SynchronizedLook {
    private static volatile boolean flag = true;
    private static final Object o = new Object();

    public static void main(String[] args) {


        Thread thread2 = new Thread(() -> {
            while (flag) {
//                System.out.println(Thread.currentThread().getName() + "---" + flag);
            }

        }, "thread2");

        thread2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SynchronizedLook synchronizedLook = new SynchronizedLook();
        synchronizedLook.changeFlag();

    }

    public synchronized void changeFlag() {
        flag = false;
    }
}
