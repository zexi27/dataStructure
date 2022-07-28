package com.zlq.day50.Day45_stack_to_queue;

import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.stack_to_queue
 * @ClassName: MyQueue2
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/23 10:10 上午
 */
public class MyQueue2<T>{
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(5);
        queue.push(1);
        queue.push(3);
        queue.push(6);
        System.out.println("poll弹出了-----" + queue.poll());
        System.out.println("poll弹出了-----" + queue.poll());
        System.out.println("peek-----" + queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }

    private Stack<T> stack1;
    private Stack<T> stack2;
    private int elementCount;

    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(T t) {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        stack1.push(t);
        while (!stack2.isEmpty()) stack1.push(stack2.pop());
        elementCount++;
    }

    public T poll() {
        elementCount--;
        return stack1.pop();
    }

    public T peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public int size() {
        return elementCount;
    }
}
