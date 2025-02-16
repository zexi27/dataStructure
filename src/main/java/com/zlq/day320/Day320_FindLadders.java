package com.zlq.day320;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/2/16 20:47
 */
/*
面试题 17.22. 单词转换
中等
给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。

编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。

示例 1：

输入：
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出：
["hit","hot","dot","lot","log","cog"]
示例 2：

输入：
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出：[]

解释：endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class Day320_FindLadders {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log","cog"};

		List<String> wordList = new ArrayList<>();
		for (String word : words) {
			wordList.add(word);
		}
		Day320_FindLadders findLadders = new Day320_FindLadders();
		List<String> ladders = findLadders.findLadders(beginWord, endWord, wordList);
		System.out.println(ladders);

	}

	List<List<String>> allResult = new ArrayList<>();
	List<String> curResult = new ArrayList<>();

	public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = wordList.stream().collect(Collectors.toSet());
		Map<String, List<String>> relateMap = buildRelateMap(beginWord, wordSet);
		if (beginWord.equals(endWord) || !relateMap.containsKey(beginWord)) {
			return new ArrayList<>();
		}
		Set<String> memo = new HashSet<>();
		curResult.add(beginWord);
		memo.add(beginWord);
		backtrack(beginWord, endWord, relateMap, memo);
		if (!allResult.isEmpty()) {
			return allResult.get(0);
		}
		return new ArrayList<>();
	}

	private void backtrack(String curWord, String targetWord, Map<String, List<String>> relateMap, Set<String> memo) {
		if (curWord.equals(targetWord)) {
			allResult.add(new ArrayList(curResult));
		}

		List<String> relateList = relateMap.get(curWord);
		if (relateList.isEmpty()) {
			return;
		}


		for (String relateWord : relateList) {
			if (memo.contains(relateWord)) {
				continue;
			}
			curResult.add(relateWord);
			memo.add(relateWord);
			backtrack(relateWord, targetWord, relateMap, memo);
			curResult.remove(curResult.size() - 1);
			String removed = curResult.get(curResult.size() - 1);
			memo.remove(removed);
		}

	}

	private Map<String, List<String>> buildRelateMap(String beginWord, Set<String> wordSet) {
		if (!wordSet.contains(beginWord)) {
			wordSet.add(beginWord);
		}
		Map<String, List<String>> relateMap = new HashMap<>();
		for (String word1 : wordSet) {
			relateMap.putIfAbsent(word1, new ArrayList<>());
			for (String word2 : wordSet) {
				if (word1.equals(word2)) {
					continue;
				}
				// 需要仅仅差一个字符
				int diffCnt = 0;
				for (int i = 0; i < word2.length(); i++) {
					if (word2.charAt(i) != word1.charAt(i)) {
						diffCnt++;
					}
				}
				if (diffCnt == 1) {
					relateMap.get(word1).add(word2);
				}
			}
		}
		return relateMap;
	}


}
