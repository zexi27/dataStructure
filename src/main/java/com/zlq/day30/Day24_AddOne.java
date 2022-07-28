package com.zlq.day30;

import java.util.Arrays;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day24_AddOne
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/23 10:51 上午
 */
/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
示例 2：

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
示例 3：

输入：digits = [0]
输出：[1]。
 */
public class Day24_AddOne {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne3(arr)));
        System.out.println(Integer.MAX_VALUE);
    }



    /*
   [1,9,9,9]
    */
    public static int[] plusOne3(int[] digits) {
        int carry;
        int length = digits.length;
        int lastNum = digits[length - 1];
        if (lastNum < 9) {
            digits[length - 1] += 1;
        } else {
            digits[length - 1] = 0;
            carry = 1;
            for (int i = digits.length - 2; i >= 0; i--) {
                if (digits[i] < 9){
                    digits[i]+=carry;
                    break;
                }else {
                    digits[i] = 0;
                    carry = 1;
                }
            }
        }
        if (digits[0] == 0){
            digits = new int[length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry;  // 进位
        int lastNum = digits[length - 1];
        // 如果最后一位小于9直接 + 1，不用考虑进位
        if (lastNum < 9) {
            digits[length - 1] = lastNum + 1;
        } else {   // 考虑进位
            carry = 1;
            for (int i = length - 1; i >= 0; i--) {
                digits[i] = digits[i] + carry;
                if (digits[i] >= 10) {
                    digits[i] = 0;
                    carry = 1;
                    // 考虑特殊情况，最左边也被进位，数组扩容长度加一，最左边为1
                    if (digits[0] == 0) {
                        digits = new int[length + 1];
                        digits[0] = 1;
                    }
                } else {
                    carry = 0;
                }
            }
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }


}
