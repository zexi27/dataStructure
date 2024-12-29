package com.zlq.dynamic_plan;


/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.dynamic_plan
 * @ClassName: RobotRemove
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/5 10:45
 */
/*
假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2,开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
如果机器人来到1位置，那么下一步只能往右来到2位置；
如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
如果机器人来到中间位置，那么下一步可以往左走或者往右走；
规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
给定四个参数 N、M、K、P，返回方法数。
N-位置的终点
M-机器人的初始位置
K-机器人走的步数
P-机器人的目标点

 */
public class RobotRemove {
    public static void main(String[] args) {
        System.out.println(numberOfMethods1(2, 4, 6, 5));
        System.out.println(numberOfMethods2(2, 4, 6, 5));
        System.out.println(way3Dp(2, 4, 6, 5));
    }

    public static int numberOfMethods1(int start, int aim, int step, int N) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || step < 1) {
            return -1;
        }
        return way1(start, aim, step, N);
    }

    public static int numberOfMethods2(int start, int aim, int step, int N) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || step < 1) {
            return -1;
        }
        int[][] dp = new int[step + 1][N];
        // 初始化缓存
        for (int i = 0; i < step + 1; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        int res = way2(start, aim, step, N, dp);
        return res;
    }

    public static int way1(int cur, int aim, int restStep, int N) {
        // base case
        if (restStep == 0) {
            if (cur == aim) return 1;
            else return 0;
        }
        // 最左位置
        if (cur == 1) return way1(2, aim, restStep - 1, N);
        // 最右位置
        if (cur == N) return way1(N - 1, aim, restStep - 1, N);
        // 中间位置
        return way1(cur + 1, aim, restStep - 1, N) + way1(cur - 1, aim, restStep - 1, N);
    }

    public static int way2(int cur, int aim, int restStep, int N, int[][] dp) {
        if (dp[restStep][cur - 1] != -1) return dp[restStep][cur - 1];
        int res = 0;

        if (restStep == 0) {
            if (cur == aim) res = 1;
            else res = 0;
        } else if (cur == 1) {
            res = way2(2, aim, restStep - 1, N, dp);
        } else if (cur == N) {
            res = way2(N - 1, aim, restStep - 1, N, dp);
        } else {
            res = way2(cur + 1, aim, restStep - 1, N, dp) + way2(cur - 1, aim, restStep - 1, N, dp);
        }
        dp[restStep][cur - 1] = res;
        return res;
    }

    public static int way3Dp(int start, int aim, int step, int N) {
        int[][] dp = new int[step + 1][N];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i == aim - 1 ? 1 : 0;
        }
        for (int i = 1; i <= step; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j < N - 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
            }
            dp[i][N - 1] = dp[i - 1][N - 2];
        }

        return dp[step][start - 1];

    }


}
