package com.zlq.day280;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/11 11:38
 */

/*
1190. Reverse Substrings Between Each Pair of Parentheses
Medium
You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.



Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.


Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.
 */
public class Day274_ReverseParentheses {


	public static void main(String[] args) {
		String s = "(ed(et(oc))el)";
		System.out.println(reverseParentheses(s));
	}

	public static String reverseParentheses(String s) {
		Stack<StringBuilder> stack = new Stack<>();
		stack.push(new StringBuilder());

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(new StringBuilder());
			} else if (c == ')') {
				StringBuilder top = stack.pop().reverse();
				stack.peek().append(top);
			} else {
				stack.peek().append(c);
			}
		}

		return stack.pop().toString();
	}


	public static int[] numberGame(int[] nums) {
		Arrays.sort(nums);

		int length = nums.length;
		int[] resArr = new int[length];
		int idx = 0;
		while (idx < length) {
			resArr[idx] = nums[idx + 1];
			resArr[idx + 1] = nums[idx];

			idx += 2;
		}
		return resArr;
	}


}
