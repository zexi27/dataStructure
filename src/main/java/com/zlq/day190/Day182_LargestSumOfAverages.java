package com.zlq.day190;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day190
 * @ClassName: Day182_LargestSumOfAverages
 * @description:
 * @author: LiQun
 * @CreateDate:2022/11/28 23:45
 */
/*
You are given an integer array nums and an integer k.
You can partition the array into at most k non-empty adjacent subarrays.
The score of a partition is the sum of the averages of each subarray.
Note that the partition must use every integer in nums, and that the score is not necessarily an integer.

Return the maximum score you can achieve of all the possible partitions.
Answers within 10-6 of the actual answer will be accepted.

Example 1:

Input: nums = [9,1,2,3,9], k = 3
Output: 20.00000
Explanation:
The best choice is to partition nums into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned nums into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
Example 2:

Input: nums = [1,2,3,4,5,6,7], k = 4
Output: 20.50000
 */
public class Day182_LargestSumOfAverages {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(largestSumOfAverages(nums, 4));
    }

    /*
    dp[3,2] = Math.max(dp[1,1] + (1+2)/2 , dp[2,1] + 2)
    dp[4,2] = Math.max(dp[1,1] + (1+2+3)/3 , dp[2,1] + (2+3)/2 , dp[3,1] + 3)
    dp[5,2] = Math.max(dp[1,1] + (1+2+3+4)/4 , dp[2,1] + (2+3+4)/3 , dp[3,1] + (3+9)/2 , dp[4,1] + 9)
    ================
    dp[i,1] = sum(0 ~ i-1)/ i
    i == j => dp[i,j] = sum(0 ~ i-1)
    dp[i,j] = Math.max()
     */
    public static double largestSumOfAverages(int[] nums, int k) {
        int length = nums.length;
        double[] sumArr = new double[length + 1];
        for (int i = 1; i < length + 1; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i - 1];
        }
        double[][] dp = new double[length + 1][k + 1];
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j <= i && j <= k; j++) {
                if (j == 0) dp[i][j] = 0;
                else if (j == 1) dp[i][j] = sumArr[i] / i;
                else if (i == j) dp[i][j] = sumArr[i];
                else {
                    int index = 1;
                    double max = 0;
                    while (index < i) {
                        max = Math.max(dp[index][j - 1] + (sumArr[i] - sumArr[index]) / (i - index), max);
                        index++;
                    }
                    dp[i][j] = max;
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[length][k];
    }


    /*
    You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

    The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

    Return the minimum number of operations needed to make s alternating.

    Example 1:

    Input: s = "0100"
    Output: 1
    Explanation: If you change the last character to '1', s will be "0101", which is alternating.
    Example 2:

    Input: s = "10"
    Output: 0
    Explanation: s is already alternating.
    Example 3:

    Input: s = "1111"
    Output: 2
    Explanation: You need two operations to reach "0101" or "1010".
    */


    public static int minOperations(String s) {
        /*
        1000111011101101
        1010101010101010
        0101010101010101
         */
        char[] charArr = s.toCharArray();
        // {1,0,0,0,1,1,1,0,1,1,1,0,1,1,0,1]
        int changeCount = 0;
        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] != charArr[i + 1]) continue;
            else {
                if (charArr[i] == '0') charArr[i + 1] = '1';
                else charArr[i + 1] = '0';
                changeCount++;
            }
        }
        return Math.min(changeCount, s.length() - changeCount);
    }
}
