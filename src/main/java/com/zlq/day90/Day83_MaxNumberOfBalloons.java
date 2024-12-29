package com.zlq.day90;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: Day83_MaxNumberOfBalloons
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/13 9:55 上午
 */
/*
给你一个字符串text，你需要使用 text 中的字母来拼凑尽可能多的单词"balloon"（气球）。

字符串text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词"balloon"。

示例 1：



输入：text = "nlaebolko"
输出：1
示例 2：



输入：text = "loonbalxballpoon"
输出：2
示例 3：

输入：text = "leetcode"
输出：0
 */
public class Day83_MaxNumberOfBalloons {
    public static void main(String[] args) {
//        String text = "noabcnfoodasalbplolnl";
        String text = "balon";

        System.out.println(maxNumberOfBalloons3(text));
    }

    public static int maxNumberOfBalloons(String text) {
        String word = "balon";
        Set<Character> wordSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            wordSet.add(word.charAt(i));
        }
        char[] textArray = text.toCharArray();
        Arrays.sort(textArray);  // 将text中的字母转化成字符串数组再排序
        int frequency = 0;
        int curFrequency = 0;
        char removedChar = ' ';


        // ==================================================
        for (int i = 0; i < text.length(); i++) {
            char c = textArray[i];
            if (wordSet.contains(c)) { // 字符串中的字母包含单词中的字母
                if (removedChar == 'l' || removedChar == 'o') curFrequency /= 2;
                if (frequency == 0) frequency = curFrequency;
                else frequency = Math.min(frequency, curFrequency);
                if (frequency == 0 && i != 0) return 0;
                curFrequency = 1;
                removedChar = c;
                wordSet.remove(c);
                continue;
            }
            if (c == removedChar) {
                curFrequency++;
            }
        }
        if (removedChar == 'l' || removedChar == 'o') curFrequency /= 2;
        frequency = Math.min(frequency, curFrequency);
        return wordSet.isEmpty() ? frequency : 0;
    }


    public static int maxNumberOfBalloons2(String text) {
        int[] cint = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') cint[0]++;
            else if (c == 'a') cint[1]++;
            else if (c == 'l') cint[2]++;
            else if (c == 'o') cint[3]++;
            else if (c == 'n') cint[4]++;
        }
        cint[2] /= 2;
        cint[3] /= 2;
        int minNum = cint[1];
        for (int i = 0; i < cint.length; i++) {
            if (cint[i] < minNum) minNum = cint[i];
        }
        return minNum;
    }

    public static int maxNumberOfBalloons3(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.put('l', map.getOrDefault('l', 0) / 2);
        map.put('o', map.getOrDefault('o', 0) / 2);

        IntStream balon = Arrays.stream(new int[]{
                map.getOrDefault('b', 0),
                map.getOrDefault('a', 0),
                map.getOrDefault('l', 0),
                map.getOrDefault('o', 0),
                map.getOrDefault('n', 0)
        });

        int res = balon.min().getAsInt();
        return res;
    }
}
