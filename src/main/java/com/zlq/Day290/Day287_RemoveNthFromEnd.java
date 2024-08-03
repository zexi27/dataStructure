package com.zlq.Day290;

import com.zlq.common.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/12 10:44
 */
public class Day287_RemoveNthFromEnd {

	public static void main(String[] args) {
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
////		ListNode.print(n1);
//		removeNthFromEnd(n1, 2);
//		ListNode.print(n1);

		ListNode list1 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(5);
		ListNode n14 = new ListNode(8);
		list1.next = n12;
		n12.next = n13;
		n13.next = n14;

		ListNode list2 = new ListNode(1);
		ListNode list22 = new ListNode(2);
		ListNode list23 = new ListNode(6);
		ListNode list24 = new ListNode(8);
		ListNode list25 = new ListNode(11);
		list2.next = list22;
		list22.next = list23;
		list23.next = list24;
		list24.next = list25;

//		ListNode list1 = null;
//		ListNode list2 = new ListNode(0);
		ListNode head = mergeTwoLists2(list1, list2);
		ListNode.print(head);

//		int[] nums = {0, 0};
//		System.out.println(minIncrementForUnique2(nums));
//		String[] strs = {"aaa", "aaa", "aa"};
//		System.out.println(findLUSlength(strs));
		int[] nums = new int[]{2, 5, 1, 4};
		System.out.println(countBeautifulPairs(nums));

		int[] temperatureA = {21, 18, 18, 18, 31};
		int[] temperatureB = {34, 32, 16, 16, 17};
		System.out.println(temperatureTrend(temperatureA, temperatureB));

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next == null && n == 1) {
			return null;
		}
		ListNode headSentinel = new ListNode();
//		ListNode tailSentinel = new ListNode();
		headSentinel.next = head;
		int length = 1;
		while (head.next != null) {
			head = head.next;
			length++;
		}
//		head.next = tailSentinel;

		int index = 0;
		ListNode curNode = headSentinel;
		while (index < length - n) {
			curNode = curNode.next;
			index++;
		}
		curNode.next = curNode.next.next;
		return headSentinel.next;
	}


	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode p1 = list1;
		ListNode p2 = list2;
		List<Integer> list = new ArrayList<>();
		while (p1 != null) {
			list.add(p1.value);
			p1 = p1.next;
		}
		while (p2 != null) {
			list.add(p2.value);
			p2 = p2.next;
		}

		list.sort(Comparator.comparingInt(o -> o));
		if (list.isEmpty()) {
			return null;
		}
		ListNode head = new ListNode(list.get(0));
		ListNode curNode = head;
		if (list.size() > 1) {
			for (int i = 1; i < list.size(); i++) {
				curNode.next = new ListNode(list.get(i));
				curNode = curNode.next;
			}
		}

		return head;
	}

	public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
		ListNode p1 = list1;
		ListNode p2 = list2;
		ListNode sentinel = new ListNode();
		ListNode curNode = sentinel;
		while (p1 != null && p2 != null) {
			if (p1.value >= p2.value) {
				curNode.next = new ListNode(p2.value);
				p2 = p2.next;
			} else {
				curNode.next = new ListNode(p1.value);
				p1 = p1.next;
			}
			curNode = curNode.next;

		}
		if (p1 != null) {
			curNode.next = p1;
		}
		if (p2 != null) {
			curNode.next = p2;
		}
		return sentinel.next;
	}

	public int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int minIncrement = 0;
		for (int i = 1, length = nums.length; i < length; i++) {
			if (nums[i] <= nums[i - 1]) {
				minIncrement += nums[i - 1] - nums[i] + 1;
				nums[i] = nums[i - 1] + 1;
			}
		}
		return minIncrement;
	}

	public static int minIncrementForUnique2(int[] nums) {
		int length = nums.length;
		int maxNum = Integer.MIN_VALUE;
		for (int num : nums) {
			maxNum = Math.max(maxNum, num);
		}
		int[] frequencyArr = new int[length + maxNum];
		for (int num : nums) {
			frequencyArr[num]++;
		}

		int minIncrement = 0;
		for (int i = 0, n = frequencyArr.length; i < n; i++) {
			if (frequencyArr[i] > 1) {
				frequencyArr[i + 1] += frequencyArr[i] - 1;
				minIncrement += frequencyArr[i] - 1;
			}
		}

		return minIncrement;
	}

	public static int findLUSlength(String a, String b) {
		if (a.equals(b)) {
			return -1;
		}
		return Math.max(a.length(), b.length());
	}

	public static int findLUSlength(String[] strs) {
		Set<String> seqSet = new HashSet<>();
		for (String str : strs) {
			seqSet.add(str);
		}
		if (seqSet.size() == 1) {
			return strs[0].length();
		}

		int max = -1;
		next:
		for (String a : seqSet) {
			if (a.length() <= max) {
				continue;
			}
			for (String b : seqSet) {
				if (a.equals(b) && isSubsequence(a, b)) {
					continue next;
				}
				max = a.length();
			}

		}

		return max;
	}

	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}
		int p1 = 0;
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (c == s.charAt(p1)) {
				p1++;
			}
			if (p1 == s.length()) {
				return true;
			}
		}
		return false;
	}

	static Set<String> set = new HashSet<>();

	static {
		set = beautifulPairsSet();
	}

	public static Set<String> beautifulPairsSet() {
		Set<String> set = new HashSet<>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				boolean beautifulPair = true;
				int min = Math.min(i, j);
				for (int k = 2; k <= min; k++) {
					if (j % k == 0 && i % k == 0) {
						beautifulPair = false;
					}
				}
				if (beautifulPair) {
					set.add(i + "," + j);
				}
			}
		}
		return set;
	}

	public static int countBeautifulPairs(int[] nums) {
		int cnt = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int a = String.valueOf(nums[i]).charAt(0) - '0';
				int b = nums[j] % 10;// nums[i]的第一个字
				// nums[i]的最后一个字
				if (gcd(a, b) == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}


	public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
		int days = temperatureA.length;
		int[] trendsArrA = new int[days - 1];
		int[] trendsArrB = new int[days - 1];
		for (int i = 1; i < days; i++) {
			trendsArrA[i - 1] = getTrend(temperatureA[i], temperatureA[i - 1]);
			trendsArrB[i - 1] = getTrend(temperatureB[i], temperatureB[i - 1]);
		}

		int maxDays = 0;

		int p = 0;
		int start, end;
		while (p < days - 1) {
			while (p < days - 1 && trendsArrA[p] != trendsArrB[p]) {
				p++;
			}
			start = p;
			while (p < days - 1 && trendsArrA[p] == trendsArrB[p]) {
				p++;
			}
			end = p;
			maxDays = Math.max(end - start, maxDays);
		}
		return maxDays;
	}

	public static int temperatureTrend1(int[] temperatureA, int[] temperatureB) {
		int days = temperatureA.length;
		int p = 0;
		int maxDays = 0;
		int start, end;
		while (p < days - 1) {
			while (p < days - 1 && !judge(temperatureA, temperatureB, p)) {
				p++;
			}
			start = p;
			while (p < days - 1 && judge(temperatureA, temperatureB, p)) {
				p++;
			}
			end = p;
			maxDays = Math.max(end - start, maxDays);
		}
		return maxDays;
	}

	public static boolean judge(int[] temperatureA, int[] temperatureB, int p) {
		return (temperatureA[p + 1] - temperatureA[p] < 0 && temperatureB[p + 1] - temperatureB[p] < 0)
				|| (temperatureA[p + 1] - temperatureA[p] > 0 && temperatureB[p + 1] - temperatureB[p] > 0)
				|| (temperatureA[p + 1] - temperatureA[p] == 0 && temperatureB[p + 1] - temperatureB[p] == 0);
	}

	public static int getTrend(int today, int lastDay) {
		if (today > lastDay) {
			return 1;
		} else if (today == lastDay) {
			return 0;
		} else {
			return -1;
		}
	}



}
