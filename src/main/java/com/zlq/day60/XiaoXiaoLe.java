package com.zlq.day60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day60
 * @ClassName: XiaoXiaoLe
 * @description:
 * @author: LiQun
 * @CreateDate:2021/9/5 10:45 上午
 */
/*
给定一个数组 nums，其中有 n 个非负整数。你的目的是进行两次操作，使得数组的元素之和最小。
每次操作形如：任选一个整数 x ，将数组中所有大于等于 x 的数减去 x 。
输入：
[2,1,3]
返回值：
0
说明：
初始数组为 [2, 1, 3]。
先选择 x = 2，则所有大于等于 2 的元素减去 2 ，变成 [0, 1, 1]。
再选择 x = 1，则所有大于等于 1 的元素减去 1 ，变成 [0, 0, 0]。
所以数组元素之和的最小值为 0。
 */
public class XiaoXiaoLe {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Object> remove = new ArrayList<>();
        remove.add(4);
        remove.add(5);

        list.removeAll(remove);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }


}
