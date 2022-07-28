package com.zlq.common;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.common
 * @ClassName: TreeNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/2 10:25 上午
 */
public class TreeNode<T> {

    // 测试
    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    public static TreeNode buildTree(){
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

    public static void printPreOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + "\t");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(TreeNode root){
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + "\t");
        printInOrder(root.right);
    }

    public static void printPostOrder(TreeNode root){
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + "\t");
    }
}
