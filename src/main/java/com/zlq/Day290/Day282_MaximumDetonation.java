package com.zlq.Day290;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/23 10:50
 */
/*
2101. 引爆最多的炸弹
中等
相关标签
相关企业
提示
给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。

炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。

你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。

给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。



示例 1：



输入：bombs = [[2,1,3],[6,1,4]]
输出：2
解释：
上图展示了 2 个炸弹的位置和爆炸范围。
如果我们引爆左边的炸弹，右边的炸弹不会被影响。
但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
示例 2：



输入：bombs = [[1,1,5],[10,10,5]]
输出：1
解释：
引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
示例 3：



输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
输出：5
解释：
最佳引爆炸弹为炸弹 0 ，因为：
- 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
- 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
- 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
所以总共有 5 个炸弹被引爆。


提示：

1 <= bombs.length <= 100
bombs[i].length == 3
1 <= xi, yi, ri <= 105
 */
public class Day282_MaximumDetonation {

	public static void main(String[] args) {
		int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
		int res = maximumDetonation(bombs);
		System.out.println(res);
	}

	public static int maximumDetonation(int[][] bombs) {
		return bfsMethod(bombs);
	}

	private static int bfsMethod(int[][] bombs) {
		Map<Integer, List<Integer>> bombRelatedMap = new HashMap<>();
		relateBomb(bombs, bombRelatedMap);
		int max = 0;
		for (Map.Entry<Integer, List<Integer>> entry : bombRelatedMap.entrySet()) {
			Integer bombIndex = entry.getKey();

			max = Math.max(max, bfs(bombIndex, bombRelatedMap));

		}
		return max;
	}

	private static int dfsMethod(int[][] bombs) {
		Map<Integer, List<Integer>> bombRelatedMap = new HashMap<>();
		relateBomb(bombs, bombRelatedMap);
		int max = 0;
		for (Map.Entry<Integer, List<Integer>> entry : bombRelatedMap.entrySet()) {
			Integer bombIndex = entry.getKey();
			max = Math.max(max,getRelateCnt(bombIndex, bombRelatedMap));
		}
		return max;
	}

	private static int getRelateCnt(Integer bombIndex, Map<Integer, List<Integer>> bombRelatedMap) {
		Set<Integer> explode = new HashSet<>();
		explode.add(bombIndex);
		dfs(bombIndex, bombRelatedMap, explode);
		return explode.size();
	}

	private static void dfs(Integer bombIndex, Map<Integer, List<Integer>> bombRelatedMap, Set<Integer> explode) {
		List<Integer> list = bombRelatedMap.get(bombIndex);
		for (Integer relatedIndex : list) {
			if (!explode.contains(relatedIndex)) {
				explode.add(relatedIndex);
				dfs(relatedIndex, bombRelatedMap, explode);
			}
		}
	}


	public static int bfs(Integer start, Map<Integer, List<Integer>> bombRelatedMap) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[bombRelatedMap.size()];
		int cnt = 1;
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			Integer bombIdx = queue.poll();
			List<Integer> relatedBombs = bombRelatedMap.get(bombIdx);
			for (Integer nextBomb : relatedBombs) {
				if (!visited[nextBomb]){
					queue.offer(nextBomb);
					visited[nextBomb] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void relateBomb(int[][] bombs, Map<Integer, List<Integer>> bombRelatedMap) {
		for (int i = 0; i < bombs.length; i++) {
			int[] explodeBomb = bombs[i];
			bombRelatedMap.putIfAbsent(i, new ArrayList<>());
			for (int j = 0; j < bombs.length; j++) {
				int[] targetBomb = bombs[j];
				if (canDetonate(explodeBomb, targetBomb) && i != j) {
					bombRelatedMap.get(i).add(j);
				}
			}
		}
	}

	private static boolean canDetonate(int[] bomb1, int[] bomb2) {
		long dx = bomb1[0] - bomb2[0];
		long dy = bomb1[1] - bomb2[1];
		long r = bomb1[2];
		return dx * dx + dy * dy <= r * r;
	}

}
