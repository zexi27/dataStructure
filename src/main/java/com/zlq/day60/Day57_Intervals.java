package com.zlq.day60;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day57_Intervals
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/4 9:42 上午
 */
/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Day57_Intervals {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{4, 5}, {1, 4}, {0, 1}};

        int[][] result = merge(intervals);
        for (int[] ints : result) {
            System.out.print(Arrays.toString(ints) + "\t");
        }


    }

    //方法1：暴力法
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i)[0] <= list.get(j)[1] && list.get(i)[0] >= list.get(j)[0] && i != j) {
                    mergeList(i, j, list);
                }
            }
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        for (int[] ints : list) {
            res[index] = ints;
            index++;
        }
        return res;
    }

    private static void mergeList(int i, int j, List<int[]> list) {
        int max1 = list.get(i)[1];
        int max2 = list.get(j)[1];
        int min1 = list.get(i)[0];
        int min2 = list.get(j)[0];
        int maxNum = max1 >= max2 ? max1 : max2;
        int minNum = min1 <= min2 ? min1 : min2;
        int[] remove1 = list.get(i);
        int[] remove2 = list.get(j);
        list.remove(remove1);
        list.remove(remove2);
        list.add(0, new int[]{minNum, maxNum});
    }


    public static int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals);
        List<int[]> merged = new ArrayList<int[]>(); // 创建一个新的集合
        for (int i = 0; i < intervals.length; ++i) {
            // 获取集合中每一项（数组）的第一个值（L）和，第二个值（R）
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }




}
