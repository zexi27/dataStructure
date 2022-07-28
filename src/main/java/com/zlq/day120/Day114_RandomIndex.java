package com.zlq.day120;

import java.util.Random;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day120
 * @ClassName: Day114_RandomIndex
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/25 23:14
 */
public class Day114_RandomIndex {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
        }
    }

    int[] arr;

    public Day114_RandomIndex(int[] nums) {
        this.arr = nums;
    }

    public int pick(int target) {
        int count = 0;
        Random random = new Random();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == target) count++;
        }
        int index = random.nextInt(count) + 1;
        count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == target) {
                count++;
            }
            if (count == index) return i;
        }
        return -1;
    }
}
