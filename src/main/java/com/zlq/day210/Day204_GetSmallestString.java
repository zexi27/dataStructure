package com.zlq.day210;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day204_GetSmallestString
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/26 09:51
 */
/*
具有给定数值的最小字符串
小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。

字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。

给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。

注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：

x 是 y 的一个前缀；
如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。

示例 1：

输入：n = 3, k = 27
输出："aay"
解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
示例 2：

输入：n = 5, k = 73
输出："aaszz"
 */
public class Day204_GetSmallestString {
    public static void main(String[] args) {
        int n = 3, k = 27;
        System.out.println(getSmallestString2(n, k));
    }

    public static String getSmallestString(int n, int k) {
        StringBuilder res1 = new StringBuilder();
        int curVal = 0;
        int l = 1;
        char appendChar = ' ';
        //如果能放a，则剩余的n - l 个位置 * 26 必然大于等于剩余value
        while (l < n && k - curVal <= (n - l) * 26) {
            appendChar = 'a';
            res1.append(appendChar);
            curVal += appendChar - 'a' + 1;
            l++;
        }
        int r = n;
        StringBuilder res2 = new StringBuilder();
        while (r >= l) {
            if (k - curVal < 26) {
                appendChar = (char) ('a' + k - curVal - 1);
                res2.append(appendChar);
            } else {
                appendChar = 'z';
                res2.append(appendChar);
            }
            curVal += appendChar - 'a' + 1;
            r--;
        }
        return res1.append(res2.reverse()).toString();
    }


    public static String getSmallestString2(int n, int k) {
        char[] charArr = new char[n];
        int curVal = 0;
        int l = 1;
        char appendChar = ' ';
        //如果能放a，则剩余的n - l 个位置 * 26 必然大于等于剩余value
        while (l < n) {
            if (k - curVal <= (n - l) * 26) appendChar = 'a';
            else break;
            charArr[l - 1] = appendChar;
            curVal += appendChar - 'a' + 1;
            l++;
        }
        int r = n;
        while (r >= l) {
            if (k - curVal < 26) appendChar = (char) ('a' + k - curVal - 1);
            else appendChar = 'z';
            charArr[r - 1] = appendChar;
            curVal += appendChar - 'a' + 1;
            r--;
        }
        return new String(charArr);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int length = heights.length;
        String[] res = new String[length];
        Map<Integer,Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < length; i++) {
            map.put(heights[i],i);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            res[index] = names[map.get(key)];
            index++;
        }
        return res;
    }
}
