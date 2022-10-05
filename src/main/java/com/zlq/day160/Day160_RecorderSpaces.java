package com.zlq.day160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day160
 * @ClassName: Day160_RecorderSpaces
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/7 13:32
 */
/*
You are given a string text of words that are placed among some number of spaces.
Each word consists of one or more lowercase English letters and are separated by at least one space.
It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized.
If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
 */
public class Day160_RecorderSpaces {
    public static void main(String[] args) {
        String text = "  this   is  a sentence ";
        System.out.println(reorderSpaces(text));
        System.out.println(Math.random());
    }

    public static String reorderSpaces(String text) {
        int spaceCount = 0;
        int wordCount = 0;
        int length = text.length();
        int index = 0;
        boolean isWord = false;
        while (index < length) {
            if (text.charAt(index) == ' ') {
                while (index < length && text.charAt(index) == ' ') {
                    isWord = false;
                    index++;
                    spaceCount++;
                }
            } else {
                while (index < length && text.charAt(index) != ' ') {
                    index++;
                    if (!isWord) {
                        wordCount++;
                        isWord = true;
                    }
                }
            }
        }
        int distance = wordCount == 1 ? spaceCount : spaceCount / (wordCount - 1);
        int remainSpace = wordCount == 1 ? spaceCount : spaceCount % (wordCount - 1);
        StringBuilder res = new StringBuilder();
        text = text.trim();
        int l = 0, r = 0;
        while (r < text.length()) {
            while (r < text.length() && text.charAt(r) != ' ') r++;
            res.append(text, l, r);
            while (r < text.length() && text.charAt(r) == ' ') r++;
            l = r;
            if (l == text.length()) break;
            for (int i = 0; i < distance; i++) {
                res.append(" ");
            }
        }
        for (int i = 0; i < remainSpace; i++) {
            res.append(" ");
        }
        return res.toString();
    }

    public static int minOperations(String[] logs) {
        int res = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                if (res <= 0) continue;
                res -= 1;
            } else if (logs[i].equals("./")) continue;
            else res += 1;
        }
        return res < 0 ? 0 : res;
    }


    public static int specialArray(int[] nums) {
        int maxVal = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > maxVal) maxVal = nums[i];
        }
        if (maxVal == 0) return -1;
        for (int i = 0; i <= maxVal; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (nums[j] >= i) count++;
            }
            if (count == i) return i;
        }
        return -1;
    }


}
