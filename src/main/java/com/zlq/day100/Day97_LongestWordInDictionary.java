package com.zlq.day100;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day97_LongestWordInDictionary
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/17 8:12 下午
 */
/*
给出一个字符串数组words 组成的一本英语词典。返回words 中最长的一个单词，
该单词是由 words词典中其他单词逐步添加一个字母组成。

若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。

示例 1：

输入：words = ["w","wo","wor","worl", "world"]
输出："world"
解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
示例 2：

输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出："apple"
解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 */
public class Day97_LongestWordInDictionary {
    public static void main(String[] args) {
        String[] words = {"t", "ti", "tig", "tige", "tiger", "e", "en", "eng", "engl", "engli", "englis", "english", "h", "hi", "his", "hist", "histo", "histor", "history"};
        System.out.println(longestWord(words));
//        System.out.println(isSmaller("fcmz", "yodn"));

        System.out.println(isSmaller("history", "english"));
    }

    public static String longestWord(String[] words) {
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        System.out.println(set);
        Iterator<String> iterator = set.iterator();
        String lastStr = "";
        String curStr = "";
        String curLongestWord = "";
        String longestWord = "";
        while (iterator.hasNext()) {
            lastStr = curStr;
            curStr = iterator.next();
            if (lastStr != null && lastStr.length() < curStr.length()) {
                String substring = curStr.substring(0, lastStr.length());
                if (substring.equals(lastStr)) {
                    curLongestWord = curStr;
                }
            }
            if (curStr.length() < lastStr.length()) {
                if (curLongestWord.length() > longestWord.length() || curLongestWord.length() == longestWord.length() && curLongestWord.compareTo(longestWord) > 0)
                    longestWord = curLongestWord;
            }

            if (!iterator.hasNext()) {
                if (curLongestWord.length() > longestWord.length() || curLongestWord.length() == longestWord.length() && curLongestWord.compareTo(longestWord) > 0)
                    longestWord = curLongestWord;
            }
        }
        return longestWord == "" ? curLongestWord : longestWord;
    }

    public static boolean isSmaller(String s1, String s2) {
        int length = s1.length();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < length; i++) {
            count1 += s1.charAt(i);
            count2 += s2.charAt(i);
        }
        return count1 < count2;
    }
}
