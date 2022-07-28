package com.zlq.day70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day70
 * @ClassName: Day61_RotateArray
 * @description:
 * @author: LiQun
 * @CreateDate:2021/11/27 9:33 上午
 */
/*
整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，返回它的下标，否则返回-1。

示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1
 */
public class Day61_RotateArray {
    public static void main(String[] args) {
        int[] arr = {6, 8, 7, 13, 9, 3, 20, 2, 5, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 9));

    }

    /*
    demo:
    int arr = [2,5,1,6,8,7,13,9,3,20]
    target = 2
    旋转后 ：[6,8,7,13,9,3,20,2,5,1]   长度为10，旋转点为index = 7 （arr.length - target - 1）
     */
    public static List<Integer> getBeforeRotate(int[] arr, int target) {
        int length = arr.length;
        int rotateIndex = arr.length - target - 1;

        List<Integer> list = new ArrayList<>();
        for (int i = rotateIndex; i < length; i++) {
            list.add(arr[i]);
        }
        for (int i = 0; i < rotateIndex; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static int search(int[] arr, int target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;

        }
        return index;
    }

    public static int binarySearch(int[] arr, int target) {
        int length = arr.length;
        int l = 0, r = length - 1;
        if (target > arr[r] || target < arr[l]) return -1;
        while (l <= r) {
            int midIndex = l + (r - l) / 2;
            int midValue = arr[midIndex];
            if (target > midValue) l = midIndex + 1;
            else if (target < midValue) r = midIndex - 1;
            else return midIndex;
        }
        return -1;
    }
/*
二分查找的变种
[4,5,6,7,0,1,2]
 */
}
