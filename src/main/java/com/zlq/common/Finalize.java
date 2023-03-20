package com.zlq.common;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.common
 * @ClassName: Text
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/10 14:43
 */
public class Finalize {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object(); // 创建一个普通对象
        ReferenceQueue<Object> queue = new ReferenceQueue<>(); // 创建引用队列

        // 创建一个虚引用，并将其与对象和引用队列关联
        PhantomReference<Object> phantomRef = new PhantomReference<>(obj, queue);

        obj = null; // 将对象设置为null，使其成为垃圾对象

        // 不断循环，直到虚引用被加入到引用队列中

        System.out.println("Waiting for PhantomReference to be enqueued...");
        System.gc(); // 手动调用垃圾回收

        // 阻塞直到虚引用被加入到引用队列中
        PhantomReference<Object> ref = (PhantomReference<Object>) queue.remove();
        if (ref == phantomRef) {
            System.out.println("PhantomReference enqueued.");
        }

    }
}
