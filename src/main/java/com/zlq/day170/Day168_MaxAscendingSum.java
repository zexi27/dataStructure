package com.zlq.day170;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day168_MaxAscendingSum
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/7 12:22
 */
/*
给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。

子数组是数组中的一个连续数字序列。

已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。

示例 1：

输入：nums = [10,20,30,5,10,50]
输出：65
解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
示例 2：

输入：nums = [10,20,30,40,50]
输出：150
解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
示例 3：

输入：nums = [12,17,15,13,10,11,12]
输出：33
解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
示例 4：

输入：nums = [100,10,1]
输出：100
 */
public class Day168_MaxAscendingSum {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};

        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, r = 0;
        // 遇到升序，右指针右移，遇到降序左指针移到降序位置
        int curSum = nums[0];
        int maxAscendingSum = nums[0];

        while (r < nums.length - 1) {
            if (nums[r + 1] > nums[r]) { // 如果递增
                r++;
                curSum += nums[r];
            } else { // 否则就将左指针重新指向
                l = r + 1;
                r = l;
                curSum = nums[l];
            }
            maxAscendingSum = Math.max(curSum, maxAscendingSum);
        }
        return maxAscendingSum;
    }
}
