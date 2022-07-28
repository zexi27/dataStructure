package com.zlq.day120;

import com.zlq.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day120
 * @ClassName: Day117_GetAllElement
 * @description:
 * @author: LiQun
 * @CreateDate:2022/5/1 14:53
 */
/*
给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.

示例 1：

输入：root1 = [2,1,4], root2 = [1,0,3]
输出：[0,1,1,2,3,4]
示例 2：

输入：root1 = [1,null,8], root2 = [8,1]
输出：[1,1,8,8]

 */
public class Day117_GetAllElement {

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(5);
        TreeNode<Integer> node3 = new TreeNode<>(8);
        TreeNode<Integer> node4 = new TreeNode<>(9);
        TreeNode<Integer> node5 = new TreeNode<>(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode<Integer> node6 = new TreeNode<>(3);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(1);
        TreeNode<Integer> node9 = new TreeNode<>(6);
        TreeNode<Integer> node10 = new TreeNode<>(2);
        node6.left = node7;
        node6.right = node8;
        node7.left = node9;
        node7.right = node10;
        getAllElements(node1,node6);
    }


    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list = new ArrayList<>();

        infixOrder(root1,list);
        infixOrder(root2,list);
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        List<Integer> res = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return res;
    }

    public static List<Integer> infixOrder(TreeNode root,List<Integer> list) {
        if (root == null) return list;
        list.add((Integer) root.val);
        infixOrder(root.left,list);
        infixOrder(root.right,list);
        return null;
    }
}
