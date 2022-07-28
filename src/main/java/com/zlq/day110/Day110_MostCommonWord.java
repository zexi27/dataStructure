package com.zlq.day110;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: Day110_MostCommonWord
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/17 11:11
 */
/*
给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。

题目保证至少有一个词不在禁用列表中，而且答案唯一。

禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。


示例：

输入:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
输出: "ball"
解释:
"hit" 出现了3次，但它是一个禁用的单词。
"ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
"hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 */
public class Day110_MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        String res = mostCommonWord(paragraph, banned);
        System.out.println(res);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace(' ', ',');
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (c <= 122 && c >= 97 || c == ' ' || c == ',') builder.append(c);
        }
        paragraph = builder.toString();
        String[] arr = paragraph.split(",");
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (!word.equals("")) map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String res = "";
        int maxFrequent = 0;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            if (!bannedSet.contains(key)) {
                if (value > maxFrequent) {
                    res = key;
                    maxFrequent = value;
                }
            }
        }
        return res;
    }

}
