package com.zlq.day50;


import com.zlq.day50.Day48_Sort.CheckNums;
import com.zlq.day50.Day48_Sort.QuickSort;

import java.util.Arrays;

import static com.zlq.day50.Day48_Sort.QuickSort.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day44_queue_to_stack
 * @ClassName: com.zlq.day50.Day49_QuickSort
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/29 9:24 上午
 */
public class Day49_QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 9, 4, 7, 1, 8, 6, 10};
        System.out.println(Arrays.toString(nums));

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        int[] array = CheckNums.generateRandomArray(1000);
        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] nums, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int mid = partition(nums, leftBound, rightBound);
        quickSort(nums, 0, mid - 1);
        quickSort(nums, mid + 1, rightBound);
    }

    private static int partition(int[] nums, int leftBound, int rightBound) {
        int left = leftBound, right = rightBound - 1;
        int pivot = nums[rightBound];
        while (left < right) {
            while (nums[left] <= pivot && left <= right) left++;
            while (nums[right] > pivot && left < right) right--;
//            System.out.println("left" + left + "\tright" + right);
            if (left < right) swap(nums, left, right);
        }
        if (pivot < nums[left])
            swap(nums, left, rightBound);
        return left;
    }

    public static void swap(int[] arr, int i, int index2) {
        int temp = arr[i];
        arr[i] = arr[index2];
        arr[index2] = temp;
    }
}
