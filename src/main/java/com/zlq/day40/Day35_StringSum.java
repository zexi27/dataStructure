package com.zlq.day40;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day35_StringSum
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/7 9:23 上午
 */
/*
给定两个字符串形式的非负整数num1 和num2，计算它们的和。

提示：

1.num1 和num2的长度都小于 5100
2.num1 和num2 都只包含数字0-9
3.num1 和num2 都不包含任何前导零
4.你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 */
public class Day35_StringSum {
    public static void main(String[] args) {
        String s1 = "389";
        String s2 = "23";
        System.out.println(addStrings(s1, s2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0 || carry != 0) {
            int x = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int y = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int sum = x + y + carry;
            result.append(sum % 10);
            carry = sum / 10;

            l1--;
            l2--;
        }
        return result.reverse().toString();
    }

}
