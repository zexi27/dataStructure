package com.zlq.day80;


/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: Day72_Battleships
 * @description:
 * @author: LiQun
 * @CreateDate:2021/12/18 9:44 上午
 */
/*
给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
返回在甲板 board 上放置的 战舰 的数量。

战舰 只能水平或者垂直放置在 board 上。
换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。
两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。

示例 1：
输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
输出：2

示例 2：
输入：board = [["."]]
输出：0
 */
public class Day72_Battleships {
    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}};

        System.out.println(hasAdjacent(1, 3, board));
        System.out.println(board[0][3]);
        System.out.println(countBattleships(board));
    }

    public static int countBattleships(char[][] board) {
        int count = 0;
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'X' && !hasAdjacent(i, j, board)) count++;
            }
        }
        return count;
    }

    public static boolean hasAdjacent(int i, int j, char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        if ((i != rows - 1)) {
            if (board[i + 1][j] == 'X') return true;
        }
        if (j != columns - 1) {
            if (board[i][j + 1] == 'X') return true;
        }
        if ((i != 0)) {
            if (board[i - 1][j] == 'X') return true;
        }
        if (j != 0) {
            if (board[i][j - 1] == 'X') return true;
        }
        return false;
    }
}
