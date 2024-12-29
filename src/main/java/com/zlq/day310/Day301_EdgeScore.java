package com.zlq.day310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/9/21 11:10
 */
/*
2374. 边积分最高的节点
中等
相关标签
相关企业
提示
给你一个有向图，图中有 n 个节点，节点编号从 0 到 n - 1 ，其中每个节点都 恰有一条 出边。

图由一个下标从 0 开始、长度为 n 的整数数组 edges 表示，其中 edges[i] 表示存在一条从节点 i 到节点 edges[i] 的 有向 边。

节点 i 的 边积分 定义为：所有存在一条指向节点 i 的边的节点的 编号 总和。

返回 边积分 最高的节点。如果多个节点的 边积分 相同，返回编号 最小 的那个。



示例 1：


输入：edges = [1,0,0,0,0,7,7,5]
输出：7
解释：
- 节点 1、2、3 和 4 都有指向节点 0 的边，节点 0 的边积分等于 1 + 2 + 3 + 4 = 10 。
- 节点 0 有一条指向节点 1 的边，节点 1 的边积分等于 0 。
- 节点 7 有一条指向节点 5 的边，节点 5 的边积分等于 7 。
- 节点 5 和 6 都有指向节点 7 的边，节点 7 的边积分等于 5 + 6 = 11 。
节点 7 的边积分最高，所以返回 7 。
示例 2：


输入：edges = [2,0,0,2]
输出：0
解释：
- 节点 1 和 2 都有指向节点 0 的边，节点 0 的边积分等于 1 + 2 = 3 。
- 节点 0 和 3 都有指向节点 2 的边，节点 2 的边积分等于 0 + 3 = 3 。
节点 0 和 2 的边积分都是 3 。由于节点 0 的编号更小，返回 0 。


提示：

n == edges.length
2 <= n <= 105
0 <= edges[i] < n
edges[i] != i
 */
public class Day301_EdgeScore {

	public static void main(String[] args) {
		String text = "iuvgbmteyivbfwuospxmmgzagfa";
		String pattern = "ti";
		System.out.println(maximumSubsequenceCount(text, pattern));
	}

	public static int edgeScore(int[] edges) {

		Map<Integer, Long> map = new TreeMap<>();
		int length = edges.length;
		for (int i = 0; i < length; i++) {
			map.putIfAbsent(edges[i], 0L);
			Long val = map.get(edges[i]);
			map.put(edges[i], val + i);
		}

		Long maxVal = 0L;
		int maxNode = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Long> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Long value = entry.getValue();
			if (value > maxVal) {
				maxVal = value;
				maxNode = key;
			}
			if (value == maxVal && key < maxNode) {
				maxNode = key;
			}
		}
		return maxNode;
	}

	public static int edgeScore2(int[] edges) {
		long[] idxArr = new long[1000000];
		int length = edges.length;

		for (int i = 0; i < length; i++) {
			idxArr[edges[i]] += i;
		}

		Long max = 0L;
		int maxPoint = 0;
		for (int i = 0; i < idxArr.length; i++) {
			long val = idxArr[i];
			if (val > max) {
				max = val;
				maxPoint = i;
			}
		}
		return maxPoint;
	}


	public static int findJudge(int n, int[][] trust) {
		if (trust.length == 0 && n == 1) {
			return 1;
		}

		int[] innerArr = new int[n + 1];
		int[] outerArr = new int[n + 1];

		for (int[] ele : trust) {
			int person = ele[0];
			int trustedPerson = ele[1];

			innerArr[person] += 1;
			outerArr[trustedPerson] += 1;
		}

		for (int i = 1; i <= n; i++) {
			if (outerArr[i] == n - 1 && innerArr[i] == 0) {
				return i;
			}
		}
		return -1;
	}

	public static long maximumSubsequenceCount(String text, String pattern) {
		// text = "abdcdbc", pattern = "ac"    acc
		char first = pattern.charAt(0);
		char second = pattern.charAt(1);
		int firstCnt = 0, secondCnt = 0,res = 0;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c == first) {
				res += secondCnt;
				firstCnt++;
			}
			if (c == second) {
				secondCnt++;
			}
		}
		return res + Math.max(firstCnt,secondCnt);
	}


}
