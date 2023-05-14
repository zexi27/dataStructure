package com.zlq.day230;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day230
 * @ClassName: Day226_BestTeamScore
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/22 10:53
 */
/*
1626. 无矛盾的最佳球队
中等
假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。

然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。

给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。



示例 1：

输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
输出：34
解释：你可以选中所有球员。
示例 2：

输入：scores = [4,5,6,5], ages = [2,1,2,1]
输出：16
解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
示例 3：

输入：scores = [1,2,3,5], ages = [8,9,10,1]
输出：6
解释：最佳的选择是前 3 名球员。


提示：

1 <= scores.length, ages.length <= 1000
scores.length == ages.length
1 <= scores[i] <= 106
1 <= ages[i] <= 1000
 */


public class Day226_BestTeamScore {

    public static void main(String[] args) {
//        int[] scores = {4, 5, 6, 5};
//        int[] ages = {2, 1, 2, 1};
//        System.out.println(bestTeamScore(scores, ages));
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    /*
    输入：scores = [4,5,6,5], ages = [2,1,2,1]
    4={2},5={1,1} 6={2}
     */
    public static int bestTeamScore(int[] scores, int[] ages) {
        int length = scores.length;
        if (length == 0) return scores[0];
        int[][] teamArr = new int[length][2];
        for (int i = 0; i < length; i++) {
            teamArr[i][0] = ages[i];
            teamArr[i][1] = scores[i];
        }
        Arrays.sort(teamArr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = teamArr[i][1];
            for (int j = 0; j < i; j++) {
                if (teamArr[i][1] >= teamArr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + teamArr[i][1]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }


    /*
    Given an integer array nums, return the length of the longest strictly increasing
            subsequence.
    Example 1:

    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example 2:

    Input: nums = [0,1,0,3,2,3]
    Output: 4
    Example 3:

    Input: nums = [7,7,7,7,7,7,7]
    Output: 1

    [10,9,2,5,3,7,101,18]
    [1, 1,1,2,2,3,4,4]
     */
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        int max  = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
