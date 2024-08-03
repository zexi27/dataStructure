package com.zlq.Day290;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/9 12:42
 */
/*
请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。



示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
 */
public class Day286_LRUCache {

	public static void main(String[] args) {
		Day286_LRUCache lruCache = new Day286_LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));

	}


	private Map<Integer, ListNode> cache = null;

	private ListNode head = null;

	private ListNode tail = null;

	private Integer capacity;

	private Integer size;


	public Day286_LRUCache(int capacity) {
		this.cache = new HashMap<>();
		this.head = new ListNode();
		this.tail = new ListNode();
		head.next = tail;
		tail.pre = head;
		this.capacity = capacity;
		this.size = 0;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			ListNode node = cache.get(key);
			removeNodeToHead(node);
			return node.value;
		} else {
			return -1;
		}
	}


	public void put(int key, int value) {
		ListNode node;
		if (!cache.containsKey(key)) {
			node = new ListNode(key, value);
			if (size >= capacity) {
				ListNode tail = removeTail();
				cache.remove(tail.getKey());
			}
			addHead(node);
			cache.put(key, node);
			size++;
		} else {
			node = cache.get(key);
			node.value = value;
			removeNodeToHead(node);
		}
	}

	public ListNode removeTail() {
		ListNode removed = tail.pre;
		removed.pre.next = removed.next;
		removed.next.pre = removed.pre;
		return removed;
	}

	public ListNode removeNode(ListNode removed) {
		removed.pre.next = removed.next;
		removed.next.pre = removed.pre;
		return removed;
	}

	public void addHead(ListNode node) {
		node.next = head.next;
		head.next.pre = node;

		head.next = node;
		node.pre = head;
	}

	public void moveTailToHead() {
		ListNode tailEle = removeTail();
		addHead(tailEle);
	}

	public void removeNodeToHead(Integer key) {
		ListNode node = cache.get(key);
		this.removeNodeToHead(node);
	}

	public void removeNodeToHead(ListNode node) {
		ListNode removed = removeNode(node);
		addHead(removed);
	}


}

class ListNode {

	Integer key;
	Integer value;
	ListNode pre;
	ListNode next;

	public ListNode() {
	}

	public ListNode(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public boolean hasNext(ListNode curNode) {
		if (curNode.next == null) {
			return false;
		}
		return true;
	}

}
