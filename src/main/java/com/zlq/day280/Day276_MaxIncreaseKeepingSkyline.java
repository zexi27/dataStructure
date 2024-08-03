package com.zlq.day280;

import com.zlq.common.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/15 10:23
 */
public class Day276_MaxIncreaseKeepingSkyline {

	public static void main(String[] args) {
		int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
		System.out.println(maxIncreaseKeepingSkyline(grid));
	}

	/*
	[3,0,8,4]
	[2,4,5,7]
	[9,2,6,3]
	[0,3,1,0]

			[8, 4, 8, 7],
			[7, 4, 7, 7],
			[9, 4, 8, 7],
			[3, 3, 3, 3]
	 */
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int length = grid.length;

		int[] rowMax = new int[length];
		int[] columnMax = new int[length];

//		for (int i = 0; i < length; i++) {
//			int[] row = grid[i];
//			int maxEle = 0;
//			for (int ele : row) {
//				maxEle = Math.max(maxEle, ele);
//			}
//			rowMax[i] = maxEle;
//		}
//
//		for (int j = 0; j < length; j++) {
//			int maxEle = 0;
//			for (int i = 0; i < length; i++) {
//				int ele = grid[i][j];
//				maxEle = Math.max(maxEle, ele);
//			}
//			columnMax[j] = maxEle;
//		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				int ele = grid[i][j];
				rowMax[i] = Math.max(rowMax[i], ele);
				rowMax[j] = Math.max(rowMax[j], ele);
			}
		}

		int[][] resArr = new int[length][length];
		int res = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				resArr[i][j] = Math.min(rowMax[i], columnMax[j]);
				res += resArr[i][j] - grid[i][j];
			}
		}
		return res;
	}

}
