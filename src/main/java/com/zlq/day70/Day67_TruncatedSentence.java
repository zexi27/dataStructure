package com.zlq.day70;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day70
 * @ClassName: Day67_TruncatedSentence
 * @description:
 * @author: LiQun
 * @CreateDate:2021/12/6 9:50 上午
 */
/*
句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。

例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
给你一个句子 s 和一个整数 k ，请你将 s 截断 ，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。


示例 1：

输入：s = "Hello how are you Contestant", k = 4
输出："Hello how are you"
解释：
s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
前 4 个单词为 ["Hello", "how", "are", "you"]
因此，应当返回 "Hello how are you"
示例 2：

输入：s = "What is the solution to this problem", k = 4
输出："What is the solution"
解释：
s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
前 4 个单词为 ["What", "is", "the", "solution"]
因此，应当返回 "What is the solution"
示例 3：

输入：s = "chopper is not a tanuki", k = 5
输出："chopper is not a tanuki"
 */
public class Day67_TruncatedSentence {
    public static void main(String[] args) {
        String s = "hello";
        int k = 5;
        System.out.println(truncateSentence(s,k));
    }
    public static String truncateSentence(String s, int k) {
        int meetSpace = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') meetSpace ++;
            if (meetSpace == k){
                endIndex = i;
                break;
            }
            if (i == s.length() - 1 && meetSpace < k) endIndex = s.length();
        }
        s= s.substring(0,endIndex);
        return s;
    }
}
