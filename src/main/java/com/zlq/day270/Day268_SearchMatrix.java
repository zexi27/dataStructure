package com.zlq.day270;

import java.util.Arrays;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/8/7 10:00
 */

/*
368
Companies
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
 */
public class Day268_SearchMatrix {

//    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,9}};
//        System.out.println(searchMatrix(matrix, 9));
//    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] arr = new int[rows * columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[index] = matrix[i][j];
                index++;
            }
        }
        // 二分
        int length = arr.length;
        if (target > arr[length - 1] || target < arr[0]) return false;
        int l = 0, r = length;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (target > arr[middle]) l = middle + 1;
            else if (target < arr[middle]) r = middle - 1;
            else return true;
        }
        return false;
    }
    /*
    81. Search in Rotated Sorted Array II
Medium
6.7K
875
Companies
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.



Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104


Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?

Accepted
545.1K
Submissions

     */

    public static void main(String[] args) {
        TreeNode n11 = new TreeNode(1);
        TreeNode n13 = new TreeNode(3);
        TreeNode n12 = new TreeNode(2);
        TreeNode n15 = new TreeNode(5);
        n11.left = n13;
        n11.right = n12;
        n13.left = n15;

        TreeNode n22 = new TreeNode(2);
        TreeNode n21 = new TreeNode(1);
        TreeNode n23 = new TreeNode(3);
        TreeNode n24 = new TreeNode(4);
        TreeNode n27 = new TreeNode(7);
        n22.left = n21;
        n22.right = n23;
        n21.right = n24;
        n23.right = n27;
        TreeNode merged = mergeTrees(n11, n22);
        printPreOrder(merged);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        if (root1 == null && root2 == null) return null;
        TreeNode merged = new TreeNode(root1.val + root2.val);

        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }


    // 前序遍历
    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

