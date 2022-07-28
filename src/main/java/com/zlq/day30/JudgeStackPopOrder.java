package com.zlq.day30;

import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: JudgeStackPopOrder
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/19 9:49 上午
 */
/*
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
 */
public class JudgeStackPopOrder {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(isStackPopOrder(arr1, arr2));
    }

    public static boolean isStackPopOrder(int[] push, int[] pop) {
        int pushLength = push.length;
        int popLength = pop.length;
        if (pushLength != popLength) return false;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushLength; i++) {
            stack.push(push[i]);
            if (stack.peek() != pop[popLength - i - 1]) return false;
        }
        return true;
    }
}
