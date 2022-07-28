package com.zlq.day140;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day140
 * @ClassName: Day134_ShiftGrid
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/20 11:05
 */
/*
Given a 2D grid of size m x nand an integer k. You need to shift the gridk times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m- 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]

Example 2:
Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 */
public class Day134_ShiftGrid {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> resList = shiftGrid2(grid, 4);
        for (int i = 0; i < resList.size(); i++) {
            for (int j = 0; j < resList.get(i).size(); j++) {
                System.out.print(resList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        List<List<Integer>> lists = shiftGrid2(grid, 4);
    }


    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] resArr = grid;
        for (int i = 0; i < k; i++) {
            resArr = shift(resArr);
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < resArr.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < resArr[0].length; j++) {
                list.add(resArr[i][j]);
            }
            resList.add(list);
        }
        return resList;
    }

    public static int[][] shift(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] shiftArr = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int ele = grid[i][j];
                if (i == row - 1 && j == column - 1) shiftArr[0][0] = ele;
                if (i < row - 1 && j == column - 1) shiftArr[i + 1][0] = ele;
                if (i <= row - 1 && j < column - 1) shiftArr[i][j + 1] = ele;
            }
        }
        return shiftArr;
    }

    /*
    {1,2,3,4,5,6,7,8,9} => {9,1,2,3,4,5,6,7,8}
     */
    public static List<List<Integer>> shiftGrid2(int[][] grid, int k) {
        int row = grid.length;
        int column = grid[0].length;
        int[] resArr = new int[row * column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int ele = grid[i][j];
                int index = i * column + j + k;
                if (index < resArr.length) resArr[index] = ele;
//                else resArr[index - resArr.length] = ele;
                else {
                    int count = 1;
                    while (index - resArr.length * count >= resArr.length) {
                        count++;
                    }
                    resArr[index - resArr.length * count] = ele;
                }
            }
        }

        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < resArr.length; i++) {
            list.add(resArr[i]);
            if ((i + 1) % column == 0) {
                resList.add(list);
                list = new ArrayList<>();
            }
        }
        return resList;
    }
}
