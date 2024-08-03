package com.zlq.Day290;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javafx.util.Pair;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/28 10:01
 */
/*
ou are given an integer n denoting the number of cities in a country. The cities are numbered from 0 to n - 1.

You are also given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.

You need to assign each city with an integer value from 1 to n, where each value can only be used once. The importance of a road is then defined as the sum of the values of the two cities it connects.

Return the maximum total importance of all roads possible after assigning the values optimally.



Example 1:


Input: n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
Output: 43
Explanation: The figure above shows the country and the assigned values of [2,4,5,3,1].
- The road (0,1) has an importance of 2 + 4 = 6.
- The road (1,2) has an importance of 4 + 5 = 9.
- The road (2,3) has an importance of 5 + 3 = 8.
- The road (0,2) has an importance of 2 + 5 = 7.
- The road (1,3) has an importance of 4 + 3 = 7.
- The road (2,4) has an importance of 5 + 1 = 6.
The total importance of all roads is 6 + 9 + 8 + 7 + 7 + 6 = 43.
It can be shown that we cannot obtain a greater total importance than 43.
Example 2:


Input: n = 5, roads = [[0,3],[2,4],[1,3]]
Output: 20
Explanation: The figure above shows the country and the assigned values of [4,3,2,5,1].
- The road (0,3) has an importance of 4 + 5 = 9.
- The road (2,4) has an importance of 2 + 1 = 3.
- The road (1,3) has an importance of 3 + 5 = 8.
The total importance of all roads is 9 + 3 + 8 = 20.
It can be shown that we cannot obtain a greater total importance than 20.

 */
public class Day289_MaximumImportance {

	public static void main(String[] args) {
//		int n = 8;
//		int[][] edges = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
//		System.out.println(getAncestors(n,edges));
//		int[] nums1 = {1, 2, 2, 1};
//		int[] nums2 = {2, 2};
		int[] nums = {82, 81, 95, 75, 20};
		System.out.println(minDifference(nums));
		System.out.println("最后活下来的囚犯为:" + getNum(126) + " 号");

	}

	public static long maximumImportance(int n, int[][] roads) {
		long sum = 0;
		long[] degree = new long[n];

		for (int[] road : roads) {
			degree[road[0]]++;
			degree[road[1]]++;
		}
		Queue<Pair<Integer, Long>> queue = new PriorityQueue<>((o1, o2) -> (int) (o2.getValue() - o1.getValue()));

		for (int i = 0; i < degree.length; i++) {
			queue.add(new Pair<>(i, degree[i]));
		}

		int[] arr = new int[n + 1];

		while (!queue.isEmpty()) {
			arr[queue.peek().getKey()] = n--;
			queue.remove();
		}

		for (int[] r : roads) {
			sum += arr[r[0]] + arr[r[1]];
		}
		return sum;
	}


	public static List<List<Integer>> getAncestors(int n, int[][] edges) {
		List<Set<Integer>> tempList = new ArrayList<>();
		Map<Integer, Set<Integer>> refernceMap = new HashMap<>();
		Map<Integer, Set<Integer>> memo = new HashMap<>();
		for (int[] edge : edges) {
			int first = edge[0];
			int second = edge[1];
			refernceMap.putIfAbsent(second, new HashSet<>());
			refernceMap.get(second).add(first);
		}

		for (int i = 0; i < n; i++) {
			Set<Integer> subSet = getAllElements(refernceMap, memo, i);
			tempList.add(subSet);
		}
		List<List<Integer>> resList = new ArrayList<>();
		for (Set<Integer> set : tempList) {
			List<Integer> subList = set.stream().collect(Collectors.toList()).stream().sorted()
					.collect(Collectors.toList());
			resList.add(subList);
		}
		return resList;
	}

	private static Set<Integer> getAllElements(Map<Integer, Set<Integer>> refernceMap, Map<Integer, Set<Integer>> memo,
			Integer element) {
		if (memo.containsKey(element)) {
			return memo.get(element);
		}
		Set<Integer> assessors = new HashSet<>();
		Set<Integer> directAssessors = refernceMap.get(element);
		if (null != directAssessors) {
			for (Integer assessor : directAssessors) {
				assessors.add(assessor);
				assessors.addAll(getAllElements(refernceMap, memo, assessor));
			}
		}
		memo.put(element, assessors);
		return assessors;
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			int num = nums1[i];
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer> resList = new ArrayList<>();

		for (int i = 0; i < nums2.length; i++) {
			int num = nums2[i];
			Integer cnt = map.get(num);
			if (cnt != null && cnt >= 1) {
				resList.add(num);
				map.put(num, map.getOrDefault(num, 0) - 1);
			}
		}

		int[] resArr = resList.stream().mapToInt(Integer::intValue).toArray();
		return resArr;
	}

	public static int[] intersect2(int[] nums1, int[] nums2) {
		int[] indexArr = new int[1001];
		int[] resArr = new int[1001];
		for (int num : nums1) {
			indexArr[num]++;
		}

		int index = 0;
		for (int num : nums2) {
			Integer cnt = indexArr[num];
			if (cnt > 0) {
				resArr[index++] = num;
				indexArr[num]--;
			}
		}

		resArr = Arrays.copyOfRange(resArr, 0, index);
		return resArr;
	}


	public static int maximumPrimeDifference(int[] nums) {
		int length = nums.length;
		int first = 0, tail = length - 1;
		while (first < length - 1 && !isPrime(nums[first])) {
			first++;
		}
		while (tail > 0 && !isPrime(nums[tail])) {
			tail--;
		}

		return tail - first;

	}

	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}


	//	  [1,3,5,5,8,9,10,11,11]
	// [0,1,5,10,14]
	// 6,6,0,1,1,4,6 [0,1,1,4,6,6,6]
	/*
	82,81,95,75,20
	20,75,81,82,95,97
	 */
	public static int minDifference(int[] nums) {
		int length = nums.length;
		if (length <= 4) {
			return 0;
		}

		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		for (int l = 0, r = length - 4; l < 4; l++, r++) {
			minDiff = Math.min(minDiff, nums[r] - nums[l]);
		}

		return minDiff;
	}


	public static Integer getNum(int personCount) {
		Set<Integer> personSet = new TreeSet<>(Comparator.comparingInt(o -> o));

		for (int i = 1; i <= personCount; i++) {
			personSet.add(i);
		}

		int round = 1;
		while (personSet.size() > 1) {
//			System.out.println("开始进行第 "+round++ +" 轮枪毙");
			// 2,4,6,8,10
			// 1,2,3,4,5
			// 奇数枪毙，偶数或者并重新排号

			// 第一轮1~100 第二轮 1·50 第三轮 1~25 第四轮 1~12
			List<Integer> removeList = new ArrayList<>(); // 记录移除的人员号码
			int index = 1;
			for (Integer personNum : personSet) {
				if (index % 2 == 1) { // 奇数人员枪毙，从map中移除
					removeList.add(personNum);
				}
				index++;
			}

			// 开始进行移除
			for (Integer removeNum : removeList) {
				personSet.remove(removeNum);
//				System.out.println(removeNum + " 号员工已经移除");
			}
			round++;
		}

		return personSet.iterator().next();
	}


	public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
		int[] indexArr1 = new int[101];
		int[] indexArr2 = new int[101];

		for (int i = 0; i < nums1.length; i++) {
			indexArr1[nums1[i]]++;
		}
		for (int i = 0; i < nums2.length; i++) {
			indexArr2[nums2[i]]++;
		}

		int res0 = 0, res1 = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (indexArr2[nums1[i]] > 0) {
				res0++;
			}
		}

		for (int i = 0; i < nums2.length; i++) {
			if (indexArr1[nums2[i]] > 0) {
				res1++;
			}
		}
		return new int[]{res0, res1};
	}

}
