package com.zlq.day20;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day19_ArrayFond
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/16 9:34 上午
 */
/*
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数

矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
因此从左下角开始查找，当要查找数字比左下角数字大时。右移
 要查找数字比左下角数字小时，上移。这样找的速度最快。
 */
public class Day19_ArrayFond {
    public static void main(String[] args) {
        int[][] arr =
                {{1, 5, 7},
                        {2, 6, 8},
                        {5, 7, 9},
                        {6, 8, 10}};
        System.out.println(find(arr, 6));
    }

    public static boolean find(int[][] arr, int findNum) {
        int row = arr.length - 1;
        int column = arr[0].length - 1;
        for (int i = 0; i < row * column; i++) {
            if (arr[i / column][i % column] == findNum)
                return true;
        }
        return false;
    }
}
