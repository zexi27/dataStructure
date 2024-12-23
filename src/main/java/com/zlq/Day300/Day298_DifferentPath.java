package com.zlq.Day300;

import java.util.Arrays;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/9/17 09:48
 */
/*
62. 不同路径
中等
相关标签
相关企业
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

示例 1：

输入：m = 3, n = 7
输出：28
示例 2：

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
示例 3：

输入：m = 7, n = 3
输出：28
示例 4：

输入：m = 3, n = 3
输出：6


提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109
 */
public class Day298_DifferentPath {

	public static void main(String[] args) {
		int m = 3, n = 7;
		System.out.println(uniquePaths3(m, n));
	}

	public static int uniquePaths(int m, int n) {
		return dfs(0, 0, m, n);
	}

	private static int dfs(int i, int j, int m, int n) {
		if (i >= m || j >= n) {
			return 0;
		}

		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		int left = dfs(i + 1, j, m, n);
		int right = dfs(i, j + 1, m, n);
		return left + right;
	}


	public static int uniquePaths2(int m, int n) {
		int[][] memo = new int[m][n];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		return dfs2(0, 0, m, n, memo);
	}

	public static int dfs2(int i, int j, int m, int n, int[][] memo) {
		// 如果越界了，返回 0
		if (i >= m || j >= n) {
			return 0;
		}
		// 如果到达了右下角，返回 1
		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		// 如果这个位置已经计算过了，直接返回缓存结果
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		// 计算右边和下边的路径数，并存储结果
		memo[i][j] = dfs2(i + 1, j, m, n, memo) + dfs2(i, j + 1, m, n, memo);
		return memo[i][j];
	}



	public static int uniquePaths3(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

}
