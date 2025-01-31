package com.zlq.day320;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/1/4 13:19
 */
/*
1930. Unique Length-3 Palindromic Subsequences
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".


Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")

Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.
 */
public class Day314_CountPalindromicSubsequence {

	public static void main(String[] args) {
		String s = "bbcbaba";
		System.out.println(countPalindromicSubsequence(s));
	}

	// 时间复杂度：o(n3)
	public static int countPalindromicSubsequence(String s) {
		Set<String> palindromics = new HashSet<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char ci = s.charAt(i);
			for (int j = i + 2; j < length; j++) {
				char cj = s.charAt(j);
				if (ci != cj) {
					continue;
				}
				for (int k = i + 1; k < j; k++) {
					StringBuilder stringBuilder = new StringBuilder();
					String string = stringBuilder.append(ci).append(s.charAt(k)).append(cj).toString();
					if (!palindromics.contains(string)) {
						palindromics.add(string);
					}
				}
			}
		}
		System.out.println(palindromics);
		return palindromics.size();
	}

	public static int countPalindromicSubsequence2(String s) {
		// 获取每个字符最左和最右的位置
		int length = s.length();
		int[] leftPositionArr = new int[26];  // 每个字符最左的位置，数组的坐标索引表示字符，值表示位置
		int[] rightPositionArr = new int[26]; // 每个字符最右的位置，数组的坐标索引表示字符，值表示位置
		Arrays.fill(leftPositionArr, -1);
		Arrays.fill(rightPositionArr, -1);
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			int idx = c - 'a';
			if (leftPositionArr[idx] == -1) {
				leftPositionArr[idx] = i;
			}
			rightPositionArr[idx] = i;
		}

		Set<String> palindromics = new HashSet<>();

		// 从a~z遍历每个字符作为两侧字符，a~z在两个index中的坐标为0~25
		for (int charIdx = 0; charIdx < 26; charIdx++) {
			// 如果该字符的最左位置小于最右位置，那么这个字符
			if (leftPositionArr[charIdx] != -1 && rightPositionArr[charIdx] != -1
					&& leftPositionArr[charIdx] < rightPositionArr[charIdx]) {
				int l = leftPositionArr[charIdx];
				int r = rightPositionArr[charIdx];
				boolean[] seen = new boolean[26];
				// 遍历中间字符
				for (int i = l + 1; i < r; i++) {
					char midChar = s.charAt(i);
					if (!seen[midChar - 'a']){
						int twoSidesChar = (char) (charIdx + 'a');
						palindromics.add("" + twoSidesChar + midChar + twoSidesChar);
						seen[midChar - 'a'] = true;
					}
				}
			}
		}
		return palindromics.size();
	}

}
