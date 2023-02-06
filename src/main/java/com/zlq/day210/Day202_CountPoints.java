package com.zlq.day210;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day202_CountPounts
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/24 13:12
 */
/*
1828. 统计一个圆中点的数目
给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。

同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。

对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。

请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。

示例 1：


输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
输出：[3,2,2]
解释：所有的点和圆如上图所示。
queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
示例 2：


输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
输出：[2,3,2,4]
解释：所有的点和圆如上图所示。
queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
 */
public class Day202_CountPoints {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        System.out.println(Arrays.toString(countPoints(points, queries)));
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int length = queries.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int cx = queries[i][0];
            int cy = queries[i][1];
            int cr = queries[i][2];
            for (int j = 0; j < points.length; j++) {
                int px = points[j][0];
                int py = points[j][1];
                if ((px - cx) * (px - cx) + (py - cy) * (py - cy) <= cr * cr)
                    res[i]++;
            }
        }
        return res;
    }




}
