package com.zlq.day260;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/6/18 14:30
 */
/*
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.



Example 1:



Input: grid = [
[1,1,1,1,1,1,1,0],
[1,0,0,0,0,1,1,0],
[1,0,1,0,1,1,1,0],
[1,0,0,0,0,1,0,1],
[1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [
[0,0,1,0,0],
[0,1,0,1,0],
[0,1,1,1,0]
]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2


Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
 */
public class Day257_ClosedIsland {

    public static int closedIsland(int[][] grid) {
        // 先将不合法的岛屿填充（有岛屿在边界的- 边界上有0 即为不合法的）
        for (int i = 0; i < grid.length; i++) {
            /*
            如果是第一行和最后一行，访问所有列；如果是其他行，访问第一列和最后一列
             */
            if (i == 0 || i == grid.length - 1) {
                for (int j = 0; j < grid[0].length; j++) {
                    dfs(grid, i, j);
                }
            } else {
                dfs(grid, i, 0);
                dfs(grid, i, grid[0].length - 1);
            }
        }

        // 将合法的岛屿填充，并增加次数
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }


    /*
    相当于填充，碰到0之后，就依次往上下左右填充。越界或者碰到1就返回
     */
    public static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return; // 越界检查
        if (grid[i][j] == 1) return; // 碰到1返回
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
