package com.zlq.day90;

import java.util.*;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: Day92_LuckyNum
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/15 10:41 上午
 */
/*
给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。

幸运数是指矩阵中满足同时下列两个条件的元素：

在同一行的所有元素中最小
在同一列的所有元素中最大

示例 1：

输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
输出：[15]
解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
示例 2：

输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
输出：[12]
解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
示例 3：

输入：matrix = [[7,8],[1,2]]
输出：[7]
 */
public class Day85_LuckyNum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12}
        };
        System.out.println(luckyNumbers(matrix));
        System.out.println("test".hashCode());
        System.out.println("zhangliqun".hashCode());
        System.out.println("zhangliqun".hashCode() ^ "zhangliqun".hashCode()>>> 16);

        System.out.println("test".hashCode() ^ "test".hashCode() >>> 16);
        System.out.println(tableSizeFor(16));
    }


    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }

    //在同一行的所有元素中最小,在同一列的所有元素中最大
    public static List<Integer> luckyNumbers(int[][] matrix) {
        Set<Integer> maxNumOfColumnSet = getMaxNumOfColumn(matrix);
        Set<Integer> minNumOfRawSet = getMinNumOfRaw(matrix);
        // 取交集
        List<Integer> resList = new ArrayList<>();
        for (Integer ele : maxNumOfColumnSet) {
            if (minNumOfRawSet.contains(ele)) {
                resList.add(ele);
            }
        }
        return resList;
    }

    public static Set<Integer> getMaxNumOfColumn(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int maxNumOfColumn = matrix[0][i];
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] > maxNumOfColumn) maxNumOfColumn = matrix[j][i];
            }
            set.add(maxNumOfColumn);
        }
        return set;
    }

    public static Set<Integer> getMinNumOfRaw(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int minNumOfRaw = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minNumOfRaw) minNumOfRaw = matrix[i][j];
            }
            set.add(minNumOfRaw);
        }
        return set;
    }
}
