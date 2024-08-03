package com.zlq.day260;

import java.util.*;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/6/15 15:02
 */
/*
1177. Can Make Palindrome from Substring
中等
165
相关企业
You are given a string s and array queries where queries[i] = [lefti, righti, ki]. We may rearrange the substring s[lefti...righti] for each query and then choose up to ki of them to replace with any lowercase English letter.

If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.

Return a boolean array answer where answer[i] is the result of the ith query queries[i].

Note that each letter is counted individually for replacement, so if, for example s[lefti...righti] = "aaa", and ki = 2, we can only replace two of the letters. Also, note that no query modifies the initial string s.



Example :

Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
Output: [true,false,false,true,true]
Explanation:
queries[0]: substring = "d", is palidrome.
queries[1]: substring = "bc", is not palidrome.
queries[2]: substring = "abcd", is not palidrome after replacing only 1 character.
queries[3]: substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
queries[4]: substring = "abcda", could be changed to "abcba" which is palidrome.
Example 2:

Input: s = "lyb", queries = [[0,1,0],[2,2,1]]
Output: [false,true]


Constraints:

1 <= s.length, queries.length <= 105
0 <= lefti <= righti < s.length
0 <= ki <= s.length
s consists of lowercase English letters.
 */
public class Day256_CanMakeDaleQueries {
    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> booleans = canMakePaliQueries(s, queries);
    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int length = s.length();
        int[][] prefixSumArr = new int[length][26];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                char c = s.charAt(j);
                prefixSumArr[i][c - 'a']++;
            }
        }
        for (int i = 0; i < prefixSumArr.length; i++) {
            System.out.println(Arrays.toString(prefixSumArr[i]));
        }
        System.out.println("----------------");
        int[] indexArr = new int[26];
        List<Boolean> resList = new ArrayList<>();
        Map<Integer, Integer> charMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < 26; j++) {
                int start = queries[i][0];
                int end = queries[i][1];
                if (start - 1 < 0) indexArr[j] = prefixSumArr[end][j] - 0;
                else indexArr[j] = prefixSumArr[end][j] - prefixSumArr[start - 1][j];

            }
            System.out.println(Arrays.toString(indexArr));
            charMap.clear();
            for (int j = 0; j < indexArr.length; j++) {
                charMap.put(indexArr[j], charMap.getOrDefault(indexArr[j], 0) + 1);
            }
            // check if it is palindrome
            if (isPalindrome(charMap, queries[2])) resList.add(true);
            else resList.add(false);
        }
        return resList;
    }

    private static boolean isPalindrome(Map<Integer, Integer> charMap, int[] changeCount) {
        return true;
    }


    public static int numberOfCuts(int n) {
        return n % 2 == 0 ? n / 2 : n;
    }
}
