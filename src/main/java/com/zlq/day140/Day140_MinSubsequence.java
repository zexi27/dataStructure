package com.zlq.day140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day140
 * @ClassName: Day140_MinSubsequence
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/4 10:43
 */
/*
给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。

如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。

与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，
也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。


示例 1：

输入：nums = [4,3,10,9,8]
输出：[10,9]
解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。
示例 2：

输入：nums = [4,4,7,6,7]
输出：[7,7,6]
解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。
示例 3：

输入：nums = [6]
输出：[6]
 */
public class Day140_MinSubsequence {
    public static void main(String[] args) {
        int[] nums = {4,3,10,9,8};
        System.out.println(minSubsequence1(nums));
    }

    public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> resList = new ArrayList<>();
        int length = nums.length;
        if (length == 1) {
            resList.add(nums[0]);
            return resList;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        int windowSize = 0;
        while (true) {
            int r = length - 1, l = r - windowSize;
            while (l >= 0) {
                int subSum = 0;
                for (int i = l; i <= r; i++) {
                    subSum += nums[i];
                }
                if (subSum > sum - subSum) {
                    for (int i = r; i >= l; i--) {
                        resList.add(nums[i]);
                    }
                    return resList;
                }
                l--;
                r--;
            }
            windowSize++;
        }
    }

    public static List<Integer> minSubsequence1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> resList = new ArrayList<>();
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        int subSum = 0;
        for (int i = length - 1; i >= 0; i--) {
            subSum += nums[i];
            resList.add(nums[i]);
            if (subSum > sum - subSum) return resList;
        }
        return null;
    }
}
