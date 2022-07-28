package com.zlq.day30;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: LastLongestWord
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/21 2:52 下午
 */
/*
给你一个字符串 s，由若干单词组成，单词之间用空格隔开。
返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

示例 1：
输入：s = "Hello World" 输出：5

示例 2：
输入：s = " " 输出：0

特殊示例
"a "," a" ,"ab   " ,"    "," ","hello world   "
 */
public class LastLongestWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello woerd"));
    }

    public static int lengthOfLastWord(String s) {
         s = s.trim(); // 先去掉首位空格
        for (int i = s.length() - 1; i >= 0; i--) { // 从后往前遍历
            if (s.charAt(i) == ' ') return s.length() - 1 - i;  // 发现空格就返回坐标
            if (i == 0) return s.length(); // 遍历到头了没发现空格返回字符串的长度
        }
        return 0;
    }
}
