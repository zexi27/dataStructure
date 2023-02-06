package com.zlq.day200;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day200
 * @ClassName: Day191_MaximumScore
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/21 12:13
 */
/*
你正在玩一个单人游戏，面前放置着大小分别为 a、b 和 c 的 三堆 石子。

每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。

给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。


示例 1：

输入：a = 2, b = 4, c = 6
输出：6
解释：石子起始状态是 (2, 4, 6) ，最优的一组操作是：
- 从第一和第三堆取，石子状态现在是 (1, 4, 5)
- 从第一和第三堆取，石子状态现在是 (0, 4, 4)
- 从第二和第三堆取，石子状态现在是 (0, 3, 3)
- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
总分：6 分 。
示例 2：

输入：a = 4, b = 4, c = 6
输出：7
解释：石子起始状态是 (4, 4, 6) ，最优的一组操作是：
- 从第一和第二堆取，石子状态现在是 (3, 3, 6)
- 从第一和第三堆取，石子状态现在是 (2, 3, 5)
- 从第一和第三堆取，石子状态现在是 (1, 3, 4)
- 从第一和第三堆取，石子状态现在是 (0, 3, 3)
- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
总分：7 分 。
示例 3：

输入：a = 1, b = 8, c = 8
输出：8
解释：最优的一组操作是连续从第二和第三堆取 8 回合，直到将它们取空。
注意，由于第二和第三堆已经空了，游戏结束，不能继续从第一堆中取石子。
 */
public class Day191_MaximumScore {
    /*
    (2,4,6) (2,3,5) (2,2,4),(2,1,3)(1,1,2) (1,0,1) (0,0,0)
    (1,8,8) (1,7,7) (1,6,6) (1,5,5) (1,4,4) (1,3,3) (1,2,2) (1,1,1) (1,0,0)
     */
    public static void main(String[] args) {
        System.out.println(maximumScore(4, 4, 6));
    }

    public static int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        int count = 0;
        while (queue.size() > 1) {
            Integer first = queue.poll();
            Integer second = queue.poll();
            first -= 1;
            second -= 1;
            if (first > 0) queue.offer(first);
            if (second > 0) queue.offer(second);
            count++;

        }

        return count;
    }


    /*
    存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：

    ++X 和 X++ 使变量 X 的值 加 1
    --X 和 X-- 使变量 X 的值 减 1
    最初，X 的值是 0

    给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。

    示例 1：

    输入：operations = ["--X","X++","X++"]
    输出：1
    解释：操作按下述步骤执行：
    最初，X = 0
    --X：X 减 1 ，X =  0 - 1 = -1
    X++：X 加 1 ，X = -1 + 1 =  0
    X++：X 加 1 ，X =  0 + 1 =  1
    示例 2：

    输入：operations = ["++X","++X","X++"]
    输出：3
    解释：操作按下述步骤执行：
    最初，X = 0
    ++X：X 加 1 ，X = 0 + 1 = 1
    ++X：X 加 1 ，X = 1 + 1 = 2
    X++：X 加 1 ，X = 2 + 1 = 3
    示例 3：

    输入：operations = ["X++","++X","--X","X--"]
    输出：0
    解释：操作按下述步骤执行：
    最初，X = 0
    X++：X 加 1 ，X = 0 + 1 = 1
    ++X：X 加 1 ，X = 1 + 1 = 2
    --X：X 减 1 ，X = 2 - 1 = 1
    X--：X 减 1 ，X = 1 - 1 = 0
     */
        public static int finalValueAfterOperations(String[] operations) {
            int res = 0;
            for (int i = 0; i < operations.length; i++) {
                String operation = operations[i];
                if (operation.charAt(1) == '+') res += 1;
                else res -= 1;
            }
            return res;
        }


}
