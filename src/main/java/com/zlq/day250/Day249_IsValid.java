package com.zlq.day250;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day249_IsValid
 * @description:
 * @author: LiQun
 * @CreateDate:2023/5/3 10:06
 */
/*
1003. Check If Word Is Valid After Substitutions
中等
97
相关企业
Given a string s, determine if it is valid.

A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:

Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
Return true if s is a valid string, otherwise, return false.


Example 1:

Input: s = "aabcbc"
Output: true
Explanation:
"" -> "abc" -> "aabcbc"
Thus, "aabcbc" is valid.
Example 2:

Input: s = "abcabcababcc"
Output: true
Explanation:
"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
Thus, "abcabcababcc" is valid.
Example 3:

Input: s = "abccba"
Output: false
Explanation: It is impossible to get "abccba" using the operation.
 */
public class Day249_IsValid {

//    public static void main(String[] args) {
//        System.out.println(isValid("aabcbc"));
//    }

    public static boolean isValid(String s) {
        while (s.contains("abc")) {
            s = s.replaceAll("abc", "");
        }
        return s.length() == 0;
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
            if (stack.size() >= 3 && stack.peek() == 'c' && stack.get(stack.size() - 2) == 'b' && stack.get(stack.size() - 3) == 'a') {
                for (int j = 0; j < 3; j++) stack.pop();

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int n = 301;
        int[][] logs = {{111, 1}, {137, 3}, {83, 6}, {50, 7}, {82, 10}, {287, 11}, {137, 13}, {204, 14}, {294, 19}};
        System.out.println(hardestWorker(n, logs));
    }
    public static int hardestWorker(int n, int[][] logs) {
        int maxWorkTimeUserId = logs[0][0];
        int maxWorkTime =  logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int curWorkTime = logs[i][1] - logs[i - 1][1];
            if (curWorkTime > maxWorkTime){
                maxWorkTimeUserId = logs[i][0];
                maxWorkTime = curWorkTime;
            }
            if (curWorkTime == maxWorkTime && logs[i][0] < maxWorkTimeUserId){
                maxWorkTimeUserId = logs[i][0];
            }
        }
        return maxWorkTimeUserId;
    }
}
