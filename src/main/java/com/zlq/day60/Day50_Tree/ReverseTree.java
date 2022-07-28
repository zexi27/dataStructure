package com.zlq.day60.Day50_Tree;


import com.zlq.common.TreeNode;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60.Day50_Tree
 * @ClassName: ReverseTree
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/3 9:44 上午
 */
public class ReverseTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree();
        TreeNode.printPreOrder(root);
        invertTree(root);
        System.out.println();
        TreeNode.printPreOrder(root);

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
