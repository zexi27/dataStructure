package com.zlq.day260;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @CreateDate:2023/6/2 16:39
 */
/*
2559. 统计范围内的元音字符串数
给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。

每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。

返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。

注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。



示例 1：

输入：words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
输出：[2,3,0]
解释：以元音开头和结尾的字符串是 "aba"、"ece"、"aa" 和 "e" 。
查询 [0,2] 结果为 2（字符串 "aba" 和 "ece"）。
查询 [1,4] 结果为 3（字符串 "ece"、"aa"、"e"）。
查询 [1,1] 结果为 0 。
返回结果 [2,3,0] 。
示例 2：

输入：words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
输出：[3,2,1]
解释：每个字符串都满足这一条件，所以返回 [3,2,1] 。


提示：

1 <= words.length <= 105
1 <= words[i].length <= 40
words[i] 仅由小写英文字母组成
sum(words[i].length) <= 3 * 105
1 <= queries.length <= 105
0 <= queries[j][0] <= queries[j][1] < words.length

 */
public class Day255_VowelStrings {

//    public static void main(String[] args) {
//        String[] words = {"bzmxvzjxfddcuznspdcbwiojiqf", "mwguoaskvramwgiweogzulcinycosovozppl", "uigevazgbrddbcsvrvnngfrvkhmqszjicpieahs", "uivcdsboxnraqpokjzaayedf", "yalc", "bbhlbmpskgxmxosft", "vigplemkoni", "krdrlctodtmprpxwditvcps", "gqjwokkskrb", "bslxxpabivbvzkozzvdaykaatzrpe", "qwhzcwkchluwdnqjwhabroyyxbtsrsxqjnfpadi", "siqbezhkohmgbenbkikcxmvz", "ddmaireeouzcvffkcohxus", "kjzguljbwsxlrd", "gqzuqcljvcpmoqlnrxvzqwoyas", "vadguvpsubcwbfbaviedr", "nxnorutztxfnpvmukpwuraen", "imgvujjeygsiymdxp", "rdzkpk", "cuap", "qcojjumwp", "pyqzshwykhtyzdwzakjejqyxbganow", "cvxuskhcloxykcu", "ul", "axzscbjajazvbxffrydajapweci"};
//        int[][] queries = {{4, 4}, {6, 17}, {10, 17}, {9, 18}, {17, 22}, {5, 23}, {2, 5}, {17, 21}, {5, 17}, {4, 8}, {7, 17}, {16, 19}, {7, 12}, {9, 20}, {13, 23}, {1, 5}, {19, 19}};
//        Day255_VowelStrings vowelStrings = new Day255_VowelStrings();
//        System.out.println(Arrays.toString(vowelStrings.vowelStrings(words, queries)));
//    }


    // 前缀和
    public int[] vowelStrings(String[] words, int[][] queries) {
        int length = words.length;
        int[] perfixSumArr = new int[length];
        int curVowelSum = 0;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                curVowelSum++;
            }
            perfixSumArr[i] = curVowelSum;
        }
        int resLength = queries.length;
        int[] resArr = new int[resLength];
        for (int i = 0; i < resLength; i++) {
            resArr[i] = perfixSumArr[queries[i][1]] - (queries[i][0] - 1 >= 0 ? perfixSumArr[queries[i][0] - 1] : 0);
        }
        return resArr;
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 0, 3, 5};
        System.out.println(distinctAverages(nums));
    }

    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        Set<Double> resSet = new HashSet<>();
        while (l < r) {
            resSet.add(((double) (nums[l] + nums[r]) / 2));
            l++;
            r--;
        }
        return resSet.size();
    }
}
