package com.zlq.Day300;

import com.zlq.common.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/9/4 15:12
 */
/*
2860. 让所有学生保持开心的分组方法数
中等
相关标签
相关企业
提示
给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。班主任希望能够在让所有学生保持开心的情况下选出一组学生：

如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心：

这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。
这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。
返回能够满足让所有学生保持开心的分组方法的数目。



示例 1：

输入：nums = [1,1]
输出：2
解释：
有两种可行的方法：
班主任没有选中学生。
班主任选中所有学生形成一组。
如果班主任仅选中一个学生来完成分组，那么两个学生都无法保持开心。因此，仅存在两种可行的方法。
示例 2：

输入：nums = [6,0,3,3,6,7,2,7]
输出：3
解释：
存在三种可行的方法：
班主任选中下标为 1 的学生形成一组。
班主任选中下标为 1、2、3、6 的学生形成一组。
班主任选中所有学生形成一组。


提示：

1 <= nums.length <= 105
0 <= nums[i] < nums.length
 */
public class Day296_CountWays {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(18);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(10);
		ListNode n4 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode head = insertGreatestCommonDivisors(n1);
		ListNode.print(head);

	}

	/*
	对于被选中的：选中的总人数要大于自己的编号
	对于没被选中的：被选中的人数要小于自己的编号
	 */
	public static int countWays(List<Integer> nums) {
		// [0,2,3,3,6,6,7,7]

		int res = 0;
		int[] numArr = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			numArr[i] = nums.get(i);

		}
		Arrays.sort(numArr);
		if (isFun(0, numArr)) {
			res++;
		}
		for (int i = 0; i < nums.size(); i++) {
			if (isFun(i + 1, numArr)) {
				res++;
			}
		}
		return res;
	}


	public static boolean isFun(int selectCnt, int[] numArr) {
//		对于被选中的：选中的总人数要大于自己的编号
		if (selectCnt == 0 && numArr[0] > 0) {
			return true;
		}
		if (selectCnt > 0 && numArr[selectCnt - 1] >= selectCnt) {
			return false;
		}

//		对于没被选中的：被选中的人数要小于自己的编号
		if (selectCnt < numArr.length && numArr[selectCnt] <= selectCnt) {
			return false;
		}

		return true;
	}


	/*
	[[1],
	[1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]]
	 */
	public static List<long[]> yanghui(int rowCnt) {
		List<long[]> res = new ArrayList<>();
		if (rowCnt <= 0) {
			return res;
		}
		for (int i = 1; i <= rowCnt; i++) {
			// 初始化数组
			long[] arr = new long[i];
			arr[0] = 1;
			arr[arr.length - 1] = 1;
			res.add(arr);
		}
		if (rowCnt > 2) {
			for (int i = 2; i < rowCnt; i++) {
				long[] lastRow = res.get(i - 1);
				long[] curRow = res.get(i);
				for (int j = 1; j < curRow.length - 1; j++) {
					curRow[j] = lastRow[j - 1] + lastRow[j];
				}
			}
		}
		return res;
	}


	public static boolean validBrackets(String s) {
		Stack<Element> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 字符为 (、[、{ 入栈
			if (c == '(') {
				stack.push(new Element(')', false));
			} else if (c == '[') {
				stack.push(new Element(']', false));
			} else if (c == '{') {
				stack.push(new Element('}', false));
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Element peek = stack.peek();
				if (c == ')' || c == ']' || c == '}') {
					if (!peek.getValue().equals(c)) {
						return false;
					}
					if (!peek.isValid()) {
						return false;
					}
					stack.pop();
				} else { // 字符为其他字符，将前面的括号都置为有效
					for (Element element : stack) {
						element.setValid(true);
					}
				}

			}
		}
		return true;
	}

	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m][n]; // dp代表将word1的前i个字符替换为word2的后j个字符所需最小的操作数

		/*
		初始化dp
		当word1为0时，最小操作数为n
		当word2为0时，最小操作数为m
		 */
		for (int i = 0; i < n; i++) {
			dp[0][i] = n;
		}
		for (int i = 0; i < m; i++) {
			dp[i][0] = m;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					// 如果i和j的字母相同，说明不需要进行操作，操作数和dp[i-1][j-1]相同
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					// 如果i和j的字母不相同，有三种操作，取最小数量的操作即可
					/*
					删除操作：dp[i][j] = dp[i - 1][j] + 1
					新增操作：dp[i][j] = dp[i][j - 1] + 1
					替换操作：dp[i][j] = dp[i - 1][j - 1] + 1
					 */
					dp[i][j] = Math.min(dp[i - 1][j] + 1,
							Math.min(dp[i][j - 1] + 1,
									dp[i - 1][j - 1] + 1));
				}
			}
		}
		return dp[m][n];
	}


	public static int[] sortedSquares(int[] nums) {
		int length = nums.length;
		int[] resArr = new int[length];
		if (length == 1) {
			return new int[]{(int) Math.pow(nums[0], 2)};
		}
		int positiveIdx = -1;
		for (int i = 0; i < length; i++) {
			if (nums[i] >= 0) {
				positiveIdx = i;
				break;
			}
		}
		if (positiveIdx == -1) { // 没有正数
			positiveIdx = length;
		}
		int p1 = positiveIdx - 1, p2 = positiveIdx, curIdx = 0;
		while (p1 >= 0 && p2 <= length - 1) {
			int left = nums[p1];
			int right = nums[p2];
			if (Math.abs(left) < Math.abs(right)) {
				while (p1 >= 0 && Math.abs(nums[p1]) < Math.abs(nums[p2])) {
					resArr[curIdx++] = (int) Math.pow(nums[p1--], 2);
				}
				resArr[curIdx++] = (int) Math.pow(nums[p2++], 2);
			} else {
				while (p2 <= length - 1 && Math.abs(nums[p1]) >= Math.abs(nums[p2])) {
					resArr[curIdx++] = (int) Math.pow(nums[p2++], 2);
				}
				resArr[curIdx++] = (int) Math.pow(nums[p1--], 2);
			}
		}

		if (p1 >= 0) {
			while (p1 >= 0) {
				resArr[curIdx++] = (int) Math.pow(nums[p1--], 2);
			}
		}

		if (p2 <= length - 1) {
			while (p2 <= length - 1) {
				resArr[curIdx++] = (int) Math.pow(nums[p2++], 2);
			}
		}
		return resArr;
	}


	public static ListNode insertGreatestCommonDivisors(ListNode head) {
		ListNode sentinel = head;
		Integer curVal,nextVal;
		while (head.next != null) {
			curVal = head.value;
			ListNode nextNode = head.next;
			nextVal = nextNode.value;
			int divisors = getGreatestCommonDivisors(curVal, nextVal);
			ListNode divisorNode = new ListNode(divisors);
			head.next = divisorNode;
			divisorNode.next = nextNode;
			head = nextNode;
		}
		return sentinel;
	}

	public static int getGreatestCommonDivisors(int a, int b) {
		if(a == 1 || b==1){
			return 1;
		}
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}



}

class Element {

	private Character value;
	private boolean valid;


	public Element(Character value, boolean valid) {
		this.value = value;
		this.valid = valid;
	}

	public Character getValue() {
		return value;
	}

	public void setValue(Character value) {
		this.value = value;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
