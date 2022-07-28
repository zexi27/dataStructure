package com.zlq.day120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day120
 * @ClassName: Day119_FindDuplicates
 * @description:
 * @author: LiQun
 * @CreateDate:2022/5/8 15:31
 */
/*
给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。

你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。

示例 1：

输入：nums = [4,3,2,7,8,2,3,1]
输出：[2,3]
示例 2：

输入：nums = [1,1,2]
输出：[1]
示例 3：

输入：nums = [1]
输出：[]
 */
public class Day119_FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates2(nums));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[nums[i] - 1]++;
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] > 1) resList.add(i + 1);
        }
        return resList;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t < 0 || t - 1 == i) continue;
            if (nums[t - 1] == t) {
                ans.add(t);
                nums[i] *= -1;
            } else {
                int c = nums[t - 1];
                nums[t - 1] = t;
                nums[i--] = c;
            }
        }
        return ans;
    }

}
