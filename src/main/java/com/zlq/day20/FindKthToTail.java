package com.zlq.day20;

import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: FindKthToTail
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/5 10:00 上午
 */
public class FindKthToTail {
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
        System.out.println(getLastKthVal3(node1, 2));
        print(node1);
    }

    // 两次遍历
    public static int getLastKthVal1(ListNode head,int k){
        // 节点右移次数
        int count = getLength(head) - k - 1;
        for (int i = 0; i < count; i++) {
            head = head.next;
        }
        Integer res = head.next.value; // 要返回的值
        head.next = head.next.next;
        return  res;
    }

    // 一次遍历，利用栈
    public static int getLastKthVal2(ListNode head,int k){
        Stack<ListNode> listNodeStack = new Stack<>();
        while (head != null) {
            listNodeStack.push(head);
            head = head.next;
        }
        for (int i = 0; i < k; i++) {
            listNodeStack.pop();
        }
        int res = listNodeStack.peek().next.value;
        listNodeStack.peek().next = listNodeStack.peek().next.next;
        return res;
    }

    // 一次遍历，利用双指针
    public static int getLastKthVal3(ListNode head,int k){
        // 定义两个指针，都指向头节点
        ListNode p1 = head;
        ListNode p2 = head;
        // 让p1现跑k下，然后停
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        // 让p1和p2同时跑
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        Integer res = p2.next.value;
        p2.next = p2.next.next;
        return res;
    }
    public static int getLength(ListNode head){
        int count = 0;
        while (head !=null){
            count++;
            head = head.next;
        }
        return count;
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
