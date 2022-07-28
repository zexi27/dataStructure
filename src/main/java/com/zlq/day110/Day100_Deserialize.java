package com.zlq.day110;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: Day100_Deserialize
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/15 20:32
 */

/*
给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果NestedInteger 。

列表中的每个元素只可能是整数或整数嵌套列表

示例 1：

输入：s = "324",
输出：324
解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
示例 2：

输入：s = "[123,[456,[789]]]",
输出：     [123,[456,[789]]]
解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
1. 一个 integer 包含值 123
2. 一个包含两个元素的嵌套列表：
    i.  一个 integer 包含值 456
    ii. 一个包含一个元素的嵌套列表
         a. 一个 integer 包含值 789
 */

    // [123,[234,345],[456,[789]]]
public class Day100_Deserialize {
    public static void main(String[] args) {
        String s = "[123,[456,[789]]]";
        NestedInteger nestedInteger = deserialize1(s);
        System.out.println(nestedInteger);
    }
    public static NestedInteger deserialize(String s) {
        int eleCount = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ',') eleCount++;
        }
        if (eleCount ==  0) return new NestedInteger(Integer.valueOf(s));
        int[] res = new int[eleCount + 1];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '[') stack.push(c);
            if (c == ']') stack.pop();


        }
        return null;
    }



    static NestedInteger ph = new NestedInteger(0);
    public static NestedInteger deserialize1(String s) {
        Deque<NestedInteger> d = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        int n = cs.length, i = 0;
        while (i < n) {
            if (cs[i] == ',' && ++i >= 0) continue;
            if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
                int j = cs[i] == '-' ? i + 1 : i, num = 0;
                while (j < n && (cs[j] >= '0' && cs[j] <= '9')) num = num * 10 + (cs[j++] - '0');
                d.addLast(new NestedInteger(cs[i] == '-' ? -num : num));
                i = j;
            } else if (cs[i] == '[') {
                d.addLast(new NestedInteger());
                d.addLast(ph);
                i++;
            } else {
                List<NestedInteger> list = new ArrayList<>();
                while (!d.isEmpty()) {
                    NestedInteger poll = d.pollLast();
                    if (poll == ph) break;
                    list.add(poll);
                }
                for (int j = list.size() - 1; j >= 0; j--) d.peekLast().add(list.get(j));
                i++;
            }
        }
        return d.peekLast();
    }

}
