package com.zlq.day170;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day161_MaximumSwap
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/13 10:43
 */
public class Day161_MaximumSwap {
    /*
    You are given an integer num. You can swap two digits at most once to get the maximum valued number.

    Return the maximum valued number you can get.


    Example 1: ;

    Input: num = 2736
    Output: 7236
    Explanation: Swap the number 2 and the number 7.
    Example 2:

    Input: num = 9973
    Output: 9973
    Explanation: No swap.
     */
    public static void main(String[] args) {
//        System.out.println(maximumSwap(1993));
//        System.out.println(tailRecursion(5, 1));
        int[] arr = {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        System.out.println(trimMean(arr));
    }

    public static int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        int[] numArr = new int[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = numStr.charAt(i) - '0';
        }
        for (int i = 0; i < length - 1; i++) {
            // 找出该位置后面最大且比它小的数，角标相同继续往后，然后交换
            int maxIndex = i + 1;
            int maxNum = 0;
            for (int j = i + 1; j < length; j++) {
                if (numArr[j] >= maxNum && numArr[j] > numArr[i]) {
                    maxNum = numArr[j];
                    maxIndex = j;
                }

            }
            if (maxNum != 0) {
                int temp = numArr[maxIndex];
                numArr[maxIndex] = numArr[i];
                numArr[i] = temp;
                break;
            }
        }
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < length; i++) {
            resStr.append(numArr[i]);
        }
        return Integer.valueOf(resStr.toString());
    }

    public static int recursion(int n) {
        if (n == 1) return 1;
        return recursion(n - 1) * n;
    }

    public static int tailRecursion(int n, int res) {
        if (n == 1) return res;
        return tailRecursion(n - 1, res * n);
    }

    /*
    Given an integer array arr,
    return the mean of the remaining integers after removing the smallest 5% and the largest 5% of the elements.
    Answers within 10-5 of the actual answer will be considered accepted.

    Example 1:
    Input: arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
    Output: 2.00000
    Explanation: After erasing the minimum and the maximum values of this array, all elements are equal to 2, so the mean is 2.
    Example 2:

    Input: arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
    Output: 4.00000
    Example 3:

    Input: arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
    Output: 4.77778
     */

    public static double trimMean(int[] arr) {
        int length = arr.length;
        int removeCount = length * 5 / 100;
        int sum = 0;
        Arrays.sort(arr);
        for (int i = removeCount; i < length - removeCount; i++) {
            sum += arr[i];
        }
        return (double) sum / (length * 0.9);
    }
}
