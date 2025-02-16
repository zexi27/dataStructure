package com.zlq.day320;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/2/10 21:22
 */
/*
93. 复原 IP 地址
中等
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。



示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


提示：

1 <= s.length <= 20
s 仅由数字组成
 */
public class Day318_RestoreIpAddresses {

	public static void main(String[] args) {
		String s = "25525511135";
		Day318_RestoreIpAddresses restoreIpAddresses = new Day318_RestoreIpAddresses();
		System.out.println(restoreIpAddresses.restoreIpAddresses(s));
	}


	List<String> result = new ArrayList<>();
	List<String> segments = new ArrayList<>();
	public List<String> restoreIpAddresses(String s) {
		backtrack(s, 0);
		return result;
	}

	private void backtrack(String s, int curIdx) {
		if (segments.size() == 4) {
			if (curIdx == s.length()) {
				result.add(String.join(".", segments));
			}
			return;
		}

		int remainChars = s.length() - curIdx;
		int remainSegments = 4 - segments.size();
		if (remainChars < remainSegments || remainChars > remainSegments * 3) {
			return;
		}

		for (int length = 1; length <= 3; length++) {
			int endIdx = curIdx + length;
			if (endIdx > s.length()) {
				break;
			}
			String segment = s.substring(curIdx, endIdx);
			if (isValid(segment)) {
				segments.add(segment);
				backtrack(s, endIdx);
				segments.remove(segments.size() - 1);
			}
		}
	}

	public boolean isValid(String s) {
		if (s.startsWith("0") && s.length() > 1) {
			return false;
		}
		Integer num = Integer.valueOf(s);
		return num >= 0 && num <= 255;
	}


	public static int[] replaceElements(int[] arr) {
		// [17,18,5,4,6,1]
		// [18,17,6,5,4,1]
		int length = arr.length;
		int[] resArr = new int[length];
		resArr[length - 1] = -1;
		for (int i = arr.length - 2; i >= 0; i--) {
			resArr[i] = Math.max(resArr[i + 1], arr[i + 1]);
		}
		return resArr;
	}
}
