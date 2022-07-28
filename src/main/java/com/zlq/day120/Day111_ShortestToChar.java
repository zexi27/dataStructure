package com.zlq.day120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day120
 * @ClassName: Day111_ShortestToChar
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/19 22:58
 */

/*
给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。

返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。

两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。

示例 1：

输入：s = "loveleetcode", c = "e"
输出：[3,2,1,0,1,0,0,1,2,2,1,0]
解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
示例 2：

输入：s = "aaab", c = "b"
输出：[3,2,1,0]
 */
public class Day111_ShortestToChar {

    public static void main(String[] args) {
        String s = "aaab";
        char c = 'b';
        System.out.println(Arrays.toString(shortestToChar(s,c)));
    }

    public static int[] shortestToChar(String s, char c) {
        List<Integer> targetIndexList = new ArrayList<>();  // 目标char的索引集合
        int length = s.length();
        // 将目标char的索引加入集合
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (charAt == c) {
                targetIndexList.add(i);
            }
        }
        int[] resArr = new int[length];  // 定义结果数组
        for (int i = 0; i < length; i++) {
            if (targetIndexList.size() > 1) {
                int distance1 = targetIndexList.get(0) - i;
                int distance2 = targetIndexList.get(1) - i;
                if (Math.abs(distance1) > Math.abs(distance2)) {
                    resArr[i] = distance2;
                    targetIndexList.remove(0);
                }else {
                    resArr[i] = Math.abs(distance1);
                }
            } else {
                resArr[i] = Math.abs(targetIndexList.get(0) - i);
            }
        }
        return resArr;
    }
}
