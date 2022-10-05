package com.zlq.day160;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day160
 * @ClassName: Day154_FindKeleNearTarget
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/25 11:31
 */
/*
给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。

整数 a 比整数 b 更接近 x 需要满足：

|a - x| < |b - x| 或者
|a - x| == |b - x| 且 a < b

示例 1：

输入：arr = [1,2,3,4,5], k = 4, x = 3
输出：[1,2,3,4]
示例 2：

输入：arr = [1,2,3,4,5], k = 4, x = -1
输出：[1,2,3,4]
 */
public class Day154_FindKeleNearTarget {
    public static void main(String[] args) {
        int[] arr = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        System.out.println(findClosestElements(arr, k, x));

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;
        List<Integer> resList = new ArrayList<>();
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                resList.add(arr[i]);
            }
        } else if (x >= arr[length - 1]) {
            for (int i = length - k ; i < length; i++) {
                resList.add(arr[i]);
            }
        } else {
            // 初始化左右指针，右指针为x的位置
            int l = 0, r = k - 1;
            int minGap = 0,minL = l, minR = r;
            for (int i = l; i <= r; i++) {
                minGap += Math.abs(arr[i] - x);
            }
            while (r < length) {
                int gap = minGap;
                gap = gap + Math.abs(arr[r] - x) - Math.abs(arr[l] - x);
                if (gap < minGap) {
                    minGap = Math.min(minGap, gap);
                    minL = l;
                    minR = r;
                }
                l++;
                r++;
            }
            for (int i = minL; i <= minR; i++) {
                resList.add(arr[i]);
            }
        }
        return resList;
    }
}
