package com.zlq.day40;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day34_FindDumplicate
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/6 8:47 上午
 */
/*
给定一个包含n + 1 个整数的数组nums，其数字都在 1 到 n之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
示例 1:
输入: [1,3,4,2,2]
输出: 2
示例 2:
输入: [3,1,3,4,2]
输出: 3
说明：
不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。
{1,8,5,2,7,4,8,3,6,9}
 */
public class Day34_FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,9,5,2,7,4,8,3,6,9};
        System.out.println(findDuplicate(nums));

    }

    public  static int findDuplicate(int[] nums) {
        int length = nums.length;
        int l = 0,r = length - 1;

        while (l <= r){
            int midIndex = l + (r - l)/2;
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] <= midIndex) count++;
            }
            if (count<= midIndex)
                l = midIndex + 1;
            else r = midIndex;
            if (l == r) return l;
        }
        return -1;
    }
}
