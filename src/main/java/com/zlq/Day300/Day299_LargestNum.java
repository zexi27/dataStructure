package com.zlq.Day300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/9/18 16:27
 */

/*

Code
Testcase
Test Result
Test Result
179. Largest Number
Medium
Topics
Companies
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,31,34,5,9]
Output: "9534330"


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
 */
public class Day299_LargestNum {

	public static void main(String[] args) {
		Map<String, Seller> map = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			Seller seller = new Seller();
			String id = UUID.randomUUID().toString();
			seller.setId(id);
			seller.setName("张" + i);
			seller.setAge(i);
			map.put(id, seller);
		}

		Seller seller;
		List<User> userList = new ArrayList<>();
		for (Entry<String, Seller> entry : map.entrySet()) {
			seller = entry.getValue();
			User user = new User(seller.getAge(), seller.getName());
			userList.add(user);
		}
		System.out.println(userList);
	}


	public static String largestNumber(int[] nums) {
		StringBuilder resBuilder = new StringBuilder();
		List<Integer> numList = new ArrayList<>();
		for (int num : nums) {
			numList.add(num);
		}
		numList.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String order1 = o1 + String.valueOf(o2);
				String order2 = o2 + String.valueOf(o1);
				return order2.compareTo(order1);
			}
		});

		if (numList.get(0).equals("0")) {
			return "0";
		}

		// Concatenate the sorted numbers to form the largest number
		for (Integer num : numList) {
			resBuilder.append(num);
		}
		return resBuilder.toString();
	}


}


class User {

	private Integer age;
	private String name;

	public User(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}

class Seller {

	private String id;
	private Integer age;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}