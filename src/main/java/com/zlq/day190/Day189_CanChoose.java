package com.zlq.day190;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day190
 * @ClassName: Day189_CanChoose
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/18 21:06
 */
/*
给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。

你是否可以从 nums 中选出 n 个 不相交 的子数组，使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，
且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。
（也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）

如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 。

如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。

示例 1：

输入：groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
输出：true
解释：你可以分别在 nums 中选出第 0 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 和第 1 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 。
这两个子数组是不相交的，因为它们没有任何共同的元素。
示例 2：

输入：groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]
输出：false
解释：选择子数组 [1,2,3,4,10,-2] 和 [1,2,3,4,10,-2] 是不正确的，因为它们出现的顺序与 groups 中顺序不同。
[10,-2] 必须出现在 [1,2,3,4] 之前。
示例 3：

输入：groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]
输出：false
解释：选择子数组 [7,7,1,2,3,4,7,7] 和 [7,7,1,2,3,4,7,7] 是不正确的，因为它们不是不相交子数组。
它们有一个共同的元素 nums[4] （下标从 0 开始）。
 */
public class Day189_CanChoose {
    public static void main(String[] args) {
//        int[][] groups = {{1,2,3}, {3,4}};
//        int[] nums = {7,7,1,2,3,4,7,7};
//        int[][] groups = {{1, -1, -1}, {3, -2, 0}};
//        int[] nums = {1, -1, 0, 1, -1, -1, 3, -2, 0};
//        int[][] groups = {{10,-2}, {1,2,3,4}};
//        int[] nums = {1,2,3,4,10,-2};
        int[][] groups = {{-8227949, -1558353, 4364713, -8653866, 7208040, -6759744, 5742626},
                {-8886462, -6668645, -8030050, 3260317},
                {6815058, -3176824, 4876349, -4932954, -5751120, -6939230},
                {7833008}, {-4041456, -8493215, 492049, -7574545, 2423635, -5698218}};
        int[] nums =
                {-6759744, 5742626,
                        -8227949, -1558353, 4364713, -8653866, 7208040, -6759744, 5742626,
                        -8653866, -8227949,
                        -8886462, -6668645, -8030050, 3260317,
                        -8030050, 6815058, -3176824, 4876349, -4932954, -5751120, -6939230, -5751120, -6939230,
                        7833008,
                        -4041456, -8493215, 492049, -7574545, 2423635};
        System.out.println(canChoose(groups, nums));
    }

    public static boolean canChoose(int[][] groups, int[] nums) {
        int index = 0, l = 0, r = groups[index].length - 1;
        while (r < nums.length && index < groups.length) {
            if (nums[l] != groups[index][0]) {
                l++;
                r++;
            } else {
                if (checkSubIsEqual(groups[index], nums, l, l + groups[index].length)) {
                    l = l + groups[index].length;
                    index++;
                    if (index < groups.length) r = l + groups[index].length - 1;
                    else r = l;
                } else {
                    l++;
                    r++;
                }
            }
        }
        if (index != groups.length) {
            return false;
        }
        return true;
    }

    private static boolean checkSubIsEqual(int[] group, int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
//            if (i >= nums.length) return false;
            if (nums[i] != group[i - start]) return false;
        }
        return true;
    }
}
