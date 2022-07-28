package com.zlq.day30;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day25_LatestTime
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/24 8:25 下午
 */
/*
给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。

替换  time 中隐藏的数字，返回你可以得到的最晚有效时间。


示例 1：

输入：time = "2?:?0"
输出："23:50"
解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
示例 2：

输入：time = "0?:3?"
输出："09:39"
示例 3：

输入：time = "1?:22"
输出："19:22"

提示：
time 的格式为 hh:mm
题目数据保证你可以由输入的字符串生成有效的时间
 */
public class Day25_LatestTime {
    public static void main(String[] args) {
        String time = "??:3?";
        String s = maximumTime(time);
        System.out.println(s);
        System.out.println( System.getProperty("user.dir") + "/mybatis_generator/src/main/resources/com.zlq.mapper/");

    }

    public static String maximumTime(String time) {
        char[] charArray = time.toCharArray();
        char c1 = charArray[0];
        char c2 = charArray[1];
        char c3 = charArray[3];
        char c4 = charArray[4];
        if (c1 == '?' && c2 == '?') {
            charArray[0] = '2';
            charArray[1] = '3';
        } else {
            if (c1 == '?') charArray[0] = charArray[1] >= '4' ? '1' : '2';
            if (c2 == '?') charArray[1] = ((charArray[0] != '2') ? '9' : '3');
        }
        if (c3 == '?') charArray[3] = '5';
        if (c4 == '?') charArray[4] = '9';
        return String.valueOf(charArray);
    }
}
