package com.zlq.day60.Day50_Tree;

import com.zlq.common.TreeNode;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60.Day50_Tree
 * @ClassName: BalancedBinaryTree
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/3 10:07 上午
 */

// 判断平衡二叉树
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree();
//        System.out.println(isBalance(root));
        System.out.println(height(root));
    }


    /*
    求平衡二叉树要有求树高的方法
     */
    public static boolean isBalance(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) <= 1
                &&isBalance(root.left) &&isBalance(root.right)){
            return true;
        }
        return false;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
//        return Math.max( height(root.left), height(root.right) ) + 1;
        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        return Math.max(left, right);
    }
}
