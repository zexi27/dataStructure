package com.zlq.day200;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day200
 * @ClassName: Day193_CountHomogenous
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/26 23:47
 */
/*
给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。

同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。

子字符串 是字符串中的一个连续字符序列。

示例 1：

输入：s = "abbcccaa"
输出：13
解释：同构子字符串如下所列：
"a"   出现 3 次。
"aa"  出现 1 次。
"b"   出现 2 次。
"bb"  出现 1 次。
"c"   出现 3 次。
"cc"  出现 2 次。
"ccc" 出现 1 次。
3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
示例 2：

输入：s = "xy"
输出：2
解释：同构子字符串是 "x" 和 "y" 。
示例 3：

输入：s = "zzzzz"
输出：15
 */
public class Day193_CountHomogenous {


    public static int countHomogenous(String s) {
        int res = s.length();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!characterList.contains(c)) {
                characterList.add(c);
            }
        }
        for (Character character : characterList) {
            // 求每一个字符串的同构子字符串出现的次数
            boolean flag = true;
            StringBuilder builder = new StringBuilder();
            builder.append(character);
            while (flag) {
                String substr = builder.append(character).toString();
                int count = countOfStr(substr, s);
                if (count == 0) flag = false;
                else res += count;
            }
        }
        return res;
    }

    private static int countOfStr(String substr, String s) {
        int count = 0;
        int length = substr.length();
        int l = 0, r = length;
        while (r <= s.length()) {
            if (s.charAt(l) == substr.charAt(0) && s.substring(l, r).equals(substr)) {
                count++;
            }
            l++;
            r++;
        }
        return count;
    }


    public static int countHomogenous2(String s) {
        long res = s.length();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!characterList.contains(c)) {
                characterList.add(c);
            }
        }
        if (characterList.size() == 1) {
            return (1 + s.length()) * s.length() / 2;
        }
        for (Character character : characterList) {
            // 求每一个字符串的同构子字符串出现的次数
            res += countOfStr2(character, s);
        }
        return (int) (res % 1000000007);
    }

    /*
    a  -> 1
    aa -> 3
    aaa -> 6
    aaaa -> 10
    aaaaa -> 15
    aaaaaa -> 21
     */
    private static long countOfStr2(char c, String s) {
        int l = 0, r = 0;
        long count = 0;
        while (r <= s.length() - 1) {
            if (c == s.charAt(l)) {
                while (r < s.length() - 1 && s.charAt(r + 1) == s.charAt(r)) {
                    r++;
                }
                int distance = r - l + 1;
                count += (((1 + distance) * distance / 2) - distance);
                l = r + 1;
                r = l;
                continue;
            }
            l++;
            r++;
        }
        return count;
    }

    public static int countHomogenous3(String s) {
        int l = 0, r = 0;
        long res = 0;
        while (r <= s.length() - 1) {
            while (r < s.length() - 1 && s.charAt(r + 1) == s.charAt(r)) {
                r++;
            }
            long distance = r - l + 1;
            res += (1 + distance) * distance / 2;
            l = r + 1;
            r = l;
        }
        return (int) (res % 1000000007);
    }

    /*

     */
    public static void main(String[] args) {
        String s = "XXOXXXOO";
        System.out.println(minimumMoves2(s));
    }

    public static int minimumMoves(String s) {
        int l = 0, r = 2;
        int res = 0;
        int length = s.length();
        boolean flag = true;
        while (r < length - 1) {
            while (r < length - 1 && s.charAt(l) != 'X') {
                l++;
                r++;
                if (r == length - 1) flag = false;
            }
            if (!flag) break;
            res += 1;
            l = r + 1;
            r = l + 2 > s.length() - 1 ? s.length() - 1 : l + 2;
        }
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == 'X') {
                res += 1;
                break;
            }
        }
        return res;
    }

    public static int minimumMoves2(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X'){
                res+=1;
                i+=2;
            }
        }
        return res;
    }

}
