package com.zlq.day130;

import com.zlq.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day123_SubRootToLeaf
 * @description:
 * @author: LiQun
 * @CreateDate:2022/5/30 21:56
 */
/*
给出一棵二叉树，其上每个结点的值都是0或1。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。

例如，如果路径为0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数01101，也就是13。
对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 */
public class Day123_SubRootToLeaf {
    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(0);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(0);
        TreeNode<Integer> node5 = new TreeNode<>(1);
        TreeNode<Integer> node6 = new TreeNode<>(0);
        TreeNode<Integer> node7 = new TreeNode<>(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        preOrder(node1);
        System.out.println(deep);
    }
    public static int deep = 0;
    public int sumRootToLeaf(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        return 0;
    }

    public static void preOrder(TreeNode root){
        if (root == null) {
            deep++;
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

}
