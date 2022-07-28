package com.zlq.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: GetNotRepeated
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/13 10:21 下午
 */
/*
描述
输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
保证输入的整数最后一位不是0。
输入描述：
输入一个int型整数

输出描述：
按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

示例1
输入：
9876673
复制
输出：
37689
 */
public class GetNotRepeated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = String.valueOf(num);
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            boolean canAdd = true;
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j) canAdd = false;
            }
            if (canAdd == true) list.add(str.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        list.forEach(ele -> builder.append(ele));
        System.out.println(Integer.valueOf(builder.toString()));
    }
}
