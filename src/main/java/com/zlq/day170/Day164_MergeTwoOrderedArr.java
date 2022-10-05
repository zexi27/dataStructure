package com.zlq.day170;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day164_MergeTwoOrderedArr
 * @description: 合并两个相同的有序数组
 * @author: LiQun
 * @CreateDate:2022/9/21 22:36
 */
/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
*/
public class Day164_MergeTwoOrderedArr {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            arr[index] = nums1[i];
            index++;
        }
        for (int i = 0; i < n; i++) {
            arr[index] = nums2[i];
            index++;
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = arr[i];
        }
    }

    /*
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        // 双指针
        int l = 0, r = 0; // l 代表nums1中的指针，r代表nums2中的指针
        // 辅助数组
        int[] tempArr = new int[m + n];
        int index = 0;
        while (r <= n - 1 && l <= m - 1) {
            if (l < m && nums1[l] < nums2[r]) {
                tempArr[index] = nums1[l];
                l++;
            } else {
                tempArr[index] = nums2[r];
                r++;
            }
            index++;
        }
        if (r < n) {
            while (r < n) {
                tempArr[index] = nums2[r];
                r++;
                index++;
            }
        } else if (l < m) {
            while (l < m) {
                tempArr[index] = nums1[l];
                l++;
                index++;
            }
        }
        for (int i = 0; i < tempArr.length; i++) {
            nums1[i] = tempArr[i];
        }
    }

    /*
    You are given an array of distinct integers arr and an array of integer arrays pieces,
    where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order.
    However, you are not allowed to reorder the integers in each array pieces[i].

    Return true if it is possible to form the array arr from pieces. Otherwise, return false.

    Example 1:

    Input: arr = [15,88], pieces = [[88],[15]]
    Output: true
    Explanation: Concatenate [15] then [88]
    Example 2:

    Input: arr = [49,18,16], pieces = [[16,18,49]]
    Output: false
    Explanation: Even though the numbers match, we cannot reorder pieces[0].
    Example 3:

    Input: arr = [91,4,64,78,23,12,37], pieces = [[23,12,37],[78],[4,64],[91]]
    Output: true
    Explanation: Concatenate [91] then [4,64] then [78]
     */

    public static void main(String[] args) {
        int[] arr = {91, 4, 64, 78, 23, 12, 37};
        int[][] pieces = {{23, 12, 37}, {78}, {4, 64}, {91},{23,22,13}};
        System.out.println(isContains(arr, pieces[4]));
    }
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        for (int[] piece : pieces) {
            if (!isContains(arr,piece)) return false;
        }
        return true;
    }

    public static boolean isContains(int[] arr, int[] subArr) {
        int length = subArr.length;
        int l = 0, r = length - 1;
        boolean flag = false;
        while (!flag && r < arr.length) {
            for (int i = l; i <= r; i++) {
                if (arr[i] != subArr[i - l]) {
                    break;
                }
                if (i == r) flag = true;
            }
            l++;
            r++;
        }
        return flag;
    }
}
