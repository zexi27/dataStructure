package com.zlq.Day300;

import com.zlq.common.TreeNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/4 13:47
 */
public class Day292_IsSubTree {

	public static void main(String[] args) {
		Integer[] rootArr = {3, 4, 5, 1, 2}, subRootArr = {4, 1, 2};
		TreeNode root = TreeNode.buildTree(rootArr);
		TreeNode subRoot = TreeNode.buildTree(subRootArr);

//		System.out.println(isSubtree(root, subRoot));
		System.out.println(isSubtree2(root, subRoot));

		String[] arr = {"d", "b", "c", "b", "c", "a"};
		int k = 2;
		System.out.println(kthDistinct(arr, k));

		char[] s = {'h', 'e', 'l', 'l', 'o'};
		System.out.println(Arrays.toString(s));
		reverseString(s);
		System.out.println(Arrays.toString(s));
		File[] files = new File[100];
		for (int i = 0; i < 100; i++) {
			files[i] = new File("/");
		}
		Arrays.sort(files);
	}

	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
		List<TreeNode> targetList = new ArrayList<>();
		findNode(targetList, root, subRoot);
		String subStr = preOrder(subRoot);
		for (TreeNode target : targetList) {
			String rootStr = preOrder(target);

			if (!rootStr.equals(subStr)) {
				return true;
			}
		}

		return false;
	}


	public static List<TreeNode> findNode(List<TreeNode> targetList, TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return targetList;
		}
		if (root.val == subRoot.val) {
			targetList.add(root);
		}
		findNode(targetList, root.left, subRoot);

		findNode(targetList, root.right, subRoot);
		return targetList;
	}

	public static String preOrder(TreeNode root) {
		StringBuilder resBuilder = new StringBuilder();
		preOrder(resBuilder, root);
		return resBuilder.toString();
	}

	private static void preOrder(StringBuilder resBuilder, TreeNode root) {
		if (root == null) {
			return;
		}
		preOrder(resBuilder, root.left);
		resBuilder.append(root.val);
		preOrder(resBuilder, root.right);
	}


	public static boolean isSubtree2(TreeNode root, TreeNode subRoot) {
		Map<TreeNode, Set<TreeNode>> rootMap = new HashMap<>();
		Map<TreeNode, Set<TreeNode>> subRootMap = new HashMap<>();

		generateMap(root, rootMap);

		generateMap(subRoot, subRootMap);

		for (Entry<TreeNode, Set<TreeNode>> entry : subRootMap.entrySet()) {
			TreeNode key = entry.getKey();
			if (!entry.getValue().equals(rootMap.get(key))) {
				return false;
			}
		}

		return true;
	}

	private static void generateMap(TreeNode root, Map<TreeNode, Set<TreeNode>> nodeMap) {
		if (root == null) {
			return;
		}
		nodeMap.putIfAbsent(root, new HashSet<>());
		if (root.left != null) {
			nodeMap.get(root).add(root.left);
		}
		if (root.right != null) {
			nodeMap.get(root).add(root.right);
		}
		generateMap(root.left, nodeMap);

		generateMap(root.right, nodeMap);
	}


	public static String kthDistinct(String[] arr, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String str : arr) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		int curCnt = 0, idx = 0;
		while (idx < arr.length) {
			if (map.get(arr[idx]) == 1) {
				curCnt++;
				if (curCnt == k) {
					return arr[idx];
				}
			}
			idx++;
		}
		return "";
	}


	public static void reverseString(char[] s) {

		reverse(s, 0, s.length - 1);
	}

	private static void reverse(char[] s, int start, int end) {
		if (start == s.length/2) {
			return;
		}
		char temp = s[end];
		s[end] = s[start];
		s[start] = temp;

		reverse(s, start + 1, end - 1);
	}


	public static int addedInteger(int[] nums1, int[] nums2) {
		int length = nums1.length;
		int sum1 = 0,sum2 = 0;
		for (int i = 0; i < length; i++) {
			sum1+=nums1[i];
			sum2+=nums2[i];
		}
		return (sum2 - sum1) /length;

	}
}
