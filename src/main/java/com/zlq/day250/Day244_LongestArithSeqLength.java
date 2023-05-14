package com.zlq.day250;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day244_LongestArithSeqLength
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/22 13:27
 */
/*
1027. Longest Arithmetic Subsequence
中等
271
相关企业
Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Note that:

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).


Example 1:

Input: nums = [3,6,9,12]
Output: 4
Explanation:  The whole array is an arithmetic sequence with steps of length = 3.
Example 2:

Input: nums = [9,4,7,2,10]
Output: 3
Explanation:  The longest arithmetic subsequence is [4,7,10].
Example 3:

Input: nums = [20,1,15,3,10,5,8]
Output: 4
Explanation:  The longest arithmetic subsequence is [20,15,10,5].


Constraints:

2 <= nums.length <= 1000
0 <= nums[i] <= 500
 */
public class Day244_LongestArithSeqLength {
    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 9, 10};
        System.out.println(longestArithSeqLength2(nums));
    }

    public static int longestArithSeqLength(int[] nums) {
        int length = nums.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int seq = nums[j] - nums[i];
                int currentLength = 2;
                int prev = nums[j];
                for (int k = j + 1; k < length; k++) {
                    if (nums[k] - prev == seq) {
                        currentLength++;
                        prev = nums[k];
                    }
                }
                res = Math.max(res, currentLength);
            }
        }
        return res;
    }

    public static int longestArithSeqLength2(int[] nums) {
        int length = nums.length;
        int res = 2; // 初始化res最小为2
        Map<Integer, Integer>[] dp = new HashMap[length];
        for (int i = 0; i < length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res,dp[i].get(diff));
            }

        }
        System.out.println(Arrays.toString(dp));
        return res;
    }


}
