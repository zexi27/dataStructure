package com.zlq.day320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/1/15 21:15
 */

/*
3066. Minimum Operations to Exceed Threshold Value II
中等

You are given a 0-indexed integer array nums, and an integer k.

In one operation, you will:

Take the two smallest integers x and y in nums.
Remove x and y from nums.
Add min(x, y) * 2 + max(x, y) anywhere in the array.
Note that you can only apply the described operation if nums contains at least two elements.

Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.



Example 1:

Input: nums = [2,11,10,1,3], k = 10
Output: 2
Explanation: In the first operation, we remove elements 1 and 2, then add 1 * 2 + 2 to nums. nums becomes equal to [4, 11, 10, 3].
In the second operation, we remove elements 3 and 4, then add 3 * 2 + 4 to nums. nums becomes equal to [10, 11, 10].
At this stage, all the elements of nums are greater than or equal to 10 so we can stop.
It can be shown that 2 is the minimum number of operations needed so that all elements of the array are greater than or equal to 10.
Example 2:

Input: nums = [1,1,2,4,9], k = 20
Output: 4
Explanation: After one operation, nums becomes equal to [2, 4, 9, 3].
After two operations, nums becomes equal to [7, 4, 9].
After three operations, nums becomes equal to [15, 9].
After four operations, nums becomes equal to [33].
At this stage, all the elements of nums are greater than 20 so we can stop.
It can be shown that 4 is the minimum number of operations needed so that all elements of the array are greater than or equal to 20.


Constraints:

2 <= nums.length <= 2 * 105
1 <= nums[i] <= 109
1 <= k <= 109
The input is generated such that an answer always exists. That is, there exists some sequence of operations after which all elements of the array are greater than or equal to k.
 */
public class Day317_MinOperations {


	public static void main(String[] args) {
		int[] nums = {2, -1, 1};
		System.out.println(findClosestNumber(nums));
	}

	public static int minOperations(int[] nums, int k) {
		PriorityQueue<Long> queue = new PriorityQueue<>();
		for (long num : nums) {
			queue.add(num);
		}
		int round = 0;
		while (queue.peek() < k) {
			long first = queue.poll();
			long second = queue.poll();
			queue.add(first * 2 + second);
			round++;
		}
		return round;
	}

	public static int findClosestNumber(int[] nums) {
		int res = Integer.MIN_VALUE;
		int abs = Integer.MAX_VALUE;
		for (int num : nums) {
			int curAbs = Math.abs(num);
			if (curAbs <= abs) {
				if (curAbs == abs) {
					res = Math.max(res, num);
				} else {
					abs = curAbs;
					res = num;
				}
			}
		}
		return res;
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(num)) {
				if (i - map.get(num) <= k) {
					return true;
				}else {
					map.put(num,i);
				}
			}else {
				map.put(num,i);
			}
		}
		return false;
	}

}
