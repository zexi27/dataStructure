package com.zlq.day20;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.time.OffsetDateTime;
import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day16_LongestPalindrome
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/9 8:41 上午
 */
/*
Leetcode: LeetCode: 最长回文子串 给定一个字符串 s，找到 s 中最长的回文子串。
你可以假设 s 的最大长度为1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"

示例 3：
输入：s = "a"
输出："a"

示例 4：
输入：s = "ac"
输出："a"
"asasfsevdvesdjcxcjccjad"
 */
public class Day16_LongestPalindrome {
    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(longestPalindrome2(str));
    }

    public static boolean isPalindrome(String s) {
        boolean isPalindrome = true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }


    public static String longestPalindrome(String s) {
        int length = s.length();
        int start = 0;
        int maxLength = 0;
        if (length < 2) return s;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String str = s.substring(i, j + 1);
                if (maxLength < j - i + 1 && isPalindrome(str)) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static String longestPalindrome2(String s) {
        int longestLength = 1;
        int length = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            longestLength = Math.max(len1, len2);
            if (longestLength > end - start) {
                start = i - (longestLength - 1) / 2;
                end = i + longestLength / 2;
            }

        }
        return s.substring(start, end + 1);
    }

    public static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;

    }

}
