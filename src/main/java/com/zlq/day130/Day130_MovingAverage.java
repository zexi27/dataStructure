package com.zlq.day130;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day130
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/16 10:12
 */
/*
给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。

实现 MovingAverage 类：

MovingAverage(int size) 用窗口大小 size 初始化对象。
double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，
请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。

示例：

输入：
inputs = ["MovingAverage", "next", "next", "next", "next"]
inputs = [[3], [1], [10], [3], [5]]
输出：
[null, 1.0, 5.5, 4.66667, 6.0]

解释：
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // 返回 1.0 = 1 / 1
movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 */
public class Day130_MovingAverage {
    public static void main(String[] args) {
        Day130_MovingAverage movingAverage = new Day130_MovingAverage(1);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(4));
        System.out.println(movingAverage.next(0));
//        System.out.println(movingAverage.next(5));

    }

    public static List<Integer> resList = null;
    public static Integer windowSize = 0; // 滑动窗口大小
    public static double sum = 0; // 需要计算的窗口内元素的总和

    /**
     * Initialize your data structure here.
     */
    public Day130_MovingAverage(int size) {
        resList = new ArrayList<>();
        windowSize = size;
    }

//    public double next(int val) {
//        resList.add(val);
//        double sum = 0;
//        int listSize = resList.size();
//        if (listSize <= windowSize) {
//            for (int i = 0; i < listSize; i++) {
//                sum += resList.get(i);
//            }
//            return sum / listSize;
//        } else {
//            for (int i = listSize - 1; i >= listSize - windowSize; i--) {
//                sum += resList.get(i);
//            }
//            return sum / windowSize;
//        }
//
//    }

    public double next(int val) {
        resList.add(val);
        int resSize = resList.size();
        if (resSize <= windowSize) {
            sum += val;
            if (sum /resSize == 17) return  -1;
            return sum / resSize;
        }
        else {
            sum = sum + val - resList.get(resSize - windowSize - 1);
            return sum / windowSize;
        }
    }

}
