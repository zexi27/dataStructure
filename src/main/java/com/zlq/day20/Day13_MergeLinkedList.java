package com.zlq.day20;

import java.util.LinkedList;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day13_MergeLinkedList
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/6 10:19 上午
 */
/*
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class Day13_MergeLinkedList{

    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(2);
        ListNode node1_4 = new ListNode(4);
        ListNode node2_1 = new ListNode(1);
        ListNode node2_3 = new ListNode(3);
        ListNode node2_4 = new ListNode(4);
        node1_1.next = node1_2;
        node1_2.next = node1_4;

        node2_1.next = node2_3;
        node2_3.next = node2_4;

        print(node1_1);
        print(node2_1);
        print(mergeTwoLinkedList2(node1_1, node2_1));
    }

    // 迭代法
    public static ListNode mergeTwoLinkedList1(ListNode head1, ListNode head2) {
        ListNode sentinel = new ListNode(0);
        ListNode curNode = sentinel;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                curNode.next = head1;
                curNode = curNode.next;
                head1 = head1.next;
            } else {
                curNode.next = head2;
                curNode = curNode.next;
                head2 = head2.next;
            }

            if (head1 == null || head2 == null)
                curNode.next = (head1 == null) ? head2 : head1;
        }
        return sentinel.next;
    }

    // 方法2：递归
    public static ListNode mergeTwoLinkedList2(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.value < head2.value) {
            head1.next = mergeTwoLinkedList2(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLinkedList2(head1, head2.next);
            return head2;
        }
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

