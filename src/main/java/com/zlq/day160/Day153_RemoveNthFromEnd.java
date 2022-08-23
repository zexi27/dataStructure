package com.zlq.day160;

import com.zlq.common.ListNode;
import com.zlq.common.TreeNode;

import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day160
 * @ClassName: Day153_RemoveNthFromEnd
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/23 12:00
 */
/*
给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。

示例 1：

输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
 */
public class Day153_RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(5);
//        ListNode node4 = new ListNode(7);
//        ListNode node5 = new ListNode(9);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode head = removeNthFromEnd(node1, 2);
        ListNode.print(head);

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null &&  n == 1) return null;
        ListNode sentinel = new ListNode(null);  // 哨兵节点
        sentinel.next = head;
        ListNode leftPoint = sentinel;
        ListNode rightPoint = sentinel;
        for (int i = 0; i < n; i++) {
            rightPoint = rightPoint.next;
        }
        while (rightPoint.next != null){
            leftPoint = leftPoint.next;
            rightPoint = rightPoint.next;
        }
        leftPoint.next = leftPoint.next.next;
        return sentinel.next;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
