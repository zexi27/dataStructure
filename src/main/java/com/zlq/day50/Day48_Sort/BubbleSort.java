package com.zlq.day50.Day48_Sort;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day48_Sort
 * @ClassName: BubbleSort
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/26 9:27 上午
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 2, 9, 7, 5, 10, 16, 13};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sort(int[] nums) {
        int length = nums.length;
        boolean isExchange = false;
        // 第一次将最大的数移到最右边，第二次将第二大的数移到倒数第二位
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    isExchange = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (!isExchange) { // 如果未交换直接跳出当前轮的循环
                break;
            } else {
                isExchange = false;
            }
            System.out.println("第" + (i + 1) + "次循环：" + Arrays.toString(nums));
        }
    }
}
