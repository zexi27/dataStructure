package com.zlq.day260;

import java.util.*;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/6/25 22:37
 */
/*
1401. Circle and Rectangle Overlapping
提示
中等
89
相关企业
You are given a circle represented as (radius, xCenter, yCenter) and an axis-aligned rectangle represented as (x1, y1, x2, y2),
 where (x1, y1) are the coordinates of the bottom-left corner, and (x2, y2) are the coordinates of the top-right corner of the rectangle.

Return true if the circle and rectangle are overlapped otherwise return false.
In other words, check if there is any point (xi, yi) that belongs to the circle and the rectangle at the same time.


Example 1:

Input: radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
Output: true
Explanation: Circle and rectangle share the point (1,0).
Example 2:

Input: radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
Output: false
Example 3:


Input: radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
Output: true


Constraints:

1 <= radius <= 2000
-104 <= xCenter, yCenter <= 104
-104 <= x1 < x2 <= 104
-104 <= y1 < y2 <= 104
 */
public class Day259_CheckOverLap {

    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int edgeX = (xCenter < x1) ? x1 : (xCenter > x2) ? x2 : xCenter;
        int edgeY = (yCenter < y1) ? y1 : (yCenter > y2) ? y2 : yCenter;
        int distX = xCenter - edgeX, distY = yCenter - edgeY;
        return distX * distX + distY * distY <= radius * radius;
    }

    /*
    There is a bag that consists of items, each item has a number 1, 0, or -1 written on it.

    You are given four non-negative integers numOnes, numZeros, numNegOnes, and k.

    The bag initially contains:

    numOnes items with 1s written on them.
    numZeroes items with 0s written on them.
    numNegOnes items with -1s written on them.
    We want to pick exactly k items among the available items. Return the maximum possible sum of numbers written on the items.



    Example 1:

    Input: numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
    Output: 2
    Explanation: We have a bag of items with numbers written on them {1, 1, 1, 0, 0}. We take 2 items with 1 written on them and get a sum in a total of 2.
    It can be proven that 2 is the maximum possible sum.
    Example 2:

    Input: numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
    Output: 3
    Explanation: We have a bag of items with numbers written on them {1, 1, 1, 0, 0}. We take 3 items with 1 written on them, and 1 item with 0 written on it, and get a sum in a total of 3.
    It can be proven that 3 is the maximum possible sum.

     */

    public static void main(String[] args) {
        int numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2;
        System.out.println(kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k));
    }

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int result = 0;
        int[] arr = new int[]{numNegOnes, numZeros, numOnes};
        for (int i = 0; i < k; i++) {
            if (arr[2] > 0){
                result += 1;
                arr[2] -= 1;
            }else if (arr[1] > 0){
                arr[1] -= 1;
            }else {
                result -=1;
                arr[0] -=1;
            }
        }
        return result;
    }

}
