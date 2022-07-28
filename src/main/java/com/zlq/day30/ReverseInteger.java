package com.zlq.day30;

import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: ReverseInteger
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/2 11:56 下午
 */
/*
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。

示例 1：
输入：x = 123
输出：321
示例 2：
输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0


 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        if (x <= Integer.MIN_VALUE) return 0;
        StringBuilder builder = new StringBuilder();
        String s = String.valueOf(Math.abs(x));
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
        }
        for (int i = 0; i < s.length(); i++) {
            builder.append(stack.pop());
        }

        Long result = Long.valueOf(String.valueOf(builder));
        if (result > Integer.MAX_VALUE) return 0;
        return x > 0 ?Math.toIntExact(result) : -Math.toIntExact(result);
    }
}
