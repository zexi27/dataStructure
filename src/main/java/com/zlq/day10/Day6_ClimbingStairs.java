package com.zlq.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day10
 * @ClassName: Day6_ClimbingStairs
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/27 8:46 上午
 */
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的⽅法可以爬到楼顶呢？
注意：给定 n 是⼀个正整数。
示例 1：
输⼊： 2
输出： 2
解释： 有两种⽅法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：
输⼊： 3
输出： 3
解释： 有三种⽅法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 */
public class Day6_ClimbingStairs {
    public static void main(String[] args) {
        int stairs = 45;
//        System.out.println(climbingStairs1(stairs));
        System.out.println(recursivePractice2(2, 4));
    }

    //求x的n次方
    public static int recursivePractice1(int x, int n) {
        int result = 1;
        if (n == 0) {
            result = 1;
        }
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }

    //方法2：递归
    public static int recursivePractice2(int x, int n) {
        if (n == 0) {
            int result = 1;
            return result;
        }
        /*
        举例：rec(2,3) = rec(2,2) * 2 = rec(2,1) * 2 * 2 = rec(2,0) * 2 * 2 * 2 = 1 * 2 * 2 * 2 = 2³ = 8
         */
        return recursivePractice2(x, n - 1) * x;
    }

    public static int recursivePractice3(int x, int n) {
        if (n == 0) {
            int result = 1;
            return result;
        }
        if (n % 2 == 1) {

            return recursivePractice3(x, n / 2) * recursivePractice3(x, n / 2) * x;
        }
        /*
        rec(2,4) = rec(2,2) * rec(2,2) = rec(2,1) * rec(2,1) * rec(2,1) * rec(2,1) =
        rec(2,0)*rec(2,0)*2 *  rec(2,0)*rec(2,0)*2 * rec(2,0)*rec(2,0) * 2 *  rec(2,0)*rec(2,0)*2  = 16
         */
        return recursivePractice3(x, n / 2) * recursivePractice3(x, n / 2);
    }

    public static int recursivePractice4(int x, int n) {
        if (n == 0) {
            int result = 1;
            return result;
        }
        int t = recursivePractice4(x, n / 2);
        if (n % 2 == 1) {

            return t * t * x;
        }

        return t * t;
    }

    //解法1：常规递归，
    public static int climbingStairs1(int stairs) {
        if (stairs == 0 || stairs == 1 || stairs == 2) {
            return stairs;
        }
        /*
        f(5) = f(3) + f(4) = f(1) + f(2) + f(2) + f(3) + 1 + 2 + 2 + f(1) + f(2) = 8
         */
        return climbingStairs1(stairs - 2) + climbingStairs1(stairs - 1);
    }


    public static int climbingStairs2(int stairs) {
        if (stairs == 0 || stairs == 1 || stairs == 2) {
            return stairs;
        }
        Map<Integer,Integer> map = new HashMap();
        int result = climbingStairs1(stairs - 2) + climbingStairs1(stairs - 1);
        map.put(stairs,result);
        if (map.containsKey(stairs)){
            return map.get(stairs);
        }
        return result;
    }

}
