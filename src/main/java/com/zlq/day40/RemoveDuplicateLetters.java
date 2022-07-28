package com.zlq.day40;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: RemoveDumplicateLetters
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/11 9:43 上午
 */
/*
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

示例 1：
输入：s = "bcabc"
输出："abc"
示例 2：
输入：s = "cbacdacbc"
输出："acdb"
提示：
1 <= s.length <= 104
s 由小写英文字母组成
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdacbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        // 遇到一个新字符，如果比栈顶小，而且新字符后面还有和栈顶一样的，就把栈顶元素踢掉,否则就入栈
        int length = s.length() - 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (stack.contains(c)) continue;
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1)
                stack.pop();
            stack.push(c);
        }
        char chars[]=new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }
}
