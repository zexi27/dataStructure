package com.zlq.day50;

import com.zlq.common.ListNode;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50
 * @ClassName: Day41_ReverseListNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/20 9:07 上午
 */
public class Day41_ReverseListNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        print(n1);
        ListNode reverseHead = reverseListNode(n1);
        print(reverseHead);

    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode curNode = head;
        ListNode prev = null;
        while (curNode != null){
            ListNode tempNode = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = tempNode;
        }
        return prev;
    }

    public static ListNode reverseListNode2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode restHead = head.next;
        ListNode reversedRest = reverseListNode2(restHead);
        restHead.next = head;
        head.next = null;
        return reversedRest;
    }


    public static void print(ListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.value + "->");
            else
                System.out.println(head.value);
            head = head.next;
        }
    }
}
