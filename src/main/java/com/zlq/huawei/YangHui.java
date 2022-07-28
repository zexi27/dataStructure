package com.zlq.huawei;

import java.util.Scanner;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: YangHui
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/14 3:38 下午
 */
/*
1：-1
2：-1
3：1 ====0
4：3 ====1
5：2 ====2
6：4 ====3
7：1 ====0
8：3 ====1
9：2 ====2
10：4 ====3


 */
public class YangHui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] res = {2, 3, 2, 4};
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num <= 2) System.out.println(-1);
            System.out.println(res[(num + 1) % 4]);
        }
    }
}
