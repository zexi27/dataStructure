package com.zlq.day160;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day160
 * @ClassName: Day156_ValidateStackSequences
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/31 10:58
 */
/*
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
[1,2,3,4,5]
[4,5,3,2,1]
[2,3,1,5,4]
-------------
[1,2,3,4,5]
[3,2,5,4,1]
 */
public class Day156_ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed = {1, 3, 2, 0};
        int[] popped = {1, 2, 0, 3};
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (pushed[index] != popped[0]) {
            stack.push(pushed[index++]);
        }
        stack.push(pushed[index++]);
        stack.pop();
        for (int i = 1; i < popped.length; i++) {
            int ele = popped[i];
            if (!stack.isEmpty() && ele == stack.peek()) {
                stack.pop();
            } else {
                if (stack.contains(ele)) {  // 不在栈顶
                    return false;
                } else {
                    while (pushed[index] != ele) {
                        stack.push(pushed[index++]);
                    }
                    stack.push(pushed[index++]);
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            d.addLast(pushed[i]);
            while (!d.isEmpty() && d.peekLast() == popped[j] && ++j >= 0) d.pollLast();
        }
        return d.isEmpty();
    }

}
