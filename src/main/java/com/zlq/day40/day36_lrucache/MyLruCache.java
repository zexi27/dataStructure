package com.zlq.day40.day36_lrucache;


import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40.day36_lrucache
 * @ClassName: MyLruCache
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/9 10:00 上午
 */
/*
/*运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制。
        实现 LRUCache 类：
        LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
        int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
        void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

        进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 */
public class MyLruCache {
    public static void main(String[] args) {
        MyLruCache lruCache = new MyLruCache(3, true);
        lruCache.put("k1", "v1");
        lruCache.put("k2", "v2");
        lruCache.put("k3", "v3");
        lruCache.print();
        lruCache.put("k4", "v4");
        lruCache.print();
        lruCache.put("k2", "v8");
        lruCache.print();
        System.out.println(lruCache.get("k4").value);
        lruCache.print();
    }

    private int capacity;
    private int size;
    private boolean accessOrder;
    public Node head;
    public Node tail;

    private Map<String, Node> map = new HashMap<>(capacity);

    public MyLruCache(int capacity, boolean accessOrder) {
        this.capacity = capacity;
        this.accessOrder = accessOrder;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public MyLruCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }


    public void put(String key, String value) {
        Node node = this.get(key);
        if (null != node) { // 如果想要放置的key已存在，改变其值，并将其置为末尾
            node.value = value;
            this.moveToTail(node);
        } else { //  key如果不存在，就放在最后,若放置后超出容量，则去掉头结点
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            this.addToTail(newNode);
            size++;
            if (size > capacity) {
                String removeKey = this.removeHead();
                map.remove(removeKey);
                size--;
            }
        }
    }


    public Node get(String key) {
        if (accessOrder) { // 获取节点之后,将节点移到末尾
            Node node = map.get(key);
            if (null != node) {
                this.moveToTail(node);
                return node;
            } else {
                return null;
            }
        } else {
            return map.getOrDefault(key, null);
        }
    }

    private void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }


    public void addToTail(Node node) {
        node.next = tail; // node插在tail前面，tail是哑结点
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private String removeHead() {
        Node node = removeNode(head.next);
        return node.key;
    }

    private Node removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public void print() {
        Node curNode = head.next;
        while (curNode != null) {
            System.out.print(curNode.value + "->");
            curNode = curNode.next;
        }
        System.out.println();
    }
}
