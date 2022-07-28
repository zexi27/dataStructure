package com.zlq.day70;

import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day70
 * @ClassName: Day70_SkyLine
 * @description:
 * @author: LiQun
 * @CreateDate:2021/12/13 8:00 下午
 */
/*
给你一座由 n x n 个街区组成的城市，每个街区都包含一座立方体建筑。
给你一个下标从 0 开始的 n x n 整数矩阵 grid ，其中 grid[r][c] 表示坐落于 r 行 c 列的建筑物的 高度 。

城市的 天际线 是从远处观察城市时，所有建筑物形成的外部轮廓。从东、南、西、北四个主要方向观测到的 天际线 可能不同。

我们被允许为 任意数量的建筑物 的高度增加 任意增量（不同建筑物的增量可能不同） 。 高度为 0 的建筑物的高度也可以增加。然而，增加的建筑物高度 不能影响 从任何主要方向观察城市得到的 天际线 。

在 不改变 从任何主要方向观测到的城市 天际线 的前提下，返回建筑物可以增加的 最大高度增量总和 。

 */
public class Day70_SkyLine {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
//        int[][] cloneArr = deepCloneArr(grid);
//        grid[3][3] = 100;
//        print(grid);
//        System.out.println("---------------");
//        print(cloneArr);
        System.out.println(maxIncreaseKeepingSkyline(grid));
//
    }

    /*
    核心就是找到每一个数为核心的十字中的第二大数（包括其自己）
     */
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[][] tempGrid = deepCloneArr(grid);
        int length = grid.length;
        int[][] rowsSortArr = rowsSortArr(grid);
        int[][] columnSortArr = columnSortArr(tempGrid);
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int rowMax = rowsSortArr[i][length - 1];
                int columnMax = columnSortArr[j][length - 1];
                int baseNum = grid[i][j];
                res += Math.min(rowMax,columnMax) - baseNum;
            }
        }
        return res;
    }

    public static int[][] rowsSortArr(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        return grid;
    }

    public static int[][] columnSortArr(int[][] grid) {
        int length = grid.length;
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = grid[j][i];
            }
        }
        return rowsSortArr(arr);
    }


    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[][] deepCloneArr(int[][] arr) {
        int length = arr.length;
        int[][] cloneArr = new int[length][length];
        for (int i = 0; i < length; i++) {
            cloneArr[i] = arr[i].clone();
        }
        return cloneArr;
    }
}
