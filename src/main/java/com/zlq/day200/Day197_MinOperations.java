package com.zlq.day200;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day200
 * @ClassName: Day197_MinOperations
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/7 10:46
 */
/*
给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。

如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。

示例 1：

输入：nums = [1,1,4,2,3], x = 5
输出：2
解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
示例 2：

输入：nums = [5,6,7,8,9], x = 4
输出：-1
示例 3：

输入：nums = [3,2,20,1,1,3], x = 10
输出：5
解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 */
public class Day197_MinOperations {

    public static void main(String[] args) {
//        int[] nums = {5, 6, 7, 8, 9};
//        System.out.println(minOperations(nums, 4));
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        System.out.println(prefixCount(words,pref));
    }

    public static int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;
        if (target < 0) return -1;  // 所有数字之和都没x大，表明全部移除都不满足要求
        int res = -1, l = 0, r = 0, sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > target) {
                sum -= nums[l];
                l++;
            }
            if (sum == target) res = Math.max(res, r - l + 1);
            r++;
        }
        return res == -1 ? -1 : nums.length - res;
    }


    public static int prefixCount(String[] words, String pref) {
        int prefLength = pref.length();
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > prefLength && words[i].substring(0,prefLength).equals(pref)) res++;
        }
        return res;
    }
}
