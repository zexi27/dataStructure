package com.zlq.day20;

import java.util.Locale;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day15_IsPalindrome
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/8 9:52 上午
 */
/*
### 4.2. 验证回文串
LeetCode: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:
输入: "race a car"
输出: false

 */
public class Day15_IsPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
//        String str = " ";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        if (str == "" || str.length() == 0) return false;
        int l = 0, r = str.length() - 1;

        while (l < r) {
            if (!Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r)))
                    return false;
                l++;
                r--;
            }
        }
        return true;
    }
}
