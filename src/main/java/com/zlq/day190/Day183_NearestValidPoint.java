package com.zlq.day190;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day190
 * @ClassName: Day183_NearestValidPoint
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/1 11:47
 */
/*
You are given two integers, x and y, which represent your current location on a Cartesian grid: (x, y).
You are also given an array points where each points[i] = [ai, bi] represents that a point exists at (ai, bi).
A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.

Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location.
If there are multiple, return the valid point with the smallest index. If there are no valid points, return -1.

The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).

Example 1:

Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
Output: 2
Explanation: Of all the points, only [3,1], [2,4] and [4,4] are valid.
Of the valid points, [2,4] and [4,4] have the smallest Manhattan distance from your current location,
with a distance of 1. [2,4] has the smallest index, so return 2.
Example 2:

Input: x = 3, y = 4, points = [[3,4]]
Output: 0
Explanation: The answer is allowed to be on the same location as your current location.
Example 3:

Input: x = 3, y = 4, points = [[2,3]]
Output: -1
Explanation: There are no valid points.
 */
public class Day183_NearestValidPoint {

    public static void main(String[] args) {
        int x = 1, y = 1;
        int[][] points = {{1,1},{1,1}};
        System.out.println(nearestValidPoint(x, y, points));
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        Map<Integer,int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                pointMap.put(i,points[i]);
            }
        }
        if (pointMap.isEmpty()) return -1;
        int smallestDistance = Integer.MAX_VALUE;
        int smallestIndex = 0;
        Iterator<Integer> iterator = pointMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer index = iterator.next();
            int[] point = pointMap.get(index);
            int curDistance = Math.abs(point[0]-x) + Math.abs(point[1] - y);
            if (curDistance < smallestDistance){
                smallestDistance = curDistance;
                smallestIndex = index;
            }
        }
        return smallestIndex;
    }
}
