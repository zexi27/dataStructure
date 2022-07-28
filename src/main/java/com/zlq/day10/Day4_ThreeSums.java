package com.zlq.day10;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day10
 * @ClassName: Day4_ThreeSums
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/24 9:58 上午
 */
/*
给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
使得a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例:
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Day4_ThreeSums {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSums1(nums);
        System.out.println(result);

    }

    public static List<List<Integer>> threeSums1(int[] nums) {
        //存放结果,返回数组的集合
        List<List<Integer>> result = new ArrayList<>();
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l-2; j++) {
                for (int k = j + 1; k < l; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }


    //给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    public static List<List<Integer>> threeSums2(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // 遍历数组，寻找每个元素的thatNum
        for (int i = 0; i < n; i++) {
            int thatNum = 0 - nums[i];

            if (hashMap.containsKey(thatNum)) {
                List<Integer> tempList = new ArrayList<>(hashMap.get(thatNum));
                tempList.add(nums[i]);
                result.add(tempList);
                continue;
            }
            for (int j = 0; j < i; j++) {
                int newKey = nums[i] + nums[j];
                if (!hashMap.containsKey(newKey)) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[j]);
                    tempList.add(nums[i]);
                    hashMap.put(newKey, tempList);
                }
            }
        }
        return result;
    }
}
