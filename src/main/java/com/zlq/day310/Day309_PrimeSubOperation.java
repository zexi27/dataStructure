package com.zlq.day310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/11/11 21:42
 */
/*
2601. Prime Subtraction Operation
Medium
Topics
Companies
Hint
You are given a 0-indexed integer array nums of length n.

You can perform the following operation as many times as you want:

Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
Return true if you can make nums a strictly increasing array using the above operation and false otherwise.

A strictly increasing array is an array whose each element is strictly greater than its preceding element.



Example 1:

Input: nums = [4,9,6,10]
Output: true
Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
After the second operation, nums is sorted in strictly increasing order, so the answer is true.
Example 2:

Input: nums = [6,8,11,12]
Output: true
Explanation: Initially nums is sorted in strictly increasing order, so we don't need to make any operations.
Example 3:

Input: nums = [5,8,3]
Output: false
Explanation: It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.


Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
nums.length == n
 */
public class Day309_PrimeSubOperation {

	public static void main(String[] args) {
		int[] nums = {5,8,3};
		System.out.println(primeSubOperation(nums));
	}

	public static boolean primeSubOperation(int[] nums) {
		int length = nums.length;
		for (int i = length - 1; i >= 1; i--) {
			if (nums[i] <= nums[i - 1]) {
				int diff = nums[i - 1] - nums[i] + 1;
				// 查找大于diff的最小质数
				int prime = findMinPrime(diff);
				nums[i - 1] -= prime;
				if (nums[i - 1] <= 0) {
					return false;
				}
			}
		}

		return true;
	}

	public static int findMinPrime(int diff) {
		while (!isPrime(diff)) {
			diff++;
		}
		return diff;
	}


	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}


	public int isPrefixOfWord(String sentence, String searchWord) {
		String[] split = sentence.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (split[i].startsWith(searchWord)) {
				return i;
			}
		}
		return -1;
	}

}
