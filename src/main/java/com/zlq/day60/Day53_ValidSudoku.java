package com.zlq.day60;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day53_ValidSudoku
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/17 8:47 下午
 */
public class Day53_ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '9', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
//                          {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
//                          {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
//                          {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
//                          {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
//                          {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
//                          {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
//                          {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
//                          {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        System.out.println(isValidSudoku(board));
/*

[[".",".",".",".","5",".",".","1","."]
,[".","4",".","3",".",".",".",".","."]
,[".",".",".",".",".","3",".",".","1"]
,["8",".",".",".",".",".",".","2","."]
,[".",".","2",".","7",".",".",".","."]
,[".","1","5",".",".",".",".",".","."]
,[".",".",".",".",".","2",".",".","."]
,[".","2",".","9",".",".",".",".","."]
,[".",".","4",".",".",".",".",".","."]]

        [0,1,2-9,10,11 -18-19-20]
        [3,4,5-12,13,14-21-22-23]


 */
    }

    public static boolean isValidSudoku(char[][] board) {
        // 判断每一行是否有重复的数字
        for (int i = 0; i < 9; i++) {
            boolean repetitiveInRow = isRepetitiveInRow(board[i].length, board[i]);
            if (!repetitiveInRow) return false;
        }
        // 判断每一列是否有重复的数字
        for (int i = 0; i < 9; i++) {
            boolean repetitiveInColumn = isRepetitiveInColumn(i, board);
            if (!repetitiveInColumn) return false;
        }
        // 判断每个九宫格是否有重复的数字
        for (int i = 1; i <= 9; i++) {
            boolean repetitiveInSmallSudoku = isRepetitiveInSmallSudoku(i, board);
            if (!repetitiveInSmallSudoku) return false;
        }
        return true;
    }


    /**
     * 判断同一行是否有相同数字
     *
     * @param rowLength
     * @return
     */
    private static boolean isRepetitiveInRow(int rowLength, char[] boardRow) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char c = boardRow[i];
            if (set.contains(c) && c != '.') return false;
            set.add(c);
        }
        return true;
    }

    /**
     * 判断同一列是否有相同数字
     *
     * @param columnNum
     * @param board
     * @return
     */
    private static boolean isRepetitiveInColumn(int columnNum, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char c = board[i][columnNum];

            if (set.contains(c)) return false;
            if (c != '.') set.add(c);
        }
        return true;
    }

    /**
     * 判断每一个小数独上是否有重复数字
     *
     * @param k 第几个数独
     */
    private static boolean isRepetitiveInSmallSudoku(int k, char[][] board) {
        Set<Character> set = new HashSet<>();
        int xStart = (k % 3) > 0 ? (k % 3) * 3 - 3 : 6;
        int xEnd = xStart + 2;
        int yStart = (k % 3) > 0 ? ((k / 3) + 1) * 3 - 3 : (k / 3) * 3 - 3;
        int yEnd = yStart + 2;
        for (int i = yStart; i <= yEnd; i++) {
            for (int j = xStart; j <= xEnd; j++) {
                char c = board[i][j];
                if (set.contains(c)) return false;
                if (c != '.') set.add(c);
            }
        }

        return true;
    }

    /*
    [[".",".","4",".",".",".","6","3","."],
     [".",".",".",".",".",".",".",".","."],
     ["5",".",".",".",".",".",".","9","."],
     [".",".",".","5","6",".",".",".","."],
     ["4",".","3",".",".",".",".",".","1"],
     [".",".",".","7",".",".",".",".","."],
     [".",".",".","5",".",".",".",".","."],
     [".",".",".",".",".",".",".",".","."],
     [".",".",".",".",".",".",".",".","."]]
     */
}
