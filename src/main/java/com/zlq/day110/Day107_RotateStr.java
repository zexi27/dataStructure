package com.zlq.day110;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: Day107_RotateStr
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/7 22:22
 */
/*
给定两个字符串, s和goal。如果在若干次旋转操作之后，s能变成goal，那么返回true。

s的 旋转操作 就是将s 最左边的字符移动到最右边。

例如, 若s = 'abcde'，在旋转一次之后结果就是'bcdea'。


示例 1:

输入: s = "abcde", goal = "cdeab"
输出: true
示例 2:

输入: s = "abcde", goal = "abced"
输出: false
 */
public class Day107_RotateStr {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }
    public static boolean rotateString(String s, String goal) {
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        for (int i = 0; i < length; i++) {
            builder.append(s.charAt(i));
            if (goal.equals(builder.substring(i + 1,builder.length()))) return true;
        }
        return false;
    }
}
