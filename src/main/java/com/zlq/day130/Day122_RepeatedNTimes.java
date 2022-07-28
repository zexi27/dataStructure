package com.zlq.day130;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day122_RepeatedNTimes
 * @description:
 * @author: LiQun
 * @CreateDate:2022/5/21 13:56
 */
/*
给你一个整数数组 nums ，该数组具有以下属性：

nums.length == 2 * n.
nums 包含 n + 1 个 不同的 元素
nums 中恰有一个元素重复 n 次
找出并返回重复了 n 次的那个元素。

示例 1：

输入：nums = [1,2,3,3]
输出：3
示例 2：

输入：nums = [2,1,2,5,3,2]
输出：2
示例 3：

输入：nums = [5,1,5,2,5,3,5,4]
输出：5
 */
public class Day122_RepeatedNTimes {
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        list.add("abc");
        list.add("def");
        String[] strings = list.toArray(new String[2]);
        System.out.println(Arrays.toString(strings));
    }

    public static int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return num;
            }
        }
        return 0;
    }


}
