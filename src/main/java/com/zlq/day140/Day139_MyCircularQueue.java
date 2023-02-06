package com.zlq.day140;

import com.zlq.common.ListNode;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day140
 * @ClassName: Day139_MyCircularQueue
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/2 14:34
 */
/*
设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
它也被称为“环形缓冲器”。

循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。

你的实现应该支持如下操作：

MyCircularQueue(k): 构造器，设置队列长度为 k 。
Front: 从队首获取元素。如果队列为空，返回 -1 。
Rear: 获取队尾元素。如果队列为空，返回 -1 。
enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
isEmpty(): 检查循环队列是否为空。
isFull(): 检查循环队列是否已满。

示例：

MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
circularQueue.enQueue(1); // 返回 true
circularQueue.enQueue(2); // 返回 true
circularQueue.enQueue(3); // 返回 true
circularQueue.enQueue(4); // 返回 false，队列已满
circularQueue.Rear(); // 返回 3
circularQueue.isFull(); // 返回 true
circularQueue.deQueue(); // 返回 true
circularQueue.enQueue(4); // 返回 true
circularQueue.Rear(); // 返回 4
 */
public class Day139_MyCircularQueue {
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private int size;

    public Day139_MyCircularQueue(int k) {
        this.capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
        if (size == capacity) {
            tail.next = head;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        tail.next = null;
        ListNode sentinel = head;
        head = head.next;
        sentinel.next = null;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return head.value;
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return tail.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
