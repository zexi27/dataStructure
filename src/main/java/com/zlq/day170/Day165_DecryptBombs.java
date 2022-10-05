package com.zlq.day170;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day165_DecryptBombs
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/24 15:35
 */
/*
You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array codeof length of nand a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.
As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!



Example 1:

Input: code = [5,7,1,4], k = 3
Output: [12,10,16,13]
Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
Example 2:

Input: code = [1,2,3,4], k = 0
Output: [0,0,0,0]
Explanation: When k is zero, the numbers are replaced by 0.
Example 3:

Input: code = [2,4,9,3], k = -2
Output: [12,5,6,13]
Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 */
public class Day165_DecryptBombs {
    /*
    Input: code = [2,4,9,3], k = -2
    Output: [12,5,6,13]
    Input: code = [2,4,9,3], k =  2
    Output: [13,12,5,6]
    ------------------------------
    [13,12,10,16]
    Input: code = [5,7,1,4], k = 3
    Output: [12,10,16,13]
    Input: code = [5,7,1,4], k = -3
    Output: [12,10,16,13]

    [13,12,7,15,18,21,19]
    Input: code = [5,7,1,4,2,9,7], k = 3
    Output: [12,7,15,18,21,19,13]
    Input: code = [5,7,1,4,2,9,7], k = -3
    Output: [18,21,19,13,12,7,15]
     */
    public static void main(String[] args) {
        int[] code = {2,4,9,3};
        System.out.println(Arrays.toString(decrypt(code, -2)));
    }

    public static int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] tempArr = new int[length];
        if (k == 0) return tempArr;
        int l = 1, r = Math.abs(k);
        int curSum = 0;
        int index = 0;
        for (int i = l; i <= r; i++) {
            curSum += code[i];
        }
        while (index < length) {
            tempArr[index++] = curSum;
            r++;
            if (r > length - 1) r = r - length;
            curSum += code[r];
            curSum -= code[l];
            l++;
            if (l > length - 1) l = l - length;
        }
        if (k > 0) return tempArr;
        else {
            int LeftRemoveIndex = (length - Math.abs(k)) - 1;
            int[] resArr = new int[length];
            if (LeftRemoveIndex == 0) return tempArr;
            for (int i = 0; i < length; i++) {
                int tempIndex = i + LeftRemoveIndex >= length ? (i + LeftRemoveIndex) - length  : i + LeftRemoveIndex;
                resArr[i] = tempArr[tempIndex];
            }
            return resArr;
        }
    }
}
