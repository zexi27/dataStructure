package com.zlq.day80;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: Day75_LastRemaining
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/2 11:23 上午
 */
/*
列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：

从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
给你整数 n ，返回 arr 最后剩下的数字。

示例 1：

输入：n = 9
输出：6
解释：
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr = [2, 4, 6, 8]
arr = [2, 6]
arr = [6]

示例 2：

输入：n = 1
输出：1
 */
public class Day75_LastRemaining {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(lastRemaining(n));
    }

    public static int lastRemaining(int n) {
        int first = 1;
        int step = 1;
        int remain = n;
        boolean isLeft = true;
        while (remain > 1) {
            if (isLeft || ((remain & 1) == 1)) {
                first += step;
            }
            isLeft = !isLeft;
            step <<= 1;
            remain >>= 1;
        }
        return first;
    }

    public static int lastRemaining2(int n) {
        List<Integer> list = new ArrayList<>();  // set中记录已删除的角标index
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) list.add(i);
        }
        int count = 1;
        n /=2;
        while (list.size() > 1) {
            if (count % 2 == 0) { // 偶数次，从左往右删
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) list.remove(new Integer(i));
                }
            } else {  // 奇数次，从右往左删
                for (int i = n - 1; i >=0; i--) {
                    if ((n - i)% 2 ==1) list.remove(new Integer(i));

                }
            }
            n /=2;
        }
        return list.get(0);
    }

    public static int lastRemaining3(int n) {
        List<Integer> list = new ArrayList<>();  // set中记录已删除的角标index
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            list.add(n);
        }
        for (int i = 0; i < n; i++) {
            if (n % 2 == 0) set.add(n);  // 第一轮删的必然是奇数，必然是偶数角标
            list.remove(new Integer(i));
        }
        while (set.size() > (n - 1)) {   // 逐渐往里添加角标（必然是奇数角标）
            for (int i = 0; i < n; i++) {
                // 寻找set中不存在的数
                int count = 0;  // 偶数次寻找到的才放到set
                if (!set.contains(i)) {
                    count++;
                    if (count % 2 == 0) set.add(i);
                }
            }
        }
        return 0;
    }

}
