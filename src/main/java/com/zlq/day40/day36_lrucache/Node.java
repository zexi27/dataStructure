package com.zlq.day40.day36_lrucache;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40.day36_lrucache
 * @ClassName: Node
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/9 10:31 上午
 */
public class Node {

    String key, value;
    Node next,prev;

    public Node() {
    }

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public  static void print(Node head) {
        while (head != null){
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
}
