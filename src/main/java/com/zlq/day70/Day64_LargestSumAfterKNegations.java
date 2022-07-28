package com.zlq.day70;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day70
 * @ClassName: Day64_LargestSumAfterKNegations
 * @description:
 * @author: LiQun
 * @CreateDate:2021/12/3 9:36 上午
 */
/*
给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。

以这种方式修改数组后，返回数组 可能的最大和 。

示例 1：

输入：nums = [4,2,3], k = 1
输出：5
解释：选择下标 1 ，nums 变为 [4,-2,3] 。
示例 2：

输入：nums = [3,-1,0,2], k = 3
输出：6
解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
示例 3：

输入：nums = [2,-3,-1,5,-4], k = 2
输出：13
解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 */
public class Day64_LargestSumAfterKNegations {

    public static void main(String[] args) {
        int[] nums = {-4, -2, -3};
        int k = 4;
        System.out.println(largestSumAfterKNegations(nums, k));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int smallestIndex = 0; // 默认第一个数是最小的
        for (int i = 0; i < k; i++) {
            nums[smallestIndex] = -nums[smallestIndex];  // 变换第一个数
            if (nums[smallestIndex] < 0) { // 如果第一个坐标变为负数，原本它都是最小的，那现在它肯定还是最小的，下次还用它
                smallestIndex = smallestIndex;
            } else { // 如果它变为整数，有可能比后面的数大了
                if (smallestIndex < nums.length - 1) {   // 设定边界条件，避免ArrayIndexOutofBounds
                    if (nums[smallestIndex] > nums[smallestIndex + 1]) smallestIndex += 1;  // 判断如果比后面的大，最小的就是它后面的
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

    public static int largestSumAfterKNegations2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int smallestIndex = findSmallestIndex(nums);
            nums[smallestIndex] = -nums[smallestIndex];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

    public static int findSmallestIndex(int[] nums) {
        int smallestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[smallestIndex] > nums[i]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            hash[index] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            hash[index] -= 1;
            if (hash[index] < 0) return false;
        }
        return true;
    }

}
