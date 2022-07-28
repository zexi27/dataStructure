package com.zlq.day90;

import com.zlq.day30.ReverseInteger;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: Day89_ReverseOnlyStr
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/23 12:17 下午
 */
public class Day89_ReverseOnlyStr {
    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        //         "Qedo1ct-eeLg=ntse-T!"
        System.out.println(reverseOnlyLetters2(s));

    }

    public static String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Integer, Character> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLetters(c)) stack.push(c);
            else map.put(i, c);
        }
        int index = 0;
        StringBuilder res = new StringBuilder();
        while (index < s.length()) {
            if (map.containsKey(index)) {
                res.append(map.get(index));
            } else {
                res.append(stack.pop());
            }
            index++;
        }
        return res.toString();
    }

    public static String reverseOnlyLetters2(String s) {
        int length = s.length();
        char[] array = s.toCharArray();
        // 双指针
        int l = 0, r = length - 1;
        while (l < r) {
            if (!isLetters(array[l])) {
                l++;
                continue;
            }
            if (!isLetters(array[r])){
                r--;
                continue;
            }
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
        StringBuilder res = new StringBuilder();
        for (char c : array) {
            res.append(c);
        }
        return res.toString();
    }

    public static boolean isLetters(char c) {
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122) return true;
        return false;
    }

}
