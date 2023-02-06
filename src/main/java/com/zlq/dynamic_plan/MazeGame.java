package com.zlq.dynamic_plan;

import java.nio.file.Path;
import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.dynamic_plan
 * @ClassName: MazeGame
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/6 14:34
 */
/*
定义一个二维数组 N*M ，如 5 × 5 数组下所示：


int maze[5][5] = {
0, 1, 0, 0, 0,
0, 1, 1, 1, 0,
0, 0, 0, 0, 0,
0, 1, 1, 1, 0,
0, 0, 0, 1, 0,
};


它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。


数据范围： 2 \le n,m \le 10 \2≤n,m≤10  ， 输入的内容只包含 0 \le val \le 1 \0≤val≤1

输入描述：
输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

输出描述：
左上角到右下角的最短路径，格式如样例所示。

示例1
输入：
5 5
0 1 0 0 0
0 1 1 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
复制
输出：
(0,0)
(1,0)
(2,0)
(2,1)
(2,2)
(2,3)
(2,4)
(3,4)
(4,4)
复制
示例2
输入：
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 1
0 1 1 1 0
0 0 0 0 0
复制
输出：
(0,0)
(1,0)
(2,0)
(3,0)
(4,0)
(4,1)
(4,2)
(4,3)
(4,4)

复制
说明：
注意：不能斜着走！！
 */
public class MazeGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int row = in.nextInt();
            int column = in.nextInt();
            int[][] maze = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    maze[i][j] = in.nextInt();
                }
            }
            List<int[]> resList = new ArrayList<>(); // 路径集合，每个元素里面是个数组长度为2，分别是x和y的坐标
            dfs(maze, 0, 0, resList);
            for (int i = 0; i < resList.size(); i++) {
                System.out.println("(" + resList.get(i)[0] + "," + resList.get(i)[1] + ")");
            }
        }


    }

    public static boolean dfs(int[][] maze, int x, int y, List<int[]> resList) {
        int[] ele = {x, y};
        resList.add(ele);
        maze[x][y] = 1;
        // base case ,结束标志
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            return true;
        }
        // 向下走
        if (x + 1 < maze.length && maze[x + 1][y] == 0) {
            if (dfs(maze, x + 1, y, resList)) return true;
        }
        // 向上走
        if (x - 1 > -1 && maze[x - 1][y] == 0) {
            if (dfs(maze, x - 1, y, resList)) return true;
        }
        // 向左走
        if (y - 1 > -1 && maze[x][y - 1] == 0) {
            if (dfs(maze, x, y - 1, resList)) return true;
        }
        // 向右走
        if (y + 1 < maze[0].length && maze[x][y + 1] == 0) {
            if (dfs(maze, x, y + 1, resList)) return true;
        }
        // 回溯
        resList.remove(resList.size() - 1);
        maze[x][y] = 0;
        return false;
    }
}


