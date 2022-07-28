package com.zlq.day130;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day126_ReverseString
 * @description:
 * @author: LiQun
 * @CreateDate:2022/6/11 12:56
 */
/*
如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。

给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。

返回使 s 单调递增的最小翻转次数。

示例 1：

输入：s = "00110"
输出：1
解释：翻转最后一位得到 00111.
示例 2：

输入：s = "010110"
输出：2
解释：翻转得到 011111，或者是 000111。
示例 3：

输入：s = "00011000"
输出：2
解释：翻转得到 00000000。
 */
/*
两种情况：
1. 碰到1了后面就不能有0
2. 要么就所有都是0
 */
public class Day126_ReverseString {
    public static void main(String[] args) {
        String s = "10011111110010111011";

        System.out.println(minFlipsMonoIncr(s));
    }

    public static int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = n;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + (cs[i - 1] - '0');
        for (int i = 1; i <= n; i++) {
            int l = sum[i - 1], r = (n - i) - (sum[n] - sum[i]);
            ans = Math.min(ans, l + r);
        }
        return ans;
    }

}
