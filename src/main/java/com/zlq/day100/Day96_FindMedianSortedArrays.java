package com.zlq.day100;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day96_CountMaxOrSubSets
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/15 3:46 下午
 */
/*
给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class Day96_FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = 0, r = 0;
        int[] arr = new int[nums1.length + nums2.length];
        int index = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] < nums2[r]) {
                arr[index] = nums1[l];
                l++;
            } else {
                arr[index] = nums2[r];
                r++;
            }
            index++;
        }
        if (l < nums1.length) {
            for (int i = l; i < nums1.length; i++) {
                arr[index] = nums1[i];
                index++;
            }
        } else {
            for (int i = r; i < nums2.length; i++) {
                arr[index] = nums2[i];
                index++;
            }
        }
        return arr.length % 2 == 0 ? ((double) (arr[(arr.length - 1) / 2] + arr[(arr.length - 1) / 2 + 1])) / 2 : arr[(arr.length - 1) / 2];
    }


}
