package com.zlq.Day300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/12 20:29
 */
/*
设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。

实现 MagicDictionary 类：

MagicDictionary() 初始化对象
void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。


示例：

输入
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
输出
[null, null, false, true, false, false]

解释
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // 返回 False
magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
magicDictionary.search("hell"); // 返回 False
magicDictionary.search("leetcoded"); // 返回 False
 */
public class Day294_MagicDictionary {

	public static void main(String[] args) {
		String[] actions = {"MagicDictionary", "buildDict", "search", "search", "search", "search", "search", "search",
				"search", "search", "search", "search", "search", "search", "search", "search", "search"};
		String[][] params = {{},
				{"a", "b", "ab", "abc", "abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj", "abcdefghijawefe",
						"aefawoifjowajfowafjeoawjfaow", "cba", "cas", "aaewfawi", "babcda", "bcd", "awefj"}, {"a"},
				{"b"}, {"c"}, {"d"}, {"e"}, {"f"}, {"ab"}, {"ba"}, {"abc"}, {"cba"}, {"abb"}, {"bb"}, {"aa"}, {"bbc"},
				{"abcd"}};
		execute(actions,params);
	}

	static Day294_MagicDictionary magicDictionary = null;
	static String[] dictArr; //key-长度 value-对应长度的字符串集合

	public Day294_MagicDictionary() {
	}

	public void buildDict(String[] dictionary) {
		this.dictArr = dictionary;
	}

	public boolean search(String searchWord) {

		for (String string : dictArr) {
			if (searchWord.length() != string.length()){
				continue;
			}

			int diffCnt = 0;
			for (int i = 0; i < searchWord.length(); i++) {
				if (searchWord.charAt(i) != string.charAt(i)) {
					diffCnt++;
				}
				if (diffCnt > 1) {
					break;
				}
			}
			if (diffCnt == 1){
				return true;
			}
		}
		return false;
	}


	/*
	["MagicDictionary", "buildDict", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search", "search"]
[[], [["a","b","ab","abc","abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj","abcdefghijawefe","aefawoifjowajfowafjeoawjfaow","cba","cas","aaewfawi","babcda","bcd","awefj"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["ab"], ["ba"], ["abc"], ["cba"], ["abb"], ["bb"], ["aa"], ["bbc"], ["abcd"]]

	 */
	public static void execute(String[] actions, String[][] params) {
		for (int i = 0; i < actions.length; i++) {
			doExecute(actions[i], params[i]);
		}
	}

	public static void doExecute(String action, String[] param) {

		if (action.equals("MagicDictionary")) {
			magicDictionary = new Day294_MagicDictionary();
		} else if (action.equals("buildDict")) {
			magicDictionary.buildDict(param);
		} else {
			System.out.println(magicDictionary.search(param[0]));
		}
	}


	public boolean isArraySpecial(int[] nums) {
		int length = nums.length;
		if (length == 1) return true;
		for (int i = 0; i < length - 1; i++) {
			int cur = nums[i];
			int next = nums[i + 1];
			if ((cur % 2 == next % 2)){
				return false;
			}
		}
		return true;
	}

}
