package com.zlq.day280;

import java.util.Arrays;

/**
 *@description:
 *@author: ZhangLiqun
 *@date: 2023/8/23 22:11
 */
/*
2337. Move Pieces to Obtain a String
提示
中等
135
相关企业
You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:

The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, and a piece 'R' can move to the right only if there is a blank space directly to its right.
The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.



Example 1:

Input: start = "_L__R__R_", target = "L______RR"
Output: true
Explanation: We can obtain the string target from start by doing the following moves:
- Move the first piece one step to the left, start becomes equal to "L___R__R_".
- Move the last piece one step to the right, start becomes equal to "L___R___R".
- Move the second piece three steps to the right, start becomes equal to "L______RR".
Since it is possible to get the string target from start, we return true.
Example 2:

Input: start = "R_L_", target = "__LR"
Output: false
Explanation: The 'R' piece in the string start can move one step to the right to obtain "_RL_".
After that, no pieces can move anymore, so it is impossible to obtain the string target from start.
Example 3:

Input: start = "_R", target = "R_"
Output: false
Explanation: The piece in the string start can move only to the right, so it is impossible to obtain the string target from start.


Constraints:

n == start.length == target.length
1 <= n <= 105
start and target consist of the characters 'L', 'R', and '_'.
 */
public class Day270_CanChange {

	public static void main(String[] args) {
		String start = "_L__R__R_";
		String target = "L______RR";
		System.out.println(canChange(start, target));
//		String s = "___L______RR";
//		char[] charArray = s.toCharArray();
////		rightRemoveL(charArray,7);
//		leftRemoveL(charArray, 3);
//		System.out.println(Arrays.toString(charArray));
	}

	public static boolean canChange(String start, String target) {
		char[] targetArr = target.toCharArray();
		char[] charArray = start.toCharArray();
		changeArr(charArray);
		changeArr(targetArr);

		return Arrays.equals(charArray, targetArr);
	}


	private static void leftRemoveL(char[] charArray, int l) {
		int index = l - 1;
		if (index < 0) {
			return;
		}
		if (index >= 0 && charArray[index] != '_') {
			return; // 如果紧邻L有字母，就不移动，直接返回
		}
		while (index > 0 && charArray[index - 1] == '_') {
			index--;
		}
		charArray[index] = 'L';
		charArray[l] = '_';
	}

	public static char[] changeArr(char[] charArray) {
		int length = charArray.length;
		for (int i = 0; i < length; i++) {
			if (charArray[i] == 'L') {
				leftRemoveL(charArray, i);
			} else if (charArray[i] == 'R') {
				rightRemoveL(charArray, i);
			}

		}
		for (int i = length - 1; i >= 0; i--) {
			if (charArray[i] == 'L') {
				leftRemoveL(charArray, i);
			} else if (charArray[i] == 'R') {
				rightRemoveL(charArray, i);
			}

		}
		return charArray;
	}

	private static void rightRemoveL(char[] charArray, int r) {
		int index = r + 1;
		if (index > charArray.length - 1) {
			return;
		}
		if (index <= charArray.length - 1 && charArray[index] != '_') {
			return; // 如果紧邻R有字母，就不移动，直接返回
		}
		while (index < charArray.length - 1 && charArray[index + 1] == '_') {
			index++;
		}
		charArray[index] = 'R';
		charArray[r] = '_';
	}

}
