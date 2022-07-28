package com.zlq.huawei;

import java.util.Scanner;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: RemoveSpecificedNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/12 4:19 下午
 */
/*
输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
链表的值不能重复。

构造过程，例如输入一行数据为:
6 2 1 2 3 2 5 1 4 5 7 2 2
则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
1 2 表示为
2->1
链表为2->1

3 2表示为
2->3
链表为2->3->1

5 1表示为
1->5
链表为2->3->1->5

4 5表示为
5->4
链表为2->3->1->5->4

7 2表示为
2->7
链表为2->7->3->1->5->4

最后的链表的顺序为 2 7 3 1 5 4

最后一个参数为2，表示要删掉节点为2的值
删除 结点 2

则结果为 7 3 1 5 4

链表长度不大于1000，每个节点的值不大于10000。
测试用例保证输入合法


输入描述：
输入一行，有以下4个部分：
1 输入链表结点个数
2 输入头结点的值
3 按照格式插入各个结点
4 输入要删除的结点的值

输出描述：
输出一行
输出删除结点后的序列，每个数后都要加空格
 */
public class RemoveSpecifiedNode {
    public static void main(String[] args) {
//        6 2 1 2 3 2 5 1 4 5 7 2 2
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node newHead = null;
        while (sc.hasNext()) {
            int countOfNode = sc.nextInt(); // 节点数量
            int count = 0;
            head = new Node(sc.nextInt());// 设置头结点
            for (int i = 0; i < (countOfNode - 1); i++) {
                findAndAddNode(head, sc.nextInt(), sc.nextInt());
                count++;
            }
             newHead = deleteNode(head, sc.nextInt());
            count++;
            if (count == countOfNode) break;
        }
        printLinkList(newHead);

    }

    /**
     * 将指定的数插入指定的节点后
     *
     * @param head
     * @param findVal
     * @param addVal
     */
    public static void findAndAddNode(Node head, int addVal, int findVal) {
        while (head != null) {
            if (head.value == findVal) {
                Node addNode = new Node(addVal);
                addNode.next = head.next;
                head.next = addNode;
            }
            head = head.next;
        }
    }

    public static Node deleteNode(Node head, int deleteVal) {
        // 设置一个哨兵节点
        Node sentinel = new Node(0);
        // 哨兵节点连接头结点
        sentinel.next = head;
        // 设置当前指针
        Node curNode = sentinel;
        while (curNode != null) {
            if (deleteVal == curNode.next.value) {
                curNode.next = curNode.next.next;
                break;
            }
            curNode = curNode.next;
        }
        return sentinel.next;

    }

    public static void printLinkList(Node head) {
        while (head != null) {
//            if (head.next != null) System.out.print(head.value + " -> ");
//            else System.out.print(head.value);
            System.out.println(head.value);
            head = head.next;
        }
        System.out.println();
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
