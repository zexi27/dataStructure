package com.zlq.day30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day28_TwoSum
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/29 8:38 下午
 */
/*
给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class Day28_TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum3(nums, target)));
    }

    // 方法1：暴力法
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 方法二，将数组存放在hash表中,两遍hash表
    public static int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < length; i++) {
            int findNum = target - nums[i];
            if (map.containsKey(findNum) && map.get(findNum) != i)
                return new int[]{i, map.get(findNum)};
        }
        return null;
    }

    // 方法三，将数组存放在hash表中,亿遍hash表
    public static int[] twoSum3(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int findNum = target - nums[i];
            if (map.containsKey(findNum) && map.get(findNum) != i)
                return new int[]{i, map.get(findNum)};
            map.put(nums[i], i);
        }
        return null;
    }
}
