package com.zlq.Day290;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/2/6 09:07
 */

/*
小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。每个房间的补血道具/怪物对于血量影响记于数组 nums，其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。

小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。

示例 1：

输入：nums = [100,100,100,-250,-60,-140,-50,-50,100,150]

输出：1

解释：初始血量为 1。至少需要将 nums[3] 调整至访问顺序末尾以满足要求。

示例 2：

输入：nums = [-200,-300,400,0]

输出：-1

解释：调整访问顺序也无法完成全部房间的访问。

提示：

1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5

 */
public class Day284_MagicTower {

	public static void main(String[] args) {
//        int[] nums = {-1, -1, 10};
//        System.out.println(magicTower(nums));
		int[] nums = {100, 100, 100, -250, -60, -140, -50, -50, 100, 150};
		System.out.println(magicTower(nums));
	}

	public static int magicTower(int[] nums) {
		int sum = 1;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			sum += nums[i];
		}
		if (sum <= 0) {
			return -1;
		}
		Map<Integer, Integer> indexMap = generateIndexMap(nums);

		// ------------------------------------------------------
		int curSum = 1;
		int curIndex = 0;
		int res = 0;
		while (curIndex < length) {
			if (curSum + nums[curIndex] <= 0) { // 如果遇到血量为负，且扣到负值，找到他后面最大的，并进行替换
				Integer maxIndexAfter = indexMap.get(curIndex);
				swap(nums, maxIndexAfter, curIndex);
				curSum += nums[curIndex];
				res++;
			} else {
				curSum += nums[curIndex];
			}
			curIndex++;
		}
		return res;
	}

	private static Map<Integer, Integer> generateIndexMap(int[] nums) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int maxIndex = 0, maxNum = Integer.MIN_VALUE;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > maxNum) {
					maxNum = nums[j];
					maxIndex = j;
				}
			}
			indexMap.put(i, maxIndex);
		}
		return indexMap;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}


	public int accountBalanceAfterPurchase(int purchaseAmount) {
		// 获取该数最接近10的倍数
		int divisor = purchaseAmount / 10;
		int minMultiples = divisor * 10;
		int maxMultiples = (divisor + 1) * 10;
		return Math.abs(minMultiples - purchaseAmount) >= Math.abs(maxMultiples - purchaseAmount) ? 100 - maxMultiples
				: 100 - minMultiples;
	}
}
