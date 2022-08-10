package com.zlq.day140;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day140
 * @ClassName: Day137_CopyComplicatedLinkedList
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/31 10:09
 */
public class Day137_CopyComplicatedLinkedList {

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        printComplicatedLinkedList(node7);
        Node newHead = copyRandomList(node7);
        printComplicatedLinkedList(newHead);
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Integer> nodeMap = putNodeIntoLinkedMap(head);
        List<Node> newNodeList = new ArrayList<>();
        Iterator<Node> iterator = nodeMap.keySet().iterator();
        Node newHead = new Node(iterator.next().val);
        Node curNode = newHead;
        newNodeList.add(newHead);
        while (iterator.hasNext()) {  // 将copy的list互相连接
            Node node = iterator.next();
            newNodeList.add(new Node(node.val));
            curNode.next = node;
            curNode = node;
        }
        curNode = newHead;
        Iterator<Node> iterator1 = nodeMap.keySet().iterator();
        while (curNode != null) {
            Integer index = nodeMap.get(curNode);
            curNode.random = index == null ? null : newNodeList.get(index);
            curNode = curNode.next;
        }
        return newHead;
    }

    public static Map<Node, Integer> putNodeIntoLinkedMap(Node head) {
        // 使用linkedHashmap存放节点数据 key: node的value值，value：下一个node的索引值
        Map<Node, Integer> map = new LinkedHashMap();
        int index = 0;
        Node curNode = head;
        while (curNode != null) {
            map.put(curNode, index++);
            curNode = curNode.next;
        }
        curNode = head;
        Map<Node, Integer> nodeMap = new LinkedHashMap();
        while (curNode != null) {
            nodeMap.put(curNode, map.get(curNode.random));
            curNode = curNode.next;
        }
        return nodeMap;
    }

    public static void printComplicatedLinkedList(Node head) {
        while (head != null) {
            List<Object> list = new ArrayList<>();
            list.add(head.val);
            list.add(head.random == null ? null : head.random.val);
            System.out.print(list);
            head = head.next;
        }
        System.out.println();
    }



    static Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public static Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList1(head.next);
            headNew.random = copyRandomList1(head.random);
        }
        return cachedNode.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
