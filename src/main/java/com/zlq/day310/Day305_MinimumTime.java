package com.zlq.day310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/10/5 19:38
 */
/*
2187. 完成旅途的最少时间
中等
相关标签
相关企业
提示
给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。

每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。

给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。



示例 1：

输入：time = [1,2,3], totalTrips = 5
输出：3
解释：
- 时刻 t = 1 ，每辆公交车完成的旅途数分别为 [1,0,0] 。
  已完成的总旅途数为 1 + 0 + 0 = 1 。
- 时刻 t = 2 ，每辆公交车完成的旅途数分别为 [2,1,0] 。
  已完成的总旅途数为 2 + 1 + 0 = 3 。
- 时刻 t = 3 ，每辆公交车完成的旅途数分别为 [3,1,1] 。
  已完成的总旅途数为 3 + 1 + 1 = 5 。
所以总共完成至少 5 趟旅途的最少时间为 3 。
示例 2：

输入：time = [2], totalTrips = 1
输出：2
解释：
只有一辆公交车，它将在时刻 t = 2 完成第一趟旅途。
所以完成 1 趟旅途的最少时间为 2 。


提示：

1 <= time.length <= 105
1 <= time[i], totalTrips <= 107
 */
public class Day305_MinimumTime {


	public static long minimumTime(int[] time, int totalTrips) {
//		Arrays.sort(time);
		long l = 1, r = (long) totalTrips * Arrays.stream(time).max().orElse(0);
		while (l < r) {
			long mid = l + (r - l) / 2;
			if (check(mid, time, totalTrips)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		return l;

	}

	public static boolean check(long curTime, int[] time, int totalTrips) {
		long res = 0;
		for (int ele : time) {
			res += curTime / ele;
			if (res >= totalTrips) {
				return true;
			}
		}
		return res >= totalTrips;
	}

	static Map<Integer, char[]> map = new HashMap<Integer, char[]>() {{
		put(1, new char[]{'I', 'V'});
		put(2, new char[]{'X', 'L'});
		put(3, new char[]{'C', 'D'});
		put(4, new char[]{'M'});
	}};

	public static String intToRoman(int num) {
		StringBuilder resBuilder = new StringBuilder();
		List<Integer> splitList = splitNum(num);
		for (int i = splitList.size() - 1; i >= 0; i--) {
			String numStr = String.valueOf(splitList.get(i));
			int length = numStr.length();
			char firstChar = numStr.charAt(0);
			if (firstChar == '4' || firstChar == '9') {
				if (firstChar == '4'){
					resBuilder.append(map.get(length)[0]).append(map.get(length)[1]);
				}else {
					resBuilder.append(map.get(length)[0]).append(map.get(length + 1)[0]);
				}
			}else {
				if (firstChar - '0' >= 5){
					resBuilder.append(map.get(length)[1]);
					for (int j = 0; j < firstChar -'0' - 5; j++) {
						resBuilder.append(map.get(length)[0]);

					}
				}else {
					for (int j = 0; j < firstChar - '0'; j++) {
						resBuilder.append(map.get(length)[0]);
					}
				}

			}
		}
		return resBuilder.toString();
	}

	public static List<Integer> splitNum(int num) {
		List<Integer> resList = new ArrayList<>();
		String numStr = String.valueOf(num);
		int length = numStr.length();
		for (int i = length; i >= 1; i--) {
			int split = (numStr.charAt(i - 1) - '0') * (int) Math.pow(10, length - i);
			resList.add(split);
		}
		return resList;
	}

	public static void main(String[] args) {
		int num = 3749;
		System.out.println(intToRoman(num));
	}
}
