package com.zlq.day50.Day48_Sort;

import java.awt.image.Kernel;
import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day48_Sort
 * @ClassName: SelectSort
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/26 10:02 上午
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 2, 9, 7, 5, 10, 16, 13};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minNum = nums[i];
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (minNum > nums[j]) {
                    minNum = nums[j];
                    minIndex = j;
                }
            }
            nums[minIndex] = nums[i];
            nums[i] = minNum;
            System.out.println("第" + i + "次" + "-----" + Arrays.toString(nums));
        }
    }
}
