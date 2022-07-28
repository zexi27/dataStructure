package com.zlq.day100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: TreeNodeErgodic
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/12 9:41 上午
 */


public class Day95_TreeNodeErgodic {
    public static void main(String[] args) {

    }

    public static List<Integer> list = new ArrayList<>();

    public static List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return list;
    }


    public static List<Integer> postorder(Node root) {
        if (root == null) return list;
        for (Node child : root.children) {
            postorder(child);
        }
        list.add(root.val);
        return list;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
