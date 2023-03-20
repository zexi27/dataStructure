package com.zlq.day230;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day230
 * @ClassName: Day223_CheckPalindromeFormation
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/18 12:42
 */
/*
给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。

当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。

如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。

注意， x + y 表示连接字符串 x 和 y 。



示例 1：

输入：a = "x", b = "y"
输出：true
解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
aprefix = "", asuffix = "x"
bprefix = "", bsuffix = "y"
那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
示例 2：

输入：a = "abdef", b = "fecab"
输出：true
示例 3：

输入：a = "ulacfd", b = "jizalu"
输出：true
解释：在下标为 3 处分割：
aprefix = "ula", asuffix = "cfd"
bprefix = "jiz", bsuffix = "alu"
那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。


提示：

1 <= a.length, b.length <= 105
a.length == b.length
a 和 b 都只包含小写英文字母
 */
public class Day223_CheckPalindromeFormation {
    public static void main(String[] args) {
        String a = "abdef";
        String b = "fecab";
    }

    public static boolean checkPalindromeFormation(String a, String b) {
        return cut(a,b)|| cut(b,a);

    }

    public static boolean cut(String a, String b) {
        int length = a.length();
        int l = 0, r = length - 1;
        while (l < r && a.charAt(l) == b.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) return true;
        return isPalindrome(a, l, r) || isPalindrome(b, l, r);
    }

    public static boolean isPalindrome(String s, int l, int r) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }


}

