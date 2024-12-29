package com.zlq.day310;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/9/28 11:41
 */
/*
641. Design Circular Deque
Medium
Topics
Companies
Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.


Example 1:

Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4


Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.

 */
public class Day303_MyCircularDeque {

	public static void main(String[] args) {
		int[] tickets = {2, 3, 2};
		int k = 2;
		System.out.println(timeRequiredToBuy(tickets, k));
	}

	private static Deque<Integer> deque;
	private static int size;

	public Day303_MyCircularDeque(int k) {
		deque = new ArrayDeque(k);
		this.size = k;
	}

	public boolean insertFront(int value) {
		if (deque.size() >= size) {
			return false;
		}
		deque.addFirst(value);
		return true;
	}

	public boolean insertLast(int value) {
		if (deque.size() >= size) {
			return false;
		}
		deque.addLast(value);
		return true;
	}

	public boolean deleteFront() {
		if (deque.isEmpty()) {
			return false;
		}
		deque.removeFirst();
		return true;
	}

	public boolean deleteLast() {
		if (deque.isEmpty()) {
			return false;
		}
		deque.removeLast();
		return true;
	}

	public int getFront() {
		if (deque.isEmpty()) {
			return -1;
		}
		return deque.getFirst();
	}

	public int getRear() {
		if (deque.isEmpty()) {
			return -1;
		}
		return deque.getLast();
	}

	public boolean isEmpty() {
		return deque.isEmpty();
	}

	public boolean isFull() {
		return deque.size() == size;
	}

	/*
	2073. 买票需要的时间
	有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。

	给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。

	每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。

	返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。



	示例 1：

	输入：tickets = [2,3,2], k = 2
	输出：6
	解释：

	队伍一开始为 [2,3,2]，第 k 个人以下划线标识。
	在最前面的人买完票后，队伍在第 1 秒变成 [3,2,1]。
	继续这个过程，队伍在第 2 秒变为[2,1,2]。
	继续这个过程，队伍在第 3 秒变为[1,2,1]。
	继续这个过程，队伍在第 4 秒变为[2,1]。
	继续这个过程，队伍在第 5 秒变为[1,1]。
	继续这个过程，队伍在第 6 秒变为[1]。第 k 个人完成买票，所以返回 6。

	示例 2：

	输入：tickets = [5,1,1,1], k = 0
	输出：8
	解释：
	队伍一开始为 [5,1,1,1]，第 k 个人以下划线标识。
	在最前面的人买完票后，队伍在第 1 秒变成 [1,1,1,4]。
	继续这个过程 3 秒，队伍在第 4 秒变为[4]。
	继续这个过程 4 秒，队伍在第 8 秒变为[]。第 k 个人完成买票，所以返回 8。


	提示：

	n == tickets.length
	1 <= n <= 100
	1 <= tickets[i] <= 100
	0 <= k < n
	 */

	public static int timeRequiredToBuy(int[] tickets, int k) {
		Map<Integer, Node> map = new HashMap<>();
		ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
		for (int i = 0; i < tickets.length; i++) {
			map.put(i, new Node(i, tickets[i]));
			arrayDeque.offerLast(new Node(i, tickets[i]));
		}

		int res = 0;
		while (map.get(k)!= null) {
			Node first = arrayDeque.pollFirst();
			Integer no = first.getNo();
			Integer remain = first.getRemain();
			if (remain > 1) {
				Node newNode = new Node(no, first.getRemain() - 1);
				arrayDeque.offerLast(newNode);
				map.put(no, newNode);
			}else {
				map.remove(no);
			}
			res++;
		}

		return res;

	}
}

class Node {

	private Integer no;
	private Integer remain;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getRemain() {
		return remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	public Node(Integer no, Integer remain) {
		this.no = no;
		this.remain = remain;
	}
}