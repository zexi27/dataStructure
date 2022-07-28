package com.zlq.day90;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: ThreadDemo004
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/3 11:35 下午
 */
public class ThreadDemo004 extends Thread {

    public boolean flag = true;

    // public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("线程开始...");
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "------" + flag);
        }
        System.out.println("线程結束...");
    }

    // 启动死循环\停止死循环
    public void setRuning(boolean flag){
        this.flag=flag;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo004 th = new ThreadDemo004();
        th.start();
        Thread.sleep(3000);
        th.setRuning(false);
        System.out.println("flag已經改為false");
        Thread.sleep(1000);
        System.out.println("flag:"+th.flag);
    }
}

