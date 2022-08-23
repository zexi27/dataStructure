package com.zlq.day160;

import com.zlq.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day160
 * @ClassName: Day152_FindBail
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/22 14:01
 */
/*
用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。

箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。

将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。

返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。

示例 1：

输入：grid = [
             [1, 1, 1, -1,-1],
             [1, 1, 1, -1,-1],
             [-1,-1,-1, 1, 1],
             [1, 1, 1, 1, -1],
             [-1,-1,-1,-1,-1]
             ]
输出：[1,-1,-1,-1,-1]
解释：示例如图：
b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
示例 2：

输入：grid = [[-1]]
输出：[-1]
解释：球被卡在箱子左侧边上。
示例 3：

输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
输出：[0,1,2,3,4,-1]

提示：

m == grid.length
n == grid[i].length
 */
public class Day152_FindBail {

    public static int[] findBall(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int balls = columns;
        int[] res = new int[balls];
        for (int i = 0; i < balls; i++) {
            int positionOfColumn = i; // 小球的初始位置
            for (int j = 0; j < rows; j++) {
                int direction = grid[j][positionOfColumn];
                positionOfColumn += direction;
                if (positionOfColumn < 0 || positionOfColumn == columns || grid[j][positionOfColumn] != direction) {
                    positionOfColumn = -1;
                    break;
                }
            }
            res[i] = positionOfColumn;
        }
        return res;
    }


    /*
    给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

    示例 1：

    输入：head = [1,2,2,1]
    输出：true
    示例 2：


    输入：head = [1,2]
    输出：false


    提示：
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(isPalindrome1(node1));

    }

    // method of double point
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {  // put into list
            list.add(head.value);
            head = head.next;
        }
        // double point
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l) == list.get(r)) {
                l++;
                r--;
            } else return false;
        }
        return true;
    }


    // method of stack
    public static boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode sentinel = head;
        while (sentinel != null){
            stack.add(sentinel.value);
            sentinel = sentinel.next;
        }
       while (!stack.isEmpty()){
           if (stack.pop() == head.value){
               head = head.next;
           }else return false;
       }
       return true;
    }


    public static boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) {
            if(pre.value != slow.value) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

}
