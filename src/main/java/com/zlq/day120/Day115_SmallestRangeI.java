package com.zlq.day120;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day120
 * @ClassName: Day115_SmallestRangeI
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/30 16:49
 */
/*
给你一个整数数组 nums，和一个整数 k 。
在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。
将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。

nums的分数是nums中最大和最小元素的差值。

在对 nums 中的每个索引最多应用一次上述操作后，返回nums 的最低 分数 。

示例 1：

输入：nums = [1], k = 0
输出：0
解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
示例 2：

输入：nums = [0,10], k = 2
输出：6
解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
示例 3：

输入：nums = [1,3,6], k = 3
输出：0
解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
 */
public class Day115_SmallestRangeI {

    public static void main(String[] args) {
        int[] nums = {0,10};
        System.out.println(smallestRangeI(nums,2));
     }
    public static int smallestRangeI(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) return 0;
        // 寻找数组中最小的元素
        int minEle = nums[0];
        for (int i = 0; i < length; i++) {
            if (nums[i] < minEle) minEle = nums[i];
        }
        // 寻找数组中最大的元素
        int maxEle = nums[0];
        for (int i = 0; i < length; i++) {
            if (nums[i] > maxEle) maxEle = nums[i];
        }
        if (maxEle - minEle < 2 * k) return 0;
        else return maxEle - minEle - 2 * k;
    }
}
