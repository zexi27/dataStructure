package com.zlq.Day290;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/29 09:36
 */
/*
1395. Count Number of Teams
Medium
Topics
Companies
Hint
There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).



Example 1:

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
Example 2:

Input: rating = [2,1,3]
Output: 0
Explanation: We can't form any team given the conditions.
Example 3:

Input: rating = [1,2,3,4]
Output: 4

 */
public class Day290_NumTeams {

	public static void main(String[] args) {
		int[] rating = {2,5,3,4,1};
		System.out.println(numTeams(rating));
	}

	public static int numTeams(int[] rating) {
		int length = rating.length;
		Map<Integer, List<Integer>> greaterMap = new HashMap<>();
		Map<Integer, List<Integer>> lessMap = new HashMap<>();
		for (int i = 0; i < length ; i++) {
			int refVal = rating[i];
			greaterMap.put(refVal, new ArrayList<>());
			lessMap.put(refVal, new ArrayList<>());
			for (int j = i; j < length; j++) {
				int comparedVal = rating[j];
				if (comparedVal > refVal) {
					greaterMap.get(refVal).add(comparedVal);
				}
				if (comparedVal < refVal) {
					lessMap.get(refVal).add(comparedVal);
				}
			}
		}

		int res = 0;
		for (Entry<Integer, List<Integer>> entry : greaterMap.entrySet()) {
			List<Integer> valList = entry.getValue();
			int valSize = valList.size();
			if (valSize >= 2) {
				for (int i = 0; i < valSize; i++) {
					res += greaterMap.get(valList.get(i)).size();
				}
			}
		}

		for (Entry<Integer, List<Integer>> entry : lessMap.entrySet()) {
			List<Integer> valList = entry.getValue();
			int valSize = valList.size();
			if (valSize >= 2) {
				for (int i = 0; i < valSize; i++) {
					res += lessMap.get(valList.get(i)).size();
				}
			}
		}
		return res;
	}

}
