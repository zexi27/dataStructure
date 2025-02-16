package com.zlq.day320;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/2/16 19:13
 */

/*
1072. Flip Columns For Maximum Number of Equal Rows
You are given an m x n binary matrix matrix.

You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).

Return the maximum number of rows that have all values equal after some number of flips.



Example 1:

Input: matrix = [[0,1],
				 [1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.
Example 2:

Input: matrix = [[0,1],
				 [1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.
Example 3:

Input: matrix = [[0,0,0],
				 [0,0,1],
				 [1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is either 0 or 1.
 */
public class Day319_MaxEqualRowsAfterFlips {

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1},
				{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
				{1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1},
				{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
				{1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}
		};
		int[] arr = {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		System.out.println(maxEqualRowsAfterFlips(matrix));
	}

	/*
	配对，什么是配对？ 比如 [0,0,1] 和 [1,1,0]、[1,0,0] 和 [0,1,1]、[1,0,1] 和 [0,1,0]

	[
	[1,0,0,0,1,1,1,0,1,1,1],
	[1,0,0,0,1,0,0,0,1,0,0],
	[1,0,0,0,1,1,1,0,1,1,1],
	[1,0,0,0,1,0,0,0,1,0,0],
	[1,1,1,0,1,1,1,0,1,1,1]
	]
	 */
	public static int maxEqualRowsAfterFlips(int[][] matrix) {
		Map<String, Integer> map = new HashMap<>();
		for (int[] segment : matrix) {
			char[] chars = new char[segment.length];
			for (int i = 0; i < segment.length; i++) {
				chars[i] = (char) segment[i];
			}
			String key = new String(chars);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		int max = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			String segment = entry.getKey();
			Integer cnt = entry.getValue();
			// 将segment里面的元素全部翻转
			char[] segmentChar = segment.toCharArray();
			for (int i = 0; i < segmentChar.length; i++) {
				segmentChar[i] = (char)(segmentChar[i] ^ 1);
			}
			String reverseKey = new String(segmentChar);
			Integer pairCnt = map.get(reverseKey) == null ? 0 : map.get(reverseKey);
			max = Math.max(max, cnt + pairCnt);
		}
		return max == 0 ? 1 : max;
	}


}
