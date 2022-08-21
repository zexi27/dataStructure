package com.zlq.day150;

import com.zlq.common.ListNode;
import com.zlq.day40.day36_lrucache.Node;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day150
 * @ClassName: Day148_MyCircularDeque
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/15 10:42
 */
/*
设计实现双端队列。

实现 MyCircularDeque 类:

MyCircularDeque(int k)：构造函数,双端队列最大为 k 。
boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true，否则返回 false 。
boolean insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true，否则返回 false 。
boolean deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true，否则返回 false 。
boolean deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true，否则返回 false 。
int getFront())：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
int getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1 。
boolean isEmpty()：若双端队列为空，则返回true，否则返回 false 。
boolean isFull()：若双端队列满了，则返回true，否则返回 false 。


示例 1：

输入
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
输出
[null, true, true, true, false, 2, true, true, true, 4]

解释
MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
circularDeque.insertLast(1);			        // 返回 true
circularDeque.insertLast(2);			        // 返回 true
circularDeque.insertFront(3);			        // 返回 true
circularDeque.insertFront(4);			        // 已经满了，返回 false
circularDeque.getRear();  				// 返回 2
circularDeque.isFull();				        // 返回 true
circularDeque.deleteLast();			        // 返回 true
circularDeque.insertFront(4);			        // 返回 true
circularDeque.getFront();				// 返回 4
 */
public class Day148_MyCircularDeque {
    public static void main(String[] args) {
        /*
       ["MyCircularDeque","insertFront","insertLast","getFront","insertLast","getFront","insertFront","getRear","getFront","getFront","deleteLast","getRear"]
[[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]
         */
        Day148_MyCircularDeque myCircularDeque = new Day148_MyCircularDeque(8);
        System.out.println(myCircularDeque.insertFront(2));
        System.out.println(myCircularDeque.insertLast(10));
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.insertLast(8));
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.insertFront(5));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.getRear());
//
//        System.out.println(myCircularDeque.isEmpty());
//        System.out.println(myCircularDeque.deleteFront());
//        System.out.println(myCircularDeque.getRear());
//        System.out.println(myCircularDeque.insertFront(5));
//        System.out.println(myCircularDeque.deleteLast());
//        System.out.println(myCircularDeque.insertLast(3));
//        System.out.println(myCircularDeque.isEmpty());

    }
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private int size;

    public Day148_MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        ListNode node = new ListNode(value);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        ListNode node = new ListNode(value);
        if (isEmpty()){
            this.head = node;
            this.tail = node;
        }else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        ListNode sentinel = head;
        head = head.next;
        sentinel.next = null;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        ListNode sentinel = tail;
        tail = tail.pre;
        sentinel.pre = null;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return this.head.value;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return this.tail.value;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.capacity == this.size;
    }
}
