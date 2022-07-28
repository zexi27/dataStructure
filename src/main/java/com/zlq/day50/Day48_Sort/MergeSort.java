package com.zlq.day50.Day48_Sort;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day48_Sort
 * @ClassName: MergeSort
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/1 9:15 上午
 */
// Java内部对象排序专用
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 8, 3, 6, 9};
        sort(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < 10000; i++) {
            int[] array = CheckNums.generateRandomArray(10000);
            sort(array,0,array.length - 1);
            boolean checkArr = CheckNums.checkArr(array);
            if(checkArr == false){
                System.out.println("出错");
            }
        }
        System.out.println(true);

    }

    public static void sort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums,left,mid + 1,right);
    }

    public static void merge(int[] nums, int left, int right, int rightBound) {
        int[] temp = new int[rightBound - left + 1];
        int mid = right - 1;
        int i = left, j = right, k = 0;
        while (i <= mid && j <= rightBound) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
//            if (nums[i] <= nums[j]) {
//                temp[k++] = nums[i++]; // 后面可以省略 k++,i++
//            } else {
//                temp[k++] = nums[j++];
//            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= rightBound) temp[k++] = nums[j++];
        for (int m = 0; m < temp.length; m++) {
            nums[left + m] = temp[m];
        }
    }


}
