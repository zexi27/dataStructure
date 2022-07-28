package com.zlq.day80;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: Day74_Construct2DArray
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/1 10:16 上午
 */
/*
给你一个下标从 0 开始的一维整数数组 original 和两个整数 m 和  n 。
你需要使用 original 中 所有 元素创建一个 m 行 n 列的二维数组。

original 中下标从 0 到 n - 1 （都 包含 ）的元素构成二维数组的第一行，下标从 n 到 2 * n - 1 （都 包含 ）的元素构成二维数组的第二行，依此类推。

请你根据上述过程返回一个 m x n 的二维数组。如果无法构成这样的二维数组，请你返回一个空的二维数组。



示例 1：


输入：original = [1,2,3,4], m = 2, n = 2
输出：[[1,2],[3,4]]
解释：
构造出的二维数组应该包含 2 行 2 列。
original 中第一个 n=2 的部分为 [1,2] ，构成二维数组的第一行。
original 中第二个 n=2 的部分为 [3,4] ，构成二维数组的第二行。
示例 2：

输入：original = [1,2,3], m = 1, n = 3
输出：[[1,2,3]]
解释：
构造出的二维数组应该包含 1 行 3 列。
将 original 中所有三个元素放入第一行中，构成要求的二维数组。
示例 3：

输入：original = [1,2], m = 1, n = 1
输出：[]
解释：
original 中有 2 个元素。
无法将 2 个元素放入到一个 1x1 的二维数组中，所以返回一个空的二维数组。
示例 4：

输入：original = [3], m = 1, n = 2
输出：[]
解释：
original 中只有 1 个元素。
无法将 1 个元素放满一个 1x2 的二维数组，所以返回一个空的二维数组。
 */
public class Day74_Construct2DArray {
    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        int m = 1, n = 3;
        int[][] arr = construct2DArray2(original, m, n);
        printArr(arr);

    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int length = original.length;
        if (m * n != length) return new int[][]{};
        int[][] arr = new int[m][n];
        for (int i = 0; i < length; i++) {
            int rowNum = i / n;
            arr[rowNum][i - rowNum * n] = original[i];
        }
        return arr;
    }
    public static int[][] construct2DArray2(int[] year2021, int m, int n) {
        if (year2021.length != m * n) return new int[0][0];
        int[][] year2022 = new int[m][n];
        for (int i = 0, idx = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                year2022[i][j] = year2021[idx++];
            }
        }
        return year2022;
    }


    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
