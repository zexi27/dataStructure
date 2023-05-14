package com.zlq.day250;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day247_MaxSumTwoNoOverlap
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/26 18:59
 */
/*
1031. Maximum Sum of Two Non-Overlapping Subarrays
中等
Given an integer array nums and two integers firstLen and secondLen, return the maximum sum of elements in two non-overlapping subarrays with lengths firstLen and secondLen.

The array with length firstLen could occur before or after the array with length secondLen, but they have to be non-overlapping.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
Example 2:

Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
Example 3:

Input: nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [0,3,8] with length 3.


Constraints:

1 <= firstLen, secondLen <= 1000
2 <= firstLen + secondLen <= 1000
firstLen + secondLen <= nums.length <= 1000
0 <= nums[i] <= 1000
 */
public class Day247_MaxSumTwoNoOverlap {
//    public static void main(String[] args) {
//        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
//        int firstLen = 1, secondLen = 2;
//        System.out.println(maxSumTwoNoOverlap(nums, firstLen, secondLen));
//    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return getMaxSubArrSum(nums, firstLen) + getMaxSubArrSum(nums, secondLen);
    }

    public static int getMaxSubArrSum(int[] nums, int length) {
        int l = 0, r = length - 1;
        int n = nums.length;
        int max = 0;
        int curSum = 0;
        for (int i = 0; i < r; i++) {
            curSum += nums[i];
        }
        max = Math.max(curSum, max);
        while (r < n - 1) {
            curSum -= nums[l];
            l++;
            r++;
            curSum += nums[r];
            max = Math.max(curSum, max);

        }
        return max;
    }

    public static void main(String[] args) {
        String word = "abcc";
        System.out.println(equalFrequency(word));
    }

    public static boolean equalFrequency(String word) {
        int[] indexArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            indexArr[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < indexArr.length; i++) {
            if (indexArr[i] != 0) {
                if (checkIfEqualFrequencyAfterDeleteOne(indexArr, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkIfEqualFrequencyAfterDeleteOne(int[] indexArr, int index) {
        int count = indexArr[index];
        if (count == 1) { // 如果为1，检查除此之外的非零坐标是否都相等
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < indexArr.length; i++) {
                if (indexArr[i] != 0 && i != index) set.add(indexArr[i]);
            }
            return set.size() == 1;
        } else { // 如果不为1，检查其他非零坐标是否都等于 这个数减1
            int check = count - 1;
            for (int i = 0; i < indexArr.length; i++) {
                if (i != index && indexArr[i] != 0 && indexArr[i] != check) return false;
            }
        }
        return true;
    }


    public static int[] numMovesStones(int a, int b, int c) {
        int[] posArr = new int[]{a, b, c};
        Arrays.sort(posArr);
        if (isConsecutive(posArr)) return new int[]{0, 0};
        // 判断是否有两个连续，或者两个间隔为1 ，此情况只需要移动一次
        if (isConTwoOrIntervalOne(posArr)) return new int[]{1, posArr[2] - posArr[0] - 2};
        return new int[]{2,posArr[2] - posArr[0] - 2};
    }


    public static boolean isConsecutive(int[] posArr) {
        return Math.abs(posArr[0] - posArr[2]) == 2;
    }


    public static boolean isConTwoOrIntervalOne(int[] posArr) {
        if (Math.abs(posArr[0] - posArr[1]) == 1 || Math.abs(posArr[1] - posArr[2]) == 1 || Math.abs(posArr[0] - posArr[1]) == 2 || Math.abs(posArr[1] - posArr[2]) == 2) return true;
        return false;
    }
}
