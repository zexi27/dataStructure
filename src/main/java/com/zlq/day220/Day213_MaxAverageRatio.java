package com.zlq.day220;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day220
 * @ClassName: Day213_MaxAverageRatio
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/19 11:26
 */
/*
一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。

给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。

一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。

请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。

示例 1：

输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
输出：0.78333
解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
示例 2：

输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
输出：0.53485

提示：

1 <= classes.length <= 105
classes[i].length == 2
1 <= passi <= totali <= 105
1 <= extraStudents <= 105
 */
public class Day213_MaxAverageRatio {
    public static void main(String[] args) {
        int[][] classes = {{1,2}, {3, 5}, {2,2}};
        int extraStudents = 2;
//        double sum = 0;
//        for (int i = 0; i < classes.length; i++) {
//            sum += (double) classes[i][0] / classes[i][1];
//        }
//        System.out.println(sum / classes.length);
        System.out.println(maxAverageRatio(classes, extraStudents));
    }

    /*
    [[2,4],[3,9],[4,5],[2,10]]
    0.5,0.33,0.8,0.2    0.4575
    0.5,0.33,0.8,0.42

     */
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
                long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
                if (val1 == val2) {
                    return 0;
                }
                return val1 < val2 ? 1 : -1;
            }
        });
        for (int i = 0; i < classes.length; i++) {
            queue.add(classes[i]);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = queue.poll();
            poll[0] += 1;
            poll[1] += 1;
            queue.offer(poll);
        }
        double sum = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] poll = queue.poll();
            sum += (double) poll[0] / poll[1];
        }
        return sum / classes.length;
    }
}
