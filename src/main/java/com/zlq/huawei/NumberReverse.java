package com.zlq.huawei;

import java.util.Scanner;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: Number
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/12 10:09 下午
 */
/*
描述
输入一个整数，将这个整数以字符串的形式逆序输出
程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001

数据范围：
输入描述：
输入一个int整数

输出描述：
将这个整数以字符串的形式逆序输出

示例1
输入：
1516000
复制
输出：
0006151
复制
示例2
输入：
0
复制
输出：
0
 */
public class NumberReverse{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = String.valueOf(num);
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        System.out.println(builder);
    }


}
