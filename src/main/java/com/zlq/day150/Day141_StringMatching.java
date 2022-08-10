package com.zlq.day150;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day150
 * @ClassName: Day141_StringMatching
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/6 10:19
 */
/*
给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。
请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。

如果你可以删除 words[j]最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。

示例 1：

输入：words = ["mass","as","hero","superhero"]
输出：["as","hero"]
解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
["hero","as"] 也是有效的答案。
示例 2：

输入：words = ["leetcode","et","code"]
输出：["et","code"]
解释："et" 和 "code" 都是 "leetcode" 的子字符串。
示例 3：

输入：words = ["blue","green","bu"]
输出：[]
 */
public class Day141_StringMatching {
    public static void main(String[] args) {
        String[] words = {"leetcode", "et", "code"};
        System.out.println(stringMatching(words));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> resList = new ArrayList<>();
        List<String> stringList = Arrays.asList(words);
        stringList.sort((o1, o2) -> o1.length() - o2.length());
        int size = stringList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j <= size - 1; j++) {
                if (words[j].contains(words[i])) {
                    if (!resList.contains(words[i])) resList.add(words[i]);
                }
            }
        }
        return resList;
    }

    public static List<String> stringMatching1(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
