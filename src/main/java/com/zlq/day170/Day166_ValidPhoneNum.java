package com.zlq.day170;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day166_ValidPhoneNum
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/2 01:30
 */
/*
给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。

请你按下述方式重新格式化电话号码。

首先，删除 所有的空格和破折号。
其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
2 个数字：单个含 2 个数字的块。
3 个数字：单个含 3 个数字的块。
4 个数字：两个分别含 2 个数字的块。
最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。

返回格式化后的电话号码。


示例 1：

输入：number = "1-23-45 6"
输出："123-456"
解释：数字是 "123456"
步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
连接这些块后得到 "123-456" 。
示例 2：

输入：number = "123 4-567"
输出："123-45-67"
解释：数字是 "1234567".
步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
步骤 2：剩下 4 个数字，所以将它们分成两个含 2 个数字的块。这 2 块分别是 "45" 和 "67" 。
连接这些块后得到 "123-45-67" 。
示例 3：

输入：number = "123 4-5678"
输出："123-456-78"
解释：数字是 "12345678" 。
步骤 1：第 1 个块 "123" 。
步骤 2：第 2 个块 "456" 。
步骤 3：剩下 2 个数字，将它们放入单个含 2 个数字的块。第 3 个块是 "78" 。
连接这些块后得到 "123-456-78" 。
示例 4：

输入：number = "12"
输出："12"
示例 5：

输入：number = "--17-5 229 35-39475 "
输出："175-229-353-94-75"
 */
public class Day166_ValidPhoneNum {
    public static void main(String[] args) {
        String number = "123 4-567";
        System.out.println(reformatNumber(number));
    }

    public static String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");
        int length = number.length();
        if (length < 3) return number;
        int remainLength = length % 3;
        StringBuilder res = appendNormal(remainLength, number);
        if (remainLength == 1) {
            if (length != 4) {
                res.append("-");
            }
            int index = 0;
            for (int i = length - (remainLength + 3); i < length; i++) {
                res.append(number.charAt(i));
                index++;
                if (index == 2) res.append("-");
            }
        }
        if (remainLength == 2) {
            res.append("-");
            res.append(number.charAt(length - 2)).append(number.charAt(length - 1));
        }
        return res.toString();
    }

    public static StringBuilder appendNormal(int remainLength, String number) {
        StringBuilder res = new StringBuilder();
        int length = number.length();
        if (remainLength == 1) {
            if (length == 4) return res;
            else remainLength = 4;
        }
        for (int i = 0; i < length - remainLength; i++) {
            char ele = number.charAt(i);
            res.append(ele);
            if ((i + 1) % 3 == 0 && i != length - remainLength - 1) res.append("-");
        }
        return res;
    }


}
