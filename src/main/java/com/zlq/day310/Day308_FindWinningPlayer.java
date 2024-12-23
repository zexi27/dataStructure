package com.zlq.day310;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/10/24 20:11
 */
/*
3175. 找到连续赢 K 场比赛的第一位玩家
中等
提示
有 n 位玩家在进行比赛，玩家编号依次为 0 到 n - 1 。

给你一个长度为 n 的整数数组 skills 和一个 正 整数 k ，其中 skills[i] 是第 i 位玩家的技能等级。skills 中所有整数 互不相同 。

所有玩家从编号 0 到 n - 1 排成一列。

比赛进行方式如下：

队列中最前面两名玩家进行一场比赛，技能等级 更高 的玩家胜出。
比赛后，获胜者保持在队列的开头，而失败者排到队列的末尾。
这个比赛的赢家是 第一位连续 赢下 k 场比赛的玩家。

请你返回这个比赛的赢家编号。



示例 1：

输入：skills = [4,2,6,3,9], k = 2

输出：2

解释：

一开始，队列里的玩家为 [0,1,2,3,4] 。比赛过程如下：

玩家 0 和 1 进行一场比赛，玩家 0 的技能等级高于玩家 1 ，玩家 0 胜出，队列变为 [0,2,3,4,1] 。
玩家 0 和 2 进行一场比赛，玩家 2 的技能等级高于玩家 0 ，玩家 2 胜出，队列变为 [2,3,4,1,0] 。
玩家 2 和 3 进行一场比赛，玩家 2 的技能等级高于玩家 3 ，玩家 2 胜出，队列变为 [2,4,1,0,3] 。
玩家 2 连续赢了 k = 2 场比赛，所以赢家是玩家 2 。

示例 2：

输入：skills = [2,5,4], k = 3

输出：1

解释：

一开始，队列里的玩家为 [0,1,2] 。比赛过程如下：

玩家 0 和 1 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
玩家 1 和 2 进行一场比赛，玩家 1 的技能等级高于玩家 2 ，玩家 1 胜出，队列变为 [1,0,2] 。
玩家 1 和 0 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
玩家 1 连续赢了 k = 3 场比赛，所以赢家是玩家 1 。


提示：

n == skills.length
2 <= n <= 105
1 <= k <= 109
1 <= skills[i] <= 106
skills 中的整数互不相同。
 */
public class Day308_FindWinningPlayer {

	/*
	[16,4,7,17]

	[16,7,17,4]
	[16,17,4,7]
	[17,4,7,16]
	[17,7,16,4]
	[17,16,4,7]
	[16,4,7,17]
	 */
	public static void main(String[] args) {
		int[] skills = {16, 4, 7, 17};
		System.out.println(findWinningPlayer(skills, 562084119));
	}

	public static int findWinningPlayer(int[] skills, int k) {
		Map<Integer, Integer> serialMap = new HashMap<>(); // 记录玩家编号 k-玩家技能等级，v-玩家位置
		Map<Integer, Integer> winnerMap = new HashMap<>();
		int maxIdx = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < skills.length; i++) {
			if (skills[i] > max) {
				maxIdx = i;
				max = skills[i];
			}
		}
		ArrayDeque<Integer> deque = new ArrayDeque<>();    // 将玩家放入双向队列
		for (int i = 0; i < skills.length; i++) {
			serialMap.put(skills[i], i);
			winnerMap.put(i, 0);
			deque.add(skills[i]);
		}

		while (winnerMap.get(maxIdx) == 0) {
			Integer first = deque.pollFirst();
			Integer second = deque.pollFirst();
			int winPosition;
			if (first > second) {
				deque.offerFirst(first);
				deque.offerLast(second);
				winPosition = serialMap.get(first);
			} else {
				deque.offerFirst(second);
				deque.offerLast(first);
				winPosition = serialMap.get(second);
			}
			Integer winCnt = winnerMap.get(winPosition);
			winnerMap.put(winPosition, winCnt + 1);
			if (winCnt + 1 == k) {
				return winPosition;
			}
		}
		return maxIdx;
	}
}
