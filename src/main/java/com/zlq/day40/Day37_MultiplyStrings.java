package com.zlq.day40;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40
 * @ClassName: Day37_MultiplyStrings
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/10 9:34 上午
 */
public class Day37_MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "122423";
        String num2 = "242123210";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        String curResult;
        String result = "0";
        for (int i = l2 - 1; i >= 0; i--) {
            StringBuilder curRes = new StringBuilder();
            curResult = String.valueOf(Integer.valueOf(num1) * (num2.charAt(i) - '0'));
            curRes = curRes.append(curResult);
            for (int j = 0; j < l2 - i - 1; j++) {
                curRes = curRes.append("0");
            }
            result = Day35_StringSum.addStrings(result, curRes.toString());

        }


        return result;
    }
}
