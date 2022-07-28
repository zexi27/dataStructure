package com.zlq.huawei;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: TimesOfletter
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/8 4:40 下午
 */
/*
写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。

输入描述：
第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。

输出描述：
输出输入字符串中含有该字符的个数。

示例1
输入：
ABCabc
A
复制
输出：
2
 */
public class TimesOfLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//
//            TreeSet<Integer> set = new TreeSet<Integer>();
//            int n = sc.nextInt();
//            if (n > 0) {
//                for (int i = 0; i < n; i++) {
//                    set.add(sc.nextInt());
//                }
//            }
//            for (Integer i : set) {
//                System.out.println(i);
//            }
//
//        }
        Double n = sc.nextDouble();
        System.out.println(n.intValue());

    }


}
