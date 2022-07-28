package com.zlq.day40;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day32_BinarySearch
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/4 9:01 上午
 */
/*
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
 */
public class Day32_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 3;
        System.out.println(solution(nums, target));
    }

    public static int solution(int[] nums, int target) {
        int length = nums.length;
        int l = 0, r = length - 1;
        if (target < nums[l] || target > nums[r]) {
            return -1;
        }
        while (l <= r) {
            int midIndex = (l + r) / 2;
            int midNum = nums[midIndex];
            if (target < midNum) r = midIndex - 1;
            else if (target > midNum) l = midIndex + 1;
            else return midIndex;
        }
        return -1;
    }


    public static int search(int[] a, int key, int fromIndex, int toIndex) {
        if (key < a[fromIndex] || key > a[toIndex] || fromIndex > toIndex)
            return -1;

        int mid = (fromIndex + toIndex) / 2;

        if (a[mid] < key)
            return search(a, key, mid + 1, toIndex);
        else if (a[mid] > key)
            return search(a, key, fromIndex, mid - 1);
        else
            return mid;
    }
}
