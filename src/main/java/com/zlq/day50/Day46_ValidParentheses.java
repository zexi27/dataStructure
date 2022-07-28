package com.zlq.day50;

import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50
 * @ClassName: Day46_ValidParentheses
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/23 10:14 上午
 */
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
1.左括号必须用相同类型的右括号闭合。
2.左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
输入: "()"
输出: true
示例 2:
输入: "()[]{}"
输出: true
示例 3:
输入: "(]"
输出: false
示例 4:
输入: "([)]"
输出: false
示例 5:
输入: "{[]}"
输出: true
 */
public class Day46_ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        String s1 = "{[]}()";
        System.out.println(isValid2(s1));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length() ; i ++){
            char c = s.charAt(i);
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (c != pop) return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }
}
