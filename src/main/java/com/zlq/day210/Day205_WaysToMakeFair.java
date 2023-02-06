package com.zlq.day210;

import java.util.Arrays;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day205_WaysToMakeFair
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/28 10:10
 */
/*
1664. 生成平衡数组的方案数
中等
49
相关企业
给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。

比方说，如果 nums = [6,1,7,4,1] ，那么：

选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。

请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。

示例 1：

输入：nums = [2,1,6,4]
输出：1
解释：
删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
只有一种让剩余数组成为平衡数组的方案。
示例 2：

输入：nums = [1,1,1]
输出：3
解释：你可以删除任意元素，剩余数组都是平衡数组。
示例 3：

输入：nums = [1,2,3]
输出：0
解释：不管删除哪个元素，剩下数组都不是平衡数组。

 */
public class Day205_WaysToMakeFair {
//    public static void main(String[] args) {
//        int[] nums = {2, 1, 6, 4};
//        System.out.println(waysToMakeFair(nums));
//    }

    /*
    -original-
    odd:  1,3,5,7,9,11,13,15
    even: 0,2,4,6,8,10,12,14,16
    -0-
    odd:  2,4,6,8,10,12,14,16
    even: 1,3,5,7,9,11,13,15
    -1-
    odd:  2,4,6,8,10,12,14,16 (72)
    even: 0,3,5,7,9,11,13,15
    -2-
    odd:  1,4,6,8,10,12,14,16 (71)
    even: 0,3,5,7,9,11,13,15
    -3-
    odd:  1,4,6,8,10,12,14,16 (71)
    even: 0,2,5,7,9,11,13,15
    -4-
    odd:  1,3,6,8,10,12,14,16 (70)
    even: 0,2,5,7,9,11,13,15
    -5-
    odd:  1,3,6,8,10,12,14,16
    even: 0,2,4,7,9,11,13,15
    -6-
    odd:  1,3,5,8,10,12,14,16

     */
    public static int waysToMakeFair(int[] nums) {
        int oddSum = 0;
        int sum = Arrays.stream(nums).sum();
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) oddSum += nums[i];
        }
        int cnt = oddSum == sum - nums[0] - oddSum ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) oddSum = oddSum - nums[i] + nums[i - 1];
            if (oddSum == sum - nums[i] - oddSum) cnt++;
        }
        return cnt;
    }

    public static int waysToMakeFair3(int[] nums) {
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 0) oddSum += nums[i];
            else evenSum += nums[i];
        }
        int cnt = oddSum == evenSum ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 0) oddSum = oddSum - nums[i] + nums[i - 1];
            else evenSum = evenSum - nums[i] + nums[i - 1];
            if (oddSum == evenSum) cnt++;
        }
        return cnt;
    }

    public static int waysToMakeFair2(int[] nums) {
        int cnt = 0;
        int sum = Arrays.stream(nums).sum();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if ((sum - nums[i]) % 2 != 0) continue;
            int oddSum = 0;
            for (int j = 0; j < length; j++) {
                if (j == i) continue;
                else if (j < i) {
                    if (j % 2 != 0) oddSum += nums[j];
                } else if (j > i) {
                    if (j % 2 == 0) oddSum += nums[j];
                }
            }
            if (oddSum == sum - nums[i] - oddSum) cnt++;
        }
        return cnt;
    }


    /*
    给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
    请你返回 不在 竖线对之间，s 中 '*' 的数目。
    注意，每个竖线 '|' 都会 恰好 属于一个对。

    示例 1：

    输入：s = "l|*e*et|c**o|*de|"
    输出：2
    解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
    第一和第二条竖线 '|' 之间的字符不计入答案。
    同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
    不在竖线对之间总共有 2 个星号，所以我们返回 2 。
    示例 2：

    输入：s = "iamprogrammer"
    输出：0
    解释：在这个例子中，s 中没有星号。所以返回 0 。
    示例 3：

    输入：s = "yo|uar|e**|b|e***au|tifu|l"
    输出：5
    解释：需要考虑的字符加粗加斜体后："yo|uar|e**|b|e***au|tifu|l" 。不在竖线对之间总共有 5 个星号。所以我们返回 5 。
     */
    public static void main(String[] args) {
        String s = "l|*e*et|c**o|*de|";
        System.out.println(countAsterisks(s));
        System.out.println(0 % 2);
    }

    public static int countAsterisks(String s) {
        String[] strings = s.split("\\|");
        int cnt = 0;
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < strings[i].length(); j++) {
                    if (strings[i].charAt(j) == '*') cnt++;
                }
            }
        }
        return cnt;
    }

    public static int countAsterisks2(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '|') flag = !flag;
            if (flag && c == '*') {
                cnt++;
            }
        }
        return cnt;
    }

}
