package com.zlq.day240;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day240
 * @ClassName: Day235_PrevPermOpt1
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/3 10:53
 */
/*
1053. 交换一次的先前排列
中等
给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。

如果无法这么操作，就请返回原数组。

示例 1：

输入：arr = [3,2,1]
输出：[3,1,2]
解释：交换 2 和 1
示例 2：

输入：arr = [1,1,5]
输出：[1,1,5]
解释：已经是最小排列
示例 3：

输入：arr = [1,9,4,6,7]
输出：[1,7,4,6,9]
解释：交换 9 和 7


提示：

1 <= arr.length <= 104
1 <= arr[i] <= 104
 */
public class Day235_PrevPermOpt1 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 1, 1, 2, 2, 1};
        System.out.println(Arrays.toString(prevPermOpt1(arr)));
    }

    public static int[] prevPermOpt1(int[] arr) {
        int length = arr.length;
        for (int i = length - 1; i >= 0 ; i--) {
            int maxLessThanCur = 0;
            int index = 0;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[i] && arr[j] > maxLessThanCur) {
                    maxLessThanCur = arr[j];
                    index = j;
                }
            }
            if (maxLessThanCur != 0) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        return arr;
    }
}
