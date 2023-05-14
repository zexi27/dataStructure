package com.zlq.day240;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day240
 * @ClassName: Day237_NextLargerNodes
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/10 11:22
 */
/*
1019. Next Greater Node In Linked List
中等
You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node,
find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed).
If the ith node does not have a next greater node, set answer[i] = 0.

Example 1:


Input: head = [2,1,5]
Output: [5,5,0]
Example 2:

Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]

Constraints:

The number of nodes in the list is n.
1 <= n <= 104
1 <= Node.val <= 109
 */
public class Day237_NextLargerNodes {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(Arrays.toString(nextLargerNodes(n1)));
    }
//    public static int[] nextLargerNodes(ListNode head) {
//        ListNode p1 = head,p2 = p1;
//        int length = 0;
//        while (head != null){
//            length++;
//            head = head.next;
//        }
//        int[] resArr = new int[length];
//        int index = 0;
//        while (p1 != null){
//            int res = 0;
//            p2 = p1;
//            while (p2 != null){
//                int val = p2.val;
//                if (val > p1.val) {
//                    res = val;
//                    break;
//                }
//                p2 = p2.next;
//            }
//            resArr[index++] = res;
//            p1 = p1.next;
//        }
//        return resArr;
//    }


    public static int[] nextLargerNodes(ListNode head) {
        int[] arr = toArray(head);
        Stack<Integer> stack = new Stack<>();
        int[] resArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

        }
        return resArr;
    }

    private static int[] toArray(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        int[] res = new int[length];
        int index = 0;
        p = head;
        while (p != null) {
            res[index++] = p.val;
            p = p.next;
        }
        return res;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
