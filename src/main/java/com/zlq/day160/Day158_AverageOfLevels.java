package com.zlq.day160;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day160
 * @ClassName: Day158_AverageOfLevels
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/3 10:29
 */
/*
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.
Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
Example 2:

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 */
public class Day158_AverageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root); // root加入deque
        while (!deque.isEmpty()) {
            double currentSum = 0;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                currentSum += node.val;
                if (node.left != null){
                    deque.addLast(node.left);
                }
                if (node.right != null){
                    deque.addLast(node.right);
                }
            }
            resList.add(currentSum/size);
        }
        return resList;
    }

    public static void dfs(TreeNode node, int level) {
        if (node == null) return;
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
}
