package com.zlq.Day290;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/5/15 14:26
 */

/*
17. 电话号码的字母组合
中等
相关标签
相关企业
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]


提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Day285_LetterCombinations {

	static Map<Character, List<String>> phoneMap = new HashMap<Character, List<String>>() {
		{
			put('2', Arrays.asList("a", "b", "c"));
			put('3', Arrays.asList("d", "e", "f"));
			put('4', Arrays.asList("g", "h", "i"));
			put('5', Arrays.asList("j", "k", "l"));
			put('6', Arrays.asList("m", "n", "o"));
			put('7', Arrays.asList("p", "q", "r", "s"));
			put('8', Arrays.asList("t", "u", "v"));
			put('9', Arrays.asList("w", "x", "y", "z"));
		}
	};

	public static void main(String[] args) {
		String digits = "3456";
		System.out.println(letterCombinations(digits));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<>();
		int length = digits.length();
		if (length == 0 || null == digits) {
			return combinations;
		}

		StringBuilder builder = new StringBuilder();
		backtrack(combinations, phoneMap, digits, 0, builder);
		return combinations;
	}

	private static void backtrack(List<String> combinations, Map<Character, List<String>> phoneMap, String digits,
			int index, StringBuilder builder) {
		if (index == digits.length()) {
			combinations.add(builder.toString());
		} else {
			char digitChar = digits.charAt(index);
			List<String> letterList = phoneMap.get(digitChar);
			for (int i = 0; i < letterList.size(); i++) {
				String letter = letterList.get(i);
				builder.append(letter);
				backtrack(combinations, phoneMap, digits, index + 1, builder);
				builder.deleteCharAt(index); // 撤销上一次的选择，比如你按了23键，设定了ad组合，但是还要继续选择ae、af、ag，因此将ad中的d去掉，继续append别的字母
			}
		}
	}


	/*
	给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
	示例 1：
	输入：nums = [1,2,3]
	输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	示例 2：

	输入：nums = [0,1]
	输出：[[0,1],[1,0]]
	示例 3：

	输入：nums = [1]
	输出：[[1]]
	 */
	public static List<List<Integer>> permute(int[] nums) {
		int index = 0;
		List<List<Integer>> combinations = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

		}

		return null;
	}
}
