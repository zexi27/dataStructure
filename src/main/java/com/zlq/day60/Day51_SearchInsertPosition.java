package com.zlq.day60;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day51_SearchInsertPosition
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/5 10:11 上午
 */
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Day51_SearchInsertPosition {
    public static void main(String[] args) {
        int nums[] = {5,6,7,8,9,15,17,19,22,88};
        System.out.println(searchInsertPosition(nums, 98));
    }

    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int midIndex = 0;
        if (target > nums[right]) return nums.length;
        if (target < nums[left]) return 0;
        while (left <= right) {
             midIndex = (left + right) / 2;
            if (target > nums[midIndex]) left = midIndex + 1;
            else if (target < nums[midIndex]) right = midIndex;
            else return midIndex;

            if (left == right) break;
        }
        return left;
    }


    public static int solution(int[] nums, int target) {
        int length = nums.length;
        int l = 0, r = length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midNum = nums[mid];
            if (target < midNum) r = mid - 1;
            else if (target > midNum) l = mid + 1;
            else return mid;
        }
        return -1;
    }


}
