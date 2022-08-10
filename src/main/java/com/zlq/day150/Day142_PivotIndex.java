package com.zlq.day150;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day150
 * @ClassName: Day142_PivotIndex
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/8 10:19
 */
/*
给你一个整数数组nums ，请计算数组的 中心下标 。
数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。

示例 1：

输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
中心下标是 3 。
左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
示例 2：

输入：nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心下标。
示例 3：

输入：nums = [2, 1, -1]
输出：0
解释：
中心下标是 0 。
左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。


提示：

1 <= nums.length <= 104
-1000 <= nums[i] <= 1000
 */
public class Day142_PivotIndex {
    public static void main(String[] args) {
//        int[] nums = {-1, -1, 0, 1, 1, 0};
//        System.out.println(pivotIndex(nums));
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        int index = 0;
        int leftSum = 0, rightSum = 0;
        while (index <= length - 1) {
            if (index == 0) leftSum = 0;
            if (index == length - 1) rightSum = 0;
            rightSum = sum - leftSum - nums[index];
            if (leftSum == rightSum) return index;
            leftSum += nums[index];
            index++;
        }
        return -1;
    }


    /*
    给定两个字符串s和t，判断它们是否是同构的。

    如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。

    每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
    不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

    示例 1:

    输入：s = "egg", t = "add"
    输出：true
    示例 2：

    输入：s = "foo", t = "bar"
    输出：false
    示例 3：

    输入：s = "paper", t = "title"
    输出：true
    */
    public static boolean isIsomorphic(String s, String t) {
        int length = s.length();
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < length; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (Objects.isNull(map1.get(tChar))) {
                map1.put(tChar, sChar);
            } else {
                if (!map1.get(tChar).equals(sChar)) return false;
            }

            if (Objects.isNull(map2.get(sChar))) {
                map2.put(sChar, tChar);
            } else {
                if (!map2.get(sChar).equals(tChar)) return false;
            }
        }

        return true;
    }
}
