package com.zlq.day20;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day20
 * @ClassName: ListNode
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/5 9:40 上午
 */
public class ListNode {
    Integer value;
    com.zlq.day20.ListNode next;

    public ListNode(Integer value) {
        this.value = value;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public com.zlq.day20.ListNode getNext() {
        return next;
    }

    public void setNext(com.zlq.day20.ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
