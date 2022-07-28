package com.zlq.day50.Day48_Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day48_Sort
 * @ClassName: QuickSort
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/28 9:21 上午
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8,2,6,3,1,9,4,7,5};
//        int[] arr = {3,6};
        sort(arr,  0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int mid = partition(arr, leftBound, rightBound);
        sort(arr,leftBound,mid - 1);
        sort(arr,mid + 1 ,rightBound);

    }

    // 首先分区的目的就是将比中心轴数小的放在其左边，比中心轴数大的放在其右边
    private static int partition(int[] arr, int leftBound, int rightBound) {
        // 定义左指针为最左边，右指针为最右边 -1，基准值为最右边
        int l = leftBound,
                r = rightBound - 1,
                pivot = arr[rightBound];
        while (l < r) {
            while (arr[l] <= pivot && l <= r) l++;  // 目的：让l指针找到比pivot大的值，找不到就右移
            while (arr[r] > pivot && l < r) r--;  // 目的：让r指针找到比pivot小的值，找不到就左移
            if (l < r) swap(arr, l, r);    // 交换l和r，最终，比pivot小的值在左边，比pivot大的值在右边
        }
//        System.out.println("l:" + l + "\t" + "r:" + r);
        if (pivot < arr[l])
            swap(arr, l, rightBound); // 将轴放在分区的正确位置上  [6, 8, 2, 5, 3, 1,*9, 10, 32]
        return l;
    }

    public static void swap(int[] arr, int  i, int index2) {
        int temp = arr[ i];
        arr[ i] = arr[index2];
        arr[index2] = temp;
    }




}
