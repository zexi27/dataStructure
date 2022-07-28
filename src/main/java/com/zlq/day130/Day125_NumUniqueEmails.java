package com.zlq.day130;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day125_NumUniqueEmails
 * @description:
 * @author: LiQun
 * @CreateDate:2022/6/4 16:20
 */
/*
每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，
电子邮件地址还可以含有一个或多个'.' 或 '+' 。

例如，在alice@leetcode.com中，alice是 本地名 ，而leetcode.com是 域名 。
如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。
请注意，此规则 不适用于域名 。

例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com”会转发到同一电子邮件地址。
如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。

例如 m.y+name@email.com 将转发到 my@email.com。
可以同时使用这两个规则。

给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。


 示例 1：

输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
输出：2
解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
示例 2：

输入：emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
输出：3
 */
public class Day125_NumUniqueEmails {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(numUniqueEmails(emails));
    }
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String s = parseEmail(emails[i]);
            if (!set.contains(s)) {
                set.add(s);
            }
        }
        return set.size();

    }

    public static String parseEmail(String email) {
        String[] split = email.split("@");
        StringBuilder emailBuilder = new StringBuilder();
        for (int i = 0; i < split[0].length(); i++) {
            char c = split[0].charAt(i);
            if (c == '.') continue;
            if (c == '+') break;
            emailBuilder.append(c);
        }
        emailBuilder.append('@');
        emailBuilder.append(split[1]);
        return emailBuilder.toString();
    }
}
