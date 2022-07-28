package com.zlq.day20;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day18_StringToInteger
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/16 8:58 上午
 */
/*
剑指offer:  将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Day18_StringToInteger {
    public static void main(String[] args) {
        Day18_StringToInteger stringToInteger = new Day18_StringToInteger();
        System.out.println(stringToInteger.myValueOf("-1231204"));

    }

    public int myValueOf(String s) {
        boolean isMinus = false;
        if (s.charAt(0) == '-') {
            s = s.substring(1);
            isMinus = true;
        }
        int length = s.length();
        int res = 0;
        int[] nums = new int[length];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (((int) c > 57 || (int) c < 48) && s.charAt(i) != '-') {
                throw new NumberFormatException();
            }
            int a = c - '0';
            nums[i] = a;
            res += nums[i] * Math.pow(10, length - 1 - i);

        }
        if (isMinus)
            res = -res;
        return res;

//        [3,5,2]
//        return res;
    }
}
