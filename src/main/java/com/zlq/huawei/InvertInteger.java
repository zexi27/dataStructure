package com.zlq.huawei;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: InvertInteger
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/20 9:48 上午
 */
/*
   给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围  [−231,   231  − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。


示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0

 */
public class InvertInteger {
    public static void main(String[] args) {
        int x = -153429;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        if (x == 0) return 0;
        StringBuilder builder = new StringBuilder();
        String str = String.valueOf(x);
        if (str.startsWith("-")) {
            str = str.substring(1);
        }
        int index = str.length() - 1;
        while (index >= 0) {
            if (str.charAt(index) != 0) break;
            index--;
        }
        for (int i = index; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        long longRes = Long.parseLong(builder.toString());
        if (longRes > Integer.MAX_VALUE || longRes < Integer.MIN_VALUE) return 0;
        return (int) (x > 0 ? longRes : -longRes);
    }
}
