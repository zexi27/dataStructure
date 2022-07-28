package com.zlq.day40;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day38_SlideWindows
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/15 4:57 下午
 */
/*
给定一个数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。
进阶：

你能在线性时间复杂度内解决此题吗？
示例1:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
public class Day38_SlideWindows {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7, 2, 13, 9, 23, 2, 21};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow3(nums, k)));
    }

    // 方法1：暴力法
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int length = nums.length;
        int l = 0, r = k - 1;
        int[] result = new int[length - k + 1];
        int index = 0;
        while (l <= length - k) {
            int maxNum = Integer.MIN_VALUE;
            for (int i = l; i <= r; i++) {
                if (maxNum < nums[i])
                    maxNum = nums[i];
            }
            result[index] = maxNum;
            index++;
            l++;
            r++;
        }
        return result;
    }

    // 方法2：使用大顶堆
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i <= k - 1; i++) {
            maxHeap.add(nums[i]);
        }
        result[0] = maxHeap.peek();
        int index = 1;
        for (int i = k; i < length; i++) {
            maxHeap.add(nums[i]);
            maxHeap.remove(nums[i - k]);
            result[index] = maxHeap.peek();
            index++;
        }
        return result;
    }

    // 方法3：使用左右扫描
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int length = nums.length;
        int[] leftNums = new int[length];
        int[] rightNums = new int[length];

        for (int i = 0; i < length; i++) {
            if (i % k == 0) {
                leftNums[i] = nums[i];
            } else {
                leftNums[i] = Math.max(leftNums[i - 1], nums[i]);
            }
            int j = length - i - 1;
            if (j % k == k - 1 || j == length - 1) {
                rightNums[j] = nums[j];
            } else {
                rightNums[j] = Math.max(rightNums[j + 1], nums[j]);
            }
        }
        System.out.println(Arrays.toString(leftNums));
        System.out.println(Arrays.toString(rightNums));
        return null;

    }


}
