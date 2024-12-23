package com.zlq.day310;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/10/6 13:20
 */
/*
134. 加油站
中等
相关标签
相关企业
在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。



示例 1:

输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
输出: 3
解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。
示例 2:

输入: gas = [2,3,4], cost = [3,4,3]
输出: -1
解释:
你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。

提示:

gas.length == n
cost.length == n
1 <= n <= 10^5
0 <= gas[i], cost[i] <= 104
 */
public class Day306_CanCompleteCircuit {

	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
		Iterator<Integer> iterator = list.stream().iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			System.out.println(next);
		}
	}

	/*
	int[] gas = {2, 5, 1, 6, 6, 2, 3};
	int[] cost = {5, 3, 5, 1, 3, 1, 5};
	int[] gainArr = {1, -3, 1, -2, 3};

	[-3,2,-4,5,3,1,-2]
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int length = gas.length;
		int[] gainArr = new int[length];
		for (int i = 0; i < length; i++) {
			gainArr[i] = gas[i] - cost[i];
		}
		int total = 0;
		for (int ele : gainArr) {
			total += ele;
		}

		if (total < 0) {
			return -1;
		}
		int l = 0, r = 0;
		while (l < length - 1 && gainArr[l] <= 0) {
			l++;
		}
		r = l;
		int sum = 0;
		int cnt = 0;
		while (cnt != length) {
			if (r > length - 1) {
				r = 0;
			}
			sum += gainArr[r];
			cnt++;
			r++;
			if (sum < 0) {
				l = r;
				sum = 0;
				cnt = 0;
			}

		}
		return r > length - 1 ? 0 : r;
	}


	public static int minLength(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!stack.isEmpty() && (stack.peek() == 'A' && c == 'B' || stack.peek() == 'C' && c == 'D')) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.size();
	}
}
