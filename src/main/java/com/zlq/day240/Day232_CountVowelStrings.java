package com.zlq.day240;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day240
 * @ClassName: Day232_CountVowelStrings
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/29 12:06
 */
/*
1641. 统计字典序元音字符串的数目
中等
给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。

字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。

示例 1：

输入：n = 1
输出：5
解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
示例 2：

输入：n = 2
输出：15
解释：仅由元音组成的 15 个字典序字符串为
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
示例 3：

输入：n = 33
输出：66045

提示：

1 <= n <= 50
 */
public class Day232_CountVowelStrings {

    /*
    n = 1:  1 + 1 + 1 + 1 + 1
    n = 2:  5 + 4 + 3 + 2 + 1
    ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
    ["aaa","aae","aai","aao","aau","aee","aei","aeo","aeu","aii","aio","aiu"]

    n = 3:  5 + 4 + 3 + 2 + 1 + 4 + 3 + 2 + 1 + 3 + 2 + 1 + 2 + 1 + 1

    5
    5+4+3+2+1
    (5+4+3+2+1 + 4+3+2+1 + 3+2+1 + 2+1 + 1)
    (5+4+3+2+1 + 4+3+2+1 + 3+2+1 + 2+1 + 1) + (4+3+2+1 + 3+2+1 + 2+1 + 1) + (3+2+1 + 2+1 + 1) + (2+1 + 1) + (1)
    ((5+4+3+2+1 + 4+3+2+1 + 3+2+1 + 2+1 + 1) + (4+3+2+1 + 3+2+1 + 2+1 + 1) + (3+2+1 + 2+1 + 1) + (2+1 + 1)) + ((4+3+2+1 + 3+2+1 + 2+1 + 1) + (3+2+1 + 2+1 + 1) + (2+1) + (1)) + ((3+2+1 + 2+1 + 1) + (2+1) + (1)) + ((2+1) + (1)) + ((1))
     ------------
     1 + 1 + 1 + 1 + 1                        5
     5 + 4 + 3 + 2 + 1        15
     15 + 10 + 6 + 3 + 1      35
     (35) + (20) + (10) + (4) + (1)     70
     sum(上一行数组和) +  arr[0] - 上一行数组第一个 +  arr[1] - 上一行数组第二个

     */
    public static void main(String[] args) {
        int n = 33;
        System.out.println(countVowelStrings(n));
    }
    public static int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for (int i = 0; i < 5; i++) dp[0][i] = 1;
        int sumLastLine = 5;
        for (int i = 1; i < n; i++) {
            dp[i][0] = sumLastLine;
            for (int j = 1; j < 5; j++) {
                dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1];
            }
            sumLastLine = Arrays.stream(dp[i]).sum();
        }
       return sumLastLine;
    }


    public static int maxWidthOfVerticalArea(int[][] points) {
        int length = points.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);
        int maxWidth  =0;
        for (int i = 1; i < length; i++) {
            maxWidth = Math.max(maxWidth,arr[i] - arr[i - 1]);
        }
        return maxWidth;
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (Integer integer : set) {
            if (set.contains(integer + diff) && set.contains(integer + diff * 2))  count++;
        }
        return count;
    }
}

