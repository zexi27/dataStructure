package com.zlq.day140;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day140
 * @ClassName: Day132_ArrayNesting
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/17 17:26
 */
/*
索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，
其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]...
以此类推，不断添加直到S出现重复的元素。

示例1:

输入: A = [5,4,0,3,1,6,2]
输出: 4
解释:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

其中一种最长的 S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
S[1] = {A[1], A[4], A[1]}
 */
public class Day132_ArrayNesting {
    public static void main(String[] args) {
        int[] nums = {0,1,2};
        System.out.println(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res > nums.length /2) return res;
            int firstNum = nums[i];
            int curNum = firstNum;
            int count = 0;
            while (true) {
                int nextNum = nums[curNum];
                curNum = nextNum;
                count++;
                if (curNum == firstNum) break;
            }
            res = Math.max(res, count);
        }
        return res;
    }

}
