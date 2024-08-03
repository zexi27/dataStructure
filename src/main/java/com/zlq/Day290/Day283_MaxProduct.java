package com.zlq.Day290;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CyclicBarrier;

/**
 *@description:
 *@author: ZhangLiqun
 *@date: 2023/11/6 22:03
 */
/*
318. Maximum Product of Word Lengths
中等
488
相关企业
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.



Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.


Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
 */
public class Day283_MaxProduct {

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        maxProduct(words);
    }
    public static int maxProduct(String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                List<Integer> indexList = map.get(c);
                if (Objects.isNull(indexList)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(c,list);
                }else {
                    indexList.add(i);
                }

            }
        }
        System.out.println(map);
        return 0;
    }

}
