package com.zlq.day50;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50
 * @ClassName: Day42_SingleNumber
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/21 9:41 上午
 */
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。你可以不使用额外空间来实现吗？
示例 1:
输入: [2,2,1]
输出: 1
示例 2:
输入: [4,1,2,1,2]
输出: 4
 */
public class Day42_SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber4(nums));
    }

    public static int singleNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            if (list.contains(num)) list.remove(num);
            else list.add(num);
        }
        return list.get(0);
    }

    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)) map.remove(num);
            else map.put(num, 1);
        }
        return map.keySet().iterator().next();
    }

    public static int singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Integer arraySum = 0;
        Integer setSum = 0;
        for (Integer num : nums) {
            arraySum += num;
            set.add(num);
        }
        for (Integer ele : set) {
            setSum += ele;
        }
        return setSum * 2 - arraySum;
    }

    public static int singleNumber4(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

}
