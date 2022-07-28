package com.zlq.day50;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50
 * @ClassName: Day50_SortColors
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/29 10:04 上午
 */
/*
给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。

进阶：
你可以不使用代码库中的排序函数来解决这道题吗？
你能想出一个仅使用常数空间的一趟扫描算法吗？
示例 1：
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：
输入：nums = [2,0,1]
输出：[0,1,2]
示例 3：
输入：nums = [0]
输出：[0]
示例 4：
输入：nums = [1]
输出：[1]
 */
public class Day50_SortColors {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));

    }


    public static void sortColors(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, index);
                index++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, index);
                index++;
            }
        }
    }


    public static void sortColors1(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            if (nums[i] == 1) count1++;
            if (nums[i] == 2) count2++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) nums[i] = 0;
            else if (i < count0 + count1) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    private static void swap(int[] nums, int  i, int index2) {
        int temp = nums[ i];
        nums[ i] = nums[index2];
        nums[index2] = temp;
    }


}
