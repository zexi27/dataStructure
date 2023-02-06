package com.zlq.day200;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day200
 * @ClassName: Day199_ReplaceContentOfBracket
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/12 21:52
 */
/*
给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。

比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。

你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：

将 keyi 和括号用对应的值 valuei 替换。
如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。

请你返回替换 所有 括号对后的结果字符串。

示例 1：

输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
输出："bobistwoyearsold"
解释：
键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
示例 2：

输入：s = "hi(name)", knowledge = [["a","b"]]
输出："hi?"
解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
示例 3：

输入：s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
输出："yesyesyesaaa"
解释：相同的键在 s 中可能会出现多次。
键 "a" 对应的值为 "yes" ，所以将所有的 "(a)" 替换为 "yes" 。
注意，不在括号里的 "a" 不需要被替换。
 */
public class Day199_ReplaceContentOfBracket {



    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<>();
        for (List<String> ele : knowledge) knowledgeMap.put(ele.get(0), ele.get(1));
        StringBuilder res = new StringBuilder();
        int l = 0, r = 0;
        while (r < s.length()) {
            while (r < s.length() && s.charAt(l) != '(') {
                res.append(s.charAt(l));
                l++;
                r++;
            }
            if (l < s.length() && s.charAt(l) == '(') {
                while (r < s.length() - 1 && s.charAt(r) != ')') r++;
                String substring = s.substring(l + 1, r);
                substring = Objects.isNull(knowledgeMap.get(substring)) ? "?" : knowledgeMap.get(substring);
                res.append(substring);
            }
            l = r + 1;
            r = l;
        }
        return res.toString();
    }


    public static int rearrangeCharacters(String s, String target) {
        int res = Integer.MAX_VALUE;
        int[] sIndex = new int[26];
        for (int i = 0; i < s.length(); i++) sIndex[s.charAt(i) - 'a']++;
        int[] targetIndex = new int[26];
        for (int i = 0; i < target.length(); i++) targetIndex[target.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (targetIndex[i] != 0) {
                res = Math.min(res, sIndex[i] / targetIndex[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "(name)is(age)yearsold";
//        List<List<String>> knowledge = new ArrayList<>();
//        ArrayList<String> list = new ArrayList<>();
//        list.add("name");
//        list.add("bob");
//        knowledge.add(list);
//        System.out.println(evaluate(s, knowledge));
        int[] nums = {93,40};
        System.out.println(minMaxGame(nums));
    }

    public static int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        int curLength = nums.length/2;
        int[] newArr = null;
        while (true) {
             newArr = new int[curLength];
            for (int i = 0; i < newArr.length; i++) {
                if (i % 2 == 0) newArr[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                else newArr[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            nums = newArr;
            if (curLength == 1) return newArr[0];
            curLength /= 2;
        }
    }
}
