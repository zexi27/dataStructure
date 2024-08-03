package com.zlq.day60.Day50_Tree;


import com.zlq.common.TreeNode;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60.Day50_Tree
 * @ClassName: ReverseTree
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/3 9:44 上午
 */
public class ReverseTree {

	public static void main(String[] args) {
//		TreeNode root = TreeNode.buildTree();
//		TreeNode.printPreOrder(root);
//		invertTree(root);
//		System.out.println();
//		TreeNode.printPreOrder(root);
		int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	public static int numTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int res = 0;
		for (int i = 1; i <= n; i++) {
			res += numTrees(i - 1) * numTrees(n - i);
		}
		return res;
	}

	public static int numTrees1(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				res[i] += res[j - 1] * res[i - j];
			}
		}
		return res[n];
	}


	public static void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		boolean[] rowArr = new boolean[rows];
		boolean[] columnArr = new boolean[columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == 0) {
					rowArr[i] = true;
					columnArr[j] = true;
				}
			}
		}
		int[] zeroArr = new int[columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (rowArr[i] == true || columnArr[j] == true) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
