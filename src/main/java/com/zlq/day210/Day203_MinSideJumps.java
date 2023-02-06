package com.zlq.day210;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day203_MinSideJumps
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/24 21:48
 */
/*
1824. 最少侧跳次数
中等
111
相关企业
给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处。然而道路上可能有一些障碍。

给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。

比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。

比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。

注意：点 0 处和点 n 处的任一跑道都不会有障碍。

示例 1：
输入：obstacles = [0,1,2,3,0]
输出：2
解释：最优方案如上图箭头所示。总共有 2 次侧跳（红色箭头）。
注意，这只青蛙只有当侧跳时才可以跳过障碍（如上图点 2 处所示）。
示例 2：


输入：obstacles = [0,1,1,3,3,0]
输出：0
解释：跑道 2 没有任何障碍，所以不需要任何侧跳。
示例 3：


输入：obstacles = [0,2,1,0,3,0]
输出：2
解释：最优方案如上图所示。总共有 2 次侧跳。


提示：

obstacles.length == n + 1
1 <= n <= 5 * 105
0 <= obstacles[i] <= 3
obstacles[0] == obstacles[n] == 0
 */
public class Day203_MinSideJumps {
    public static void main(String[] args) {
        int[] obstacles = {0,0,0,0,2,1,2,0,2,2,3,3,3,0,0,1,1,3,0,0,0,1,2,2,1,2,1,3,2,2,3,1,3,0,1,1,1,3,0,0,0,2,0,2,0,3,1,2,3,3,2,2,2,0,0,0,1,0,0,0,0,3,0,0,0,3,0,2,1,2,3,1,0,3,3,2,0,1,1,0,1,0,2,2,2,1,3,0,3,0,2,1,1,3,1,0,1,2,2,0,0};
        System.out.println(minSideJumps(obstacles));
    }
    // 方法1：贪心
    /*
    1. 从起点开始一直向前
    2. 遇到障碍物开始侧跳，因为只有三条跑道，所以会有两个侧跳结果
    3. 两个侧跳路径同时向前侧跳，当侧跳路径率先遇到障碍，则将此条路径失效
    4. 直到终点
     */

    public static int minSideJumps(int[] obstacles) {
        int[] curPos1 = {0, 2};
        int[] curPos2 = null;
        int length = obstacles.length;
        int res = 0;
        while (curPos1[0] < length - 1) {
            if (curPos2 != null){
                if (obstacles[curPos2[0] + 1] == curPos2[1]){
                    // 如果pos2下一个位置有石头直接失效
                    curPos2 = null;
                }else if (obstacles[curPos1[0] + 1] == curPos1[1]){
                    curPos1 = curPos2;
                    curPos2 = null;
                }
            }
            if (obstacles[curPos1[0] + 1] == curPos1[1]) { // 如果下一个位置有石头，分出两个侧跳结果
                if (curPos1[1] == 1) { // 如果在1位置，往2,3侧跳
                    if (obstacles[curPos1[0]] == 2) { // 如果2有障碍，往3跳
                        curPos1[1] = 3;
                    } else if (obstacles[curPos1[0]] == 3) {
                        curPos1[1] = 2;
                    } else {
                        curPos2 = Arrays.copyOf(curPos1, 2);
                        curPos1[1] = 2;
                        curPos2[1] = 3;
                    }
                } else if (curPos1[1] == 2) { // 如果在2位置，往1,3侧跳
                    if (obstacles[curPos1[0]] == 1) { // 如果1有障碍，往3跳
                        curPos1[1] = 3;
                    } else if (obstacles[curPos1[0]] == 3) {
                        curPos1[1] = 1;
                    } else {
                        curPos2 = Arrays.copyOf(curPos1, 2);
                        curPos1[1] = 1;
                        curPos2[1] = 3;
                    }
                } else if (curPos1[1] == 3) {  // 如果在3位置，往1,2侧跳
                    if (obstacles[curPos1[0]] == 1) { // 如果1有障碍，往2跳
                        curPos1[1] = 2;
                    } else if (obstacles[curPos1[0]] == 2) {
                        curPos1[1] = 1;
                    } else {
                        curPos2 = Arrays.copyOf(curPos1, 2);
                        curPos1[1] = 1;
                        curPos2[1] = 2;
                    }
                }
                res++;
            }
            curPos1[0]++;
            if (curPos2 != null){
                curPos2[0]++;
            }
        }
        return res;
    }
}