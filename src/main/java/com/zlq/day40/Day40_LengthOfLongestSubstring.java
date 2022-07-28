package com.zlq.day40;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day40_LengthOfLongestSubstring
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/19 9:05 上午
 */
/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0

提示：
0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */
public class Day40_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "yfsrsrpzuya";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == "") return 0;
        if (s.length() == 1) return 1;
        int l = 0, r = 0;    // 左右指针,初始都为0
        int largestLength = 0;
        while (r < s.length() - 1) {
            r++;
            // 如果窗口内包含重复数 将左指针移到最左边重复数的右边一个位置上
            for (int i = l; i < r; i++) {
                if (s.charAt(i) == s.charAt(r)) {
                    l = i + 1;
                }
            }
            largestLength = Math.max(largestLength, r - l + 1);
        }
        return largestLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < length; j++) {
                char c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                    if (j == length - 1) {
                        maxLength = Math.max(j - i + 1, maxLength);
                    }
                } else {
                    maxLength = Math.max(j - i, maxLength);
                    break;
                }
            }
        }
        return maxLength;
    }


}

