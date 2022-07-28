package com.zlq.day90;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: Day90_MaximumDifference
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/26 9:44 上午
 */
/*
给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。

返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。

示例 1：

输入：nums = [7,1,5,4]
输出：4
解释：
最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，但 i > j 不满足题面要求，所以 6 不是有效的答案。
示例 2：

输入：nums = [9,4,3,2]
输出：-1
解释：
不存在同时满足 i < j 和 nums[i] < nums[j] 这两个条件的 i, j 组合。
示例 3：

输入：nums = [1,5,2,10]
输出：9
解释：
最大差值出现在 i = 0 且 j = 3 时，nums[j] - nums[i] = 10 - 1 = 9 。
 */
public class Day90_MaximumDifference {
    public static void main(String[] args) {
        int[] nums  = {7,1,5,4};
        System.out.println(maximumDifference(nums));
    }
    public static int maximumDifference(int[] nums) {
        int maxDifference = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i]) maxDifference = Math.max(maxDifference,nums[j] - nums[i]);
            }
        }
        return maxDifference > 0 ? maxDifference : -1;
    }

    public static int maximumDifference2(int[] nums) {
        int n = nums.length, ans = -1;
        for (int i = 0, min = nums[0]; i < n; i++) {
            if (nums[i] > min) ans = Math.max(ans, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return ans;
    }

    public static int maximumDifference3(int[] nums) {
        int res = -1;
        for (int i = 0,min = nums[0]; i < nums.length; i++) {
            if (nums[i] > min ) res = Math.max(res,nums[i] - min);
            min = Math.min(min,nums[i]);
        }
        return res;

    }


    }
