package com.zlq.day260;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day260
 * @ClassName: Day252_SmallestRepunitDivByK
 * @description:
 * @author: LiQun
 * @CreateDate:2023/5/10 23:06
 */
/*
1015. Smallest Integer Divisible by K
中等
Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.

Return the length of n. If there is no such n, return -1.

Note: n may not fit in a 64-bit signed integer.



Example 1:

Input: k = 1
Output: 1
Explanation: The smallest answer is n = 1, which has length 1.
Example 2:

Input: k = 2
Output: -1
Explanation: There is no such positive integer n divisible by 2.
Example 3:

Input: k = 3
Output: 3
Explanation: The smallest answer is n = 111, which has length 3.
 */
public class Day252_SmallestRepunitDivByK {
    public static void main(String[] args) {
        int k = 10;
        System.out.println(smallestRepunitDivByK(k));
    }
    public static int smallestRepunitDivByK(int k) {
        if (k == 1) return 1;
        int curNum = 1;
        int pow = 1;
        while (curNum < Math.pow(10,k)) {
            curNum = (int) (curNum + Math.pow(10, pow));
            if (curNum % k == 0) return pow + 1;
            pow += 1;
        }
        return -1;
    }
}
