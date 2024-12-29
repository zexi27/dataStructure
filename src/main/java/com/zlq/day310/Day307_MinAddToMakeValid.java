package com.zlq.day310;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/10/9 15:31
 */
/*

921. Minimum Add to Make Parentheses Valid
Medium
Topics
Companies
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.



Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3


Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.
 */
public class Day307_MinAddToMakeValid {


	public static int minAddToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.size();
	}

	/*
	3171. 找到按位或最接近 K 的子数组
	给你一个数组 nums 和一个整数 k 。你需要找到 nums 的一个子数组 ，满足子数组中所有元素按位或运算 OR 的值与 k 的 绝对差 尽可能 小 。
	换言之，你需要选择一个子数组 nums[l..r] 满足 |k - (nums[l] OR nums[l + 1] ... OR nums[r])| 最小。

	请你返回 最小 的绝对差值。

	子数组 是数组中连续的 非空 元素序列。



	示例 1：

	输入：nums = [1,2,4,5], k = 3

	输出：0

	解释：

	子数组 nums[0..1] 的按位 OR 运算值为 3 ，得到最小差值 |3 - 3| = 0 。

	示例 2：

	输入：nums = [1,3,1,3], k = 2

	输出：1

	解释：

	子数组 nums[1..1] 的按位 OR 运算值为 3 ，得到最小差值 |3 - 2| = 1 。

	示例 3：

	输入：nums = [1], k = 10

	输出：9

	解释：

	只有一个子数组，按位 OR 运算值为 1 ，得到最小差值 |10 - 1| = 9 。
	 */

	public static int minimumDifference(int[] nums, int k) {
		int length = nums.length;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			int cur = nums[i];
			for (int j = i; j < length; j++) {
				cur = cur | nums[j];
				res = Math.min(res, Math.abs(cur - k));
			}
		}
		return res;
	}

	public static int maxUniqueSplit(String s) {
		Set<String> seen = new HashSet<>();  // Set to store unique substrings
		int[] res = {0};  // Array to store the maximum count of unique substrings

		// Call the backtracking function to find the maximum count
		backtrack(s, 0, seen, 0, res);

		return res[0];  // Return the final result

	}

	private static void backtrack(String s, int start, Set<String> seen, int count, int[] res) {
// Pruning: If the remaining characters plus current count can't exceed res, return
		if (count + (s.length() - start) <= res[0]) {
			return;
		}

		// Base case: If we've reached the end of the string
		if (start == s.length()) {
			res[0] = Math.max(res[0], count);  // Update res if necessary
			return;
		}

		// Try all possible substrings starting from 'start'
		for (int end = start + 1; end <= s.length(); ++end) {
			String substring = s.substring(start, end);  // Extract substring

			// If the substring is not in the set (i.e., it's unique)
			if (!seen.contains(substring)) {
				seen.add(substring);  // Add the substring to the set

				// Recursively call backtrack with updated parameters
				backtrack(s, end, seen, count + 1, res);

				seen.remove(substring);  // Remove the substring from the set (backtracking)
			}
		}
	}


	public static void main(String[] args) {
		int[] hours = {12, 12, 30, 24, 24};
		System.out.println(countCompleteDayPairs(hours));
	}

	public static long countCompleteDayPairs(int[] hours) {
		Long res = 0L;
		int length = hours.length;
		// 将所有数对24取模，结果保存在数组
		int[] idxArr = new int[25];
		for (int i = 0; i < length; i++) {
			idxArr[hours[i] % 24]++;
		}

		for (int i = 0; i < length; i++) {
			int mod = hours[i] % 24;
			int need;
			if (mod == 0){
				need = 0;
			}else {
				need = 24 - mod;
			}

			int needCnt = idxArr[need];
			if (mod == need){
				res += needCnt- 1;
			}else {
				res += needCnt;
			}
		}
		return res / 2;
	}
}
