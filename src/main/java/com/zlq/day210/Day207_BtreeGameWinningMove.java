package com.zlq.day210;


/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day207_BtreeGameWinningMove
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/3 11:35
 */
/*
1145. 二叉树着色游戏
有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。

最开始时：

「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。

之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「一号」玩家染红色，「二号」玩家染蓝色）。

如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。

若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。

现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true ；若无法获胜，就请返回 false 。

示例 1 ：

输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
输出：true
解释：第二个玩家可以选择值为 2 的节点。
示例 2 ：

输入：root = [1,2,3], n = 3, x = 1
输出：false

提示：

树中节点数目为 n
1 <= x <= n <= 100
n 是奇数
1 <= Node.val <= n
树中所有值 互不相同
 */
public class Day207_BtreeGameWinningMove {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(evaluateTree(node1));
    }

    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        find(root, x);
        int leftTreeSize = getTreeSize(curNode.left);
        if (leftTreeSize >= (n + 1) / 2) return true;
        int rightTreeSize = getTreeSize(curNode.right);
        if (rightTreeSize >= (n + 1) / 2) return true;
        int remain = n - 1 - leftTreeSize - rightTreeSize;
        return remain >= (n + 1) / 2;

    }

    //    public static int sum = 0;
    public static TreeNode curNode = null;

    public static int getTreeSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + getTreeSize(root.left) + getTreeSize(root.right);
    }

    /**
     * @param node
     * @param x
     */
    public static void find(TreeNode node, int x) {
        if (curNode != null || node == null) return;
        if (node.val == x) {
            curNode = node;
            return;
        }
        find(node.left, x);
        find(node.right, x);
    }


    public static boolean evaluateTree(TreeNode root) {
        if (root.left == null) return root.val == 1 ;
        if (root.val == 2) {
            return evaluateTree(root.left) | evaluateTree(root.right);
        }else {
            return evaluateTree(root.left) & evaluateTree(root.right);
        }
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
}
