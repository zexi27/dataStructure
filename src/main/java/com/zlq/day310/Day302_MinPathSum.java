package com.zlq.day310;

import java.util.Arrays;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/9/25 22:26
 */
/*
64. Minimum Path Sum
Medium
Topics
Companies
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
 */
public class Day302_MinPathSum {

	public static void main(String[] args) {
		int[][] grid =
				{{1, 3, 1},{1, 5, 1},{4, 2, 1}};
		System.out.println(minPathSum3(grid));
	}
	public static int minPathSum(int[][] grid) {
		return dfs(0, 0, grid);
	}

	private static int dfs(int i, int j, int[][] grid) {
		// 如果当前位置到达右下角直接返回当前格子的值
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return grid[i][j];
		}
		// 如果当前位置超出范围，返回一个很大的值，因此在比较的过程中可以取最小的
		if (i >= grid.length || j >= grid[0].length) {
			return Integer.MAX_VALUE;
		}

		// 向右
		int right = dfs(i, j + 1, grid);
		// 向下
		int down = dfs(i + 1, j, grid);
		return grid[i][j] + Math.min(right, down);
	}

	public static int minPathSum2(int[][] grid) {
		int[][] memo = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(memo[i],-1);
		}
		return dfs2(0, 0, grid, memo);
	}

	private static int dfs2(int i, int j, int[][] grid, int[][] memo) {
		// 如果当前位置到达右下角直接返回当前格子的值
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return grid[i][j];
		}
		// 如果当前位置超出范围，返回一个很大的值，因此在比较的过程中可以取最小的
		if (i >= grid.length || j >= grid[0].length) {
			return Integer.MAX_VALUE;
		}

		if (memo[i][j] != -1){
			return memo[i][j];
		}
		memo[i][j] = grid[i][j] + Math.min(dfs2(i,j + 1,grid,memo),dfs2(i + 1,j,grid,memo));
		return memo[i][j];
	}


	public static int minPathSum3(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] += Math.min(dp[i][j - 1],dp[i - 1][j]) + grid[i][j];
			}
		}
		return dp[grid.length - 1][grid[0].length - 1];
	}
}
