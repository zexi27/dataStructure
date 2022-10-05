package com.zlq.day170;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day162_MaxLengthBetweenEqualCharacters
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/15 16:20
 */

/*
给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。

子字符串 是字符串中的一个连续字符序列。

示例 1：

输入：s = "aa"
输出：0
解释：最优的子字符串是两个 'a' 之间的空子字符串。
示例 2：

输入：s = "abca"
输出：2
解释：最优的子字符串是 "bc" 。
示例 3：

输入：s = "cbzxy"
输出：-1
解释：s 中不存在出现出现两次的字符，所以返回 -1 。
示例 4：

输入：s = "cabbac"
输出：4
解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 */
public class Day162_MaxLengthBetweenEqualCharacters {
    public static void main(String[] args) {
////        String s = "cbzxy";
//        String s= "aa";
//        System.out.println(maxLengthBetweenEqualCharacters(s));
        int[] nums = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    /*
    nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
    nums = [1,2,3,3,]
     */
    public static int maxLengthBetweenEqualCharacters(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, i);
            else res = res > i - map.get(c) - 1 ? res : i - map.get(c) - 1;
        }
        if (map.size() == s.length()) return -1;
        return res;
    }
    /*
    Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

    Return the sorted array.

    Example 1:

    Input: nums = [1,1,2,2,2,3]
    Output: [3,1,1,2,2,2]
    Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
    Example 2:

    Input: nums = [2,3,1,3,2]
    Output: [1,3,3,2,2]
    Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
    Example 3:

    Input: nums = [-1,1,-6,4,5,-6,1,4,1]
    Output: [5,-1,4,4,-6,-6,1,1,1]
     */

    public static int[] frequencySort(int[] nums) {
        int length = nums.length;
        int[] resArr = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int ele = nums[i];
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            list.add(nums[i]);
        }
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int ele1 = map.get(o1);
                int ele2 = map.get(o2);
                if (ele1 == ele2) return o2 - o1;
                else return ele1 - ele2;
            }
        });
        for (int i = 0; i < length; i++) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }

}
