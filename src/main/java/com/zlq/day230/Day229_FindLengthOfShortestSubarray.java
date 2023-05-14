package com.zlq.day230;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day230
 * @ClassName: Day229_FindLengthOfShortestSubarray
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/25 11:35
 */
/*
1574. Shortest Subarray to be Removed to Make Array Sorted
middle
Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.

Return the length of the shortest subarray to remove.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: arr = [1,2,3,10,4,2,3,5]
Output: 3
Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
Another correct solution is to remove the subarray [3,10,4].
Example 2:

Input: arr = [5,4,3,2,1]
Output: 4
Explanation: Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].
Example 3:

Input: arr = [1,2,3]
Output: 0
Explanation: The array is already non-decreasing. We do not need to remove any elements.


Constraints:

1 <= arr.length <= 105
0 <= arr[i] <= 109
 */
public class Day229_FindLengthOfShortestSubarray {

//    public static void main(String[] args) {
//        int[] arr = {2, 5, 4, 3, 1, 0, 3, 4, 8};
//        findLengthOfShortestSubarray(arr);
//    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int length = arr.length;
        int l = 0, r = length - 1;
        // 如果后面的数字大于前面的数字，指针后移
        while (l < length - 1 && arr[l] < arr[l + 1]) l++;
        if (l == length - 1) return 0; // l 都移到最右面了，说明整个数组都是递增的，无需remove
        while (r > 0 && arr[r - 1] < arr[r]) r--;
        if (r == 0) return length - 1; // r 都移到最左面了，说明整个数组都是递减的，全都要remove
        int res = Math.min(length - l - 1, r);
        int i = 0, j = r;
        while (i <= l && j <= length - 1) {
            if (arr[j] >= arr[i]) {
                res = Math.min(res, j - i - 1);
                ++i;
            } else ++j;
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(findSubarrays(nums));
    }
    public static boolean findSubarrays(int[] nums) {
        // 存储每个长度为2的子数组的和
        Set<Integer> set = new HashSet<>();
        int sum = nums[0] + nums[1];
        set.add(sum);
        for (int i = 2; i < nums.length; i++) {
            sum +=nums[i];
            sum -=nums[i - 2];
            if (set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }
}