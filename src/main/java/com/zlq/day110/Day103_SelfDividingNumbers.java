package com.zlq.day110;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: Day103_SelfDividingNumbers
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/31 22:46
 */
/*
自除数 是指可以被它包含的每一位数整除的数。

例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
自除数 不允许包含 0 。

给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。

示例 1：

输入：left = 1, right = 22
输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
示例 2:

输入：left = 47, right = 85
输出：[48,55,66,77]
 */
public class Day103_SelfDividingNumbers {


    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(47, 85));
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) list.add(i);
        }
        return list;
    }

    public static boolean isSelfDividingNumber(int num){
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            char c = strNum.charAt(i);
            if (c == '0') return false;
            if (num % (c - '0') != 0) return false;
        }
        return true;
    }


}
