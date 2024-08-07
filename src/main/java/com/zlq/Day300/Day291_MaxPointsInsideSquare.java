package com.zlq.Day300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/3 12:28
 */
public class Day291_MaxPointsInsideSquare {

	public static void main(String[] args) {
		int[][] points = {{10, -12}, {-5, -4}, {-7, 15}, {9, 16}};
		String s = "dada";
		System.out.println(maxPointsInsideSquare(points, s));
	}

	public static int maxPointsInsideSquare(int[][] points, String s) {
		Map<Character, List<Integer>> pointMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			pointMap.putIfAbsent(c, new ArrayList<>());
			int[] point = points[i];
			int level = getMaxLevel(point);
			pointMap.get(c).add(level);
		}

		boolean hasRepeat = false;
		int resLevel = Integer.MAX_VALUE;
		for (Entry<Character, List<Integer>> entry : pointMap.entrySet()) {
			List<Integer> levelList = entry.getValue();
			if (levelList.size() > 1) {
				hasRepeat = true;
				levelList = levelList.stream().sorted().collect(Collectors.toList());
				resLevel = Math.min(resLevel, levelList.get(1) - 1);
			}
		}
		if (resLevel == 0 && !hasRepeat){
			return points.length;
		}
		int cnt = 0;
		for (Entry<Character, List<Integer>> entry : pointMap.entrySet()) {
			for (Integer ele : entry.getValue()) {
				if (ele <= resLevel){
					cnt ++;
				}
			}
		}
		return cnt;
	}

	public static int getMaxLevel(int[] ele) {
		return Math.max(Math.abs(ele[0]), Math.abs(ele[1]));
	}

}
