package com.zlq.day60;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day54_KindsOfBinarySearchTree
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/22 10:01 上午
 */
public class Day54_KindsOfBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        if (n == 1 || n == 0)
            return 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + numTrees(i) * numTrees(n - i - 1);
        }
        return sum;
    }
}
