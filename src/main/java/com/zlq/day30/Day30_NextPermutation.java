package com.zlq.day30;

import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day30_NextPermutation
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/2 2:03 下午
 */
/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1


[1,3,8,7,6,2]
[1,6,2,3,7,8]

{1,2,3,4,5}
{1,2,3,5,4}

代码实现如下：

原数组：    [1 , 5 , 8 , 4 , 7 , 6 , 5 , 3 , 1 ]
下一个排列  [1 , 5 , 8 , 5 , 1 , 3 , 4 , 6 , 7 ]
 */
public class Day30_NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1 , 5 , 8 , 4 , 7 , 6 , 5 , 3 , 1 };
        int[] nums = {1, 2, 4, 3, 5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = s2.intern();
        System.out.println(s1 == s3);
    }

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        boolean isDescendingOrder = true;
        // 如果数组依次递减则将数组升序排序
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                isDescendingOrder = false;
                break;
            }
        }
        if (isDescendingOrder == true) {
            Arrays.sort(nums);
        } else {
//            getNextOrder(nums);
            int k = 0;
            int exchangeIndex = 0;
            for (int i = length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    // 后面的比前面的大，处理i - 1这个位置
                    k = i - 1;
                    break;
                }
            }
            for (int i = length - 1; i > k; i--) {
                if (nums[i] > nums[k]) {
                    exchangeIndex = i;
                    break;
                }
            }
            if (exchangeIndex != 0)
                exchange(nums, k, exchangeIndex);
            int start = k + 1;
            int end = length - 1;
            while (start < end) {
                exchange(nums, start, end);
                start++;
                end--;
            }

        }
    }

    private static void exchange(int[] arr, int  i, int index2) {
        int temp = arr[ i];
        arr[ i] = arr[index2];
        arr[index2] = temp;
    }
}
