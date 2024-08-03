package com.zlq.day270;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/7/30 13:33
 */
/*
给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

不允许修改 链表。



示例 1：



输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：



输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：



输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。


提示：

链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引
 */
public class Day264_DetectCycle {

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(-4);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        n1.next = n2;
//        n2.next = n1;


//        ListNode.print(node1);
        System.out.println(detectCycle2(n1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode sentinel = head;
        Map<ListNode, Integer> map = new HashMap<>(); // key- listNode ,val - 坐标
        int index = 0;
        while (sentinel.next != null) {
            if (map.containsKey(sentinel.next)) {
                index = map.get(sentinel.next);
                break;
            }
            map.put(sentinel, index++);
            sentinel = sentinel.next;
        }

        int curIndex = 0;
        while (head.next != null) {
            if (curIndex == index) {
                return head;
            }
            head = head.next;
            curIndex++;

        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        if (head == null) return null;
        ListNode n1 = head, n2 = head; // n1 - 慢指针 ， n2 - 快指针

        while (true) {
            if ( n2.next == null || n2.next.next == null) return null;
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                n2 = head;
                break;
            }
        }

        while (true) {
            if (n1 == n2) {
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;

        }
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
