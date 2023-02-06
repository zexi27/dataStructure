package com.zlq.day190;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day190
 * @ClassName: Day184_MinOperations
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/2 10:38
 */
/*
有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。

在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。

返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。

每个 answer[i] 都需要根据盒子的 初始状态 进行计算。



示例 1：

输入：boxes = "110"
输出：[1,1,3]
解释：每个盒子对应的最小操作数如下：
1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
示例 2：

输入：boxes = "001011"
输出：[11,8,5,4,3,4]
 */
public class Day184_MinOperations {


    public static int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] resArr = new int[length];
        int countOne = 0, startCount = 0;
        for (int i = 0; i < length; i++) {
            if (boxes.charAt(i) == '1') {
                countOne++;
                startCount += i;
            }
        }
        resArr[0] = startCount;
        int lc = 0, rc = countOne;
        for (int i = 1; i < length; i++) {
            if (boxes.charAt(i - 1) == '1') {
                lc++;
                rc--;
            }
            resArr[i] = resArr[i - 1] + lc - rc;

        }
        return resArr;
    }

    /*
    给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
    混合字符串 由小写英文字母和数字组成。
    示例 1：

    输入：s = "dfa12321afd"
    输出：2
    解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
    示例 2：

    输入：s = "abc1111"
    输出：-1
    解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
     */
    public static void main(String[] args) {
        String s = "dfa12321afd";
        System.out.println(secondHighest2(s));
    }

    public static int secondHighest(String s) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9 && !numList.contains(c - '0')) numList.add(c - '0');
        }
        if (numList.size() < 2) return -1;
        else return numList.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList()).get(1);
    }

    public static int secondHighest2(String s) {
        List<Integer> numList = new ArrayList<>();
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int curNum = c - '0';
            if (curNum >= 0 && curNum <= 9 && !numList.contains(curNum)) {
                numList.add(curNum);
            }
            if (curNum >= 0 && curNum <= 9 && curNum > maxNum) maxNum = curNum;
        }
        if (numList.size() < 2) return -1;
        int minDifference = Integer.MAX_VALUE;
        int minValue = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) != maxNum && maxNum - numList.get(i) < minDifference) {
                minDifference = maxNum - numList.get(i);
                minValue = numList.get(i);
            }
        }
        return minValue;
    }
}
