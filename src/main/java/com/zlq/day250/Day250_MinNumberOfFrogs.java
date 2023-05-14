package com.zlq.day250;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day250_MinNumberOfFrogs
 * @description:
 * @author: LiQun
 * @CreateDate:2023/5/6 22:22
 */
/*
1419. Minimum Number of Frogs Croaking
中等
You are given the string croakOfFrogs, which represents a combination of the string "croak" from different frogs, that is, multiple frogs can croak at the same time, so multiple "croak" are mixed.

Return the minimum number of different frogs to finish all the croaks in the given string.

A valid "croak" means a frog is printing five letters 'c', 'r', 'o', 'a', and 'k' sequentially. The frogs have to print all five letters to finish a croak. If the given string is not a combination of a valid "croak" return -1.



Example 1:

Input: croakOfFrogs = "croakcroak"
Output: 1
Explanation: One frog yelling "croak" twice.
Example 2:

Input: croakOfFrogs = "crcoakroak"
Output: 2
Explanation: The minimum number of frogs is two.
The first frog could yell "crcoakroak".
The second frog could yell later "crcoakroak".
Example 3:

Input: croakOfFrogs = "croakcrook"
Output: -1
Explanation: The given string is an invalid combination of "croak" from different frogs.

Constraints:

1 <= croakOfFrogs.length <= 105
croakOfFrogs is either 'c', 'r', 'o', 'a', or 'k'.
 */
public class Day250_MinNumberOfFrogs {
    public static void main(String[] args) {
        String croakOfFrogs = "croakcrook";
        System.out.println(isContinuous(croakOfFrogs));
    }
    public static int minNumberOfFrogs(String croakOfFrogs) {
        // 如果是连续的croak ,例如croakcroakcroak，只叫一声
        if (isContinuous(croakOfFrogs)) return 1;
        int[] indexArr = new int[26];
        // 初始化字母索引数组
        for (int i = 0; i < croakOfFrogs.length(); i++) indexArr[croakOfFrogs.charAt(i) - 'a']++;
        // 如果字母之间的数量不等，就不是有效的字符串
        if (!isEqualCount(indexArr)) return -1;
        // 开始叫


        return 0;
    }

    private static boolean isEqualCount(int[] indexArr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < indexArr.length; i++) {
            if (indexArr[i] != 0 && !set.contains(indexArr[i])){
                set.add(indexArr[i]);
            }
        }
        return set.size() == 1;
    }
    private static boolean isContinuous(String croakOfFrogs) {
        int length = croakOfFrogs.length();
        if (length % 5 != 0) return false;
        int l = 0,r = 5;
        while (r < length){
            if (!croakOfFrogs.substring(l,r).equals("croak")){
                return false;
            }
            l +=5;
            r +=5;
        }
        return true;
    }

}
