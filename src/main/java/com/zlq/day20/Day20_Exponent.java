package com.zlq.day20;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day20_Exponent
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/17 9:12 上午
 */
/*
#### **题目描述：**

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

#### **问题解析：**

这道题算是比较麻烦和难一点的一个了。我这里采用的是**二分幂**思想，当然也可以采用**快速幂**。
更具剑指offer书中细节，该题的解题思路如下：
1.当底数为0且指数<0时，会出现对0求倒数的情况，需进行错误处理，设置一个全局变量；
2.判断底数是否等于0，由于base为double型，所以不能直接用==判断
3.优化求幂函数（二分幂）。
当n为偶数，a^n =（a^n/2）*（a^n/2）；
当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a。时间复杂度O(logn)
 */
public class Day20_Exponent {
    public static void main(String[] args) {
        System.out.println(solution(4, 0));
    }

    public static double solution(double base, int exponent) {
        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            if (exponent >= 0) res *= base;
            else res = 1 / res;
        }
        return res;
    }
}
