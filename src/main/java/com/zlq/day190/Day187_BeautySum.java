package com.zlq.day190;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day190
 * @ClassName: Day187_BeautySum
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/12 11:07
 */
/*
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"],
each with beauty equal to 1.
Example 2:

Input: s = "aabcbaa"
Output: 17
 */
public class Day187_BeautySum {


    public static int beautySum(String s) {
        int l = 0, r = l;
        int res = 0;
        int[] charIndex = new int[26];
        int maxFrequent = 0;
        while (l < s.length()) {
            boolean hasMin = false;
            int minFrequent = 500;
            charIndex[s.charAt(r) - 'a']++;
            maxFrequent = Math.max(maxFrequent, charIndex[s.charAt(r) - 'a']);
            if (charIndex[s.charAt(r) - 'a'] == 1) {
                minFrequent =1;
                hasMin = true;
            }
            if (!hasMin){
                for (int i = 0; i < 26; i++) {
                    if (charIndex[i] != 0 && charIndex[i] < minFrequent) {
                        minFrequent = charIndex[i];
                    }
                }
            }

            res += maxFrequent - minFrequent;
            r++;
            if (r == s.length()){
                l++;
                r= l;
                maxFrequent = 0;
                charIndex = new int[26];
            }
        }
        return res;
    }

    public static boolean checkIfPangram(String sentence) {
        int length = sentence.length();
        if (length < 26) return false;
        int[] letterArr = new int[26];
        for (int i = 0; i < length; i++) {
            letterArr[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < letterArr.length; i++) {
            if (letterArr[i] == 0) return false;
        }
        return true;
    }


    /*
    You are given a string s consisting of lowercase English letters, and an integer k.

    First, convert s into an integer by replacing each letter with its position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, transform the integer by replacing it with the sum of its digits. Repeat the transform operation k times in total.

    For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:

    Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
    Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
    Transform #2: 17 ➝ 1 + 7 ➝ 8
    Return the resulting integer after performing the operations described above.

    Example 1:

    Input: s = "iiii", k = 1
    Output: 36
    Explanation: The operations are as follows:
    - Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
    - Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
    Thus the resulting integer is 36.
    Example 2:

    Input: s = "leetcode", k = 2
    Output: 6
    Explanation: The operations are as follows:
    - Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
    - Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
    - Transform #2: 33 ➝ 3 + 3 ➝ 6
    Thus the resulting integer is 6.
    Example 3:

    Input: s = "zbax", k = 2
    Output: 8
     */

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 2;
        System.out.println(getLucky(s,k));
    }

    public static int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i) - 'a' + 1);
        }
        String convert = stringBuilder.toString();

         int res = 0;
        for (int i = 0; i < k; i++) {
            convert = convertString(convert);
        }
        return Integer.valueOf(convert);
    }

    private static String convertString(String convert) {
        int  res = 0;
        for (int i = 0; i < convert.length(); i++) {
            res += convert.charAt(i) - '0';
        }
        return String.valueOf(res);
    }


    public static int getLucky2(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i) - 'a' + 1);
        }
        String convert = stringBuilder.toString();

        int res = Integer.valueOf(convert);
        for (int i = 0; i < k; i++) {
            convert = convertString(convert);
        }
        return Integer.valueOf(convert);
    }

    private static String convertString2(String convert) {
        int  res = 0;
        for (int i = 0; i < convert.length(); i++) {
            res += convert.charAt(i) - '0';
        }
        return String.valueOf(res);
    }
}
