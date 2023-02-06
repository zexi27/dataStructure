package com.zlq.common;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: ListNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/5 9:40 上午
 */
public class ListNode {
    public Integer value;
    public ListNode  pre;
    public ListNode next;

    public ListNode(Integer val) {
        this.value = val;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer val) {
        this.value = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }

    public static void print(ListNode head) {
        while (head != null) {
            if (head.next == null) System.out.println(head.value);
            else System.out.print(head.value + " -> ");
            head = head.next;
        }
    }
}
