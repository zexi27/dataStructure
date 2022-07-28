package com.zlq.day50.Day48_Sort;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day48_Sort
 * @ClassName: InsertSort
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/26 10:23 上午
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 2, 9, 7, 5, 10, 16, 13};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sort(int[] nums) {
        // 将无序数组第一个数插到有序数组，然后将这个数一点点往有顺序数组前面挪
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j > 0; j--) {
//                if (nums[j] < nums[j - 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j - 1];
//                    nums[j - 1] = temp;
//                }
//            }
//            System.out.println("第" + (i + 1) + "次" + "-----" + Arrays.toString(nums));
//        }

//        for (int i = 1; i < nums.length; i++) {
//            int value = nums[i];
//            int j = i - 1;
//            // 查找插入的位置
//            for (; j >= 0; --j) {
//                if (nums[j] > value) {
//                    nums[j + 1] = nums[j];  // 数据移动
//                } else {
//                    break;
//                }
//            }
//            nums[j + 1] = value; // 插入数据
//            System.out.println("第" + (i) + "次" + "-----" + Arrays.toString(nums));
//        }

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) { // 有序数组里面
                if (value < nums[j]) nums[j + 1] = nums[j]; // 如果无序数组中的第一个数小于有序数组最后一个数
                else break;
            }
            nums[j + 1] = value;
            System.out.println("第" + (i) + "次" + "-----" + Arrays.toString(nums));
        }
    }
}
