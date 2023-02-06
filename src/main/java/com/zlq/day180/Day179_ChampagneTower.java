package com.zlq.day180;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day179_ChampagneTower
 * @description:
 * @author: LiQun
 * @CreateDate:2022/11/20 11:54
 */
/*
我们把玻璃杯摆成金字塔的形状，其中 第一层 有 1 个玻璃杯， 第二层 有 2 个，依次类推到第 100 层，每个玻璃杯 (250ml) 将盛有香槟。

从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）

例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。

现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（ i 和 j 都从0开始）。

示例 1:
输入: poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1
输出: 0.00000
解释: 我们在顶层（下标是（0，0））倒了一杯香槟后，没有溢出，因此所有在顶层以下的玻璃杯都是空的。

示例 2:
输入: poured(倾倒香槟总杯数) = 2, query_glass(杯子的位置数) = 1, query_row(行数) = 1
输出: 0.50000
解释: 我们在顶层（下标是（0，0）倒了两杯香槟后，有一杯量的香槟将从顶层溢出，位于（1，0）的玻璃杯和（1，1）的玻璃杯平分了这一杯香槟，所以每个玻璃杯有一半的香槟。
示例 3:

输入: poured = 100000009, query_row = 33, query_glass = 17
输出: 1.00000
 */
public class Day179_ChampagneTower {

    public static double champagneTower2(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[1][1] = poured;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 0 || j == i) dp[i][j] = Math.max(dp[i - 1][0] - 1, 0) / 2.0;
                dp[i][j] = Math.max(dp[i - 1][j - 1] - 1, 0) / 2.0 + Math.max(dp[i - 1][j] - 1, 0) / 2.0;
            }
        }
        return Math.min(dp[query_row + 1][query_glass + 1], 1);
    }

    /*
    你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束（包括 lowLimit 和 highLimit ，即 n == highLimit - lowLimit + 1）。另有无限数量的盒子，编号从 1 到 infinity 。

    你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。

    给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。

    示例 1：

    输入：lowLimit = 1, highLimit = 10
    输出：2
    解释：
    盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
    小球数量：2 1 1 1 1 1 1 1 1 0  0  ...
    编号 1 的盒子放有最多小球，小球数量为 2 。
    示例 2：

    输入：lowLimit = 5, highLimit = 15
    输出：2
    解释：
    盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
    小球数量：1 1 1 1 2 2 1 1 1 0  0  ...
    编号 5 和 6 的盒子放有最多小球，每个盒子中的小球数量都是 2 。
    示例 3：

    输入：lowLimit = 19, highLimit = 28
    输出：2
    解释：
    盒子编号：1 2 3 4 5 6 7 8 9 10 11 12 ...
    小球数量：0 1 1 1 1 1 1 1 1 2  0  0  ...
    编号 10 的盒子放有最多小球，小球数量为 2 。
     */
    public static void main(String[] args) {
        System.out.println(countBalls2(5, 15));
    }

    public static int countBalls(int lowLimit, int highLimit) {
        int ballCount = highLimit - lowLimit + 1;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int boxNum = 0;
            int param = 10;
            while (true) {
                boxNum += i % param / (param / 10);
                if (i % param == i) break;
                param *= 10;
            }
            map.put(boxNum, map.getOrDefault(boxNum, 0) + 1);
        }
        return map.values().stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList()).get(0);
    }

    public static int countBalls2(int lowLimit, int highLimit) {
        int[] boxArr = new int[45];
        int curMax = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int boxNum = 0;
            int param = 10;
            while (true) {
                boxNum += i % param / (param / 10);
                if (i % param == i) break;
                param *= 10;
            }
            curMax = Math.max(++boxArr[boxNum - 1],curMax);
        }
        return curMax;
    }


    }
