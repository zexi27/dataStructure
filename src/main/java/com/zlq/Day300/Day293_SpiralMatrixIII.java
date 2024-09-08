package com.zlq.Day300;

import com.zlq.common.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/8 13:23
 */
/*
885. Spiral Matrix III
Medium
Topics
Companies
You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.



Example 1:


Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]
Example 2:


Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

 */
public class Day293_SpiralMatrixIII {

	/*
	[7,8,9]
	[6,1,2]
	[5,4,3]

	[6,1,2] [3,4,5][7,8,9]



	[1 ,2 ,3]
	[4 ,5 ,6]
	[7 ,8 ,9]

	 */
	public static void main(String[] args) {
//		int rows = 3, cols = 3, rStart = 2, cStart = 2;
//		int[][] arr = spiralMatrixIII(rows, cols, rStart, cStart);
//		ArrayUtils.printGridArr(arr);

		int[] nums1 = {1, 3, 7, 1, 7, 5},
				nums2 = {1, 9, 2, 5, 1};
		System.out.println(maxUncrossedLines(nums1, nums2));
	}

	public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		int resCnt = rows * cols;
		int[][] res = new int[resCnt][2];
		int[] centerPoint = {rStart, cStart};

		int curRound = 1, index = 1;
		res[0] = centerPoint;
		int minCol, maxCol, minRow, maxRow;
		while (index < resCnt) {
			minCol = cStart - curRound;
			maxCol = cStart + curRound;
			minRow = rStart - curRound;
			maxRow = rStart + curRound;
			for (int row = minRow + 1; row < maxRow; row++) {
				if (row >= 0 && row <= rows - 1 &&
						maxCol >= 0 && maxCol <= cols - 1) {
					int[] curPoint = {row, maxCol};
					res[index++] = curPoint;
				}
			}

			for (int col = maxCol; col > minCol; col--) {
				if (maxRow >= 0 && maxRow <= rows - 1 &&
						col >= 0 && col <= cols - 1) {
					int[] curPoint = {maxRow, col};
					res[index++] = curPoint;
				}
			}

			for (int row = maxRow; row > minRow; row--) {
				if (row >= 0 && row <= rows - 1 &&
						minCol >= 0 && minCol <= cols - 1) {
					int[] curPoint = {row, minCol};
					res[index++] = curPoint;
				}
			}

			for (int col = minCol; col <= maxCol; col++) {
				if (minRow >= 0 && minRow <= rows - 1 &&
						col >= 0 && col <= cols - 1) {
					int[] curPoint = {minRow, col};
					res[index++] = curPoint;
				}
			}
			curRound++;
		}
		return res;
	}


	public static int maxUncrossedLines(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[][] memo = new int[m + 1][n + 1];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}

		return solve(m, n, nums1, nums2, memo);
	}

	private static int solve(int m, int n, int[] nums1, int[] nums2, int[][] memo) {
		// base case 1
		if (m <= 0 || n <= 0) {
			return 0;
		}

		if (memo[m][n] != -1) {
			return memo[m][n];
		}

		if (nums1[m - 1] == nums2[n - 1]) {
			memo[m][n] =  1 + solve(m - 1, n - 1, nums1, nums2, memo);
		}else {
			memo[m][n] = Math.max(solve(m,n - 1,nums1,nums2,memo),solve(m - 1,n,nums1,nums2,memo));
		}
		return memo[m][n];
	}


}
