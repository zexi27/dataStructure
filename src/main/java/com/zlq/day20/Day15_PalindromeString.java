package com.zlq.day20;

import java.util.HashSet;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day15_PalindromeString
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/8 9:35 上午
 */
/*
LeetCode:  给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如`"Aa"`不能当做一个回文字符串。
注意:假设字符串的长度不会超过 1010。

回文串：“回文串”是一个正读和反读都一样的字符串
比如“level”或者“noon”等等就是回文串
示例 1:
输入:
"abccccdd"
输出:
7
解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
```
 */
public class Day15_PalindromeString {
    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(longestPalindrome(str));
    }

    public static int longestPalindrome(String s) {
        HashSet<Character> stringSet = new HashSet<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stringSet.contains(c)) {
                length += 2;
                stringSet.remove(c);
            }else {
                stringSet.add(c);
            }
        }
        return stringSet.size() > 0 ?  length + 1: length;
    }
}

