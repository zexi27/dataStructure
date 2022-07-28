package com.zlq.day30;

import java.util.stream.Stream;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day21_AbnormalJump
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/19 9:29 上午
 */
/*
变态跳台阶问题
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
f(n) = 2f(n - 1)
 */
public class Day21_AbnormalJump {
    public static void main(String[] args) {
        System.out.println(methodsCount(20));
        System.out.println(JumpFloorII(20));
        System.out.println(15 >> 2);
    }

    public static int methodsCount(int steps) {
        if (steps == 1) return 1;
        return 2 * methodsCount(steps - 1);
    }

    public static int JumpFloorII(int number) {
        int num = number - 1;
        return 1 << num;//2^(number-1)用位移操作进行，更快
    }
}
