package com.zlq.day250;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day243_MaxAncestorDiff
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/18 11:54
 */
/*
1026. Maximum Difference Between Node and Ancestor
中等
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Example 1:


Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
Example 2:


Input: root = [1,null,2,null,0,3]
Output: 3


Constraints:

The number of nodes in the tree is in the range [2, 5000].
0 <= Node.val <= 105
 */
public class Day243_MaxAncestorDiff {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node6.left = node9;
        node5.left = node7;
        node5.right = node8;
        Day243_MaxAncestorDiff maxAncestorDiff = new Day243_MaxAncestorDiff();
        System.out.println(maxAncestorDiff.maxAncestorDiff(node1));
    }

    Map<Integer, List<Integer>> map = new HashMap<>();

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }


    private static int dfs(TreeNode root, int min, int max) {
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        int a = dfs(root.left, min, max);
        int b = dfs(root.right, min, max);
        return Math.max(a, b);
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

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int length = books.length;
        int[] dp = new int[length + 1];
        for (int i = 0; i < length; i++) {
            dp[i + 1] = dp[i] + books[i][1]; // Step 2- 1: on the new layer
            int sum = 0, h = 0;
            for (int j = i; j >= 0; j--) {
                sum += books[j][0]; // try to put on current layer, rather than the new one
                if (sum > shelfWidth) // the sum of width exceeds the shift width, unable to squeeze
                {
                    break;
                } else // Step 2- 2: keep squeezing
                {
                    h = Math.max(h, books[j][1]); // get the tallest book for this layer
                    dp[i + 1] = Math.min(dp[j] + h, dp[i + 1]); // for i + 1 th book it can either be the next layer, or this layer(try the combination to make 'one layer' as short as possible)
                    // printf("sum %d booksj_h %d h %d j %d dp[j] %d i %d dp[i + 1] %d\n", sum, books[j][1], h, j, dp[j], i, dp[i + 1]);
                }
            }
            // print_dp(dp);
        }
        // print_dp(dp);
        return dp[length];
    }
}

