package com.zlq.day250;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day248_PowerfulIntegers
 * @description:
 * @author: LiQun
 * @CreateDate:2023/5/2 22:32
 */
/*
970. Powerful Integers
中等
87
相关企业
Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.

An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.

You may return the answer in any order. In your answer, each value should occur at most once.

Example 1:

Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation:
2 = 20 + 30
3 = 21 + 30
4 = 20 + 31
5 = 21 + 31
7 = 22 + 31
9 = 23 + 30
10 = 20 + 32
Example 2:

Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]
Constraints:

1 <= x, y <= 100
0 <= bound <= 106
 */
public class Day248_PowerfulIntegers {
    public static void main(String[] args) {
        int x = 2, y = 1, bound = 10;
        System.out.println(powerfulIntegers(x, y, bound));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> resList = new ArrayList<>();
        int curNum = 0;
        int power1 = 0;
        int power2 = 0;
        while (true) {
            while (true) {
                curNum = (int) (Math.pow(x, power1) + Math.pow(y, power2));
                if (curNum > bound) break;
                if (!resList.contains(curNum)) resList.add(curNum);
                if (y == 1) break;
                power2++;
            }
            power1++;
            power2 = 0;
            if (Math.pow(x, power1) > bound || x == 1) break;
        }
        return resList;
    }
}
