package com.zlq.day160;

import com.zlq.common.ListNode;
import com.zlq.common.TreeNode;

import java.util.*;
import java.util.concurrent.Executors;

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
        int[] target = {1, 1, 1, 1, 1};
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(canBeEqual1(target, arr));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        ListNode sentinel = new ListNode(null);  // 哨兵节点
        sentinel.next = head;
        ListNode leftPoint = sentinel;
        ListNode rightPoint = sentinel;
        for (int i = 0; i < n; i++) {
            rightPoint = rightPoint.next;
        }
        while (rightPoint.next != null) {
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


    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        if (Arrays.equals(target, arr)) return true;
        return false;
    }

    public static boolean canBeEqual1(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < target.length; i++) {
            int ele = target[i];
            if (!Objects.isNull(map.get(ele))) {
                Integer count = map.get(ele) - 1;
                map.put(ele, count);
                if (count < 0) return false;
                else if (count == 0) map.remove(ele);
            } else {
                return false;
            }

        }
        return map.isEmpty();
    }



}
