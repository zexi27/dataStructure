package com.zlq.day280;

import java.util.Arrays;
import java.util.Map;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/25 12:17
 */
/*
2844. 生成特殊数字的最少操作
中等
相关标签
相关企业
提示
给你一个下标从 0 开始的字符串 num ，表示一个非负整数。

在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。

返回最少需要多少次操作可以使 num 变成特殊数字。

如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。


示例 1：

输入：num = "2245047"
输出：2
解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 2 位数字。
示例 2：

输入：num = "2908305"
输出：3
解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 3 位数字。
示例 3：

输入：num = "10"
输出：1
解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 1 位数字。


提示

1 <= num.length <= 100
num 仅由数字 '0' 到 '9' 组成
num 不含任何前导零

 */
public class Day279_MinimumOperations {

	/*
	- 一位数：必须是0
	- 两位数：必须是25,50,75
	- 三位数及其以上：必须是00，25，50，75结尾
	 */

	public static void main(String[] args) {

		String num = "528033";
		System.out.println(Arrays.toString(find0(num)));
		System.out.println(minimumOperations(num));
	}

	public static int minimumOperations(String num) {
		if (num.equals("0")){
			return 0;
		}

		int[] res0 = find0(num);
		int[] res5 = find5(num);

		int res;
		if (res5[1] == -1) {
			res = res0[1];
		} else if (res0[1] == -1) {
			res = res5[1];
		} else {
			res = Math.min(res0[1], res5[1]);
		}

		if (res == -1) {
			if (res0[0] != -1) {
				return num.length() - 1;
			} else{
				return num.length();
			}
		}
		return res;
	}

	public static int[] find0(String num) {
		int[] res = {-1, -1};
		int length = num.length();
		int r = length - 1, l = r;
		while (l >= 0) {
			while (r >= 0 && num.charAt(r) != '0') {
				r--;
			}
			if (r > 0) { // 找到0
				res[0] = r;
			}
			l = r - 1;

			while (l >= 0 && num.charAt(l) != '5' && num.charAt(l) != '0') {
				l--;
			}
			if (l >= 0) { // 找到5或0
				res[1] = length - l - 2;
				break;
			}
		}
		return res;
	}


	public static int[] find5(String num) {
		int[] res = {-1, -1};
		int length = num.length();
		int r = length - 1, l = r;
		while (l >= 0) {
			while (r >= 0 && num.charAt(r) != '5') {
				r--;
			}
			if (r >= 0) { // 找到5
				res[0] = r;
			}
			l = r - 1;

			while (l >= 0 && (num.charAt(l) != '7' && num.charAt(l) != '2')) {
				l--;
			}
			if (l >= 0) { // 找到7或2
				res[1] = length - 2 - l;
				break;
			}
		}
		return res;
	}

	public static int findValueOfPartition(int[] nums) {
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;

		for (int i = 1; i < nums.length; i++) {
			minDiff = Math.min(minDiff,nums[i] - nums[i - 1]);
		}
		return minDiff;
	}



}
