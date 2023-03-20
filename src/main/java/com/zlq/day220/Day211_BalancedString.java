package com.zlq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq
 * @ClassName: Day220_BalancedString
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/13 19:58
 */
/*
1234. 替换子串得到平衡字符串

有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。

假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。

给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。

你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。

请返回待替换子串的最小可能长度。

如果原字符串自身就是一个平衡字符串，则返回 0。

示例 1：

输入：s = "QWER"
输出：0
解释：s 已经是平衡的了。
示例 2：

输入：s = "QQWE"
输出：1
解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
示例 3：

输入：s = "QQQW"
输出：2
解释：我们可以把前面的 "QQ" 替换成 "ER"。
示例 4：

输入：s = "QQQQ"
输出：3
解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。

提示：

1 <= s.length <= 10^5
s.length 是 4 的倍数
s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 */
public class Day211_BalancedString {


    // E-3  Q-4  R-6  W-3
    public static int balancedString(String s) {
        int length = s.length();
        int balance = length / 4;
        Map<Character, Integer> map = new TreeMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) + 1);
        }
        if (checkBalance(map, balance)) return 0;

        System.out.println(map);
        int changeCount = 0;
        for (Character character : map.keySet()) {
            if (map.get(character) < balance) {
                changeCount += balance - map.get(character);
            }
        }
        // 从changeCount为初始值大小的可变滑动窗口
        for (int windowSize = changeCount; windowSize < length - 1; windowSize++) {
            int l = 0, r = windowSize - 1;
            Map<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < windowSize; i++) {
                char c = s.charAt(i);
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            }
            if (check(map, tempMap, balance)) return windowSize;
            while (r < length - 1) {
                tempMap.put(s.charAt(l), tempMap.get(s.charAt(l)) - 1);
                l++;
                r++;
                tempMap.put(s.charAt(r), tempMap.getOrDefault(s.charAt(r), 0) + 1);
                if (check(map, tempMap, balance)) return windowSize;
            }
        }
        return 0;
    }

    public static boolean check(Map<Character, Integer> map, Map<Character, Integer> tempMap, Integer balance) {
        for (Character character : tempMap.keySet()) {
            if (map.get(character) - tempMap.get(character) != balance) return false;
        }
        return true;
    }

    public static boolean checkBalance(Map<Character, Integer> map, Integer balance) {
        for (Character character : map.keySet()) {
            if (map.get(character) != balance) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "WWEQERQWQWWRWWERQWEQ";
//        System.out.println(balancedString(s));
        int[] hours = {9,9,6,0,6,6,9};
        System.out.println(longestWPI2(hours));
    }

    // {-1, -1 , 1, 1, -1, -1, 1}
    public static int longestWPI(int[] hours) {
        int length = hours.length;
        Integer tiredDays = 0;
        for (int i = 0; i < length; i++) {
            if (hours[i] > 8) tiredDays++;
        }
        Integer noTiredDays = length - tiredDays;
        if (tiredDays > noTiredDays) return length;

        for (int windowSize = length - 1; windowSize > 0; windowSize--) {
            tiredDays = 0;
            noTiredDays = 0;
            for (int i = 0; i < windowSize; i++) {
                if (hours[i] > 8) tiredDays++;
            }
            noTiredDays = windowSize - tiredDays;
            if (tiredDays > noTiredDays) return windowSize;

            int l = 0, r = windowSize - 1;
            while (r < length - 1) {
                if (hours[l] > 8) tiredDays -= 1;
                else noTiredDays -= 1;
                l++;
                r++;
                if (hours[r] > 8) tiredDays += 1;
                else noTiredDays += 1;
                if (tiredDays > noTiredDays) return r - l + 1;
            }
        }
        return 0;
    }


    public static int longestWPI2(int[] hours) {
        int length = hours.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = hours[i] > 8 ? 1 : -1;
        }
        System.out.println(Arrays.toString(arr));

        int[] sumArr = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            sumArr[i] = sum;
        }
        System.out.println(Arrays.toString(sumArr));
        Integer maxLength = 0;
        for (int i = 0; i < sumArr.length; i++) {
            for (int j = i; j < sumArr.length; j++) {
                if (sumArr[j] - sumArr[i] > 0) {
                    maxLength = Math.max(j - i,maxLength);
                }
            }
        }
        for (int i = 0; i < sumArr.length; i++) {
            if (sumArr[i] > 0){
                maxLength = Math.max(i + 1,maxLength);
            }
        }
        return maxLength;
    }
}
