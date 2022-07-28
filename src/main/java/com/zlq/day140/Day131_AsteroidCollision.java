package com.zlq.day140;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day140
 * @ClassName: Day131_AsteriodCollision
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/16 11:39
 */
/*
给定一个整数数组 asteroids，表示在同一行的行星。

对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
每一颗行星以相同的速度移动。

找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。
如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

示例 1：

输入：asteroids = [5,10,-5]
输出：[5,10]
解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
示例 2：

输入：asteroids = [8,-8]
输出：[]
解释：8 和 -8 碰撞后，两者都发生爆炸。
示例 3：

输入：asteroids = [10,2,-5]
输出：[10]
解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 */
public class Day131_AsteroidCollision {
    // {3,-7,9,-2,-1,-8,12,-11}  => {-7,9,12}
    public static void main(String[] args) {
        int[] asteroids = {-2, 2, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        while (!checkValidAsteroid(asteroids)) {
            asteroids = collision(asteroids);
        }
        return asteroids;
    }

    public static boolean checkValidAsteroid(int[] asteroids) {
        int length = asteroids.length;
        if (length == 0 || length == 1) return true;
        for (int i = 0; i < length - 1; i++) {
            if (asteroids[i] > 0 && asteroids[i + 1] < 0) return false;
        }
        return true;
    }

    public static int[] collision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int ele = asteroids[i];
            if (stack.size() == 0) {
                stack.push(ele);
                continue;
            }
            Integer peek = stack.peek();
            if (peek > 0 && ele < 0) {  // 如果前一个行星向右，此行星向左，就会碰撞
                if (Math.abs(peek) > Math.abs(ele)) continue;  // 向右的行星比向左的大，不用添加
                else if (Math.abs(peek) == Math.abs(ele)) { // 向右的行星和向左的相等，直接碰撞抵消
                    stack.pop();
                    continue;
                } else {
                    stack.pop();
                    stack.push(ele);
                }
            } else {
                stack.push(ele);
            }
        }
        int size = stack.size();
        int[] resArr = new int[size];
        while (!stack.isEmpty()) resArr[--size] = stack.pop();
        return resArr;
    }

    public int[] asteroidCollision1(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int ele : asteroids) {
            boolean isTrue = true;
            while (isTrue && !deque.isEmpty() && deque.peekLast() > 0 && ele < 0) {
                int a = deque.peekLast(), b = -ele;
                if (a <= b) deque.pollLast();
                if (a >= b) isTrue = false;
            }
            if (isTrue) deque.addLast(ele);
        }
        int sz = deque.size();
        int[] ans = new int[sz];
        while (!deque.isEmpty()) ans[--sz] = deque.pollLast();
        return ans;
    }
}
