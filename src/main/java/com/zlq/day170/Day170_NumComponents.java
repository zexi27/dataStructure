package com.zlq.day170;

import com.zlq.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day170_NumComponents
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/12 23:25
 */
/*
给定链表头结点head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表nums，该列表是上述链表中整型值的一个子集。

返回列表nums中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表nums中）构成的集合。

示例1：

输入: head = [0,1,2,3], nums = [0,1,3]
输出: 2
解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
示例 2：

输入: head = [0,1,2,3,4], nums = [0,3,1,4]
输出: 2
解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 */
public class Day170_NumComponents {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        System.out.println(numComponents(node1, new int[]{0, 1, 3}));
    }

    public static int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>(); // 将nums访入hashset
        for (int num : nums) set.add(num);
        int components = 0;
        while (head != null) {
            if (set.contains(head.value)) {
                components++;
                while (head != null && set.contains(head.value)) {
                    head = head.next;
                }
            } else {
                head = head.next;
            }
        }
        return components;
    }
}
