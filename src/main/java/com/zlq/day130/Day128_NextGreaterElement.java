package com.zlq.day130;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day128_NextGreaterElement
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/3 11:30
 */
/*
给你一个正整数n ，请你找出符合条件的最小整数，其由重新排列 n中存在的每位数字组成，并且其值大于 n 。
如果不存在这样的正整数，则返回 -1 。

注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。

示例 1：

输入：n = 12
输出：21
示例 2：

输入：n = 21
输出：-1

 */
public class Day128_NextGreaterElement {

    /*
    12345 => 12354
    122222222 =>
    212222222
    32531 => 33521

    2147483476
    2147483674

     */
    public static void main(String[] args) {
        int n = 12222333;
        System.out.println(nextGreaterElement(n));
    }

    public static int nextGreaterElement(int n) {
        String stringN = String.valueOf(n);
        int changeIndex = -1;
        int changeNum = 0;
        // 寻找交换数的索引
        char[] charArray = stringN.toCharArray();
        int length = charArray.length;
        if (length == 1) return -1;
        // 从后往前找到第一个 从后往前降序的位置，它后面都是从后往前升序的
        for (int i = length - 1; i > 0; i--) {
            int num = charArray[i] - '0';
            int lastNum = charArray[i - 1] - '0';
            if (i > 0 && num > lastNum){
                changeIndex = i - 1;
                changeNum = lastNum;
                break;
            }
        }
        if (changeIndex == -1) return -1;
        // 找到第一个大于它的值翻转
        for (int i = length - 1; i >=  0; i--) {
            int num = charArray[i] - '0';
            if (num > changeNum) {
                swap(charArray,changeIndex,i);
                break;
            }
        }

        int j = changeIndex+ 1;
        int k = length - 1;
        while (j < k) {
            swap(charArray, j, k);
            j++;
            k--;
        }
        long res = Long.parseLong(String.valueOf(charArray));
        if (res > Integer.MAX_VALUE) return -1;
        return res == n ? -1 : (int) res;
    }

    public static void swap(char[] charArr, int index1, int index2) {
        char temp = charArr[index1];
        charArr[index1] = charArr[index2];
        charArr[index2] = temp;
    }
}
