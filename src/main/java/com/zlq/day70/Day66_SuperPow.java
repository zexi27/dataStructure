package com.zlq.day70;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day70
 * @ClassName: Day66_SuperPow
 * @description:
 * @author: LiQun
 * @CreateDate:2021/12/5 9:49 上午
 */
public class Day66_SuperPow {
    public static void main(String[] args) {
        int[] b = {1, 1};
        Day66_SuperPow pow = new Day66_SuperPow();
        System.out.println(pow.superPow(2, b));
    }

    int MOD = 1337;

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    int dfs(int a, int[] b, int u) {
        if (u == -1) return 1;
        return pow(dfs(a, b, u - 1), 10) * pow(a, b[u]) % MOD;
    }

    int pow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b-- > 0) ans = ans * a % MOD;
        return ans;
    }


}
