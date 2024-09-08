package com.zlq;

import com.zlq.common.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/14 16:03
 */
public class ShortestTime {

	public static void main(String[] args) {
		int[][] store = {
				{2, 4, 6, 8, 7, 9},
				{3, 8, 9, 1, 4, 5},
				{6, 9, 12, 2, 15, 11},
				{8, 7, 18, 7, 13, 2},
				{7, 2, 10, 4, 3, 7},
				{9, 5, 6, 17, 5, 1}
		};
		ArrayUtils.printGridArr(store);
		getShortestTime2(store);
	}

	/*
	{
	{2,4,6,8,7,9},
	{3,8,9,1,4,5},
	{6,9,12,2,15,11},
	{8,7,18,7,13,2},
	{7,2,10,4,3,7},
	{9,5,6,17,5,1}
	}
	 */
	public static void getShortestTime(int[][] store) {
		List<Integer> routeList = new ArrayList<>();
		int[][] memo = new int[6][6];
		for (int[] row : memo) {
			Arrays.fill(row, 0);
		}
		dfs(store, 0, 0, 0, routeList, memo);

		System.out.println(routeList);
	}

	public static boolean dfs(int[][] store, int i, int j, int totalTime, List<Integer> resList, int[][] memo) {
		int time = store[i][j];
		resList.add(time);
		memo[i][j] = 1;
		if (i == 5 && j == 5) {
			resList.add(time);
			System.out.println(totalTime);
			return true;
		}

		// 向下走
		if (i >= 0 && i < 5 && memo[i + 1][j] == 0) {
			if (dfs(store, i + 1, j, totalTime + time, resList, memo)) {
				return true;
			}
		}

		// 向上走
		if (i > 0 && i < 5 && memo[i - 1][j] == 0) {
			if (dfs(store, i - 1, j, totalTime + time, resList, memo)) {
				return true;
			}
		}

		// 向左走
		if (j > 0 && j < 5 && memo[i][j - 1] == 0) {
			if (dfs(store, i, j - 1, totalTime + time, resList, memo)) {
				return true;
			}
		}

		// 向右走
		if (j >= 0 && j < 5 && memo[i][j + 1] == 0) {
			if (dfs(store, i, j + 1, totalTime + time, resList, memo)) {
				return true;
			}
		}
		// 回溯
		resList.remove(resList.size() - 1);
		totalTime -= store[i][j];
		return false;
	}


	public static void getShortestTime2(int[][] store) {
		int rows = store.length;
		int columns = store[0].length;
		int[][] dp = new int[rows][columns];

		dp[0][0] = store[0][0];
		// 填充第一行
		for (int i = 1; i < columns; i++) {
			dp[0][i] = dp[0][i - 1] + store[0][i];
		}
		// 填充第一列

		for (int i = 1; i < rows; i++) {
			dp[i][0] = dp[i - 1][0] + store[i][0];
		}
		// 填充剩余部分
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + store[i][j];
			}
		}

		ArrayUtils.printGridArr(dp);
		System.out.println("最短时间为" + dp[rows - 1][columns - 1]);


		// 寻找路径

		List<int[]> paths = new ArrayList<>();
		int i = rows - 1,j = columns - 1;
		paths.add(new int[]{i,j});
		while (i > 0 || j > 0){
			if (i == 0){
				j--;
			}else if (j == 0){
				i--;
			}else if (dp[i][j - 1] > dp[i - 1][j]) {
				i--;
			}else {
				j--;
			}
			paths.add(new int[]{i,j});
		}

		System.out.print("最短路径为：");
		for (i = paths.size() - 1; i >= 0;i--){
			int[] path = paths.get(i);
			if (i == 0){
				System.out.print(Arrays.toString(path)) ;
			}else {
				System.out.print(Arrays.toString(path) + "->") ;
			}
		}
	}

}
