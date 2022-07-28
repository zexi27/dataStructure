package com.zlq.day60;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day55_ClimbStairs
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/24 10:35 上午
 */
public class Day55_ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(5));
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        int[] dep = new int[2];
        dep[0] = 1;
        dep[1] = 2;
        int result;
        for (int i = 3; i <= n; i++) {
            result = dep[0] + dep[1];
            dep[0] = dep[1];
            dep[1] = result;
        }
        return dep[1];
    }
}
