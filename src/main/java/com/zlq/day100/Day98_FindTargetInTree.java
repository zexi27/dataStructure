package com.zlq.day100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day98_FindTargetInTree
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/21 10:08 下午
 */
public class Day98_FindTargetInTree {
    public static void main(String[] args) {
    }

    List<Integer> list = new ArrayList<>();

    Set<Integer> set = new HashSet<>();

    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget1(root.left, k) || findTarget1(root.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        addInList(root);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i != j && list.get(i) + list.get(j) == k) return true;
            }
        }
        return false;
    }

    public void addInList(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        addInList(root.left);
        addInList(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
