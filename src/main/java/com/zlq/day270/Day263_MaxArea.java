package com.zlq.day270;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/7/16 13:16
 */
/*
11. Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */
public class Day263_MaxArea {
    public static void main(String[] args) {
//        int[] height = {2, 3, 10, 5, 7, 8, 9};
//        System.out.println(maxArea2(height));
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    public static int maxArea(int[] height) {
        int res = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return res;
    }

    public static int maxArea2(int[] height) {
        int length = height.length;
        int l = 0, r = length - 1;
        int res = (r - l) * Math.min(height[l], height[r]);
        while (l < r) {
            res = height[l] < height[r] ? Math.max(res, (r - l) * height[l++]) : Math.max(res, (r - l) * height[r--]);

        }
        return res;
    }


    public static boolean lemonadeChange(int[] bills) {

        int fiveCount = 0, tenCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount == 0) return false;
                fiveCount--;
                tenCount++;
            } else {
                // 先用10后用5
                if (!(tenCount > 0 && fiveCount > 0 || fiveCount >= 3)) {
                    return false;
                }
                if (tenCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else {
                    fiveCount -= 3;
                }
            }
        }
        return true;
    }
}
