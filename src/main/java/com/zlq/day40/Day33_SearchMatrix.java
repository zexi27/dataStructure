package com.zlq.day40;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day33_SearchMatrix
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/5 9:25 上午
 */
/*
搜索二维矩阵（#74）
3.2.1 题目说明
编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1：

 */
public class Day33_SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                          {10, 11, 16, 20},
                          {23, 30, 34, 50}};
        int target = 20;
        System.out.println(searchMatrix2(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[1].length;
        int[] arr = new int[row * column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[j + column * i] = matrix[i][j];
            }
        }
        int solution = solution(arr, target);
        if (solution != -1) return true;
        return false;
    }

    public static int solution(int[] nums, int target) {
        int length = nums.length;
        int l = 0, r = length - 1;
        if (target < nums[l] || target > nums[r]) {
            return -1;
        }
        while (l <= r) {
            int midIndex = (l + r) / 2;
            int midNum = nums[midIndex];
            if (target < midNum) r = midIndex - 1;
            else if (target > midNum) l = midIndex + 1;
            else return midIndex;
        }
        return -1;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        if (row == 0) return false;
        int l = 0, r = row * column - 1;
        while (l <= r) {
            int midIndex = l + (r - l) / 2;
            int midNum = matrix[midIndex / column][midIndex % column];
            if (target < midNum) r = midIndex - 1;
            else if (target > midNum) l = midIndex + 1;
            else return true;
        }
        return false;
    }
}
