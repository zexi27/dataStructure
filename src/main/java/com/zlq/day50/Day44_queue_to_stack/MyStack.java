package com.zlq.day50.Day44_queue_to_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day44_queue_to_stack
 * @ClassName: MyStack
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/22 9:24 上午
 */
/*
其实栈实现队列和队列实现栈的核心思想都是将其顺序最终倒过来。。。
使用两个队列实现，想象Queue1中存贮的是已经处理过的一些数据
现在Queue2中放入数据，然后将Queue1中的数据分别出队进入Queue2中
然后将Queue2拷贝到Queue1中
 */
public class MyStack<T> {
    private Queue queue1;
    private Queue queue2;

    public MyStack() {
        queue1 = new LinkedList<T>();
        queue2 = new LinkedList<T>();
    }

    public void push(T t) {
        queue2.offer(t);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }

        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public T pop() {

        return (T) queue1.poll();
    }

    public T peek() {
        return (T) queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack();
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
