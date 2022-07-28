package com.zlq.day10;

import java.util.Stack;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day10
 * @ClassName: Day8_ValidParentheses
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/30 8:57 上午
 */
/*
给定⼀个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满⾜：
左括号必须⽤相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
示例 1：
输⼊：s = "()"
输出：true
示例 2：
输⼊：s = "()[]{}"
输出：true
示例 3：
输⼊：s = "(]"
输出：false
示例 4：
输⼊：s = "([)]"
输出：false
示例 5：
输⼊：s = "{[]}"
输出：true
提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
原字符串："{[]}()"
入栈    ："{[("
 */
public class Day8_ValidParentheses {

    public static void main(String[] args) {
        String str = "{[]}{}";
        System.out.println(Day8_ValidParentheses.validParentheses2(str));
    }


    public static boolean validParentheses1(String str) {
        if (str.startsWith(")") || str.startsWith("]") || str.startsWith("}")
                || str.length() < 2 || str == null) {
            return false;
        }
        if (str.contains("()")) {
            str = str.replace("()", "");
        }
        if (str.contains("[]")) {
            str = str.replace("[]", "");
        }
        if (str.contains("{}")) {
            str = str.replace("{}", "");
        }
        return str.length() == 0;
    }


    // 原   "{[]}()" ，
    // 入栈 "{[("
    public static boolean validParentheses2(String str) {
        if (str.startsWith(")") || str.startsWith("]") || str.startsWith("}")
                || str.length() < 2 || str == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                Character target = stack.pop();
                if (!(ch == '}' && target == '{' ||ch == ']' && target == '['||ch == ')' && target == '(')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
