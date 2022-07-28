package com.zlq.day20;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day12_ReverseListNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/5 9:38 上午
 */
/*
剑指 offer:输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Day12_ReverseListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next  = node3;
        node3.next = node4;
        node4.next = node5;
        print(node1);
        ListNode reverseHead = reverse(node1);
        print(reverseHead);
    }

    public static ListNode reverse(ListNode head){
        // 保存当前节点的前面一个节点
        ListNode preNode = null;
        // 保存当前节点的后面一个节点
        ListNode nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }

    public static void print(ListNode head) {
        while (head != null) {
            if (head.next == null)
                System.out.println(head.value);
            else
                System.out.print(head.value + "->");
            head = head.next;
        }
    }
}
