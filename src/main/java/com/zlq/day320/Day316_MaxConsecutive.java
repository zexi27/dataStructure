package com.zlq.day320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/1/6 21:47
 */
/*
2274. Maximum Consecutive Floors Without Special Floors
Alice manages a company and has rented some floors of a building as office space. Alice has decided some of these floors should be special floors, used for relaxation only.

You are given two integers bottom and top, which denote that Alice has rented all the floors from bottom to top (inclusive). You are also given the integer array special, where special[i] denotes a special floor that Alice has designated for relaxation.

Return the maximum number of consecutive floors without a special floor.



Example 1:

Input: bottom = 2, top = 9, special = [4,6]
Output: 3
Explanation: The following are the ranges (inclusive) of consecutive floors without a special floor:
- (2, 3) with a total amount of 2 floors.
- (5, 5) with a total amount of 1 floor.
- (7, 9) with a total amount of 3 floors.
Therefore, we return the maximum number which is 3 floors.
Example 2:

Input: bottom = 6, top = 8, special = [7,6,8]
Output: 0
Explanation: Every floor rented is a special floor, so we return 0.

Constraints:

1 <= special.length <= 105
1 <= bottom <= special[i] <= top <= 109
All the values of special are unique.
 */
public class Day316_MaxConsecutive {

	public static void main(String[] args) {
		int[] nums = {10, 4, -8, 7};
		System.out.println(waysToSplitArray(nums));

		Function<Integer, String[]> function = String[]::new;
		System.out.println(Arrays.toString(function.apply(3)));

		Integer cntA = Stream.of("a", "b", "c", "d", "a", "a").map(c -> "a".equals(c) ? 1 : 0).reduce(0, Integer::sum);
		System.out.println(cntA);

	}

	public static int maxConsecutive(int bottom, int top, int[] special) {
		Arrays.sort(special);

		int maxConsecutive = 0;
		for (int i = 1; i < special.length; i++) {
			maxConsecutive = Math.max(special[i] - special[i - 1] - 1, maxConsecutive);
		}
		maxConsecutive = Math.max(special[0] - bottom, maxConsecutive);
		maxConsecutive = Math.max(top - special[special.length - 1], maxConsecutive);
		return maxConsecutive;
	}

	public static int[] minOperations(String boxes) {
		int length = boxes.length();
		int[] result = new int[length];
		int leftCnt = 0;
		int rightCnt = 0;
		int curRes = 0;
		for (int i = 0; i < length; i++) {
			if (boxes.charAt(i) == '1') {
				rightCnt++;
				curRes += i;
			}
		}
		result[0] = curRes;
		for (int i = 1; i < length; i++) {
			if (boxes.charAt(i - 1) == '1') {
				leftCnt++;
				rightCnt--;
			}
			curRes = curRes - rightCnt + leftCnt;
			result[i] = curRes;
		}
		return result;
	}

	public static String largestGoodInteger(String num) {
		int l = 0, r = 2;
		int length = num.length();
		int max = -1;
		while (r < length) {
			while (r < length && num.charAt(l) != num.charAt(l + 1)) {
				l++;
				r++;
			}
			if (r <= length && num.charAt(l) == num.charAt(l + 1) && num.charAt(l + 1) == num.charAt(r)) {
				max = Math.max(max, num.charAt(l) - '0');
			}
			l++;
			r++;
		}
		if (max == -1) {
			return "";
		}
		char maxChar = (char) ('0' + max);
		return "" + maxChar + maxChar + maxChar;
	}

	public static int waysToSplitArray(int[] nums) {
		int res = 0;
		long left = 0, right = 0;
		for (int num : nums) {
			right += num;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			left += nums[i];
			right -= nums[i];
			if (left >= right) {
				res++;
			}
		}
		return res;
	}


	public static int minOperations(int[] nums, int k) {
		int cnt = 0;
		for (int num : nums) if (num >= k) cnt ++;
		return nums.length - cnt;
	}
}
