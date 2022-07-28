package com.zlq.day100;

import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day94_ConvertBase7
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/7 9:29 下午
 */
public class Day94_ConvertBase7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(0));
    }

    /*
    十进制转七进制
     */
    public static String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        if (num < 0) res.append('-');
        
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % 7);
            num /= 7;
        }
        while (!stack.isEmpty()){
            res.append(Math.abs(stack.pop()));
        }
        return res.toString();
    }
}
