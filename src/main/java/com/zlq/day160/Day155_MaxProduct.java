package com.zlq.day160;

import com.zlq.common.TreeNode;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day160
 * @ClassName: Day155_MaxProduct
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/26 10:12
 */
/*
给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

请你计算并返回该式的最大值。

示例 1：

输入：nums = [3,4,5,2]
输出：12
解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
示例 2：

输入：nums = [1,5,4,5]
输出：16
解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
示例 3：

输入：nums = [3,7]
输出：12
 */
public class Day155_MaxProduct {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(Arrays.toString(shuffle(nums, 3)));
    }

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static int maxProduct1(int[] nums) {
        int maxNum = 0;
        int secondMaxNum = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondMaxNum && i != maxIndex) {
                secondMaxNum = nums[i];
            }
        }

        return (maxNum - 1) * (secondMaxNum - 1);
    }

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        int length = nums.length;
        int l = 0, r = length - 1;
        if (target < nums[l] || target > nums[r]) return -1;
        while (l <= r) {
            int middleIndex = l + (r - l) / 2;
            if (target > nums[middleIndex]) {
                l = middleIndex + 1;
            } else if (target < nums[middleIndex]) {
                r = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }


    public static int[] shuffle(int[] nums, int n) {
        int[] resArr = new int[2 * n];
        int l = 0, r = n;
        int index = 0;
        while (r < 2 * n) {
            if (index % 2 == 0) {
                resArr[index] = nums[l];
                l++;
            } else {
                resArr[index] = nums[r];
                r++;
            }
            index++;
        }
        return resArr;
    }

    public TreeNode<Integer> insertIntoMaxTree(TreeNode<Integer> root, int val) {
        TreeNode<Integer> parent = null;
        TreeNode<Integer> cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode<Integer>(val, root, null);
                }
                TreeNode node = new TreeNode<Integer>(val, cur, null);
                parent.right = node;
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }


}
