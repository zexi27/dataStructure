package com.zlq.day130;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day129_MagicDictionary
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/11 22:17
 */
/*
设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。

实现 MagicDictionary 类：

MagicDictionary() 初始化对象
void buildDict(String[]dictionary) 使用字符串数组dictionary 设定该数据结构，dictionary 中的字符串互不相同
bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。


示例：

输入
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
输出
[null, null, false, true, false, false]

解释
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // 返回 False
magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
magicDictionary.search("hell"); // 返回 False
magicDictionary.search("leetcoded"); // 返回 False
 */
public class Day129_MagicDictionary {

    public static String[] dictionary = null;

    public Day129_MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        int length = dictionary.length;
        for (int i = 0; i < length; i++) {
            // 如果长度不等直接跳过
            if (searchWord.length() != dictionary[i].length()) continue;
            else {
                // 长度相等直接比较不相等字符的个数
                int countOfNotEqual = 0;
                for (int j = 0; j < searchWord.length(); j++) {
                    if (searchWord.charAt(j) != dictionary[i].charAt(j)) countOfNotEqual++;
                }
                if (countOfNotEqual == 1) return true;
            }
        }
        return false;
    }
}
