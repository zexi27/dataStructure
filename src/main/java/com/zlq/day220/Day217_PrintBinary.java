package com.zlq.day220;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day220
 * @ClassName: Day217_PrintBinary
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/2 11:00
 */
public class Day217_PrintBinary {
    public static void main(String[] args) {
        double num = 0.1;
        System.out.println(printBin(num));
    }

    public static String printBin(double num) {
        StringBuilder res = new StringBuilder();
        res.append("0").append(".");


        while (num != 1) {
            num *= 2;
            res.append(num >= 1.0 ? "1" : "0");
            num = num > 1.0 ? num - 1.0 : num;
            if (res.length() >= 34) return "ERROR";
        }
        return res.toString();
    }
}
