package com.zlq.day130;

import com.zlq.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day130
 * @ClassName: Day127_FindFrequentTreeSum
 * @description:
 * @author: LiQun
 * @CreateDate:2022/6/19 13:19
 */
/*
Given the root of a binary tree, return the most frequent subtree sum.
If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values
formed by the subtree rooted at that node (including the node itself).

Example 1:
Input: root = [5,2,-3]
Output: [2,-3,4]
Example 2:

Input: root = [5,2,-5]
Output: [2]
 */
public class Day127_FindFrequentTreeSum {

    public static void main(String[] args) {
        
    }


    Map<Integer,Integer> map = new HashMap<>();
    int max = 0;
    public static int[] findFrequentTreeSum(TreeNode root) {
        return null;
    }

    public int dfs(TreeNode<Integer> root) {
        if (root == null) return 0;
        int cur = root.val + dfs(root.left) + dfs(root.right);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        max = Math.max(max, map.get(cur));
        return cur;
    }
}
