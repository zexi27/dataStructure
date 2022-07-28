package com.zlq.day50.Day44_queue_to_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day44_queue_to_stack
 * @ClassName: MyStack1
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/22 9:54 上午
 */
/*
使用一个队列实现，数据直接往队列里放，然后再把队列后年的所有数据出队在入队，
这样每次添加的数据都在队列尾部
 */
public class MyStack1<T> {
    private Queue<T> queue;

    public MyStack1() {
        this.queue = new LinkedList();
    }

    public void push(T t) {
        queue.offer(t);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public T pop() {
        return queue.poll();
    }

    public T peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack1<Integer> myStack = new MyStack1();
        myStack.push(3);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.peek());
        System.out.println("弹出了" + myStack.pop());
        System.out.println("弹出了" + myStack.pop());
        System.out.println("弹出了" + myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
    }

}
