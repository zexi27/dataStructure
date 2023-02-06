package com.zlq.day190;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day190
 * @ClassName: Day190_ValidPath
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/19 14:15
 */
/*
有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。

请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。

给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。

示例 1：


输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
输出：true
解释：存在由顶点 0 到顶点 2 的路径:
- 0 → 1 → 2
- 0 → 2
示例 2：

输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
输出：false
解释：不存在由顶点 0 到顶点 5 的路径.
 */
public class Day190_ValidPath {


    public static void main(String[] args) {
        int[] nums = {9};
        int maxOperations = 2;
        System.out.println(minimumSize(nums, maxOperations));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid, nums, maxOperations)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    static boolean check(int mid, int[] nums, int maxOperations) {
        for (int x : nums) {
            maxOperations -= (x - 1) / mid;
        }
        return maxOperations >= 0;
    }
}
