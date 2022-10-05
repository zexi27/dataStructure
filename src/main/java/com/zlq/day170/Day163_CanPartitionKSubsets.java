package com.zlq.day170;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day163_CanPartitionKSubsets
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/20 17:51
 */
/*
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 */
public class Day163_CanPartitionKSubsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 9};
        traversal(nums, 0);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (sum % k != 0) return false;
        int subSum = sum / k;

        for (int i = 0; i < nums.length; i++) {

        }
        return false;
    }

    // 迭代
    private static void traversal(int[] nums) {
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    // 递归迭代数组
    private static void traversal(int[] nums, int index) {
        int length = nums.length;
        if (index == length) return;
        System.out.print(nums[index] + "\t");
        traversal(nums, ++index);
    }

}
