package com.zlq.day80;


import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: Day76_SimplifyPath
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/6 10:16 下午
 */
/*
给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。

在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。

请注意，返回的 规范路径 必须遵循下述格式：

始终以斜杠 '/' 开头。
两个目录名之间必须只有一个斜杠 '/' 。
最后一个目录名（如果存在）不能 以 '/' 结尾。
此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
返回简化后得到的 规范路径 。


示例 1：

输入：path = "/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。
示例 2：

输入：path = "/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
示例 3：

输入：path = "/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
示例 4：

输入：path = "/a/./b/../../c/"
输出："/c"

 */
public class Day76_SimplifyPath {
    public static void main(String[] args) {
//        String path = "/a//./b/../../c/";
        String path = "/home/../../..";
        System.out.println(simplifyPath(path));

    }


    public static String simplifyPath(String path) {
        path = RemoveRepeatedSlashes(path);
//        System.out.println("去重后：" + path);
        int length = path.length();
        if (path.charAt(length - 1) != '/') {
            StringBuilder builder = new StringBuilder();
            builder.append(path).append('/');
            path = builder.toString();
        }
        System.out.println(path);
        Deque<String> deque = new ArrayDeque();
        int start = 0;
        int end = 0;
        for (int i = 1; i < path.length(); i++) {

            if (path.charAt(i) == '/') {
                end = i;
                String item = path.substring(start, end);
                if (item.equals("/..")){
                    deque.pollLast();
                }else {
                    if (!item.equals("/.")) deque.addLast(item);
                }
                start = end;
            }
        }
        System.out.println(deque);
        StringBuilder res = new StringBuilder();
        while (deque.size() > 0){
            res.append(deque.pollFirst());
        }
        return res.toString().length() == 0?"/":res.toString();
    }

    public static String RemoveRepeatedSlashes(String path) {
        StringBuilder builder = new StringBuilder();
        builder.append(path.charAt(0));
        for (int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/' && path.charAt(i - 1) == '/') continue;
            else builder.append(c);
        }
        return builder.toString();
    }

    public static String simplifyPath2(String path) {
        Deque<String> d = new ArrayDeque<>();
        int n = path.length();
        for (int i = 1; i < n; ) {
            if (path.charAt(i) == '/' && ++i >= 0) continue;
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') j++;
            String item = path.substring(i, j);
            if (item.equals("..")) {
                if (!d.isEmpty()) d.pollLast();
            } else if (!item.equals(".")) {
                d.addLast(item);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) sb.append("/" + d.pollFirst());
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
