package com.zlq.day170;

import java.net.URI;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day165_MyLinkedList
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/23 14:27
 */
/*
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 */
public class Day165_MyLinkedList {
    /*
["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
[[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]
     */
    public static void main(String[] args) {
        Day165_MyLinkedList myLinkedList = new Day165_MyLinkedList();

        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        System.out.println(myLinkedList.get(5));
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);




    }

    Node head = null;

    public int get(int index) {
        Node curNode = head;
        if (curNode == null) return -1;
        for (int i = 0; i < index; i++) {
            if (curNode.next != null) curNode = curNode.next;
            else return -1;
        }
        return curNode.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = node;
    }

    /*
    void addAtIndex(int index, int val)
    Add a node of value val before the indexth node in the linked list.
    If index equals the length of the linked list, the node will be appended to the end of the linked list.
    If index is greater than the length, the node will not be inserted.

     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        Node curNode = head;
        for (int i = 0; i < index - 1; i++) {
            curNode = curNode.next;
        }
        if (curNode == null) {
            return;
        }
        if (curNode.next == null) {
            addAtTail(val);
            return;
        } else {
            Node node = new Node(val);
            node.next = curNode.next;
            curNode.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head.next != null) head = head.next;
            else head = null;
            return;
        }
        Node curNode = head;
        for (int i = 0; i < index - 1; i++) {
            curNode = curNode.next;
            if (curNode == null) return;
        }
        if (curNode.next == null ) return;
        if (curNode.next.next == null) {
            curNode.next = null;
        } else {
            curNode.next = curNode.next.next;
        }
    }

    public void print(Node head) {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + "\t");
            curNode = curNode.next;
        }
        System.out.println();
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
