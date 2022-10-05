package com.zlq.day160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day160
 * @ClassName: Day159_NumSameConsecDiff
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/3 11:32
 */
/*
Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.



Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:
Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 */
public class Day159_NumsSameConsecDiff {
    public static void main(String[] args) {
//        numsSameConsecDiff(3, 5);
//        System.out.println(381 / 100);
//        System.out.println(381 % 100 / 10);
//        System.out.println(381 % 100 % 10 / 1);
//        System.out.println("===================");
//        System.out.println(3816 / 1000);
//        System.out.println(3816 % 1000 / 100);
//        System.out.println(3816 % 1000 % 100 / 10);
//        System.out.println(3816 % 1000 % 100 % 10 / 1);
        int[][] mat = {
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(numSpecial(mat));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        int maxNum = (int) Math.pow(10, n);
        List<Integer> resList = new ArrayList<>();
        for (int i = maxNum / 10; i < maxNum; i++) {
            if (isValid(i, k)) resList.add(i);
        }
        int size = resList.size();
        int[] resArr = new int[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    public static boolean isValid(int num, int k) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs((s.charAt(i) - '0') - (s.charAt(i + 1) - '0')) != k) return false;
        }
        return true;
    }

    public static int numSpecial(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int count = 0;
        int eleS = rows * columns;
        for (int i = 0; i < eleS; i++) {
            int rowNum = i / columns;
            int columnNum = i % columns;
            if (mat[rowNum][columnNum] == 1) {
                if (isValid(mat,rowNum,columnNum)) count++;
            }
        }
        return count;
    }

    public static boolean isValid(int[][] mat, int rowNum, int columnNum) {
        int rows = mat.length;
        int columns = mat[0].length;
        for (int i = 0; i < columns; i++) {
            if (mat[rowNum][i] == 1 && i != columnNum) return false;
        }
        for (int i = 0; i < rows; i++) {
            if (mat[i][columnNum] == 1 && i != rowNum) return false;
        }
        return true;
    }
}
