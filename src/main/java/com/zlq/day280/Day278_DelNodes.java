package com.zlq.day280;

import com.zlq.common.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.w3c.dom.NodeList;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/18 11:18
 */
/*
1110. Delete Nodes And Return Forest
Medium

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.



Example 1:


Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]


Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
 */
public class Day278_DelNodes {

	public static void main(String[] args) {
		Integer[] eleArr = {1,2,null,4,3};
		TreeNode headNode = TreeNode.buildTree(eleArr);
		int[] to_delete = {2,3};
		List<TreeNode> treeNodes = delNodes(headNode, to_delete);
		System.out.println(treeNodes);
	}

	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> resList = new ArrayList<>();
		Set<Integer> toDeleteSet = new HashSet<>();
		for (int deleteEle : to_delete) {
			toDeleteSet.add(deleteEle);
		}
		TreeNode node = deleteNode(resList, root, toDeleteSet);
		if (node != null){
			resList.add(node);
		}
		return resList;

	}

	public static TreeNode deleteNode(List<TreeNode> nodeList, TreeNode node, Set<Integer> deleteSet) {
		if (node == null) {
			return null;
		}

		node.left = deleteNode(nodeList,node.left,deleteSet);
		node.right = deleteNode(nodeList,node.right,deleteSet);

		if (deleteSet.contains(node.val)){
			if (node.left != null) {
				nodeList.add(node.left);
			}
			if (node.right != null) {
				nodeList.add(node.right);
			}
			return null;
		}
		return node;
	}


}
