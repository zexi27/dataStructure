package com.zlq.day280;

import com.zlq.common.ListNode;
import com.zlq.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/7 14:26
 */
/*

代码
测试用例
测试结果
测试结果
55. 跳跃游戏
中等
相关标签
相关企业
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。



示例 1：

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


提示：

1 <= nums.length <= 104
0 <= nums[i] <= 105

 */
public class Day273_CanJump {

	public static void main(String[] args) {
//		int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
//		System.out.println(canJump(nums));
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;

		node5.right = node6;

		TreeNode.printPreOrder(node1);
		System.out.println();
		flatten(node1);

		TreeNode.printPreOrder(node1);
	}

	// 贪心
	public static boolean canJump(int[] nums) {
		int reachable = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > reachable) {
				return false;
			}
			reachable = Math.max(reachable, i + nums[i]);
		}
		return true;
	}


	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		deFlatten(root);
	}

	public static void deFlatten(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}

		int val = (int) root.val;
		list.add(val);
		deFlatten(root.left, list);
		deFlatten(root.right, list);
	}


	public static void deFlatten(TreeNode root) {
		if (root == null) {
			return;
		}
		moveNode(root);
		deFlatten(root.left);
		deFlatten(root.right);

	}

	public static void moveNode(TreeNode node) {
		if (node.left != null) {
			if (node.right != null) {
				TreeNode tempNode = node.right;
				node.right = node.left;
				TreeNode rightNode = getRightNode(node.left);// 找到左子树的最右侧节点
				rightNode.right = tempNode;
			} else {
				node.right = node.left;
			}
			node.left = null;

		}
	}

	public static TreeNode getRightNode(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}
}
