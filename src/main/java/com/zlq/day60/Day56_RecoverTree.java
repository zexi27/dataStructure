package com.zlq.day60;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.zlq.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: Day56_RecoverTree
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/24 10:47 上午
 */
/*
给你'的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。

进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 */
public class Day56_RecoverTree {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode<Integer> head = buildTree();
//        System.out.println(isValidBST(head));
//        System.out.println(list);
        System.out.println("=================+++");
        recoverTree(head);
        System.out.println(isValidBST(head));
        System.out.println(list);

    }

    public static void recoverTree(TreeNode root) {
        InfixOrder(root);
    }

    public static void InfixOrder(TreeNode root) {
        if (root == null) return;
        InfixOrder(root.left);
        if (null != root.left && (int) root.left.val > (int) root.val) swap(root.left, root);
        if (null != root.right && (int) root.right.val < (int) root.val) swap(root.right, root);
        InfixOrder(root.right);
    }

    private static void swap(TreeNode leftOrRight, TreeNode root) {
        int temp = (int) root.val;
        root.val = leftOrRight.val;
        leftOrRight.val = temp;
    }


    public static boolean isValidBST(TreeNode root) {
        addInListInfixOrder(root);
        if (list.size() == 0 || list.size() == 1) return true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) < list.get(i)) return false;
        }
        return true;
    }


    public static void addInListInfixOrder(TreeNode root) {
        if (root == null) return;
        addInListInfixOrder(root.left);
        if (root.val != null) list.add((Integer) root.val);
        addInListInfixOrder(root.right);
    }

    public static TreeNode<Integer> buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(null);
        TreeNode n5 = new TreeNode(null);
        n1.left = n3;
        n3.right = n2;
        return n1;
    }
}
