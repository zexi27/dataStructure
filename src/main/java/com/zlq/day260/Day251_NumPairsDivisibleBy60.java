package com.zlq.day260;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day260
 * @ClassName: Day251_NumPairsDivisibleBy60
 * @description:
 * @author: LiQun
 * @CreateDate:2023/5/7 13:18
 */
/*
1010. 总持续时间可被 60 整除的歌曲
提示
中等
240
相关企业
在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。

返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。



示例 1：

输入：time = [30,20,150,100,40]
输出：3
解释：这三对的总持续时间可被 60 整除：
(time[0] = 30, time[2] = 150): 总持续时间 180
(time[1] = 20, time[3] = 100): 总持续时间 120
(time[1] = 20, time[4] = 40): 总持续时间 60
示例 2：

输入：time = [60,60,60]
输出：3
解释：所有三对的总持续时间都是 120，可以被 60 整除。


提示：

1 <= time.length <= 6 * 104
1 <= time[i] <= 500
 */
public class Day251_NumPairsDivisibleBy60 {
//    public static void main(String[] args) {
////        int[] time = {60, 60, 60};
////        System.out.println(numPairsDivisibleBy60(time));
//        int x = 1122;
//        System.out.println(isPalindrome(x));
//    }

    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(); // key - time value - count
        int length = time.length;
        for (int i = 0; i < length; i++) {
            int remain = time[i] % 60;
            if (map.get(60 - remain) != null) {
                count += map.get(60 - remain);
            }
            if (remain == 0 && map.get(0) != null) {
                count += map.get(0);
            }
            map.put(remain, map.getOrDefault(remain, 0) + 1);
        }
        return count;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        int length = str.length();
        int l = 0, r = length - 1;
        while (l < r) {
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return l >= r;
    }

    public static void main(String[] args) {
        String time = "2?:??";
        System.out.println(countTime(time));
    }
    public static int countTime(String time) {
        String[] times = time.split(":");
        int countHours = count(times[0], 1);
        int countMinutes = count(times[1], 2);
        return (countHours == 0 ? 1:countHours )* ( countMinutes == 0 ? 1 : countMinutes);
    }

    public static int count(String time,int type) {
        if (!time.contains("?")) return 0;

        if (type == 1) {
          if (time.equals("??")) return 24;
          if (time.charAt(0) == '?'){
              if (time.charAt(1) < '4') return 3;
              else return 2;
          }
          if (time.charAt(1) == '?'){
              if (time.charAt(0) < '2') return 10;
              else return 4;
          }
        }

        if (type == 2){
            if (time.equals("??")) return 60;
            if (time.charAt(0) == '?'){
                return 6;
            }
            if (time.charAt(1) == '?'){
                return 10;
            }
        }
        return 0;
    }
}
