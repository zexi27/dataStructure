package com.zlq.day250;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day246_MaxSubArray
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/25 21:35
 */
/*
Given an integer array nums, find the
subarray
 with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Day246_MaxSubArray {
    public static void main(String[] args) {
//        int[] nums = {5, 4, -1, 7, 8};
//        System.out.println(maxSubArray(nums));
        String num1 = "456", num2 = "77";
        System.out.println(addStrings(num1, num2));
    }

    // 方法1：暴力法(超时)
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int res = -105;
        for (int i = 1; i <= length; i++) {
            int l = 0, r = i;
            int sum = 0;
            for (int j = l; j < r; j++) {
                sum += nums[j];
            }
            res = Math.max(sum, res);
            for (int j = i; j < length; j++) {
                sum += nums[j];
                sum -= nums[j - i];
                res = Math.max(sum, res);
            }
        }
        return res;
    }

    // maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i];
    public static int maxSubArray2(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = (dp[i - 1] > 0 ? dp[i - 1] : 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubArray3(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }


    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int index = 0; // 从后往前
        int l1 = num1.length() - 1;  // num1初始位置
        int l2 = num2.length() - 1;  // num2初始位置
        int carry = 0;
        int sum = 0;
        while (index <= l1 && index <= l2) {
            sum = (num1.charAt(l1 - index) - '0') + (num2.charAt(l2 - index) - '0') + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            res.insert(0, sum);
            index++;
        }
        if (l1 == l2 && carry == 1) {
            res.insert(0, 1);
            return res.toString();
        }
        String longNum = num1.length() > num2.length() ? num1 : num2;
        for (int i = longNum.length() - index - 1; i >= 0; i--) {
            sum = (longNum.charAt(i) - '0') + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            res.insert(0, sum);
        }
        if (carry == 1) res.insert(0,1);
        return res.toString();
    }
}
