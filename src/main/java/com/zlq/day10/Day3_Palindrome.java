package com.zlq.day10;


import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day10
 * @ClassName: Day3_Palindrome
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/24 9:19 上午
 */
/*
给定字符串，验证是否是回文串，只考虑子母和数字，可忽略字母的大小写
输入："A man, a plan ,a canal : Panama"
输出：true
输入： "race a car"
输出：false
 */
public class Day3_Palindrome {
    public static void main(String[] args) {
        String str = "A man, a plan ,a canal : Panama";
//        String str = "$%#!@#$^";
        System.out.println(palindrome(str));
    }

    public static boolean palindrome(String str) {
        if (str.length() == 0 || str == "")
            return true;

        //提取出所有字母和数字
        String newStr = str.replaceAll("[^a-zA-Z0-9]", "");
        //定义一个栈
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < newStr.length(); i++) {
            //将每个元素分别入栈
            stringStack.push(Character.toString(newStr.charAt(i)));
        }
        StringBuffer stringBuffer = new StringBuffer();
        //将每个元素分别出栈
        for (int i = 0; i < newStr.length(); i++) {
            stringBuffer.append(stringStack.pop());
        }
        if (stringBuffer.toString().equalsIgnoreCase(newStr))
            return true;
        return false;
    }
}
