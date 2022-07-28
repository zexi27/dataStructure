package com.zlq.day110;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: Day105_CountPrimeSetBits
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/6 23:04
 */
/*
给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。

计算置位位数 就是二进制表示中 1 的个数。

例如， 21 的二进制表示 10101 有 3 个计算置位。


示例 1：

输入：left = 6, right = 10
输出：4
解释：
6 -> 110 (2 个计算置位，2 是质数)
7 -> 111 (3 个计算置位，3 是质数)
9 -> 1001 (2 个计算置位，2 是质数)
10-> 1010 (2 个计算置位，2 是质数)
共计 4 个计算置位为质数的数字。
示例 2：

输入：left = 10, right = 15
输出：5
解释：
10 -> 1010 (2 个计算置位, 2 是质数)
11 -> 1011 (3 个计算置位, 3 是质数)
12 -> 1100 (2 个计算置位, 2 是质数)
13 -> 1101 (3 个计算置位, 3 是质数)
14 -> 1110 (3 个计算置位, 3 是质数)
15 -> 1111 (4 个计算置位, 4 不是质数)
共计 5 个计算置位为质数的数字。
 */
public class Day105_CountPrimeSetBits {
    public static void main(String[] args) {
    }

    static Set<Integer> set = new HashSet<>();
    static {
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        set.add(23);
        set.add(31);
    }
    public int countPrimeSetBits(int left, int right) {

        int res = 0;
        for (int i = left; i <= right; i++) {
            if (isPrimeNumber(countOfOneBits(i))) res++;
        }
        return res;
    }

    public boolean isPrimeNumber(int num) {

        if (set.contains(num)) return true;
        return false;
    }

    public int countOfOneBits(int num) {
        int res = 0;
        while (num > 0) {
            if (num % 2 == 1) res++;
            num /= 2;
        }
        return res;
    }
}
