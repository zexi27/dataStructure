package com.zlq.day60;

import com.zlq.common.ListNode;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: RotateListNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/11 10:49 下午
 */
/*
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。

示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]

示例 2：
输入：head = [0,1,2], k = 4
输出：[2,0,1]
 */
public class RotateListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = rotateRight(node1, 11);
        print(head);
    }

    /*
    1 -> 2 -> 3 -> 4 -> 5
     */
    // 如果右移的长度小于链表的长度，直接右移长度-链表长度
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        int length = getLength(head);
        while (k >= length){
            k -=length;
        }
        // 双指针移动指针，当后指针达到末尾，前指针达到目标节点
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }


        ListNode sentinel = new ListNode(null);
        ListNode curPoint = p1;
        ListNode curNode = sentinel;
        while (curPoint.next != null) {
            curNode.next = curPoint.next;
            curNode = curNode.next;
            curPoint = curPoint.next;
        }
        p1.next = null;
        curNode.next = head;

        return sentinel.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            if (head.next == null) System.out.println(head.value);
            else System.out.print(head.value + " -> ");
            head = head.next;
        }
    }

    public static int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}
