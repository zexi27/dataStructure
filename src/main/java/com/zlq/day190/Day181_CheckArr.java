package com.zlq.day190;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day190
 * @ClassName: Day181_CheckArr
 * @description:
 * @author: LiQun
 * @CreateDate:2022/11/27 14:24
 */
/*
Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length
such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.

 */
public class Day181_CheckArr {

    public static void main(String[] args) {
        int[] nums = {2,1,3,4};
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int length = nums.length;
        int minIndex = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] <= nums[minIndex] && i == minIndex - 1) minIndex = i;
        }
        int p = minIndex, nextIndex = 0, count = 1;
        while (count < length) {
            count++;
            nextIndex = p + 1 <= length - 1 ? p + 1 : 0;
            if (nums[p] <= nums[nextIndex]) {
                p++;
            } else {
                if (count < length + 1) return false;
                break;
            }
            if (p > length - 1) p = 0;
        }
        return true;
    }
}
