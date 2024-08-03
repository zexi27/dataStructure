package com.zlq.day280;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@description:
 *@author: ZhangLiqun
 *@date: 2023/10/4 19:29
 */
/*
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
0 <= key, value <= 106
 */
public class MyHashMap {

	ListNode[] nodes = new ListNode[10000];

	public int get(int key) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);
		return prev.next == null ? -1 : prev.next.val;
	}

	public void put(int key, int value) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);

		if (prev.next == null) {
			prev.next = new ListNode(key, value);
		} else {
			prev.next.val = value;
		}
	}

	public void remove(int key) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);

		if (prev.next != null) {
			prev.next = prev.next.next;
		}
	}

	private int getIndex(int key) {
		return Integer.hashCode(key) % nodes.length;
	}

	private ListNode findElement(int index, int key) {
		if (nodes[index] == null) {
			return nodes[index] = new ListNode(-1, -1);
		}

		ListNode prev = nodes[index];

		while (prev.next != null && prev.next.key != key) {
			prev = prev.next;
		}
		return prev;
	}

	private static class ListNode {

		int key, val;
		ListNode next;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}