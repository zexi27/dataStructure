package com.zlq.day270;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/8/4 09:06
 */
/*
139. Word Break
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
 */
public class Day267_WordBreak {
    public static void main(String[] args) {
//        String s = "aaaaaaa";
//        List<String> wordDict = Arrays.asList("aaaa", "aaa");
////        String s =  "a";
////        List<String> wordDict = Arrays.asList("b");
//        System.out.println(wordBreak(s, wordDict));
       char[] s = {'h','e','l','l','o'};
       reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int l = 0, r = 0;
        int length = s.length();
        while (r < length) {
            boolean b = false;
            while (r < length) {
                r++;
                if (wordDict.contains(s.substring(l, r))) {
                    b = true;
                    break;
                }
            }
            if (b) l = r;
        }
        if (r == 0) return false;
        return l == r;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length];
        dp[0] = false;
        Set<String> wordSet = new HashSet<>();
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {  // 检查前面位置是否可以组成一个单词
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }



    public static void reverseString(char[] s) {
        int length = s.length;
        int l = 0, r = length - 1;
        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    public static void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
