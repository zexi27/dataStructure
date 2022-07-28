package com.zlq.day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day10
 * @ClassName: Day5_Container
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/25 8:32 上午
 */
/*
给你n个非负整数a1,a2,
an,每个数代表生标中的一个点(i,ai)。在坐标内画n条垂直线,垂直线1的两个端点分别为(i,ai)和(1,0)。
找出其中的两条线,使得它们与x轴共同构成的容器可以容纳最多的水。说明:你不能傾斜容器。
输入:[1,8,6,2,5,4,8,3,7]
     [1,7,8,2,5,4,8,6,3]
输出:49
解释:图中重直线代表输入数组[1,8,6,2,5,4,8,3,7]。在此情況下,容器能够容纳水(表示为蓝色部分)的最大值为49
示例 2
输入: height=[1,1]
输出 1
示例 3
输入: height=[4,3,2,1,4]
输出:16
示例4
输入: height=[1,2,1]
输出:2
 */
public class Day5_Container {
    public static void main(String[] args) {
        int[] height = {2,3,10,5,7,8,9};
        System.out.println(container3(height));
    }

    //暴力法：时间复杂度：O(N²)，空间复杂度O(C)
    public static Integer container1(int[] height) {
        Integer result = null;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                //nums[i]和nums[j]中的最小值乘以它们的距离
                int newResult = (height[i] >= height[j] ? height[j] : height[i]) * (j - i);
                //如果result为空，或者newResult大于result将结果替换
                if (result == null || newResult > result) {
                    result = newResult;
                }
            }
        }
        return result;
    }


    //解法存在错误，不能这么找最大值
    public static Integer container2(int[] height) {
        Integer maxNum = null; // 最大值
        Integer maxNumIndex = null;
        //求出数组中最大值及最大值角标
        for (int i = 0; i < height.length; i++) {
            if (maxNum == null || height[i] >= maxNum) {
                maxNum = height[i];
                maxNumIndex = i;
            }
        }

        //定义一个指针
        int p = 0;
        Integer result = null;
        while (p < height.length) {
            Integer newResult = (maxNum >= height[p] ? height[p] : maxNum) * Math.abs(maxNumIndex - p);
            if (result == null || newResult > result) {
                result = newResult;
            }
            p++;
        }
        return result;
    }

    public static Integer container3(int[] height) {
        //定义两个指针
        int left = 0, right = height.length - 1;
        while (left < right  ) {
            if (getCurrentResult(left + 1, right, height) >
                    getCurrentResult(left, right, height)) {
                left++;
//                break;
            }
            if (getCurrentResult(left, right - 1, height) >
                    getCurrentResult(left, right, height)) {
                right--;
//                break;
            }
            return getCurrentResult(left,right,height);
        }
        return getCurrentResult(left,right,height);

    }

    //求出当前指针中的结果
    public static Integer getCurrentResult(int left, int right, int[] height) {
        Integer currentResult =
                (height[left] >= height[right] ? height[right] : height[left]) * (right - left);
        return currentResult;
    }


}
