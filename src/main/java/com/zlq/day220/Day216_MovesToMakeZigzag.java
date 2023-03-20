package com.zlq.day220;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day220
 * @ClassName: Day216_MovesToMakeZigzag
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/27 09:43
 */
/*
1144. 递减元素使数组呈锯齿状
中等
给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。

如果符合下列情况之一，则数组 A 就是 锯齿数组：

每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
返回将数组 nums 转换为锯齿数组所需的最小操作次数。



示例 1：

输入：nums = [1,2,3]
输出：2
解释：我们可以把 2 递减到 0，或把 3 递减到 1。
示例 2：

输入：nums = [9,6,1,6,2]
输出：4

提示：

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
 */
public class Day216_MovesToMakeZigzag {

    public static int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return Math.min(decreaseByCase(nums, 0), decreaseByCase(nums, 1));
    }

    public static int decreaseByCase(int[] nums, int startIndex) {
        int cnt = 0;
        for (int i = startIndex; i < nums.length; i += 2) {
            // 将数处理到比它两边的数都要小，即：比左右两边最小的数要小
            // 注意角标越界情况，即第一个或是最后一个（如果index为0，只和index为1作比较，如果index为最后一个，之和前一个比较）
            int a = 0;
            if (i == 0) {
                a = nums[i + 1];
            } else if (i == nums.length - 1) {
                a = nums[nums.length - 2];
            } else {
                a = Math.min(nums[i + 1], nums[i - 1]);
            }

            if (nums[i] >= a) {
                cnt += nums[i] - a + 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = {{3, 1}, {1, 5}};
        mergeSimilarItems(items1, items2);
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) map.put(items1[i][0], items1[i][1]);
        for (int i = 0; i < items2.length; i++) {
            Integer value = map.get(items2[i][0]);
            if (value != null) {
                map.put(items2[i][0], value + items2[i][1]);
            } else {
                map.put(items2[i][0], items2[i][1]);
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            Integer val = map.get(key);
            list.add(key);
            list.add(val);
            resList.add(list);
        }
        return resList;
    }

}
