package com.zlq.day110;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: CountNumbersWithUniqueDigits
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/11 18:34
 */
/*
给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n。

示例 1：

输入：n = 2
输出：91
解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
9000009
示例 2：

输入：n = 0
输出：1
 */
public class Day108_CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
//        System.out.println(countNumbersWithUniqueDigits(6));
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);
        int c = 100;
        int d = 100;
        System.out.println(c == d);
        Integer e = new Integer(100);
        Integer f = new Integer(100);
        System.out.println(e == f);
        Integer r = 127;
        Integer u = 127;
        System.out.println(r == u);

    }


    public static Set<Character> set = new HashSet<>();

    public static int countNumbersWithUniqueDigits(int n) {
        int res = 0;
        int range = (int) Math.pow(10, n);
        for (int i = 0; i < range; i++) {
            if (isUnique(i)) res++;
        }
        return res;
    }

    public static boolean isUnique(int num) {
        // 求出这个数向下取的10的次方 (如 820703 取 800000)
        int a = 10;
        while (num % a != num) {
            a *= 10;
        }
        int floor = num - num % (a/10);
        return false;
    }
}
