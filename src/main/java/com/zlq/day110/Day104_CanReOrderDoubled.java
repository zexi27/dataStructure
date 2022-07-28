package com.zlq.day110;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day110
 * @ClassName: Day104
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/1 23:18
 */
/*
给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，
都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。

示例 1：

输入：arr = [3,1,3,6]
输出：false
示例 2：

输入：arr = [2,1,2,6]
输出：false
示例 3：

输入：arr = [4,-2,2,-4]
输出：true
解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 */
public class Day104_CanReOrderDoubled {
    /*
    i == 0 => arr[1] = 2 * arr[0];
    i == 1 => arr[3] = 2 * arr[2];
    i == 2 => arr[5] = 2 * arr[4];
    i == 3 => arr[7] = 2 * arr[6]
     */
    public static void main(String[] args) {
        int[] arr = {2,4,0,0,8,1};
        System.out.println(canReorderDoubled(arr));
    }

    public static boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        if (validateNormal(arr)) return true;
        Set<Integer> set = new HashSet<>();  // hashset记录组合坐标
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && arr[j] == 2 * arr[i] && !set.contains(i) && !set.contains(j)) {  // 判断是否会有两倍组合
                    // 将两倍组合添加到hashset
                    set.add(i);
                    set.add(j);
                }
            }
        }
        if (set.size() < length) return false;

        return true;
    }

    public static boolean validateNormal(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[2 * i + 1] != 2 * arr[2 * i]) return false;
        }
        return true;
    }
}
