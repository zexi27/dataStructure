package com.zlq.day50.Day48_Sort;

import java.util.Random;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day50.Day48_Sort
 * @ClassName: CheckNums
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/1 10:41 上午
 */
public class CheckNums {
    public static int[] generateRandomArray(int length){
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int ele = random.nextInt(length);
            arr[i] = ele;
        }
        return arr;
    }

    public static boolean checkArr(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}
