package com.zlq.day70;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day70
 * @ClassName: Day63_CatchRain
 * @description:
 * @author: LiQun
 * @CreateDate:2021/11/29 9:23 下午
 */
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，
在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9
 */
public class Day63_CatchRain {

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    /*

     */
    public static int trap(int[] height) {
        int length = height.length;
        int l = 0, r = 0;  // 定义双指针，初始位置都为0
        int result = 0; // 定义结果值
        int count = 1; // 定义初始第1轮
        while (r < length ) {  // 边界条件
            int thisTimeArea = 0;
            // 右指针开始往右找比左指针小的

            // 如果右边的一个值比开始寻找的值大，就让左右指针都右移
            while (r < length - 1 && height[r + 1] >= height[r] && r == l) {
                l++;
                r++;
            }
            // 右指针右移，每一轮啥时候停？当这个数大于等于开始的那个数
            while (r < length ) {
                if (height[r] >= height[l] && l != r) {
                    System.out.println("第" + count + "轮");
                    System.out.println("左指针l= " + l);
                    System.out.println("右指针r=" + r);
                    // 计算当前次的雨水量
                    int sum = 0;
                    int minRange = Math.min(height[l], height[r]);
                    for (int i = l; i <= r; i++) {
                        sum += height[i] > minRange ? minRange : height[i];
                    }
                    thisTimeArea = (r - l + 1) * minRange;
                    result += thisTimeArea - sum;
                    System.out.println("thisTimeArea = " + thisTimeArea);
                    System.out.println("sum = " + sum);
                    System.out.println("此次的雨水量：" + result);
                    l = r;

                    count++;
                }
                r++;
//                // 如果r往后移到头了
//                if (r == length -1 ) {
//                    System.out.println("到头了");
//               // r指针指向最右 如果左边的一个值比开始寻找的值大，就让右指针都左移
//                    System.out.println(r + "...");
//                    System.out.println(r + "...");
//                    break;
//                }

            }
//
        }
//        System.out.println(l);
//        System.out.println(r);
        int l2 = length - 1, r2 = length - 1;
        // 如果左边的一个值比开始寻找的值大，就让左右指针都左移
        while (r2 > l && height[r2 - 1] >= height[r2] && r2 == l2) {
            l2--;
            r2--;
        }

        int thisTimeArea = 0;

        while (r2 > l + 1) {
            // 左指针左移，每一轮啥时候停？当这个数大于等于开始的那个数
            if (height[l2] >= height[r2] && l2 != r2) {
                if (l2 == r2) continue;
                System.out.println("第" + count + "轮");
                System.out.println("左指针l2= " + l2);
                System.out.println("右指针r2=" + r2);

                // 计算当前次的雨水量
                int sum = 0;
                int minRange = Math.min(height[l2], height[r2]);
                for (int i = r2; i >= l2; i--) {
                    sum += height[i] > minRange ? minRange : height[i];
                }
                thisTimeArea = (r2 - l2 + 1) * minRange;
                result += thisTimeArea - sum;
                System.out.println("thisTimeArea = " + thisTimeArea);
                System.out.println("sum = " + sum);
                System.out.println("此次的雨水量：" + result);
                r2 = l2;
                count++;
            }
            l2--;
        }

        return result;
    }




    public static int trap2(int[] height) {
        int length = height.length;
        int l = 0, r = 0;  // 定义双指针，初始位置都为0
        int result = 0; // 定义结果值
        while (r < length ) {  // 边界条件
            int thisTimeArea = 0;
            // 右指针开始往右找比左指针小的

            // 如果右边的一个值比开始寻找的值大，就让左右指针都右移
            while (r < length - 1 && height[r + 1] >= height[r] && r == l) {
                l++;
                r++;
            }
            // 右指针右移，每一轮啥时候停？当这个数大于等于开始的那个数
            while (r < length ) {
                if (height[r] >= height[l] && l != r) {
                    // 计算当前次的雨水量
                    int sum = 0;
                    int minRange = Math.min(height[l], height[r]);
                    for (int i = l; i <= r; i++) {
                        sum += height[i] > minRange ? minRange : height[i];
                    }
                    thisTimeArea = (r - l + 1) * minRange;
                    result += thisTimeArea - sum;
                    l = r;
                }
                r++;
            }
        }
        int l2 = length - 1, r2 = length - 1;
        // 如果左边的一个值比开始寻找的值大，就让左右指针都左移
        while (r2 > l && height[r2 - 1] >= height[r2] && r2 == l2) {
            l2--;
            r2--;
        }

        int thisTimeArea = 0;

        while (r2 > l + 1) {
            // 左指针左移，每一轮啥时候停？当这个数大于等于开始的那个数
            if (height[l2] >= height[r2] && l2 != r2) {

                // 计算当前次的雨水量
                int sum = 0;
                int minRange = Math.min(height[l2], height[r2]);
                for (int i = r2; i >= l2; i--) {
                    sum += height[i] > minRange ? minRange : height[i];
                }
                thisTimeArea = (r2 - l2 + 1) * minRange;
                result += thisTimeArea - sum;
                r2 = l2;
            }
            l2--;
        }
        return result;
    }

}
