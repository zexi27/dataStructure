package com.zlq.day120;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day120
 * @ClassName: Day118_NumSubarrayProductLessThanK
 * @description:
 * @author: LiQun
 * @CreateDate:2022/5/5 22:07
 */
/*
给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
示例 1：

输入：nums = [10,5,2,6], k = 100
输出：8
解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
示例 2：

输入：nums = [1,2,3], k = 0
输出：0
 */
public class Day118_NumSubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;  // 定义双指针
        int length = nums.length;
        while (left < length) {
            int curRes = nums[left];  // 保存curRes为left
            if (left == right) curRes = nums[left];
            else curRes *= nums[right];
            if (curRes < k) {  // 如果结果小于k，右指针右移，结果数+1;否则左指针右移，右指针等于左指针（指针重置）
                right++;
                res++;
            } else {
                left++;
                right = left;
            }
            if (right > length - 1) {
                left++;
                right = left;
            }
        }
        return res;
    }
}
