package com.zlq.day80;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: Day73_EatenApples
 * @description:
 * @author: LiQun
 * @CreateDate:2021/12/24 9:33 上午
 */
/*
有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。
在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，
变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。

你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。

给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。


示例 1：

输入：apples = [1,2,3,5,2],
        days = [3,2,1,4,2]
输出：7
解释：你可以吃掉 7 个苹果：
- 第一天，你吃掉第一天长出来的苹果。
- 第二天，你吃掉一个第二天长出来的苹果。
- 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
- 第四天到第七天，你吃的都是第四天长出来的苹果。
示例 2：

输入：apples = [3,0,0,0,0,2],
        days = [3,0,0,0,0,2]
输出：5
解释：你可以吃掉 5 个苹果：
- 第一天到第三天，你吃的都是第一天长出来的苹果。
- 第四天和第五天不吃苹果。
- 第六天和第七天，你吃的都是第六天长出来的苹果
 */
public class Day73_EatenApples {
    public static void main(String[] args) {
        int[] apples = {1, 2, 3, 5, 2};
        int[] days = {3, 2, 1, 4, 2};
        System.out.println(eatenApples(apples, days));
    }

    public static int eatenApples(int[] apples, int[] days) {
        int day = 0;    // 定义能吃的天数
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < apples.length; i++) {
            queue.add(new int[]{apples[i], days[i] + i}); // list里面存的是每天苹果生产数量和有效期时间
        }
        while (!queue.isEmpty()) {
            // 每天都吃要烂的苹果
            

        }
        return 0;
    }
}
