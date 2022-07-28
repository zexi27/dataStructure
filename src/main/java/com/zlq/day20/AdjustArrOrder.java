package com.zlq.day20;


import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: AdjustArrOrder
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/17 9:24 上午
 */
/*
#### **题目描述：**

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。

#### **问题解析：**

这道题有挺多种解法的，给大家介绍一种我觉得挺好理解的方法：
我们首先统计奇数的个数假设为n,然后新建一个等长数组，然后通过循环判断原数组中的元素为偶数还是奇数。如果是则从数组下标0的元素开始，把该奇数添加到新数组；如果是偶数则从数组下标为n的元素开始把该偶数添加到新数组中。
 */
public class AdjustArrOrder {
    public static void main(String[] args) {
        //{5,7,1,3,9,5,3,27,|2,6,8,6,16}
        int[] arr = {5, 2, 7, 6, 8, 1, 3, 9, 5, 3, 6, 16, 27};
        System.out.println(Arrays.toString(adjustArrOrder(arr)));
    }

    public static int[] adjustArrOrder(int[] arr) {
        int[] res = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int remainder = arr[i] % 2; // 取余
            if (remainder == 1) {
                res[index] = arr[i];
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int remainder = arr[i] % 2; // 取余
            if (remainder == 0) {
                res[index] = arr[i];
                index++;
            }
        }
        return res;
    }

    public static int[] mergeArr(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] arr = new int[length1 + length2];
        for (int i = 0; i < arr.length; i++) {
            if (i >= 0 && i <= length1 - 1) arr[i] = arr1[i];
            else arr[i] = arr2[i - length1];
        }
        return arr;
    }
}
