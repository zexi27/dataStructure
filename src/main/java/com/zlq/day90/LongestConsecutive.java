package com.zlq.day90;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: LongestConsecutive
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/12 10:13 下午
 */
/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return nums.length;
        Arrays.sort(nums);  // {1,2,3,4,5,7,8,9,11,12,12,13}
        int longestLength = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) length++;
            else if (nums[i] == nums[i - 1]) continue;
            else {
                longestLength = Math.max(length, longestLength);
                length = 1;
            }
            longestLength = Math.max(length, longestLength);
        }
        return longestLength;
    }
}
