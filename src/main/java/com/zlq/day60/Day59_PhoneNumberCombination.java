package com.zlq.day60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day59_PhoneNumberCombination
 * @description:
 * @author: LiQun
 * @CreateDate:2021/11/23 9:11 上午
 */
/*
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 */
public class Day59_PhoneNumberCombination {
    public static void main(String[] args) {
        String digits = "252";
        List<String> stringList = letterCombinations(digits);
        System.out.println(stringList);
    }

    public static Map<String, String> generateMap() {
        Map<String, String> map = new HashMap<>();
        map.put("0", "");
        map.put("1", "");
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("9", "wxyz");
        return map;
    }


    //设置全局列表存储最后的结果
    static List<String> list = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return list;

    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    static StringBuilder temp = new StringBuilder();

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public static void backTracking(String digits, String[] numString, int num) {
        Map<String, String> map = generateMap();
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = map.get((String.valueOf(digits.charAt(num))));
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }


}
