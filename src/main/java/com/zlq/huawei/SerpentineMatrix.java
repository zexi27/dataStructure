package com.zlq.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: SerpentineMatrix
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/14 4:16 下午
 */
/*
蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
例如，当输入5时，应该输出的三角形为：

1 3 6 10 15
2 5 9 14
4 8 13
7 12
11

请注意本题含有多组样例输入。
输入描述：
输入正整数N（N不大于100）
输出描述：
输出一个N行的蛇形矩阵。

示例1
输入：
4
复制
输出：
1 3 6 10
2 5 9
4 8
7
 */
public class SerpentineMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            print(num);
        }
    }

    static List<Integer> list = null;

    public static void print(int num) {
        for (int i = 1; i <= num; i++) {
            int headOfLine = 1;
            list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                headOfLine += j - 1;
            }
            list.add(headOfLine);
            for (int k = 1; k <= (num - i); k++) {
                headOfLine = headOfLine + (i) + k;
                list.add(headOfLine);
            }
            list.forEach(ele -> System.out.print(ele + " "));
            System.out.println();
        }

    }
}
