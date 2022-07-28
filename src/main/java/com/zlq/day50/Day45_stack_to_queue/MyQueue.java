package com.zlq.day50.Day45_stack_to_queue;

import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.stack_to_queue
 * @ClassName: MyQueue
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/23 9:30 上午
 */
/*
出队栈时反转
入栈的时候往stack1直接放
出栈的时候将stack1出栈并入栈stack2，求栈顶元素的时候也如此
 */
public class MyQueue<T> {
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
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//        stack1.push(3);
//        stack1.push(6);
//        stack1.push(2);
//        stack1.push(7);
//        System.out.println(stack1);
//
//        while (!stack1.isEmpty())
//         stack2.push(stack1.pop());
//        System.out.println(stack2);
//        System.out.println(stack2.pop());


    }

    private Stack<T> stack1;
    private Stack<T> stack2;
    private int elementCount;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(T t) {
        stack1.push(t);
        elementCount++;
    }

    public T poll() {
        elementCount--;
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        return stack2.pop();
    }

    public T peek() {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack2.isEmpty();
    }

    public int size() {
        return elementCount;
    }
}
