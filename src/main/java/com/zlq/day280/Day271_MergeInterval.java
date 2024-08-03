package com.zlq.day280;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@description:
 *@author: ZhangLiqun
 *@date: 2023/8/29 23:05
 */
/*
56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.


Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
public class Day271_MergeInterval {

	public static void main(String[] args) {

		int[][] intervals = {{2, 3}, {4, 5},{6, 7}, {8, 9}, {1, 10}};
		int[][] res = merge(intervals);
		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}

	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

		List<int[]> intervalList = new ArrayList<>();
		for (int[] interval : intervals) {
			intervalList.add(interval);
		}
		List<int[]> mergedList = new ArrayList<>();
		int size = intervalList.size();
		int l = 0, r = 0;
		while (l < size) {
			while (r < size - 1 && isOverlap(intervalList.get(r), intervalList.get(r + 1))) {
				r++;
			}
			int[] arrL = intervalList.get(l);
			int[] arrR = intervalList.get(r);
			int[] mergedArr = new int[]{arrL[0] > arrR[0]? arrR[0]:arrL[0],arrL[1] > arrR[1] ? arrL[1]:arrR[1]};
			mergedList.add(mergedArr);
			l = r + 1;
			r = l;
		}
		int[][] resArr = new int[mergedList.size()][2];
		for (int i = 0; i < mergedList.size(); i++) {
			resArr[i] = mergedList.get(i);
		}
		return resArr;
	}

	public static boolean isOverlap(int[] before, int[] after) {
		if (before[1] >= after[0]) {
			return true;
		}
		return false;
	}
}
