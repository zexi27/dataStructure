package com.zlq.day80;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: LongestSubsequence
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/29 4:27 下午
 */
/*
和谐数组是指一个数组里元素的最大值和最小值之间的差别 *正好是 1 。

现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。

数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。

示例 1：

输入：nums = [1,3,2,2,5,2,3,7]
输出：5
解释：最长的和谐子序列是 [3,2,2,2,3]
示例 2：

输入：nums = [1,2,3,4]
输出：2
示例 3：

输入：nums = [1,1,1,1]
输出：0
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 2, 5, 5, 5, 2, 5, 2, 3, 100};
//        System.out.println(findLHS(nums));
        System.out.println(findLHS3(nums));
    }

    // 排序  {1,2,2,2,3,3,5,7}

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int maxLength = 0;
        int curLength = 0;
        Map.Entry<Integer, Integer> ele = iterator.next();
        while (iterator.hasNext()) {
            Integer key = ele.getKey();
            Map.Entry<Integer, Integer> nextEle = iterator.next();
            Integer nextKey = nextEle.getKey();
            if (nextKey == key + 1) {
                curLength = map.get(nextKey) + map.get(key);
            }
            maxLength = maxLength > curLength ? maxLength : curLength;
            ele = nextEle;
        }
        return maxLength;
    }


    public static int findLHS2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int l = 0; // 左指针
        int curLength = 0, maxLength = 0;
        while (l < length - 1) {
            boolean valid = false;
            int r = length - 1; // 右指针
            if (nums[r] == nums[l] + 1) valid = true;
            while (nums[r] > nums[l] + 1) {
                r--;
                if (nums[r] == nums[l] + 1) valid = true;
            }
            if (valid) curLength = r - l + 1;
            maxLength = maxLength > curLength ? maxLength : curLength;
            l++;
        }
        return maxLength;
    }

    public static int findLHS3(int[] nums){
        Arrays.sort(nums);
        int begin = 0,res = 0;
        for(int end = 0;end < nums.length;end++){
            while(nums[end] - nums[begin] > 1)
                begin++;
            if(nums[end] - nums[begin] == 1)
                res = Math.max(res,end - begin + 1);
        }
        return res;
    }

}
