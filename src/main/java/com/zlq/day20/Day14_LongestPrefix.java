package com.zlq.day20;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day14_LongestPrefix
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/7 9:27 上午
 */
/*
> Leetcode:  编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"
示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 */
public class Day14_LongestPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestPrefix(strs));
        System.out.println(Arrays.toString(strs));
    }


    // 核心思想，排序，无论字符串数组有多少个字符串元素
    // ，如果排序后第一个元素的第一个字符和最后一个元素第一个字符相等，
    // 就说明所有元素第一个字符相等！
     public static String longestPrefix(String[] strs) {

        // 如果检查值不合法及就返回空串
        if (!check(strs)) {
            return "";
        }
        // 数组长度
        int len = strs.length;
        // 用于保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;

        }
        return res.toString();

    }

    // 检查字符串数组中的字符串是否合法
    public static boolean check(String[] strs) {
        for (String str : strs) {
            if (str == null || str.length() == 0)
                return false;
        }
        return true;
    }
}
