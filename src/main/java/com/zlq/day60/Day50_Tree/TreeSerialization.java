package com.zlq.day60.Day50_Tree;

import com.zlq.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60.Day50_Tree
 * @ClassName: TreeSerialization
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/2 10:49 上午
 */
public class TreeSerialization {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree();
        String serialize = serialize(root);
        LinkedList dataList = handleSerialize(serialize);
        System.out.println(dataList);
        TreeNode treeNode = deSerialize(dataList);
        System.out.println(treeNode);
    }


    public static void preSerialize(TreeNode root, StringBuilder data) {
        if (root == null) {
            data.append("null,");
            return;
        }
        data.append(root.val + ",");
        preSerialize(root.left, data);
        preSerialize(root.right, data);
    }

    public static String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        data.append("[");
        preSerialize(root, data);
        data.deleteCharAt(data.length() - 1);
        data.append("]");
        return data.toString();
    }


    // 处理序列化结果
    public static LinkedList handleSerialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> dataList = new LinkedList<>(Arrays.asList(split));
        String first = dataList.getFirst().substring(1);
        dataList.removeFirst();
        dataList.addFirst(first);
        String last = dataList.getLast().substring(0, dataList.getLast().length() - 1);
        dataList.removeLast();
        dataList.add(last);
        System.out.println(dataList);
        return dataList;
    }

    public static TreeNode deSerialize(LinkedList dataList) {
        if (dataList.getFirst().equals("null")) {
            dataList.removeFirst();
            return null;
        }
        TreeNode treeNode = new TreeNode(String.valueOf(dataList.getFirst()));
        dataList.removeFirst();
        treeNode.left = deSerialize(dataList);
        treeNode.right = deSerialize(dataList);
        return treeNode;
    }

}
