package com.zlq.day120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day120
 * @ClassName: Day116_SortArrByPrimary
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/30 17:01
 */
/*
给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。

返回满足此条件的 任一数组 作为答案。

示例 1：

输入：nums = [3,1,2,4]
输出：[2,4,3,1]
解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
示例 2：

输入：nums = [0]
输出：[0]
 */
public class Day116_SortArrByPrimary {
    public static void main(String[] args) {
        int[] nums = {0,2,4,5,7,9,20};
        System.out.println(Arrays.toString(sortArrayByParity2(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        int[] resArr = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 0) {
                list.add(nums[i]);
                nums[i] = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) list.add(nums[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }


    public static int[] sortArrayByParity2(int[] nums) {
        int length = nums.length;
        int[] resArr = new int[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 0) {
                resArr[index++] = nums[i];
                nums[i] = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) resArr[index++] = nums[i];
        }
        return resArr;
    }
}
