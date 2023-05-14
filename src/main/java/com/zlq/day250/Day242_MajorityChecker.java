package com.zlq.day250;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day241_MajorityChecker
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/16 13:15
 */
/*
1157. 子数组中占绝大多数的元素
提示
困难
110
相关企业
设计一个数据结构，有效地找到给定子数组的 多数元素 。

子数组的 多数元素 是在子数组中出现 threshold 次数或次数以上的元素。

实现 MajorityChecker 类:

MajorityChecker(int[] arr) 会用给定的数组 arr 对 MajorityChecker 初始化。
int query(int left, int right, int threshold) 返回子数组中的元素  arr[left...right] 至少出现 threshold 次数，如果不存在这样的元素则返回 -1。

示例 1：

输入:
["MajorityChecker", "query", "query", "query"]
[[[1, 1, 2, 2, 1, 1]], [0, 5, 4], [0, 3, 3], [2, 3, 2]]
输出：
[null, 1, -1, 2]

解释：
MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
majorityChecker.query(0,5,4); // 返回 1
majorityChecker.query(0,3,3); // 返回 -1
majorityChecker.query(2,3,2); // 返回 2


提示：

1 <= arr.length <= 2 * 104
1 <= arr[i] <= 2 * 104
0 <= left <= right < arr.length
threshold <= right - left + 1
2 * threshold > right - left + 1
调用 query 的次数最多为 104
 */
public class Day242_MajorityChecker {


    int[] arr = null;

    public Day242_MajorityChecker(int[] arr) {
        this.arr = arr;
    }

    public Day242_MajorityChecker() {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        int candidate = -1;
        int count = 0;

        // Boyer-Moore投票算法
        for (int i = left; i <= right; i++) {
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            } else if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // 检查候选元素是否为多数元素
        count = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == candidate) {
                count++;
            }
        }

        return count >= threshold ? candidate : -1;
    }


    public static void main(String[] args) {
        String arriveAlice =
                "09-01";
        String leaveAlice =
                "10-19";
        String arriveBob =
                "06-19";
        String leaveBob =
                "10-20";

//        int res = 0;
//        for (int i = 0; i < calender.length; i++) {
//            System.out.println(res += calender[i]);
//        }
        System.out.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));

    }

    static int[] calender = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] calenderIndex = new int[12];

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int days = 0;
        for (int i = 0; i < 12; i++) {
            calenderIndex[i] = days += calender[i];
        }
        int arriveA = parseDate(arriveAlice);
        int leaveA = parseDate(leaveAlice);
        int arriveB = parseDate(arriveBob);
        int leaveB = parseDate(leaveBob);
        int start = Math.max(arriveA, arriveB);
        int end = Math.min(leaveA, leaveB);
        if (start > end) {
            return 0;
        } else {
            return end - start + 1;
        }
    }

    public static int parseDate(String date) {
        int res = 0;
        String[] split = date.split("-");
        int monthIndex = Integer.valueOf(split[0]) - 2;
        if (monthIndex >= 0) res += calenderIndex[monthIndex];
        Integer day = Integer.valueOf(split[1]);
        res += day;
        return res;
    }


}

