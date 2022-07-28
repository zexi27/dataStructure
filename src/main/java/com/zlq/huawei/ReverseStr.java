package com.zlq.huawei;

import java.util.Scanner;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: ReverseStr
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/12 10:19 下午
 */
/*
描述
接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）

输入描述：
输入一行，为一个只包含小写字母的字符串。

输出描述：
输出该字符串反转后的字符串。

示例1
输入：
abcd
复制
输出：
dcba
 */
public class ReverseStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(reverseStr(str));
    }
    public static String reverseStr(String s){
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
