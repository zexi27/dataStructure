package com.zlq.day280;

import com.zlq.common.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/4 11:58
 */
public class Day272_MergeNodes {

	public static void main(String[] args) {
//		[0,3,1,0,4,5,2,0]
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(2);
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;

		ListNode.print(n1);

		System.out.println(Arrays.toString(nodesBetweenCriticalPoints(n1)));

		System.out.println(numWaterBottles(15, 4));
	}

	public static ListNode mergeNodes(ListNode head) {
		List<ListNode> valList = new ArrayList<>();
		head = head.next;
		int curSum = 0;
		while (head != null) {
			if (head.value == 0) {
				ListNode curNode = new ListNode(curSum);
				valList.add(curNode);
				if (valList.size() > 1) {
					ListNode lastNode = valList.get(valList.size() - 2);
					lastNode.next = curNode;
				}

				curSum = 0;
			}
			curSum += head.value;
			head = head.next;
		}
		return valList.get(0);
	}


	public static ListNode mergeNodes2(ListNode head) {
		ListNode modifyNode = head.next;
		ListNode curNode = head.next;
		while (curNode != null) {
			int curSum = 0;
			while (curNode.value != 0) {
				curSum += curNode.value;
				curNode = curNode.next;
			}
			modifyNode.value = curSum;
			curNode = curNode.next;
			modifyNode.next = curNode;
			modifyNode = modifyNode.next;
		}

		return head.next;
	}


	public static int[] nodesBetweenCriticalPoints(ListNode head) {
		if (head.next == null || head.next.next == null) { // 如果链表长度为1或2，则没有正确结果
			return new int[]{-1, -1};
		}

		ListNode preNode = head;
		ListNode curNode = head.next;
		ListNode nextNode = head.next.next;

		int curIndex = 2, minCriticalIndex = -1, maxCriticalIndex = -1, minBetween = Integer.MAX_VALUE;
		while (curNode.next != null) {
			if (isCritical(preNode.value, curNode.value, nextNode.value)) {
				if (minCriticalIndex == -1) {
					minCriticalIndex = curIndex;
				}
				if (maxCriticalIndex != -1) {
					minBetween = Math.min(minBetween, curIndex - maxCriticalIndex);
				}
				maxCriticalIndex = curIndex;
			}
			preNode = preNode.next;
			curNode = curNode.next;
			nextNode = nextNode.next;
			curIndex++;
		}
		minBetween = minBetween == Integer.MAX_VALUE ? -1 : minBetween;
		Integer maxBetween = maxCriticalIndex - minCriticalIndex == 0 ? -1 : maxCriticalIndex - minCriticalIndex;
		return new int[]{minBetween, maxBetween};
	}

	public static boolean isCritical(int preVal, int curVal, int nextVal) {
		if (preVal < curVal && curVal > nextVal || preVal > curVal && curVal < nextVal) {
			return true;
		}

		return false;
	}

	public static int numWaterBottles(int numBottles, int numExchange) {
		int drinkedCount = 0, emptyBottles = 0; // define the bottles has already drank, and empty bottles count
		while (true) {
			drinkedCount += numBottles; // drink current full bottles
			emptyBottles += numBottles; // 空瓶子数量为原有空瓶子数量 + 喝掉的数量
			numBottles = emptyBottles / numExchange; // 换掉了水后，当前的可以喝水的瓶数
			emptyBottles = emptyBottles - numBottles * numExchange; // 剩余的水瓶子数量
			if (numBottles == 0) break;
		}
		return drinkedCount;
	}

}
