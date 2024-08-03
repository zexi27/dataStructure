package com.zlq.Day290;

import com.zlq.common.TreeNode;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/25 17:01
 */

/*
1038. Binary Search Tree to Greater Sum Tree
medium
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
Example 2:

Input: root = [0,null,1]
Output: [1,null,1]


Constraints:

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val <= 100
All the values in the tree are unique.
 */
public class Day288_Bst_toGst {


	public static void main(String[] args) {
		TreeNode<Integer> n5 = new TreeNode<>(5);
		TreeNode<Integer> n3 = new TreeNode<>(3);
		TreeNode<Integer> n7 = new TreeNode<>(7);
		TreeNode<Integer> n2 = new TreeNode<>(2);
		TreeNode<Integer> n4 = new TreeNode<>(4);

		TreeNode<Integer> n12 = new TreeNode<>(12);
		TreeNode<Integer> n9 = new TreeNode<>(9);
		TreeNode<Integer> n15 = new TreeNode<>(15);
		TreeNode<Integer> n19 = new TreeNode<>(19);

		n5.left = n3;
		n5.right = n7;
		n3.left = n2;
		n3.right = n4;
		n7.right = n12;
		n12.left = n9;
		n12.right = n15;
		n15.right = n19;


		TreeNode.printInOrder(bstToGst(n5));

	}

	public static TreeNode bstToGst(TreeNode root) {
		int[] nodeSum = new int[1];
		helper(root, nodeSum);
		return root;
	}

	public static void helper(TreeNode root, int[] nodeSum) {
		if (root == null) {
			return;
		}
		helper(root.right, nodeSum);
		nodeSum[0] += (int) root.val;
		root.val = nodeSum[0];
		helper(root.left, nodeSum);
	}

}
