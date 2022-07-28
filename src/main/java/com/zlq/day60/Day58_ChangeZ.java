package com.zlq.day60;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day58_ChangeZ
 * @description:
 * @author: LiQun
 * @CreateDate:2021/11/22 9:00 上午
 */
/*
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

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

输入：s = "A", numRows = 1
输出："A"
 */
public class Day58_ChangeZ {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String res = convert(s, numRows);
        System.out.println(res);
    }

    public static String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) return s;
        Character[][] characters = changeShapeOfZ(s, numRows);
        characters = assignment(s, characters, numRows);
        return getRes(characters);

    }

    public static Character[][] changeShapeOfZ(String s, int numRows) {
        int length = s.length();
        int numColumns = getNumColumns(length, numRows);
        Character[][] characters = new Character[numRows][numColumns];
        return characters;
    }

    public static Character[][] assignment(String s, Character[][] characters, int numRows) {
        int length = s.length();
        int rounds = getRounds(length, numRows);
        int index = 0;
        for (int i = 0; i < rounds - 1; i++) {
            for (int j = 0; j < numRows; j++) {
                characters[j][i * (numRows - 1)] = s.charAt(index);
                index++;
            }
            for (int k = 0; k < (numRows - 2); k++) {
                characters[numRows - k - 2][k + 1 + (numRows - 1) * i] = s.charAt(index);
                index++;
            }
        }
        int remain = length - (rounds - 1) * (2 * numRows - 2);
        if (remain <= numRows){
            for (int m = 0; m < remain; m++) {
                characters[m][(rounds - 1) * (numRows - 1)] = s.charAt(index);
                index++;
            }
        }
        else {
            for (int m = 0; m < numRows; m++) {
                characters[m][(rounds - 1) * (numRows - 1)] = s.charAt(index);
                index++;
            }
            for (int n = 0; n < (remain - numRows); n++) {
                characters[numRows - n - 2][n + 1 + (numRows - 1) * (rounds - 1)] = s.charAt(index);
                index++;
            }
        }

        return characters;
    }


    public static int getNumColumns(int length, int numRows) {
        int baseNum = numRows * 2 + numRows - 2;
        int appendNum = numRows + numRows - 2;
        int numColumns = 0;
        if (length <= baseNum) numColumns = numRows;
        numColumns = (int) (numRows + Math.ceil((double) (length - baseNum) / (double) appendNum) * (numRows - 1));
        return numColumns;
    }

    public static int getRounds(int length, int numRows) {
        return (int) Math.ceil((double) length / (double) (2 * numRows - 2));
    }

    public static String getRes(Character[][] characters) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[0].length; j++) {
                Character character = characters[i][j];
                if (character != null) {
                    result.append(character);
                }
            }
        }
        return result.toString();
    }

}
