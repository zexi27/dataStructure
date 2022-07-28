package com.zlq.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day10
 * @ClassName: Day2_TwoSums
 * @description: 两数之和
 * @author: LiQun
 * @CreateDate:2021/5/23 9:55 上午
 */
/*
给定一个数组、给定一个目标值，求数组中两数之和为该目标值的数组下标
int[] arr = {1,5,2,6,8,3}
int target = 8
int[] result = [1,5]
 */
public class Day2_TwoSums {
    public static void main(String[] args) {
        int[] arr = {1,5,2,6,8,3};
        int target = 8;
        int[] result = Day2_TwoSums.getIndex(arr, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }
    //方法1：暴力法
    private static int[] getIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("找不到相应的结果！");
    }

    //方法2：使用hashMap，利用空间换时间
    private static int[] getIndex2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();  //将数组转换成哈希表，key就是数组的值，value是数组的索引
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                map.put(arr[i], i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int cpNum = target - arr[i];  //获取想要找到的另一个匹配数字
            if (map.containsKey(cpNum) && map.get(cpNum) != i) { //如果哈希表中存在该匹配数字，且匹配数字不是自己
                return new int[]{i, map.get(cpNum)};
            }
        }
        throw new IllegalArgumentException("找不到相应的结果！");
    }


    private static int[] getIndex3(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int cpNum = target - arr[i];  //获取想要找到的另一个匹配数字
            if (map.containsKey(cpNum)) { //如果哈希表中存在该匹配数字
                return new int[]{map.get(cpNum), i};
            }
            if (arr[i] <= target) {
                map.put(arr[i], i);
            }
        }
        throw new IllegalArgumentException("找不到相应的结果！");
    }
}
