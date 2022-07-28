package com.zlq.day30;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day29_ThreeSum
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/30 8:31 上午
 */
/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例:
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Day29_ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum3(nums));
    }

    //暴力法
    public static List<int[]> threeSum(int[] nums) {
        int length = nums.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] resArr = new int[]{nums[i], nums[j], nums[k]};
                        list.add(resArr);
                    }
                }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
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

    public static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) break;
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = length - 1;   // 定义左右指针
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                } else if (sum < 0)
                    l++;
                else
                    r--;
            }
        }
        return result;
    }


    public static void print(List<int[]> List) {
        for (int[] arr : List) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
