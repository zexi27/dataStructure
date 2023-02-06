package com.zlq.day190;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day190
 * @ClassName: Day186_MinOperations
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/7 13:32
 */
/*
给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。

每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。

请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。



示例 1：

输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
输出：3
解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
示例 2：

输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
输出：-1
解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
示例 3：

输入：nums1 = [6,6], nums2 = [1]
输出：3
解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 */
public class Day186_MinOperations {
    /*
    实例1举例：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
    sumNums1 = 21  sumNums2 = 10  ==》 sumNums1  > sumNums2  ==》nums1要执行变小操作，nums2要执行变大操作
    nums1跨度：{0,1,2,3,4,5} ，nums2跨度：{5,5,4,4,4,4}  ===>
    {0 : 1次 , 1 : 1次 , 2 : 1次 , 3 : 1次 , 4 : 5次 , 5 : 3次}
    差值为11 ，先减去最大跨度 11 - 5 = 6 ，再减去最大跨度 6 - 5 =  1， 因为1小于跨度5 ，再进行一步操作成立
    最少共操作三次
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 1, 1, 1, 1};
        int[] nums2 = {6};
        System.out.println(minOperations(nums1, nums2));
        System.out.println(checkPowersOfThree(12));
    }

    public static int minOperations(int[] nums1, int[] nums2) {
        int[] spanArr = new int[6];
        int sumNums1 = 0, sumNums2 = 0;
        for (int num : nums1) sumNums1 += num;
        for (int num : nums2) sumNums2 += num;
        if (sumNums1 == sumNums2) return 0;
        for (int num : nums1) {
            int key = sumNums1 > sumNums2 ? num - 1 : 6 - num;
            spanArr[key]++;
        }

        for (int num : nums2) {
            int key = sumNums1 > sumNums2 ? 6 - num : num - 1;
            spanArr[key]++;
        }
        int distance = Math.abs(sumNums1 - sumNums2);
        int count = 0;
        int maxSpan = 0;
        while (distance > 0) {
            maxSpan = getMaxSpan(spanArr);
            if (maxSpan == 0) return -1;
            if (distance >= maxSpan) {
                distance -= maxSpan;
                spanArr[maxSpan] -= 1;
            } else {
                distance = 0;
            }
            count++;
        }
        return count;
    }

    public static int getMaxSpan(int[] spanArr) {
        for (int i = spanArr.length - 1; i >= 0; i--) {
            if (spanArr[i] != 0) return i;
        }
        return -1;
    }


    // 白色返回true黑色返回false
    public static boolean squareIsWhite(String coordinates) {
        int column = coordinates.charAt(0) - 'a' + 1;
        int raw = coordinates.charAt(1) - '0';
        boolean isWhite = false;
        if (column % 2 == 0) isWhite = true;
        if (raw % 2 == 0) isWhite = !isWhite;

        return isWhite;
    }

    /*
    给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。

    对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。

    示例 1：

    输入：n = 12
    输出：true
    解释：12 = 31 + 32
    示例 2：

    输入：n = 91
    输出：true
    解释：91 = 30 + 32 + 34
    示例 3：

    输入：n = 21
    输出：false
     */
    public static boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 != 1 && n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }

    /*
    You are given an integer array nums (0-indexed). In one operation,
    you can choose an element of the array and increment it by 1.

    For example, if nums = [1,2,3], you can choose to increment nums[1] to make nums = [1,3,3].
    Return the minimum number of operations needed to make nums strictly increasing.

    An array nums is strictly increasing if nums[i] < nums[i+1] for all 0 <= i < nums.length - 1. An array of length 1 is trivially strictly increasing.

    Example 1:

    Input: nums = [1,1,1]
    Output: 3
    Explanation: You can do the following operations:
    1) Increment nums[2], so nums becomes [1,1,2].
    2) Increment nums[1], so nums becomes [1,2,2].
    3) Increment nums[2], so nums becomes [1,2,3].
    Example 2:

    Input: nums = [1,5,2,4,1]
    Output: 14
    Example 3:

    Input: nums = [8]
    Output: 0
     */
    public static int minOperations(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;
        int operationCount = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) continue;
            else {
                operationCount += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return operationCount;
    }


}