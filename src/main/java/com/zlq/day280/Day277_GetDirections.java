package com.zlq.day280;

import com.zlq.common.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/16 13:48
 */
/*
2096. Step-By-Step Directions From a Binary Tree Node to Another
Medium
Topics
Companies
Hint
You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n.
 You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t.
Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'.
 Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.


Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.


Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue

 */
public class Day277_GetDirections {

	public static void main(String[] args) {
		Integer[] eleArr = {1,null,10,12,13,4,6,null,15,null,null,5,11,null,2,14,7,null,8,null,null,null,9,3};

		TreeNode headNode = TreeNode.buildTree(eleArr);
		System.out.println(getDirections(headNode, 6, 15));
	}

	public static String getDirections(TreeNode root, int startValue, int destValue) {
		List<String> rootToStart = new ArrayList<>();
		List<String> rootToDest = new ArrayList<>();


		findPath(rootToStart, root, startValue);
		findPath(rootToDest, root, destValue);
		StringBuilder resBuilder = new StringBuilder();

		removeDuplicate(rootToStart,rootToDest);
		for (int i = rootToStart.size() - 1; i >= 0; i--) {
			resBuilder.append("U");
		}

		for (int i = 0; i < rootToDest.size(); i++) {
			resBuilder.append(rootToDest.get(i));
		}
		return resBuilder.toString();
	}


	private static void removeDuplicate(List<String> rootToStart, List<String> rootToDest) {
		while (!rootToStart.isEmpty() && !rootToDest.isEmpty() && rootToStart.get(0).equals(rootToDest.get(0))){
			rootToStart.remove(0);
			rootToDest.remove(0);
		}
	}


	private static boolean findPath(List<String> pathList, TreeNode curNode, int destVal){
		if (curNode == null ) {
			return false;
		}
		if ((int)curNode.val == destVal) { // base case
			return true;
		}
		pathList.add("L");
		if (findPath(pathList,curNode.left,destVal)){
			return true;
		}

		pathList.remove(pathList.size() - 1);
		pathList.add("R");
		if (findPath(pathList,curNode.right,destVal)){
			return true;
		}
		pathList.remove(pathList.size() - 1);
		return false;
	}

}
