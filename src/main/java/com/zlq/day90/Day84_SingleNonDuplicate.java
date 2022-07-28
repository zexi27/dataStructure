package com.zlq.day90;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: Day91_SingleNonDuplicate
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/14 11:34 上午
 */
/*
给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。

请你找出并返回只出现一次的那个数。

你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。

示例 1:

输入: nums = [1,1,2,3,3,4,4,8,8]
输出: 2
示例 2:

输入: nums =  [3,3,7,7,10,11,11]
输出: 10
 */
public class Day84_SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate3(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            } else {
                list.remove(new Integer(nums[i]));
            }
        }
        return list.get(0);
    }

    public static int singleNonDuplicate2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l + 1] == nums[l]) l += 2;
            if (nums[r - 1] == nums[r]) r -= 2;
        }
        return nums[r];
    }

    public static int singleNonDuplicate3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) >> 1;
            if (nums[mid] == nums[mid ^ 1]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}
