package com.zlq.day60;

import com.zlq.common.ListNode;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day60_SwapNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/11/26 9:22 上午
 */
/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1：

输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]
 */
public class Day60_SwapNode {
    public static void main(String[] args) {
        ListNode head = generateListNode();
        System.out.print("原始链表为：");
        ListNode.print(head);

        ListNode listNodeHead = swapPairs(head);
        System.out.print("交换后的链表为：");
        ListNode.print(listNodeHead);
    }


    /*
     5 -> 8 -> 6 -> 2 -> 9
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curNode = head.next;  // 初始节点为头结点的下一个节点
        ListNode prevNode = head;      // 记录初始节点的前一个节点
        ListNode returnHead = head.next; // 记录返回的头结点


        ListNode sentinelNode = new ListNode(0);   // 哨兵节点
        while (curNode != null) {
            prevNode.next = curNode.next;
            curNode.next = prevNode;
            sentinelNode.next = curNode;


            sentinelNode = prevNode;

            if (prevNode.next == null) break;
            curNode = prevNode.next.next;
            prevNode = prevNode.next;
        }
        return returnHead;
    }

    public static ListNode generateListNode() {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(9);
//        ListNode n6 = new ListNode(7);
//        ListNode n7 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
        return n1;
    }
}
