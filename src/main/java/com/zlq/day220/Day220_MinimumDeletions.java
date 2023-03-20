package com.zlq.day220;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day220
 * @ClassName: Day220_MinimumDeletions
 * @description:
 * @author: LiQun
 * @CreateDate:2023/3/6 09:47
 */
/*
1653. 使字符串平衡的最少删除次数
中等
相关企业
给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。

你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。

请你返回使 s 平衡 的 最少 删除次数。



示例 1：

输入：s = "aababbab"
输出：2
解释：你可以选择以下任意一种方案：
下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
示例 2：

输入：s = "bbaaaaabb"
输出：2
解释：唯一的最优解是删除最前面两个字符。


提示：

1 <= s.length <= 105
s[i] 要么是 'a' 要么是 'b' 。
 */
public class Day220_MinimumDeletions {

    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbb";
        System.out.println(minimumDeletions(s));
    }
    /*
    要使得字符串达到平衡，即删除字符串左侧所有b和字符串右侧所有a即可
     */
    public static int minimumDeletions(String s) {
        if (s.length() == 1) return 0;
        int countA = 0,countB = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') countA++;
            else countB++;
        }
        int leftB = 0,rightA = countA,res = 100000;
        res = Math.min(leftB + rightA,res);
        for (int i = 1; i < s.length() + 1; i++) {
            char c = s.charAt(i - 1);
            if (c == 'a') rightA--;
            else leftB++;
            res = Math.min(leftB + rightA,res);
        }
        return res;
    }
}
