package com.zlq.day90;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: LongestHappyString
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/7 11:49 上午
 */
/*
如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。

给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：

s 是一个尽可能长的快乐字符串。
s 中 最多 有a 个字母 'a'、b个字母 'b'、c 个字母 'c' 。
s 中只含有 'a'、'b' 、'c' 三种字母。
如果不存在这样的字符串 s ，请返回一个空字符串 ""。

示例 1：

输入：a = 1, b = 1, c = 7
输出："ccaccbcc"
解释："ccbccacc" 也是一种正确答案。
示例 2：

输入：a = 2, b = 2, c = 1
输出："aabbc"
示例 3：

输入：a = 7, b = 1, c = 0
输出："aabaa"
解释：这是该测试用例的唯一正确答案。
 */
public class Day81_LongestHappyString {
    public static void main(String[] args) {
        System.out.println(longestDiverseString(2, 10, 3));
    }

    /*
    核心思路：创建一个大顶堆，填入三个数组，每个数组记录要添加的字符和数量，因此堆顶永远是剩余次数最多的字符
    使用StringBuilder可变长字符串进行逐个append...
    - 如果该要填加的字符和前两个不相同（不满足三个相同），那就直接添加
    - 如果该要填加的字符和前两个相同（满足三个字符相同），那就添加堆顶的下一个元素

     */
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        if (a > 0) queue.add(new int[]{0, a});
        if (b > 0) queue.add(new int[]{1, b});
        if (c > 0) queue.add(new int[]{2, c});
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] curEle = queue.poll();
            int curLength = res.length();
            char c1 = (char) ('a' + curEle[0]);
            if (curLength >= 2 && res.charAt(curLength - 1) == c1 && res.charAt(curLength - 2) == c1) {
                if (queue.isEmpty()) break;
                int[] nextEle = queue.poll();
                char cNext = (char) ('a' + nextEle[0]);
                res.append(cNext);
                if (--nextEle[1] != 0) queue.add(nextEle);
                queue.add(curEle);
            } else {
                res.append((char) ('a' + curEle[0]));
                if (--curEle[1] != 0) queue.add(curEle);
            }
        }
        return res.toString();
    }
}
