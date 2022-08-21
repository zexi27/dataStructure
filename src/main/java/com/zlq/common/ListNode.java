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
    public ListNode next;
    public ListNode pre;

    public ListNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
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
