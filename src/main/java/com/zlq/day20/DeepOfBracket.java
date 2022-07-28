package com.zlq.day20;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: DeepOfBracket
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/12 9:40 上午
 */
/*
> 爱奇艺 2018 秋招 Java：
> 一个合法的括号匹配序列有以下定义:
>
> 1. 空串""是一个合法的括号匹配序列
> 2. 如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
> 3. 如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
> 4. 每个合法的括号序列都可以由以上规则生成。

> 例如: "","()","()()","((()))"都是合法的括号序列
> 对于一个合法的括号序列我们又有以下定义它的深度:
>
> 1. 空串""的深度是0
> 2. 如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y)
> 3. 如果"X"的深度是x,那么字符串"(X)"的深度是x+1

> 例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。

```
输入描述:
输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。

输出描述:
输出一个正整数,即这个序列的深度。
```
 */
public class DeepOfBracket {
    public static void main(String[] args) {
        deepOfBracket();
    }

    public static void deepOfBracket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = scanner.next();
        int count = 0, deep = 0, charDeep = 0, res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            } else {
                charDeep = str.charAt(i) - 'A' > charDeep ? str.charAt(i) - 'A' : charDeep;
            }
            deep = Math.max(count, deep);
        }
        scanner.close();
        System.out.println((deep + charDeep));

    }
}
