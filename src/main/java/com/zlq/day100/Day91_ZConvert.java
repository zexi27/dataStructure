package com.zlq.day100;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day91_ZConvert
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/1 9:32 上午
 */
/*
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。

比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);


示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：
P          H
A       S  I
Y    I     R
P  L       I  G
A          N

输入：s = "A", numRows = 1
输出："A"
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day91_ZConvert {
    public static void main(String[] args) {

        String s = "p";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int interval = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                char c = s.charAt(index);
                if (i == 0 || i == numRows - 1) {
                    res.append(c);
                } else {
                    res.append(c);
                    if (index + interval - 2 * i > s.length() - 1) break;
                    res.append(s.charAt(index + interval - 2 * i));
                }
                index += interval;
            }
        }
        return res.toString();
    }
}
