package com.zlq.day240;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq
 * @ClassName: Day240_ShortestCommonSupersequence
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/28 11:06
 */
/*
1092. 最短公共超序列
困难
给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。

（如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）



示例：

输入：str1 = "abac", str2 = "cab"
输出："cabac"
解释：
str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
最终我们给出的答案是满足上述属性的最短字符串。

提示：

1 <= str1.length, str2.length <= 1000
str1 和 str2 都由小写英文字母组成。
 */
public class Day231_ShortestCommonSupersequence {

    /*
    - 如果str1为空，结果为str2
    - 如果str2为空，结果为str1
    - 如果str1和str2的最后一个字母相同，则答案的最后一个字母为他们的最后一个字母。
      然后继续由str1[0 ~ length - 2] 和 str2[0 ~ length - 2] 构造答案
    - 如果str1和str2的最后一个字母不相同
      - 如果答案的最后一个字母为s1的最后一个字母，继续由str1[0 ~ length - 2]  和 str2构造 ，答案记为ans1
      - 如果答案的最后一个字母为s2的最后一个字母，继续由str1 和 str2[0 ~ length - 2]构造，答案记为ans2

      - 如果ans1比ans2短，
     */
    public static String shortestCommonSupersequence(String str1, String str2) {
        if (str1.length() == 0) return str2;
        if (str2.length() == 0) return str1;
        String s1 = str1.substring(0, str1.length() - 1);
        String s2 = str2.substring(0, str2.length() - 1);
        char x = str1.charAt(str1.length() - 1);
        char y = str2.charAt(str2.length() - 1);
        if (x == y) return shortestCommonSupersequence(s1, s2) + x;
        String ans1 = shortestCommonSupersequence(s1, str2);
        String ans2 = shortestCommonSupersequence(str1, s2);
        return ans1.length() < ans2.length() ? ans1 + x : ans2 + y;
    }

    private static String s;
    private static String t;
    private static String[][] memo;

    public static String shortestCommonSupersequence2(String str1, String str2) {
        s = str1;
        t = str2;
        memo = new String[str1.length()][str2.length()];
        return dfs(s.length() - 1, t.length() - 1);
    }

    private static String dfs(int i, int j) {
        if (i < 0) return t.substring(0, j + 1); // s 是空串，返回剩余的 t
        if (j < 0) return s.substring(0, i + 1); // t 是空串，返回剩余的 s
        if (memo[i][j] != null) return memo[i][j]; // 避免重复计算 dfs 的结果
        if (s.charAt(i) == t.charAt(j)) // 最短公共超序列一定包含 s[i]
            return memo[i][j] = dfs(i - 1, j - 1) + s.charAt(i);
        String ans1 = dfs(i - 1, j);
        String ans2 = dfs(i, j - 1);
        if (ans1.length() < ans2.length()) // 取 ans1 和 ans2 中更短的组成答案
            return memo[i][j] = ans1 + s.charAt(i);
        return memo[i][j] = ans2 + t.charAt(j);
    }
}
