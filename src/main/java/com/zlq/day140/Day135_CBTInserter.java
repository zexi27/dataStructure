package com.zlq.day140;

import com.zlq.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day140
 * @ClassName: Day135_CBTInserter
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/25 10:17
 */
/*
完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。

设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。

实现 CBTInserter 类:

CBTInserter(TreeNode root)使用头节点为root的给定树初始化该数据结构；
CBTInserter.insert(int v) 向树中插入一个值为Node.val == val的新节点TreeNode。使树保持完全二叉树的状态，并返回插入节点TreeNode的父节点的值；
CBTInserter.get_root() 将返回树的头节点。


示例 1：


输入
["CBTInserter", "insert", "insert", "get_root"]
[[[1, 2]], [3], [4], []]
输出
[null, 1, 2, [1, 2, 3, 4]]

解释
CBTInserter cBTInserter = new CBTInserter([1, 2]);
cBTInserter.insert(3);  // 返回 1
cBTInserter.insert(4);  // 返回 2
cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 */
public class Day135_CBTInserter {
    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(1);
//        TreeNode<Integer> node2 = new TreeNode<>(2);
//        root.left = node2;
        Day135_CBTInserter cbtInserter = new Day135_CBTInserter(root);
        System.out.println(cbtInserter.insert(2));
//        System.out.println(cbtInserter.insert(4));

    }

    List<TreeNode> list = new ArrayList<>();
    int idx = 0;

    public Day135_CBTInserter(TreeNode root) {
        list.add(root);
        int cur = 0;
        while (cur < list.size()) {
            TreeNode node = list.get(cur);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            cur++;
        }
    }

    public int insert(int val) {
        TreeNode<Integer> node = new TreeNode<>(val);
        while (list.get(idx).left != null && list.get(idx).right != null) idx++;
        TreeNode curNode = list.get(idx);
        if (curNode.left == null) curNode.left = node;
        else if (curNode.right == null) curNode.right = node;
        list.add(node);
        return (int) curNode.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }
}
