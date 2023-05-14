package com.zlq.day210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day200
 * @ClassName: Day201_CountNicePairs
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/17 11:04
 */
/*
给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：

0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。



示例 1：

输入：nums = [42,11,1,97]
输出：2
解释：两个坐标对为：
 - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
示例 2：

输入：nums = [13,10,35,24,76]
输出：4
 */
public class Day201_CountNicePairs {
    public static void main(String[] args) {
        String password = "ziyS5FrPQhoQ5oEWRpHW2MjI7sGfcMJdcsjQnIyRbdCilvFaQN07jQtAkOklbjFrU5KcHzw4EvJ41Yz2Ykyd";
        Day201_CountNicePairs pairs = new Day201_CountNicePairs();
        System.out.println(pairs.strongPasswordCheckerII(password));
        System.out.println(password.charAt(47));
    }

    /*
    nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])  =>
    nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
     */
    public static int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        //map统计，key为 f(i) = nums[i] - rev(nums[i]) ，v为次数
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int revNum = revNum(nums[i]);
            res = (res + map.getOrDefault(nums[i] - revNum, 0)) % MOD;
            map.put(nums[i] - revNum, map.getOrDefault(nums[i] - revNum, 0) + 1);
        }
        System.out.println(map);
        return res;
    }

    public static int revNum(int num) {
        int rev = 0;
        for (int t = num; t != 0; t /= 10) rev = rev * 10 + t % 10;
        return rev;
    }

    public boolean strongPasswordCheckerII(String password) {
        /*
        它有至少 8 个字符。
        至少包含 一个小写英文 字母。
        至少包含 一个大写英文 字母。
        至少包含 一个数字 。
        至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
        它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
         */
        int length = password.length();
        if (length < 8) return false;
        if (containLowercase(password) && containUppercase(password) && containNumber(password) && containSpecialChar(password) && notConsecutiveSame(password)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean notConsecutiveSame(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) return false;
        }
        return true;
    }

    private boolean containSpecialChar(String password) {
        String special = "!@#$%^&*()-+";
        List<Character> specialList = new ArrayList<>();
        for (int i = 0; i < special.length(); i++) {
            specialList.add(special.charAt(i));
        }
        for (int i = 0; i < password.length(); i++) {
            if (specialList.contains(password.charAt(i))) return true;
        }
        return false;
    }

    private boolean containNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) return true;
        }
        return false;
    }

    private boolean containUppercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) return true;
        }
        return false;
    }

    private boolean containLowercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) return true;
        }
        return false;
    }

    public static int commonFactors(int a, int b) {
        int cnt = 0;
        int small = a > b ? b : a;
        for (int i = 0; i < small; i++) {
            if (a % i == 0 && b % i == 0) cnt++;
        }
        return cnt;
    }
}
