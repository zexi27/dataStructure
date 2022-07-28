package com.zlq.day70;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day70
 * @ClassName: Day62_PowSolution
 * @description:
 * @author: LiQun
 * @CreateDate:2021/11/28 10:27 上午
 */
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。

示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class Day62_PowSolution {
    public static void main(String[] args) {
        double x = 2;
        int n = -2;
        System.out.println(myPow(x,n));
        System.out.println(myPow(34.00515 ,-3));
    }

    public static double myPow(double x, int n) {
        double res = x;

        if (n > 0) {
            for (int i = 0; i < n-1; i++) {
                res *= x;
            }
        } else if (n < 0) {
            for (int i = 0; i < Math.abs(n) - 1; i++) {
                res *= x;
            }
            res = 1 / res;
        } else {
            return 1;
        }
        return res;
    }
}
