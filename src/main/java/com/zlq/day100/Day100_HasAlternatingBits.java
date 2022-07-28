package com.zlq.day100;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day100_HasAlternatingBirs
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/28 12:44 下午
 */
/*
题目描述
评论 (395)
题解 (476)
提交记录
693. 交替位二进制数
给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。

示例 1：

输入：n = 5
输出：true
解释：5 的二进制表示是：101
示例 2：

输入：n = 7
输出：false
解释：7 的二进制表示是：111.
示例 3：

输入：n = 11
输出：false
解释：11 的二进制表示是：1011.

 */
public class Day100_HasAlternatingBits {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits1(11));
    }

    public static boolean hasAlternatingBits(int n) {
        StringBuilder bitString = new StringBuilder();
        while (n != 0) {
            bitString.append(n % 2);
            n /= 2;
        }
        System.out.println(bitString);
        for (int i = 1; i < bitString.length(); i++) {
            if (bitString.charAt(i) == bitString.charAt(i - 1)) return false;
        }
        return true;
    }

    public static boolean hasAlternatingBits1(int n) {
        Integer lastMod = null;
        Integer curMod = null;
        while (n != 0) {
            lastMod = curMod;
            curMod = n % 2;
            if (lastMod == curMod) return false;
            n /= 2;
            System.out.println(lastMod);
            System.out.println(curMod);
            System.out.println("=========");
        }
        return true;
    }
}
