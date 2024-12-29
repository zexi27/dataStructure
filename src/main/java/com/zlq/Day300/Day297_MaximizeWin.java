package com.zlq.Day300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/9/11 13:59
 */
/*
2555. 两个线段获得的最多奖品
中等
相关标签
相关企业
提示
在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，它按照 非递减 顺序排列，其中 prizePositions[i] 是第 i 件奖品的位置。数轴上一个位置可能会有多件奖品。再给你一个整数 k 。

你可以同时选择两个端点为整数的线段。每个线段的长度都必须是 k 。你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。

比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。



示例 1：

输入：prizePositions = [1,1,2,2,3,3,5], k = 2
输出：7
解释：这个例子中，你可以选择线段 [1, 3] 和 [3, 5] ，获得 7 个奖品。
示例 2：

输入：prizePositions = [1,2,3,4], k = 0
输出：2
解释：这个例子中，一个选择是选择线段 [3, 3] 和 [4, 4] ，获得 2 个奖品。

提示：

1 <= prizePositions.length <= 105
1 <= prizePositions[i] <= 109
0 <= k <= 109
prizePositions 有序非递减。
 */
public class Day297_MaximizeWin {

	public static void main(String[] args) {
//		nums = [[3,6],[1,5],[4,7]]
		int[] distance = {6, 47, 48, 31, 10, 27, 46, 33, 52, 33, 38, 25, 32, 45, 36, 3, 0, 33, 22, 53, 8, 13, 18, 1, 44,
				41, 14, 5, 38, 25, 48};
		System.out.println(distanceBetweenBusStops(distance, 22, 0));
	}



	/*
	小美在处理一系列字符串时，她需要找到这些字符串中共有的最长前缀。给定一个字符串数组，请编写一个函数来帮助小美找出这个数组中所有字符串共同拥有的最长前缀字符串。

	如果这些字符串之间不存在公共前缀，那么函数应该返回空字符串 ""

	备注
	1 <= strs.length <= 200

	0 <= strs[i].length <= 200

	strs[i] 仅由小写英文字母组成

	示例1
	输入
	strs = ["meituan","dianping","xiaoxiang"]
	输出
	""
	解释
	输入不存在公共前缀
	示例2
	输入
	strs = ["ab","abc","abcd"]
	输出
	"ab"
	 */


	public static String longestCommonPrefix(String[] strs) {
		// write your code here.
		// 找到元素中长度最短的
		int minLen = 200;
		int length = strs.length;
		for (int i = 0; i < strs.length; i++) {
			minLen = Math.min(minLen, strs[i].length());
		}

		// 初始化窗口大小
		int windowSize = minLen;
		while (windowSize > 0) {
			boolean vaild = true;
			String compared = strs[0].substring(0, windowSize);

			for (int i = 1; i < length; i++) {
				String str = strs[i];
				String substring = str.substring(0, windowSize);
				if (!substring.equals(compared)) {
					vaild = false;
				}
			}
			if (vaild) {
				break;
			}
			windowSize--;
		}
		return strs[0].substring(0, windowSize);
	}


	public static int numberOfPoints(List<List<Integer>> nums) {
		int[] idxArr = new int[100];

		for (int i = 0; i < nums.size(); i++) {
			List<Integer> rangeList = nums.get(i);
			int start = rangeList.get(0);
			int end = rangeList.get(1);

			for (int j = start; j <= end; j++) {
				idxArr[j]++;
			}
		}

		int res = 0;
		for (int idx : idxArr) {
			if (idx > 0) {
				res++;
			}
		}
		return res;
	}

	public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int sum = Arrays.stream(distance).sum();
		int length = distance.length;
		int res = 0;
		if (start < destination) {
			res = Arrays.stream(Arrays.copyOfRange(distance, start, destination)).sum();
			return Math.min(res, sum - res);
		} else {
			for (int i = start; i < length; i++) {
				res += distance[i];
			}
			for (int i = 0; i < destination; i++) {
				res += distance[i];
			}
			return Math.min(res, sum - res);
		}

	}

	public String[] uncommonFromSentences(String s1, String s2) {
		List<String> resList = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		for (String ele : s1.split(" ")) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}

		for (String ele : s2.split(" ")) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			String ele = entry.getKey();
			Integer count = entry.getValue();
			if (count == 1) {
				resList.add(ele);
			}
		}

		String[] resArr = new String[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
			resArr[i] = resList.get(i);
		}
		return resArr;
	}

}


