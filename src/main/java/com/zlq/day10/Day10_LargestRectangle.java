package com.zlq.day10;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day10
 * @ClassName: Day10_LargestRectangle
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/31 9:34 上午
 */
/*
给定 n 个⾮负整数，⽤来表示柱状图中各个柱⼦的⾼度。每个柱⼦彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最⼤⾯积。
以上是柱状图的示例，其中每个柱⼦的宽度为 1，给定的⾼度为 [2,1,5,6,2,3] 。
图中阴影部分为所能勾勒出的最⼤矩形⾯积，其⾯积为 10 个单位。
示例:
输⼊: [2,1,5,6,2,3]
输出: 10
 */
public class Day10_LargestRectangle {
    public static void main(String[] args) {
        System.out.println(999 + 9999);
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(Day10_LargestRectangle.solution(arr));
    }

    // 解法1：暴力法
    public static Integer largestRectangle(int[] arr) {
        Integer result = null;
        Integer largestRectangle = null;
        int l = 0, r = 0;
        for (int i = 0; i < arr.length; i++) {
            //每次循环定义定义两个指针
            // 定义两个指针
            l = i;
            r = i;

            //如果i为0,只需要一个右指针
            if (i == 0) { // 如果为第一个，右边比arr[0]大，右指针增
                while (r <= arr.length - 1 && arr[r + 1] > arr[i])
                    r++;
            }
            //如果i为最后,只需要一个左指针
            else if (i == arr.length - 1) { // 如果为最后一个，左边比arr[arr.length - 1]大，左指针减
                while (l >= arr[0] && arr[l - 1] < arr[i])
                    l--;
            } else {
                while (r <= arr.length - 1 && l >= 0) { // 当左指针指向的值小于i并且右指针指向的值小于i停止当前while
                    int temp1 = 0;
                    int temp2 = 0;
                    if (l > 1)
                        temp1 = arr[l - 1];
                    if (temp2 < arr.length - 2)
                        temp2 = arr[r + 1];
                    if (l > 0 && temp1 > arr[i])
                        l--;
                    if (r < arr.length - 1 && temp2 > arr[i])
                        r++;
                }
            }
            largestRectangle = arr[i] * (r - l);
            if (result == null || largestRectangle > result)
                result = largestRectangle;
        }
        return result;
    }

    public static int solution(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSum = arr[i] > maxSum ? arr[i] : maxSum;
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                temp = temp > arr[j] ? arr[j] : temp;
                maxSum = (j - i + 1) * temp > maxSum ? (j - i + 1) * temp : maxSum;
            }
        }
        return maxSum;
    }


}
