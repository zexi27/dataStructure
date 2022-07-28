package com.zlq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq
 * @ClassName: TestArrayListAndLinkedList
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/12 10:09 上午
 */
public class TestArrayListAndLinkedList {
    public static void main(String[] args) {
        TestArrayListAndLinkedList test = new TestArrayListAndLinkedList();
        test.addArrayList();
        test.addLinkedList();
        test.selectArrayList();
        test.selectLinkedList();
    }

    public static List<String> arrayList = new ArrayList<>();
    public static List<String> linkedList = new LinkedList<>();

    public static int length = 100000;


    public void addArrayList(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            arrayList.add(0,"element");
        }
        long end = System.currentTimeMillis();
        System.out.println("arrayList的添加时间为" + (end - start));
    }

    public void addLinkedList(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            linkedList.add(0,"element");
        }
        long end = System.currentTimeMillis();
        System.out.println("linkedList的添加时间为" + (end - start));
    }
    public void selectArrayList() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            arrayList.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("arrayList的查询时间为" + (end - start));
    }

    public void selectLinkedList() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            linkedList.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("linkedList的查询时间为" + (end - start));
    }
}
