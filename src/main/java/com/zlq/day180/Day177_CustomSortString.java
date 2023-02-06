package com.zlq.day180;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day177_CustomSortString
 * @description:
 * @author: LiQun
 * @CreateDate:2022/11/14 11:14
 */
/*
You are given two strings order and s.
All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted.
More specifically, if a character x occurs before a character y in order,
then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

Example 1:

Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
Example 2:

Input: order = "cbafg", s = "abcd"
Output: "cbad"

 */
public class Day177_CustomSortString {


    public static String customSortString(String order, String s) {
        List<Character> sList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            sList.add(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        int index = 0;
        for (int i = 0; i < order.length(); i++) {
            char ele = order.charAt(i);
            while (sList.contains(ele)) {
                res.append(ele);
                sList.remove(new Character(ele));
                index++;
            }
        }
        for (int i = 0; i < sList.size(); i++) {
            res.append(sList.get(i));
        }
        return res.toString();
    }

    public static String customSortString2(String order, String s) {
        int[] indexArr = new int[26]; // 对 s中的词频进行统计
        for (int i = 0; i < s.length(); i++) indexArr[s.charAt(i) - 'a']++;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            while (indexArr[c - 'a']-- > 0) res.append(c);
        }
        for (int i = 0; i < indexArr.length; i++) while (indexArr[i]-- > 0) res.append((char) (i + 'a'));
        return res.toString();
    }

    /*
    请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，
    其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：

    numberOfBoxesi 是类型 i 的箱子的数量。
    numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
    整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。
    只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。

    返回卡车可以装载 单元 的 最大 总数。


    示例 1：

    输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
    输出：8
    解释：箱子的情况如下：
    - 1 个第一类的箱子，里面含 3 个单元。
    - 2 个第二类的箱子，每个里面含 2 个单元。
    - 3 个第三类的箱子，每个里面含 1 个单元。
    可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
    单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8

    示例 2：

    输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
    输出：91
     */
    public static void main(String[] args) {
        int[][] boxTypes = {{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}, {1, 3}, {4, 3}, {5, 3}, {5, 3}};
//        System.out.println(maximumUnits(boxTypes, 13));
        System.out.println(maximumUnits2(boxTypes, 13));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        TreeMap<Integer, Integer> boxesMap = new TreeMap<>((o1, o2) -> o2 - o1); // key为箱子的大小，value为箱子的个数
        for (int i = 0; i < boxTypes.length; i++) {
            int boxSize = boxTypes[i][1];
            int boxCount = boxTypes[i][0];
            boxesMap.put(boxSize, boxesMap.getOrDefault(boxSize, 0) + boxCount);
        }
        int curSize = 0;
        int total = 0;
        Iterator<Integer> iterator = boxesMap.keySet().iterator();
        while (iterator.hasNext() && curSize < truckSize) {
            Integer boxSize = iterator.next();
            Integer boxCount = boxesMap.get(boxSize);
            while (boxCount > 0 && curSize < truckSize) {
                total += boxSize;
                boxCount--;
                curSize++;
            }

        }
        return total;
    }

    public static int maximumUnits2(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int total = 0, curSize = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int boxCount = boxTypes[i][0];
            int boxSize = boxTypes[i][1];
            if (boxCount < truckSize - curSize) {
                total += boxCount * boxSize;
                curSize += boxCount;
            }
            else {
                total+= (truckSize - curSize) * boxSize;
                break;
            }
        }
        return total;
    }


}
