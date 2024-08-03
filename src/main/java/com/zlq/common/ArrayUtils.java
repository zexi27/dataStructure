package com.zlq.common;

import java.util.Arrays;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/15 10:42
 */
public class ArrayUtils {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{1, 2, 3},{4,5,6},{7,8,9}};
		printGridArr(arr);
	}
	public static void printArr(int[] arr){
		StringBuilder resBuilder = new StringBuilder();
		resBuilder.append("{");
		for (int i = 0; i < arr.length; i++) {
			resBuilder.append(arr[i]);
			if (i < arr.length - 1){
				resBuilder.append(",");
			}
		}
		resBuilder.append("}");
		System.out.println(resBuilder);
	}

	public static void printGridArr(int[][] arr){
		StringBuilder resBuilder = new StringBuilder();
		resBuilder.append("{");
		resBuilder.append("\n");
		for (int i = 0; i < arr.length; i++) {
			resBuilder.append("\t");
			resBuilder.append("{");
			for (int j = 0; j < arr[i].length; j++) {
				int ele = arr[i][j];
				resBuilder.append(ele);
				if (j < arr[i].length - 1){
					resBuilder.append(",");
				}
			}
			resBuilder.append("}");
			resBuilder.append("\n");
		}
		resBuilder.append("}");
		System.out.println(resBuilder);
	}

}
