package com.zlq.day20;


/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day11_TwoSum
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/4 9:03 上午
 */
/*
Leetcode:给定两个非空链表来表示两个非负整数。
位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
示例：
输入：(7 -> 9 -> 3 ->8) + (6 -> 8 -> 5)
输出：3 -> 8 -> 9 ->8
原因：8397 + 586 = 8983
 */
public class Day11_TwoSum {
    public static void main(String[] args) {
//        ListNode n1_2 = new ListNode(9);
//        ListNode n1_4 = new ListNode(9);
//        ListNode n1_3 = new ListNode(9);
//        ListNode n1_8 = new ListNode(9);
//        n1_2.setNext(n1_4);
//        n1_4.setNext(n1_3);
//        n1_3.setNext(n1_8);
//
//        ListNode n2_5 = new ListNode(9);
//        ListNode n2_6 = new ListNode(9);
//        ListNode n2_4 = new ListNode(9);
//        n2_5.setNext(n2_6);
//        n2_6.setNext(n2_4);
//        ListNode newNodeHead = addTwoNumbers1(n1_2, n2_5);
        ListNode n11 = new ListNode(9);
        ListNode n21 = new ListNode(9);
        ListNode newNodeHead = addTwoNumbers1(n11, n21);
        print(newNodeHead);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(null); //定义个哨兵节点
        ListNode curNode = sentinel;
        int carry = 0; // 保存进位
        while (l1 != null || l2 != null) {
            int value = (l1 != null ? l1.value : 0) + (l2 != null ? l2.value : 0) + carry;
            carry = value / 10;
            ListNode listNode = new ListNode(value % 10);
            curNode.next = listNode;
            curNode = curNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }
        return sentinel.next;
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

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode head = sentinel;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int curNum = (l1 != null ? l1.value : 0) + (l2 != null ? l2.value : 0) + carry;
            carry = curNum >= 10 ? 1 : 0;
            curNum = curNum >= 10 ? curNum - 10 : curNum;
            head.next = new ListNode(curNum);
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1){
            head.next = new ListNode(1);
        }
        return sentinel.next;
    }

}


