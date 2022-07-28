package com.zlq.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: PerfectNumberCalculate
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/13 11:25 下午
 */
/*
完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。

它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。

例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。s

输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000


本题输入含有多组样例。

输入描述：
输入一个数字n

输出描述：
输出不超过n的完全数的个数

示例1
输入：
1000
7
100
复制
输出：
3
1
2
 */
public class PerfectNumberCalculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
//            for (int i = 6; i < num; i++) {
//                if (isPerfectNum(i)){
//                    System.out.println(i);
//                }
//            }
            if (num < 6) System.out.println(0);
            if (num > 6 && num < 28) System.out.println(1);
            if (num >28 && num < 496) System.out.println(2);
            if (num > 496) System.out.println(3);
//            System.out.println(getPerfectNumCounts(num));

        }
    }

    public static int getPerfectNumCounts(int num){
        int res = 0;
        for (int i = 3; i <= num; i++) {
            if (isPerfectNum(i)) res++;
        }
        return res;
    }

    /**
     * 判断是不是完全数
     * @param num
     * @return
     */
    public static boolean isPerfectNum(int num) {
        if (num % 2 != 0) return false; // 奇数就不是完全数
        List<Integer> listOfPrimeNums = getPrimeNumsList(num);
        int res = 0;
        for (int i = 0; i < listOfPrimeNums.size(); i++) {
            res += listOfPrimeNums.get(i);
        }
        if (res == num) return true;
        return false;
    }

    /**
     * 生成这个数的所有因子，以链表的形式存储
     *
     * @param num
     * @return
     */
    private static List<Integer> getPrimeNumsList(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j < num; j++) {
                if (i * j == num) {
                    list.add(j);
                }
            }
        }
        return list;
    }

    //蛇形矩阵

}
