package com.zlq.day40;


import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day31_RotatePIC
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/3 11:26 下午
 */
/*
给定一个 n×n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:
给定 matrix =
[
  [5 , 1, 9,11],
  [2 , 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],
原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class Day31_RotatePic {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        rotate(matrix);
        print(matrix);
    }


    public static void rotate(int[][] matrix) {
        // 设置右斜下方的对角线为中心轴将元素对调
        int length = matrix.length;
        // 翻转行
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 翻转列
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = temp;
            }
        }
    }

    public static void print(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
