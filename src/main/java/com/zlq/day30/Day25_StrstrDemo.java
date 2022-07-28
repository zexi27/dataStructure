package com.zlq.day30;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day25_StrstrDemo
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/24 6:27 下午
 */
/*
实现 strStr() 函数。
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
如果不存在，则返回  -1 。

说明：
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。
这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。

示例 1：

输入：haystack = "hello", needle = "ll"
输出：2
示例 2：

输入：haystack = "aaaaa", needle = "bba"
输出：-1
示例 3：

输入：haystack = "", needle = ""
输出：0


提示：

0 <= haystack.length, needle.length <= 5 * 104
haystack 和 needle 仅由小写英文字符组成
 */
public class Day25_StrstrDemo {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        System.out.println(s1.indexOf(s2));
        System.out.println(strStr(s1, s2));
    }


    // 调库indexOf;调库Substring
    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        //定义左右指针
        int l = 0, r = needleLength;
        while (r <= haystackLength) {
            if (haystack.substring(l, r).equals(needle)) {
                break;
            }
            l++;
            r++;
        }
        return r > haystackLength ? -1 : l;
    }
}
