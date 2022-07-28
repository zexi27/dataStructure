package com.zlq.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: WorkReverse
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/12 11:12 下午
 */
/*
对字符串中的所有单词进行倒排。

说明：

1、构成单词的字符只有26个大写或小写英文字母；

2、非构成单词的字符均视为单词间隔符；

3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；

4、每个单词最长20个字母；

数据范围：字符串长度满足
输入描述：
输入一行以空格来分隔的句子

输出描述：
输出句子的逆序

示例1
输入：
I am a student
复制
输出：
student a am I
复制
示例2
输入：
$bo*y gi!r#l
复制
输出：
l r gi y bo
 */
public class WordReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(wordReverse(s));
    }

    public static String wordReverse(String s) {
        List<String> stringList = new ArrayList<>();
        int startIndex = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (isSpecificChar(c)) {
                String sub = s.substring(startIndex, i);
                stringList.add(sub);
                startIndex = i + 1;
            }
            if (i == length - 1) {
                stringList.add(s.substring(startIndex, i + 1));
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = stringList.size() - 1; i >= 0; i--) {
            if (i == 0) res.append(stringList.get(i));
            else res.append(stringList.get(i)).append(" ");

        }
        return res.toString();
    }

    public static boolean isSpecificChar(char c) {
        if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) {
            return false;
        }
        return true;
    }

}
