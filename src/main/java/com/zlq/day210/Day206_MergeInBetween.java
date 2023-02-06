package com.zlq.day210;


import com.zlq.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day206_MergeInBetween
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/30 10:01
 */
/*
1669. 合并两个链表
中等
给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。

请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。

下图中蓝色边和节点展示了操作后的结果：


请你返回结果链表的头指针。

示例 1：

输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
输出：[0,1,2,1000000,1000001,1000002,5]
解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
示例 2：


输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
解释：上图中蓝色的边和节点为答案链表。
 */
public class Day206_MergeInBetween {

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(0);
//        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(5);
//        ListNode node7 = new ListNode(6);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        ListNode.print(node1);
//
//        ListNode node21 = new ListNode(1000000);
//        ListNode node22 = new ListNode(1000001);
//        ListNode node23 = new ListNode(1000002);
//        ListNode node24 = new ListNode(1000003);
//        ListNode node25 = new ListNode(1000004);
//
//        node21.next = node22;
//        node22.next = node23;
//        node23.next = node24;
//        node24.next = node25;
//        ListNode.print(node21);
//        mergeInBetween(node1, 2, 5, node21);
//        ListNode.print(node1);
//        int[][] grid = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
//        System.out.println(checkXMatrix(grid));
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key, message));
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list1;
        for (int i = 0; i < a - 1; i++) {
            p1 = p1.next;
        }
        for (int i = 0; i <= b; i++) {
            p2 = p2.next;
        }
        p1.next = list2;
        while (p1.next != null) {
            p1 = p1.next;
        }
        p1.next = p2;

        return list1;
    }

    public static boolean checkXMatrix(int[][] grid) {
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j || i == length - 1 - j) {
                    if (grid[i][j] == 0) return false;
                } else {
                    if (grid[i][j] != 0) return false;

                }
            }
        }
        return true;
    }

    public static String decodeMessage(String key, String message) {
        int index = 0;
        Map<Character, Character> charMap = new HashMap<>();
//        key = key.replaceAll(" ", "");
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!charMap.containsKey(c) && c != ' ') {
                charMap.put(c, (char) ('a' + index++));
            }
        }
//        System.out.println(charMap);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c != ' ') c = charMap.get(c);
            res.append(c);
        }
        return res.toString();
    }

}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}