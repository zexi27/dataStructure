package com.zlq.day20;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: Day14_ReplaceSpace
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/7 9:12 上午
 */
/*
剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Day14_ReplaceSpace {
    public static void main(String[] args) {
        String str = "We Are Happy";
        String result = replaceSpace3(str);
        System.out.println(result);

    }

    public static String replaceSpace1(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == (int) ' ')
                str = str.replace(" ", "%20");
        }

        return str;
    }

    public static String replaceSpace2(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (String.valueOf(c).equals(" "))
                result.append("%20");
            else
                result.append(c);
        }
        return result.toString();
    }

    public static String replaceSpace3(String str) {

        return str.replaceAll("\\s", "%20");
    }


}
