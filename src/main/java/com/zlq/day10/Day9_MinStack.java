package com.zlq.day10;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day10
 * @ClassName: Day9_MinStacl
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/31 9:03 上午
 */
/*
设计⼀个⽀持 push ，pop ，top 操作，并能在常数时间内检索到最⼩元素的栈。
push(x) —— 将元素 x 推⼊栈中。
pop() —— 删除栈顶的元素。
top() ———— 获取栈顶元素。
getMin() —— 检索栈中的最⼩元素。
输⼊：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); --> 返回 -3.
minStack.pop();
minStack.top(); --> 返回 0.
minStack.getMin(); --> 返回 -2.
输出：
[null,null,null,null,-3,null,0,-2]
 */
public class Day9_MinStack {
}

//手写简单栈
class Stack {
    private Integer[] datas;
    private int size;
    private int capacity;

    public Stack() {
        datas = new Integer[10];
        this.capacity = 10;
    }

    private void push(int val) {
        if (capacity == size) {
            grow(capacity * 2);
        }
        datas[size++] = val;
    }

    /**
     * 栈 扩容方法
     *
     * @param capacity
     */
    private void grow(int capacity) {
        Integer[] newArr = new Integer[capacity]; //创建一个新的数组
        System.arraycopy(this.datas, 0, newArr, 0, size);
        this.datas = newArr;
        this.capacity = capacity;
    }

    private void pop() {
        datas[--size] = null;
    }

    private int top() {
        return datas[size - 1];
    }
}

