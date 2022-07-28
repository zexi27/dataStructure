package com.zlq.day30;

import com.zlq.common.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day23_PlalindromeListNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/21 8:55 上午
 */
/*

请判断一个链表是否为回文链表。
示例 1:
输入: 1->2
输出: false
示例 2:
输入: 1->2->2->1
输出: true
 */
public class Day23_PlalindromeListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.setNext(node2);
        node2.setNext(node5);
        node5.setNext(node3);
        node3.setNext(node4);
        System.out.println(isPlalindromeListNode(node1));
    }

    public static boolean isPlalindromeListNode(ListNode head) {
        ListNode curNode = head;
        Stack<ListNode> stack = new Stack<>();
        while (head!= null){
            stack.push(head);
            head = head.getNext();
        }
        while (stack != null && curNode != null){
            ListNode node = stack.pop();
            if (curNode.getValue() != node.getValue()) return false;
            curNode = curNode.getNext();
        }
        return true;
    }

}
