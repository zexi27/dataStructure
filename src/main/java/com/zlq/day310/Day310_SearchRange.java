package com.zlq.day310;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/12/2 21:18
 */

/*
34. 在排序数组中查找元素的第一个和最后一个位置
中等
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。



示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]


提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109
 */
public class Day310_SearchRange {

	public static void main(String[] args) {
		int[] nums = {};
		System.out.println(searchRange(nums, 8));
	}

	public static int[] searchRange(int[] nums, int target) {
		int leftBound = searchLowerBound(nums, target);
		if (leftBound > nums.length - 1 ||nums[leftBound] != target) {
			return new int[]{-1, -1};
		}
		int rightBound = searchLowerBound(nums, target + 1) - 1;
		return new int[]{leftBound, rightBound};
	}


	public static int searchLowerBound(int[] nums, int target) {
		int start = 0, end = nums.length;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}


}
