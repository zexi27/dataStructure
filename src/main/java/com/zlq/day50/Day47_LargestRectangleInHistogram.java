package com.zlq.day50;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50
 * @ClassName: Day47_LargestRectangleInHistogram
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/24 11:44 下午
 */
/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。

以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

示例:
输入: [2,1,5,6,2,3]
输出: 10
 */
public class Day47_LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea2(heights));
    }

    public static int largestRectangleArea1(int[] heights) {
        int length = heights.length;
        int curArea = 0;
        int largestArea = 0;
        // 定义两个指针i,j
        for (int i = 0; i < length; i++) {
            int curMinHeight = heights[i];
            for (int j = i; j < length; j++) {
                curMinHeight = heights[j] < curMinHeight ? heights[j] : curMinHeight;
                curArea = (j - i + 1) * curMinHeight;
                largestArea = curArea > largestArea ? curArea : largestArea;
            }
        }
        return largestArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int largestArea = 0;
        // 以每个i节点为中心像两边找比i节点高的，因此i节点高度为最矮
        for (int i = 0; i < heights.length; i++) {
            int l = i, r = i;
            // 左指针不能超过左边界
            while (l >= 0) {
                // 当l指针的节点高度小于height[i],指针停止左移
                if (heights[l] < heights[i]) break;
                l--;
            }
            // 右指针不能超过右边界
            while (r < heights.length) {
                // 当r指针的节点高度大于height[i],指针,指针停止右移
                if (heights[r] < heights[i]) break;
                r++;
            }
            int newArea = (r - l - 1) * heights[i];
            largestArea = newArea > largestArea ? newArea:largestArea;
        }
        return largestArea;
    }
}
