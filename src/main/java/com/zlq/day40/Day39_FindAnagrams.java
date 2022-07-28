package com.zlq.day40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day39_FindAnagrams
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/18 6:03 下午
 */
/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：
字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。

示例 1:
输入:
s: "cbaebabacd" p: "abc"
输出:
[0, 6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:
输入:
s: "abab" p: "ab"
输出:
[0, 1, 2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Day39_FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        for (Integer ele : result) {
            System.out.print(ele);
        }

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        int lp = p.length();
        int ls = s.length();
        char[] charsP = p.toCharArray();
        Arrays.sort(charsP);
        for (int i = 0; i <= ls - lp; i++) {
            char[] charTemp = s.substring(i, i + lp).toCharArray();
            Arrays.sort(charTemp);
            if (String.valueOf(charsP).equals(String.valueOf(charTemp))){
                resultList.add(i);
            }
        }
        return resultList;
    }

}
