package com.zlq.Day290;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import com.zlq.common.TreeNode;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/19 12:59
 */
/*
You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.

Return the number of good leaf node pairs in the tree.



Example 1:


Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
Example 2:


Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
Example 3:

Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
Output: 1
Explanation: The only good pair is [2,5].


Constraints:

The number of nodes in the tree is in the range [1, 210].
1 <= Node.val <= 100
1 <= distance <= 10
 */
public class Day281_GoodLeafNodePairs {

	public static void main(String[] args) {
		Integer[] nodeELE = {15,38,49,75,52,75,79,43,80,72,55,89,46,14,null,14,22,43,80,91,35,86,null,55,22,71,null,11,89,74,93,42,83,19,97,45,null,53,96,null,null,null,null,22,67,11,null,53,null,69,null,null,null,16,9,56,58,22,50,18,null,47,91,92,21,25,null,98,100,93,63,21,20,43,null,null,null,67,null,91,null,13,20,81,32,32,28,10,null,63,41,63,null,65,null,3,68,70,55,21,91,null,null,null,null,54,65,81,null,25,null,null,null,36,null,68,null,null,30,45,null,null,null,69,100,25,95,97,75,48,null,53,52,null,null,13,null,3,42,25,null,null,71,47,71,39,28,56,null,94,null,null,null,44,null,null,null,21,55,21,62,43,null,null,null,68,82,null,null,null,null,null,null,7,48,23,45,33,75,7,null,83,10,49,null,null,null,45,94,13,null,null,null,94,null,51,null,null,null,null,null,1,null,11,null,7,70,null,null,null,null,42,null,24,null,14,34,15,null,null,22,null,null,12,null,35,70,null,null,30,55,45,70,77,null,85,null,57,43,null,98,80,null,69,48,55,null,85,null,79,null,40,null,76,null,29,20,75,null,null,null,null,null,51,null,null,null,null,null,null,null,96,66,null,null,null,null,null,null,null,null,32,null,11,null,11,100,37,35,4,15,92,null,47,9,58,36,83,null,null,null,null,null,null,null,17,92,8,null,55,null,77,null,25,30,31,null,null,null,76,null,24,null,37,null,49,92,36,19,null,null,26,26,null,null,83,84,33,null,44,12,41,37,20,40,31,null,9,null,66,null,56,null,null,null,null,null,12,45,85,80,29,null,null,null,null,null,5,null,58,null,null,null,null,null,97,null,null,null,null,null,47,78,null,null,6,58,null,69,73,61,null,null,37,46,94,null,1,null,47,10,88,null,65,null,null,null,89,48,99,null,44,40,null,null,96,null,null,null,16,99,64,null,88,null,null,null,17,86,null,60,80,47,72,null,38,null,null,null,56,18,88,null,null,null,75,null,null,null,38,94,31,5,3,94,69,null,65,11,null,null,null,null,null,null,72,82,null,null,26,null,null,null,null,null,22,null,70,87,null,null,null,null,59,64,null,null,null,null,null,null,82,100,87,null,57,7,94,null,50,96,20,null,null,null,16,null,85,9,24,74,7,9,null,null,92,null,64,null,95,null,100,7,null,null,21,null,null,null,null,null,76,43,96,95,61,null,76,9,72,null,69,100,null,75,null,null,12,null,null,null,43,null,81,null,null,null,null,null,null,null,82,92,1,38,54,58,null,null,93,47,null,null,5,null,null,null,100,null,97,null,null,null,84,54,5,null,null,null,74,35,72,2,4,null,32,21,null,null,21,null,98,null,null,null,null,null,null,null,26,null,60,null,22,2,86,null,35,30,null,null,10,36,null,null,65,81,99,null,27,null,92,null,83,null,19,null,88,null,66,95,29,82,null,null,15,null,null,null,null,null,39,null,null,null,37,null,25,null,73,null,76,null,69,28,14,2,13,null,95,null,null,null,62,null,61,null,80,null,null,62,null,null,19,null,5,null,47,null,21,null,null,null,23,null,null,null,72,95,null,null,70,63,57,null,null,null,38,null,null,null,86,null,45,22,89,null,18,null,null,null,58,7,17,null,40,null,null,null,29,null,null,null,81,null,null,null,null,null,51,null,null,null,52,null,null,null,null,null,null,null,84,null,73,null,null,null,99,40,78,null,81,null,50,11,25,null,null,null,91,null,57,null,null,68,null,null,68,null,null,null,39,null,17,45,20,20,42,null,95,null,77,null,null,null,null,null,14,null,null,null,23,null,null,null,null,null,31,null,null,null,null,null,43,90,21,null,79,null,76,null,15,null,72,null,94,null,null,null,75,8,null,44,null,null,39,null,53,null,null,null,null,null,null,null,18,68,50,null,null,null,null,null,null,null,88,null,5,null,89,null,84,74,24,null,null,null,41,76,91,null,null,null,46,52,57,null,62,13,76,7,84,null,null,null,null,null,null,null,56,82,33,null,null,null,74,1,null,null,55,null,99,null,null,null,null,null,83,72,16,74,null,null,35,75,71,null,73,null,null,null,null,null,null,35};
		com.zlq.common.TreeNode root = TreeNode.buildTree(nodeELE);

		System.out.println(countPairs(root, 3));

	}

	public static int countPairs(TreeNode root, int distance) {

		Map<TreeNode, Map<TreeNode, Integer>> nodeToLeafDistances = new HashMap<>();
		populateDistanceMap(nodeToLeafDistances, root);

		List<TreeNode> leaves = new ArrayList<>();
		getLeaves(root, leaves);

		int res = 0;
		Set<String> calcuSet = new HashSet<>();
		for (TreeNode startLeaf : leaves) {
			for (TreeNode endLeaf : leaves) {
				if (startLeaf == endLeaf) {
					continue;
				}
				if (calcuSet.contains(startLeaf + "-" + endLeaf) &&calcuSet.contains(endLeaf + "-" + startLeaf) ) {
					continue;
				}
				calcuSet.add(startLeaf + "-" + endLeaf);
				calcuSet.add(endLeaf + "-" + startLeaf);

				int dis = getTwoNodesDistance(nodeToLeafDistances, startLeaf, endLeaf);
				if (dis <=distance){
					res++;
				}
			}
		}

		return res;
	}

	private static int getTwoNodesDistance(Map<TreeNode, Map<TreeNode, Integer>> nodeToLeafDistances,
			TreeNode startLeaf, TreeNode endLeaf) {
		int minDistance = Integer.MAX_VALUE;
		for (Map.Entry<TreeNode, Map<TreeNode, Integer>> entry : nodeToLeafDistances.entrySet()) {
			Map<TreeNode, Integer> leafDistances = entry.getValue();
			if (leafDistances.containsKey(startLeaf) && leafDistances.containsKey(endLeaf)) {
				minDistance = Integer.min(leafDistances.get(startLeaf) + leafDistances.get(endLeaf), minDistance);
			}
		}
		return minDistance;
	}

	public static void populateDistanceMap(Map<TreeNode, Map<TreeNode, Integer>> nodeToLeafDistances, TreeNode node) {
		if (node == null) {
			return;
		}

		Map<TreeNode, Integer> leafDistances = new HashMap<>();
		getLeafDistances(leafDistances, 0, node);
		nodeToLeafDistances.put(node, leafDistances);

		populateDistanceMap(nodeToLeafDistances, node.left);
		populateDistanceMap(nodeToLeafDistances, node.right);

	}

	private static void getLeafDistances(Map<TreeNode, Integer> leafDistances, int distance, TreeNode node) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			leafDistances.put(node, distance);
		}

		getLeafDistances(leafDistances, distance + 1, node.left);
		getLeafDistances(leafDistances, distance + 1, node.right);
	}


	private static void getLeaves(TreeNode node, List<TreeNode> leaves) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			leaves.add(node);
			return;
		}

		getLeaves(node.left, leaves);
		getLeaves(node.right, leaves);
	}

}
