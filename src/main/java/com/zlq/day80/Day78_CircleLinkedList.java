package com.zlq.day80;

import com.zlq.common.ListNode;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: Day78_CircleLinkedList
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/29 9:57 上午
 */

public class Day78_CircleLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n2;
        System.out.println(hasCycle2(n1));

    }
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Set<Integer> listNodeSet = new HashSet<>();
        while (head.next != null){
            listNodeSet.add(head.value);
            if (listNodeSet.contains(head.next.value)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 快慢指针法
    public static boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode slowPointer = head;
        ListNode quickPointer = head;
        while (quickPointer.next != null &&quickPointer.next.next != null){
            slowPointer = slowPointer.next;
            quickPointer = quickPointer.next.next;
            if (quickPointer.equals(slowPointer)) return true;
        }
        return false;
    }

    }
