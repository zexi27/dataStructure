package com.zlq.day170;


import java.util.Scanner;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day169_ScoreOfParentheses
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/9 21:15
 */
/*
给定一个平衡括号字符串S，按下述规则计算该字符串的分数：

() 得 1 分。
AB 得A + B分，其中 A 和 B 是平衡括号字符串。
(A) 得2 * A分，其中 A 是平衡括号字符串。

示例 1：

输入： "()"
输出： 1
示例 2：

输入： "(())"
输出： 2
示例3：

输入： "()()"
输出： 2
示例4：
((()))
输入： "(()(()))"
输出： 6
 */
public class Day169_ScoreOfParentheses {
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(scoreOfParentheses(s));
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a + b);

    }

    public static int scoreOfParentheses(String s) {
        int res = 0;
        int layers = 0;
        for (int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);
            if (ele == '(') {
                layers++;
            } else {
                layers--;
                if (s.charAt(i - 1) == '(') {
                    res += Math.pow(2, layers);
                }
            }
        }

        return res;
    }
}
