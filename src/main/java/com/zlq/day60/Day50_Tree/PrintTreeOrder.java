package com.zlq.day60.Day50_Tree;

import com.zlq.common.TreeNode;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.Day60.Day50_Tree
 * @ClassName: PrintTreeOrder
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/2 10:27 上午
 */
public class PrintTreeOrder {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree();
        System.out.println("前序遍历：");
        TreeNode.printPreOrder(root);
        System.out.println();
        System.out.println("=========================");
        System.out.println("中序遍历：");
        TreeNode.printInOrder(root);
        System.out.println();
        System.out.println("=========================");
        System.out.println("后序遍历");
        TreeNode.printPostOrder(root);
    }


}
