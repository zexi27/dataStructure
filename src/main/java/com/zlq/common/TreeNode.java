package com.zlq.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.common
 * @ClassName: TreeNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/2 10:25 上午
 */
public class TreeNode<T> {

	public static void main(String[] args) {
		Integer[] eleArr = {1,2,3,4,5,6,7,9};
		TreeNode head = buildTree(eleArr);
		printPreOrder(head);
		System.out.println("树的高度：" + getTreeHeight(head));
	}

	// 测试
	public T val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(T val) {
		this.val = val;
	}

	public TreeNode(T val, TreeNode<T> cur, Object o) {

	}

//	@Override
//	public String toString() {
//		return "TreeNode{" +
//				"val=" + val +
//				", left=" + left +
//				", right=" + right +
//				'}';
//	}


	public static TreeNode buildTree() {
		TreeNode nodeA = new TreeNode("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		TreeNode nodeD = new TreeNode("D");
		TreeNode nodeE = new TreeNode("E");
		TreeNode nodeF = new TreeNode("F");
		TreeNode nodeG = new TreeNode("G");
		TreeNode node1 = new TreeNode("1");
		TreeNode node2 = new TreeNode("2");

		nodeA.left = nodeB;
		nodeA.right = nodeC;
		nodeB.left = nodeD;
		nodeB.right = nodeE;
		nodeC.left = nodeF;
		nodeC.right = nodeG;
		nodeD.left = node1;
		nodeD.right = node2;
		return nodeA;
	}

	public static void printPreOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + "\t");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	public static void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.val + "\t");
		printInOrder(root.right);
	}

	public static void printPostOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.val + "\t");
	}

	public static TreeNode buildTree(Integer[] eleArr) {
		int length = eleArr.length;
		if (length == 0) {
			return null;
		}
		Integer headEle = eleArr[0];
		if (headEle == -1) {
			return null;
		}
		// 获取头结点，并构建上一层节点列表
		TreeNode head = new TreeNode(headEle);
		List<TreeNode> lastTreeNodes = new ArrayList<>();
		lastTreeNodes.add(head);
		int l = 0, r, curNodeCnt = 2;
		while (l < length - 1) {
			// 生成当前层的所有节点
			List<TreeNode> treeNodes = new ArrayList<>();
			r = l + curNodeCnt > length - 1 ? length - 1 : l + curNodeCnt;
			int lastNodeCnt = 0;
			for (int i = l + 1; i <= r; i++) {
				Integer ele = eleArr[i];
				TreeNode treeNode;
				if (ele != null) {
					treeNode = new TreeNode<>(Integer.valueOf(ele));
					lastNodeCnt++;
				} else {
					treeNode = new TreeNode<>(null);
				}
				treeNodes.add(treeNode);
			}
			curNodeCnt = lastNodeCnt * 2;

			// 连接节点
			connectTreeNodes(lastTreeNodes, treeNodes);

			// 层级下移
			lastTreeNodes = treeNodes;
			treeNodes = new ArrayList<>();

			l = r;
		}

		return head;
	}

	private static void connectTreeNodes(List<TreeNode> lastTreeNodes, List<TreeNode> treeNodes) {
		int index = 0;
		for (TreeNode treeNode : lastTreeNodes) {
			if (treeNode.val != null) {
				TreeNode leftNode = treeNodes.get(index++);
				if (leftNode != null && leftNode.val != null) {
					treeNode.left = leftNode;
				}

				if (index > treeNodes.size() - 1) {
					break;
				}
				TreeNode rightNode = treeNodes.get(index++);
				if (rightNode != null && rightNode.val != null) {
					treeNode.right = rightNode;
				}
				if (index > treeNodes.size() - 1) {
					break;
				}
			}
		}
	}


	public static int getTreeHeight(TreeNode root){
		if (root == null){
			return 0;
		}

		int leftHeight = getTreeHeight(root.left) + 1;
		int rightHeight = getTreeHeight(root.right) + 1;
		return Math.max(leftHeight,rightHeight);

	}
}
