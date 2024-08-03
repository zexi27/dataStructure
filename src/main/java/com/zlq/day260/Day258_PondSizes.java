package com.zlq.day260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/6/22 14:39
 */
/*
面试题 16.19. Pond Sizes LCCI
提示
中等
124
相关企业
You have an integer matrix representing a plot of land, where the value at that location represents the height above sea level.
A value of zero indicates water. A pond is a region of water connected vertically, horizontally, or diagonally.
The size of the pond is the total number of connected water cells. Write a method to compute the sizes of all ponds in the matrix.

Example:

Input:
[
  [0,2,1,0],
  [0,1,0,1],
  [1,1,0,1],
  [0,1,0,1]
]
Output:  [1,2,4]
Note:

0 < len(land) <= 1000
0 < len(land[i]) <= 1000
 */
public class Day258_PondSizes {
    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        int[] resArr = pondSizes(land);
        System.out.println(Arrays.toString(resArr));
    }

    public static int[] pondSizes(int[][] land) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    resList.add(fill(land, i, j));
                }
            }
        }
        resList = resList.stream().sorted().collect(Collectors.toList());
        int size = resList.size();
        int[] resArr = new int[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    private static Integer fill(int[][] land, int i, int j) {
        int count = 1;
        // base case
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = -1;
        count += fill(land, i + 1, j);
        count += fill(land, i - 1, j);
        count += fill(land, i, j + 1);
        count += fill(land, i, j - 1);
        count += fill(land, i - 1, j - 1);
        count += fill(land, i + 1, j + 1);
        count += fill(land, i - 1, j + 1);
        count += fill(land, i + 1, j - 1);
        return count;
    }

    public static int maximumValue(String[] strs) {
        int maxLength = 0;
        for (String str : strs) {
            maxLength =  Math.max(maxLength,getLength(str));
        }
        return maxLength;
    }

    private static int getLength(String str) {
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (Character.isAlphabetic(c)){
                return str.length();
            }
        }
        return Integer.valueOf(str);
    }
}
