package com.zlq.day120;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day120
 * @ClassName: Day112_MaxRotateFunction
 * @description:
 * @author: LiQun
 * @CreateDate:2022/4/23 13:32
 */
/*
假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：

F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
返回 F(0), F(1), ..., F(n-1)中的最大值 。

生成的测试用例让答案符合 32 位 整数。

示例 1:

输入: nums = [4,3,2,6]
输出: 26
解释:
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25

F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
示例 2:

输入: nums = [100]
输出: 0
 */
public class Day112_MaxRotateFunction {
    public static void main(String[] args) {
        int[] nums = {100};
        System.out.println(maxRotateFunction(nums));
    }

    /*
    0 * arr[0] + 1 * arr[1] + 2 * arr[2] + 3 * arr[3]
    0 * arr[3] + 1 * arr[0] + 2 * arr[1] + 3 * arr[2]
    0 * arr[2] + 1 * arr[3] + 2 * arr[0] + 3 * arr[1]
    0 * arr[1] + 1 * arr[2] + 2 * arr[3] + 3 * arr[0]
     */
    public static int maxRotateFunction(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            int seq = 0;
            for (int j = i; j < length + i; j++) {
                sum += j > length - 1? (j - length)* nums[seq++] : j* nums[seq++];
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
