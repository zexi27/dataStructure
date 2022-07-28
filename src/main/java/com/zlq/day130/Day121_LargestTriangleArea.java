package com.zlq.day130;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day121_LargestTriangleArea
 * @description:
 * @author: LiQun
 * @CreateDate:2022/5/15 00:02
 */
/*
给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。

示例:
输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
输出: 2
解释:
这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 */
public class Day121_LargestTriangleArea {

    public static void main(String[] args) {
//        System.out.println(getArea(new int[]{0, 0}, new int[]{1, 0}, new int[]{0, 1}));
        int[][] points = {{-35, 19}, {40, 19}, {27, -20}, {35, -3}, {44, 20}, {22, -21}, {35, 33}, {-19, 42}, {11, 47}, {11, 37}};
        System.out.println(largestTriangleArea(points));
    }

    public static double largestTriangleArea(int[][] points) {
        int length = points.length;
        double maxArea = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    maxArea = Math.max(maxArea, getArea(points[i], points[j], points[k]));
                }
            }
        }
        return maxArea;
    }

    public static double getArea(int[] p1, int[] p2, int[] p3) {
        double first = Math.sqrt(Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2));
        double second = Math.sqrt(Math.pow((p2[0] - p3[0]), 2) + Math.pow((p2[1] - p3[1]), 2));
        double third = Math.sqrt(Math.pow((p1[0] - p3[0]), 2) + Math.pow((p1[1] - p3[1]), 2));
        double p = (first + second + third) / 2;
        Double area = Math.sqrt(p * (p - first) * (p - second) * (p - third));

        return area.isNaN() ? 0 : area;
    }
}
