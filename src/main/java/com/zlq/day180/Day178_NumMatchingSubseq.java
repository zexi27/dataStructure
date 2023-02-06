package com.zlq.day180;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day178_NumMatchingSubseq
 * @description:
 * @author: LiQun
 * @CreateDate:2022/11/17 11:59
 */
/*
给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。

字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。

例如， “ace” 是 “abcde” 的子序列。

示例 1:

输入: s = "abcde", words = ["a","bb","acd","ace"]
输出: 3
解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
Example 2:

输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
输出: 2
 */
public class Day178_NumMatchingSubseq {

    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println(numMatchingSubseq3(s, words));
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "thread1");
        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.start();
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isSubSeq(s, word)) res++;
        }
        return res;
    }

    public static boolean isSubSeq(String s, String word) {
        int l = 0, r = 0;
        while (l < s.length() - 1) {
            char c = word.charAt(r);
            while (l < s.length() - 1 && s.charAt(l) != c) l++;
            if (s.charAt(l) == c) {
                l++;
                r++;
            }
            if (r == word.length()) return true;
        }
        return false;
    }

    static Map<Character, List<Integer>> map = new HashMap<>();

    public static int numMatchingSubseq3(String s, String[] words) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> charList = map.getOrDefault(c, new ArrayList<>());
            charList.add(i);
            map.put(c, charList);
        }
        int res = 0;
        for (String word : words) {
            if (isSubSeq3(s, word)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isSubSeq3(String s, String word) {
        int wordLength = word.length();
        if (word.length() > s.length()) {
            return false;
        }
        int[] wordArr = new int[26];
        int curIndex = -1,lastIndex = -1;
        for (int i = 0; i < wordLength; i++) {
            char c = word.charAt(i);
            wordArr[c - 'a']++;
            List<Integer> charList = map.get(c);
            if (Objects.isNull(charList)) return false;
            if (curIndex != -1) lastIndex = curIndex;
            if (charList.size() < wordArr[c - 'a']) return false;
            curIndex = charList.get(wordArr[c - 'a'] - 1);
            if (lastIndex != -1 && curIndex < lastIndex) return false;
        }
        return true;
    }


    public int numMatchingSubseq2(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

    /*
    有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。

    给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。

    示例 1：

    输入：gain = [-5,1,5,0,-7]
    输出：1
    解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
    示例 2：

    输入：gain = [-4,-3,-2,-1,4,3,2]
    输出：0
    解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0
     */
    public static int largestAltitude(int[] gain) {
        int[] altitudeArr = new int[gain.length + 1];
        int curAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            curAltitude += gain[i];
            altitudeArr[i + 1] = curAltitude;
        }
        int maxAltitude = Integer.MIN_VALUE;
        for (int i = 0; i < altitudeArr.length; i++) {
            if (altitudeArr[i] > maxAltitude) maxAltitude = altitudeArr[i];
        }
        return maxAltitude;
    }
}
