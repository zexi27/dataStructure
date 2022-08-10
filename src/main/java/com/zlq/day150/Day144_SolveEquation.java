package com.zlq.day150;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day150
 * @ClassName: Day144_SolveEquation
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/10 10:05
 */
/*
求解一个给定的方程，将x以字符串 "x=#value"的形式返回。该方程仅包含 '+' ， '-' 操作，变量x和其对应系数。
如果方程没有解，请返回"No solution"。如果方程有无限解，则返回 “Infinite solutions” 。
题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。

示例 1：

输入: equation = "x+5-3+x=6+x-2"
输出: "x=2"
示例 2:

输入: equation = "x=x"
输出: "Infinite solutions"
示例 3:

输入: equation = "2x=x"
输出: "x=0"
 */
public class Day144_SolveEquation {
    public static void main(String[] args) {
        String equation = "x + 7=x";
        System.out.println(solveEquation(equation));
    }

    /*
    x + 5 - 3 + x = 6 + x - 2 =>  x + 2 + x = 4 + x  => 2x + 2 = 4 + x => x + 2 = 4 => x = 2
    2x = x =>

     */
    public static String solveEquation(String equation) {
        int length = equation.length();
        List<String> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        int sumNum = 0;
        int sumX = 0;
        boolean isLeft = true;
        equation = new StringBuilder().append(equation).append("+").toString();
        while (r < length) {
            while (!(equation.charAt(r) == '+' || equation.charAt(r) == '-' || equation.charAt(r) == '=')) {
                r++;
            }
            String subStr = equation.substring(l, r);
            l = r;
            r = l + 1;
            list.add(subStr);
        }
        list.add(equation.substring(l));
         System.out.println(list);
        int size = list.size();
        for (int i = 0; i < size -1 ; i++) {
            String s = list.get(i);
            if (s.length() == 0) continue;
            if (s.contains("=")) {
                s = s.substring(1);
                isLeft = false;
                if (s.length() == 0) continue;
            }
            if (isLeft) {
                if (s.contains("x")) {
                    s = s.substring(0, s.length() - 1);
                    if (s.length() == 0 || s.equals("+")) sumX += 1;
                    else if (s.equals("-")) sumX -= 1;
                    else {
                        sumX += Integer.valueOf(s);
                    }
                } else {
                    sumNum -= Integer.valueOf(s);
                }
            } else {
                if (s.contains("x")) {
                    s = s.substring(0, s.length() - 1);
                    if (s.length() == 0 || s.equals("+")) sumX -= 1;
                    else if (s.equals("-")) sumX += 1;
                    else {
                        sumX -= Integer.valueOf(s);
                    }

                } else {
                    sumNum += Integer.valueOf(s);
                }
            }
        }
        System.out.println(sumNum);
        System.out.println(sumX);
        if (sumX == 0 && sumNum == 0) return "Infinite solutions";
        else if (sumX == 0 && sumNum != 0) return "No solution";
        return "x=" + sumNum / sumX;
    }
}
