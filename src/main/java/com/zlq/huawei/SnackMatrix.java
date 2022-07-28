package com.zlq.huawei;

import java.util.Scanner;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: SnackMatrix
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/12 11:32 下午
 */
/*
描述
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
public class SnackMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            getTriangle(n);

        }
    }

    public static void getTriangle(int n) {
        int startNum = 1;
        for (int i = 0; i < n; i++) {
            startNum += i;
            int num = startNum;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                if (j == 0) builder.append(startNum + " ");
                else {
                    num += j + 1  + i;
                    builder.append(num + " ");
                }
            }
            System.out.println(builder.toString());
        }
    }
}
