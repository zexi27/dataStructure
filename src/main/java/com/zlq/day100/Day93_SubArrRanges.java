package com.zlq.day100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day93_SubArrRanges
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/4 10:28 上午
 */

/*
给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。

返回 nums 中 所有 子数组范围的 和 。

子数组是数组中一个连续 非空 的元素序列。


示例 1：

输入：nums = [1,2,3]
输出：4
解释：nums 的 6 个子数组如下所示：
[1]，范围 = 最大 - 最小 = 1 - 1 = 0
[2]，范围 = 2 - 2 = 0
[3]，范围 = 3 - 3 = 0
[1,2]，范围 = 2 - 1 = 1
[2,3]，范围 = 3 - 2 = 1
[1,2,3]，范围 = 3 - 1 = 2
所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
示例 2：

输入：nums = [1,3,3]
输出：4
解释：nums 的 6 个子数组如下所示：
[1]，范围 = 最大 - 最小 = 1 - 1 = 0
[3]，范围 = 3 - 3 = 0
[3]，范围 = 3 - 3 = 0
[1,3]，范围 = 3 - 1 = 2
[3,3]，范围 = 3 - 3 = 0
[1,3,3]，范围 = 3 - 1 = 2
所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
示例 3：

输入：nums = [4,-2,-3,4,1]
输出：59
解释：nums 中所有子数组范围的和是 59
 */
class User implements Cloneable {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Day93_SubArrRanges {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] nums = {1,1};
        System.out.println(subArrayRanges(nums));
        User user = new User("zhangliqun", 12);
    }


    public static long subArrayRanges(int[] nums) {
        int length = nums.length;
        long res = 0;
        for (int i = 0; i < length; i++) {
            int max = nums[i],min = nums[i];
            for (int j = i; j < length; j++) {
                max = Math.max(nums[j],max);
                min = Math.min(nums[j],min);
                res += max - min;
            }
        }
        return res;
    }


    public static int n;
    public static long subArrayRanges2(int[] nums) {
        n = nums.length;
        // min[i] 代表 nums[i] 作为区间最小值的次数；max[i] 代表 nums[i] 作为区间最大值的次数
        long[] min = getCnt(nums, true), max = getCnt(nums, false);
        long ans = 0;
        for (int i = 0; i < n; i++) ans += (max[i] - min[i]) * nums[i];
        return ans;
    }
    public static long[] getCnt(int[] nums, boolean isMin) {
        int[] a = new int[n], b = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] >= nums[i] : nums[d.peekLast()] <= nums[i])) d.pollLast();
            a[i] = d.isEmpty() ? -1 : d.peekLast();
            d.addLast(i);
        }
        d.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] > nums[i] : nums[d.peekLast()] < nums[i])) d.pollLast();
            b[i] = d.isEmpty() ? n : d.peekLast();
            d.addLast(i);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) ans[i] = (i - a[i]) * 1L * (b[i] - i);
        return ans;
    }

    public int findLUSlength(String a, String b) {
        if(a == b) return -1;
        return Math.max(a.length(),b.length());
    }
}
