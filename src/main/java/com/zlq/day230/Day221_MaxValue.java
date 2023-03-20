package com.zlq.day230;

import javax.naming.spi.ResolveResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day230
 * @ClassName: Day221_MaxValue
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/8 10:21
 */
/*
剑指 Offer 47. 礼物的最大价值
中等
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

示例 1:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物


提示：

0 < grid.length <= 200
0 < grid[0].length <= 200
 */
public class Day221_MaxValue {


    /*
    {1, 3, 1}
    {1, 5, 1}
    {4, 2, 1}
    --------------
    {1,4,5}
    {2,9,10}
    {6,11,12}
     */
    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cacheArr = new int[m][n];
//        int res = dfs2(grid, cacheArr, 0, 0);
        return dp(grid, cacheArr);

    }

    public static int dp(int[][] grid, int[][] cacheArr) {
        // 先初始化第一排和第一列的数据
        int rows = cacheArr.length;
        int columns = cacheArr[0].length;
        cacheArr[0][0] = grid[0][0];
        // 初始化第一排数据
        for (int i = 1; i < columns; i++) {
            cacheArr[0][i] = cacheArr[0][i - 1] + grid[0][i];
        }
        // 初始化第一列数据
        for (int i = 1; i < rows; i++) {
            cacheArr[i][0] = cacheArr[i - 1][0] + grid[i][0];
        }
        // dp生成其他数据
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                // 每一个数据都是它上边和左边的最大值加这个位置的数据
                cacheArr[i][j] = grid[i][j] + Math.max(cacheArr[i - 1][j], cacheArr[i][j - 1]);
            }
        }
        return cacheArr[rows - 1][columns - 1];
    }

    public static int dfs1(int[][] grid, int x, int y) {
        if (x == grid.length || y == grid[0].length) return 0;
        int right = dfs1(grid, x + 1, y);
        int down = dfs1(grid, x, y + 1);
        return grid[x][y] + Math.max(right, down);
    }

    public static int dfs2(int[][] grid, int[][] cacheArr, int x, int y) {
        if (x == grid.length || y == grid[0].length) return 0;
        if (cacheArr[x][y] != -1) return cacheArr[x][y];
        int right = dfs2(grid, cacheArr, x + 1, y);
        int down = dfs2(grid, cacheArr, x, y + 1);
        return grid[x][y] + Math.max(right, down);
    }


    /*
    {2,6,3,1}
    {3,5,-4,-7}
     */
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int minEnergy = 0;
        for (int i = 0; i < energy.length; i++) {
            minEnergy += energy[i];
        }
        int res = 0;
        // 需要增加的精力
        res += minEnergy < initialEnergy ? 0 : minEnergy + 1 - initialEnergy;
        int length = experience.length;
        int[] dp = new int[length];
        int temp = experience[0];
        // x + temp > arr[i]  ==> x > arr[i] - temp ==> x = arr[i] - temp + 1;
        dp[0] = experience[0] + 1;

        for (int i = 1; i < length; i++) {
            dp[i] = experience[i] - temp + 1;
            temp += experience[i];
        }
        int minExperience = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i] > minExperience) minExperience = dp[i];
        }
        res += minExperience > initialExperience ? minExperience - initialExperience : 0;
        return res;
    }


    public static void main(String[] args) {
        int[] rowSum = {14, 9};
        int[] colSum = {6, 9, 8};
        int[][] resArr = restoreMatrix(rowSum, colSum);
        for (int i = 0; i < resArr.length; i++) {
            for (int j = 0; j < resArr[0].length; j++) {
                System.out.print(resArr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int columns = colSum.length;
        int[][] resArr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (rowSum[i] == 0) break;
                if (colSum[j] == 0) continue;
                int putNum = Math.min(rowSum[i], colSum[j]);
                resArr[i][j] = putNum;
                rowSum[i] -= putNum;
                colSum[j] -= putNum;
            }
        }
        return resArr;
    }


}
