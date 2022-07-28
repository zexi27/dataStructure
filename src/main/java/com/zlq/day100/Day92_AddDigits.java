package com.zlq.day100;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day92_AddDigits
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/3 12:08 下午
 */
/*
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。

示例 1:

输入: num = 38
输出: 2
解释: 各位相加的过程为：
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
由于 2 是一位数，所以返回 2。
示例 1:

输入: num = 0
输出: 0

提示：

0 <= num <= 231 - 1
 */
public class Day92_AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(199));
        System.out.println(198 % 9);
    }

    public static int addDigits(int num) {
        while (num > 9){
            int res = 0;
            while (num != 0) {
                res += num % 10;
                num = num / 10;
            }
            num = res;
        }
       return num;
    }
    // return (num-1) % 9 + 1

}
