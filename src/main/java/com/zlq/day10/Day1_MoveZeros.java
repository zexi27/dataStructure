package com.zlq.day10;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq
 * @ClassName: MoveZeros
 * @description:
 * @author: LiQun
 * @CreateDate:2021/5/21 9:17 上午
 */
/*
给定一个数组nums，编写一个函数将所有0移动到数组末尾，同时保持非零元素的正常相对顺序

输入:[0,1,0,3,12]
输出:[1,3,12,0,0]
 */
public class Day1_MoveZeros {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
//        [1,0,0,3,12]
        int[] nums2 = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] res = moveZeros3(nums1);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "\t");
        }

    }

    //错误解法，不适合连续的0出现
    public static int[] moveZeros1(int[] nums) {
        //循环遍历数组
        for (int i = 0; i < nums.length; i++) {
            //如果遇到0，就后一个坐标的值赋值给该坐标
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                //补零
                nums[nums.length - 1] = 0;
            }
        }
        return nums;
    }

    //方法1：暴力法，时间复杂度O(N²）空间复杂度O(c)
    public static int[] moveZeros2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //从i之后遍历数组
            for (int j = i + 1; j < nums.length; j++) {
                //如果出现为0的数，就将0和后面的数替换
                //判断当前j循环中是否替换过
                boolean isReplaced = false;
                if (nums[i] == 0) {
                    if (nums[j] != 0) { //i后面的j如果为0不需要替换
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        isReplaced = true;
                    }
                    //如果当前j循环中替换过，就结束当前循环
                    if (isReplaced)
                        break;
                }
            }
        }
        return nums;
    }

    //方法2：定义一个指针
    private static int[] moveZeros3(int[] nums) {
        //声明一个指针
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果当前值不为0，就将当前值赋值给指针
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        //将指针后面的数清零
        for (int j = p; j < nums.length; j++) {
            nums[j] = 0;
        }
        return nums;
    }
}
