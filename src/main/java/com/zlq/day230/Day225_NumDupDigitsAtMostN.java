package com.zlq.day230;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day230
 * @ClassName: Day225_NumDupDigitsAtMostN
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/21 10:12
 */
/*
给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。

示例 1：

输入：n = 20
输出：1
解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
示例 2：

输入：n = 100
输出：10
解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
示例 3：

输入：n = 1000
输出：262

提示：

1 <= n <= 109
 */
public class Day225_NumDupDigitsAtMostN {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(numDupDigitsAtMostN(20));
    }
    static Set<Character> set = new HashSet<>();

    public static int numDupDigitsAtMostN(int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isNumDup(i)) cnt++;
        }
        return cnt;
    }

    public static boolean isNumDup(int num) {
        String s = String.valueOf(num);
        set.clear();
        for (int i = 0; i <= s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) return true;
            else set.add(c);
        }
        return false;
    }
}
