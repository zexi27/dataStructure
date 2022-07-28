package com.zlq.day110;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: Day102_MaxConsecutiveAnswers
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/29 17:32
 */
/*
一位老师正在出一场由 n道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
老师想增加学生对自己做出答案的不确定性，
方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。

给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。
除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：

每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。

示例 1：

输入：answerKey = "TTFF", k = 2
输出：4
解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
总共有四个连续的 'T' 。
示例 2：

输入：answerKey = "TFFT", k = 1
输出：3
解释：我们可以将最前面的 'T' 换成 'F' ，得到 answerKey = "FFFT" 。
或者，我们可以将第二个 'T' 换成 'F' ，得到 answerKey = "TFFF" 。
两种情况下，都有三个连续的 'F' 。
示例 3：

输入：answerKey = "TTFTTFTT", k = 1
输出：5
解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
两种情况下，都有五个连续的 'T' 。
 */
public class Day102_MaxConsecutiveAnswers {
    public static void main(String[] args) {
        String answerKey = "FFTTFFFTFFFFFTTTFFFFFTTFTFFFTTTFFTTTTTTTTFTFTFFFFTTTFFFTFFFTFTFTFTTTTTTFFTTFTTTTFFFFFFFFTFFFTTFFFTFTFFFFFFTTTTFFTTFFFFFFTTFTFFFTTFTFTFTFTTFTFFFFFFFTFTTFTTFFFTTTTFFFTFTTFFTFTTFFTTTFTTFFFFFFTTTFTFTTTTTFFTTFFTTTFFFFFTFFFTTFTTTTTTTTFTFFTTTTTTFFFTFFTTTFFTFTFTTFTTFTTFTFFFTTFTFFTTTTTFTTTTFTFFFFTTTTFFFFTTTTTTFFFFTFFTTFFFFFFFTTTTTTFFFTFFTTFFTFFTTFFTTFTFTFFFTTTTFFTTFFTFFTTFFTTFFFTFFFTFTTFFTTTFTFFFTTFFFFFTTTTFFFFTTTFTFTFTTTFTFTFTFTTFFTFTTFFTTTTFFFFTFFFFFTTFFFTTTFFTTFTFFFFFTTTFTTTTFTFFTTFTTFFTTFTFTFFFFTTFTFTFTTFFTTTTTFTFFFTTFTFFTTTFTFFFTFTTTTFFTFTTFFFFTFTTFFTTTFFTFFFTFFFTFTFTTTTTTTFTTFTTTFFTTTTTFTTFFFFFFFTFTTTTTFTFFTFFFFTFTTTFFTFFTTTTTFTFTFTFTTTTFTTTTFTFTFTTFFFTTTFTTFFFFFTFFFTTFTTFFFTFFFFFFFTTTFTTFTTTTFTTFFTFFTFTFTFFTTTTFTTTFFTTFTTFFTTTFFFFTTFTFFTFFFTFFTFFFFFTTFTTTFTTTTFTTFFTFFFTTFTTTTTTTTTTFTFTFTTFFFTTFTTFTFFTTFFTTTTFTTTFTTTFTTFFFTFTFFFTFTFFTTFFFTTTTTFTFFFTTFFFFFFFTFFTFFFFFFTTTFTTTFFTTFTTTFFTTFTFTTFFFTTFFTTFTTTTTFTTTTFFFFFTTTTFFFFTTFFTFTFTTFFTFFFFFTFFFTFTFTFTTFFFTFTFTFFTTFFFTFTTFTTTFTTTTFTTTTFTTFFFFFFTFFTTTFFTFFTFTFFTTTFTFFFTFTFFFFTFFTFFFFFFTTTTFTFFTTTFTTFFTFFFFTFTTTTFFTFFFFFFFTFTFTTFFFFFTFFFTTFFFTTTFTFFFFFFFFFFTTTTTFTTTFTTTFTTFTTFTTFFTTFFTTTTTFFFFFFTTFFFFFTTFFFFFTFTTTFFFTFFFTFFTTFTFFFTTFFTFTFTFFFFTTTTFTFFFFTFTTTTTTFFTFTTTTTFTFFFFFFTFTTTFFTFTTFFTTTFFTTTFTTFFFFTTTFFFTFTTTTFFTTFTFTTTFTFTTTFTFTTFTTTFTFFFTTFFTFTFFFFTTFFFFTTTFFFFFTFTTFTFTFTFTFFFFTTTTTTTTTFTTTFFFTFTTTTFTFTFFFTFTTFTTTTTFTTTTFTFFFTTTFFTFFFFFFFFTTFFFFFFTTFTTFTFTTFTFTTTFFTTFFTTFFTFTTFFTFTFTFTTFFFFTTTFTFTFTFTTTFFTTFFFTTFTFTFFTFFTTFTFFTTTTFFFTTFFFFTFFTFTFFTFTTTFTTTTTTFTFTFFFTFTTTFFTTFTFTTFTFTFTTFFFTTFFTFTFFTTTFTTTFFFFTTFFFFTFTFFTFTTFFTTFTFTTFFFFTTTTTFTFTTFTTTFTTFFFFFFTTTTTTFTTTTFTFTFFTFFFTTTTTFTFFTTTTTFFFFTFFTFFFTTFFTTFTFTTFFFFFFTFFTTFFTTTTFFFFTTFTFTFFTTTTFFTFTFFTTFTTTTTFFFFFTTTTTFTFFFTFTTFFFFTTTFTTTTTFTTTFFTTTFTTFTFFTTFFFFTFTFFTTFFFTTTTTFFFFFFTFFFTTFTTTTFTTFFTFFTTTFFTFFFTTFFFTTTFFFFTTFTFFFFTFFTTFFTTFTFFTFTTFFTFFTFTFFFTFTTFTTTFTFTTFFFFTTTTTFFTTFTTFFTTFTFTFTTFFFFTFTTFTTTTFFFTFTTTFFFTTTFTTFTTFFTFFFFTTFTTFTFFFFTTTFFFTFFFFTTF";
        System.out.println(maxConsecutiveAnswers(answerKey, 116));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        if (answerKey.length() <= 2) return answerKey.length();
        int length = answerKey.length();
        int frequency = 0;
        int res = 0;
        for (int i = k; i < length; i++) {
            int l = 0, r = k + frequency;  // 定义左右指针，指定滑动窗口
            frequency++;
            while (r < length) {
                int countT = 0, countF = 0;
                for (int j = l; j <= r; j++) {
                    if (answerKey.charAt(j) == 'T') countT++;
                    else countF++;
                }
                if (countF <= k || countT <= k) res = Math.max(res, r - l + 1);
                l++;
                r++;
            }
        }
        return res;
    }


    static String s;
    static int n, k;

    public static int maxConsecutiveAnswers2(String answerKey, int _k) {
        s = answerKey;
        n = s.length();
        k = _k;
        return Math.max(getCnt('T'), getCnt('F'));
    }

    static int getCnt(char c) {
        int ans = 0;
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            while (cnt > k) {
                if (s.charAt(j) == c) cnt--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
