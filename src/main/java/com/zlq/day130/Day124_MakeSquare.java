package com.zlq.day130;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day124_MakeSquare
 * @description:
 * @author: LiQun
 * @CreateDate:2022/6/1 23:56
 */
/*
你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i个火柴棒的长度。
你要用 所有的火柴棍拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。

如果你能使这个正方形，则返回 true ，否则返回 false 。


示例1:

输入: matchsticks = [1,1,2,2,2]
输出: true
解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例2:

输入: matchsticks = [3,3,3,3,4]
输出: false
解释: 不能用所有火柴拼成一个正方形。
 */
public class Day124_MakeSquare {
    public static void main(String[] args) {

        int[] matchsticks = {1, 1, 2, 2, 2};
        System.out.println(makesquare(matchsticks));
    }

    public static boolean makesquare(int[] matchsticks) {
        int length = matchsticks.length;
        int subLength = 0;
        for (int i = 0; i < length; i++) {
            subLength += matchsticks[i];
        }
        if (subLength % 4 != 0) {
            return false;
        } else {
            int everySideLength = subLength / 4;
            // 检查每一个火柴是否大于理论边长
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (matchsticks[i] > subLength) return false;
                list.add(matchsticks[i]);
            }
            int index = 0;
            int count;
            while (list.size() > 0) {

            }
        }
        return true;
    }
}
