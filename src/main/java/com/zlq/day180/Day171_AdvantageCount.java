package com.zlq.day180;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day171_AdvantageCount
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/8 12:55
 */
/*
给定两个大小相等的数组nums1和nums2，nums1相对于 nums的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。

返回 nums1的任意排列，使其相对于 nums2的优势最大化。



示例 1：

输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
输出：[2,11,7,15]
示例 2：

输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
输出：[24,32,8,12]
 */
public class Day171_AdvantageCount {
    public static void main(String[] args) {

        int[] nums1 = {2,0,4,1,2};
        int[] nums2 = {1,3,0,0,2};
        // {0,1,2,2,4}
        System.out.println(Arrays.toString(advantageCount(nums1, nums2)));
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            int ele = nums1[i];
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            set.add(ele);
        }
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            Integer ele = set.ceiling(nums2[i] + 1);  // 寻找大于该元素最小的元素
            if (ele == null) ele = set.ceiling(-1); // 如果找不到，取最小的元素
            res[i] = ele;
            map.put(ele, map.get(ele) - 1);
            if (map.get(ele) == 0) {
                map.remove(ele);
                set.remove(ele);
            }
        }
        return res;
    }
}
