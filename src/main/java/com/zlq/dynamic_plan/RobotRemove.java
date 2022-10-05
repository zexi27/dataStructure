package com.zlq.dynamic_plan;

import com.sun.org.apache.bcel.internal.generic.RET;

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
        System.out.println(numberOfMethods(1,5,6,7));
        System.out.println(ways1(7,1,5,6));
    }
    public static int numberOfMethods(int start, int aim, int step, int N) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || step < 1) {
            return -1;
        }
        return way(start,aim,step,N);
    }

    public static int way(int cur, int aim, int restStep, int N) {
        // base case
        if (restStep == 0) {
            if (cur == aim) return 1;
            else return 0;
        }
        // 最左位置
        if (cur == 1) return way(2, aim, restStep - 1, N);
        // 最右位置
        if (cur == N) return way(N - 1, aim, restStep - 1, N);
        // 中间位置
        return way(cur + 1, aim, restStep - 1, N) + way(cur - 1, aim, restStep - 1, N);
    }


    public static int ways1(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        return process1(start, K, aim, N);
    }

    // 机器人当前来到的位置是cur，
    // 机器人还有rest步需要去走，
    // 最终的目标是aim，
    // 有哪些位置？1~N
    // 返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) { // 如果已经不需要走了，走完了！
            return cur == aim ? 1 : 0;
        }
        // (cur, rest)
        if (cur == 1) { // 1 -> 2
            return process1(2, rest - 1, aim, N);
        }
        // (cur, rest)
        if (cur == N) { // N-1 <- N
            return process1(N - 1, rest - 1, aim, N);
        }
        // (cur, rest)
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }
}
