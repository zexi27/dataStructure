package com.zlq.day150;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day150
 * @ClassName: Day145_Reformat
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/11 10:17
 */
/*
给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。

请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。

请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。

示例 1：

输入：s = "a0b1c2"
输出："0a1b2c"
解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
示例 2：

输入：s = "leetcode"
输出：""
解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
示例 3：

输入：s = "1229857369"
输出：""
解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
示例 4：

输入：s = "co2idv019"
输出："c2o0v1i9d"
示例 5：

输入：s = "ab123"
输出："1a2b3"
 */
public class Day145_Reformat {
    public static void main(String[] args) {
        String s = "co2idv019";
        System.out.println(reformat(s));
    }

    public static String reformat(String s) {
        int length = s.length();
        if (length == 0 || length == 1) return "";
        List<Character> letterList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c >= 'a') {
                letterList.add(c);
            } else {
                numList.add(c);
            }
        }
        int letterSize = letterList.size();
        int numSize = numList.size();
        if (letterSize == 0 || numSize == 0 || Math.abs(letterSize - numSize) > 1) return "";
        StringBuilder res = new StringBuilder();
        int index = 0;
//        if (letterSize > numSize) {
//            while (index < numSize) {
//                res.append(letterList.get(index)).append(numList.get(index));
//                index++;
//            }
//            if (index == letterSize - 1)
//                res.append(letterList.get(index));
//        } else {
//            while (index < letterSize) {
//                res.append(numList.get(index)).append(letterList.get(index));
//                index++;
//            }
//            if (index == numSize - 1) res.append(numList.get(index));
//        }

        return res.toString();
    }
}
