package com.zlq.huawei.niuke.a_add_b;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.huawei.niuke.a_add_b
 * @ClassName: Main_01
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/11 00:07
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组
 */
public class Main_01 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] numStrings = s.split(" ");
            int res = 0;
            for (int i = 0; i < numStrings.length; i++) {
                String ele = numStrings[i];
                if (ele.length() == 1) res += Integer.valueOf(ele);
            }
            System.out.println(res);
        }

    }
    /*
    1 2 1.2 3
    3 2
    8 5 3
    2.2 1 3
     */
}
