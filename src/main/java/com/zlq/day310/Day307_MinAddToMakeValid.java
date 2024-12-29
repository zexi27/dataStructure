package com.zlq.day310;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/10/9 15:31
 */
/*

921. Minimum Add to Make Parentheses Valid
Medium
Topics
Companies
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.



Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3


Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.
 */

class Student {

	private String name;
	private Integer age;

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Student student = (Student) o;
		return Objects.equals(name, student.name) && Objects.equals(age, student.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
public class Day307_MinAddToMakeValid {


	public static int minAddToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.size();
	}

	/*
	3171. 找到按位或最接近 K 的子数组
	给你一个数组 nums 和一个整数 k 。你需要找到 nums 的一个子数组 ，满足子数组中所有元素按位或运算 OR 的值与 k 的 绝对差 尽可能 小 。
	换言之，你需要选择一个子数组 nums[l..r] 满足 |k - (nums[l] OR nums[l + 1] ... OR nums[r])| 最小。

	请你返回 最小 的绝对差值。

	子数组 是数组中连续的 非空 元素序列。



	示例 1：

	输入：nums = [1,2,4,5], k = 3

	输出：0

	解释：

	子数组 nums[0..1] 的按位 OR 运算值为 3 ，得到最小差值 |3 - 3| = 0 。

	示例 2：

	输入：nums = [1,3,1,3], k = 2

	输出：1

	解释：

	子数组 nums[1..1] 的按位 OR 运算值为 3 ，得到最小差值 |3 - 2| = 1 。

	示例 3：

	输入：nums = [1], k = 10

	输出：9

	解释：

	只有一个子数组，按位 OR 运算值为 1 ，得到最小差值 |10 - 1| = 9 。
	 */

	public static int minimumDifference(int[] nums, int k) {
		int length = nums.length;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			int cur = nums[i];
			for (int j = i; j < length; j++) {
				cur = cur | nums[j];
				res = Math.min(res, Math.abs(cur - k));
			}
		}
		return res;
	}

	public static List<Integer> stableMountains(int[] height, int threshold) {
		List<Integer> resList = new ArrayList<>();
		int length = height.length;
		for (int i = 1; i < length; i++) {
			if (height[i - 1] > threshold) {
				resList.add(i);
			}
		}
		return resList;
	}


}
