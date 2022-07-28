package com.zlq.day30;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day30
 * @ClassName: Day26_YangHuiTriangle
 * @description:
 * @author: LiQun
 * @CreateDate:2021/7/26 1:59 下午
 */
/*
给定一个非负整数numRows，生成「杨辉三角」的前numRows行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。

示例 1:

输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例2:

输入: numRows = 1
输出: [[1]]
 */
public class Day26_YangHuiTriangle {
    public static void main(String[] args) {
        System.out.println(generate(6));

    }


    public static List<List<Integer>> generate(int numRows) {
        List<Integer> lastRes = null;  // 定义上一个结果
        List<List<Integer>> result = new ArrayList<>(); // 定义的结果集
        for (int i = 1; i <= numRows; i++) { // 逐行遍历
            List<Integer> curRes = new ArrayList<>(i); // 定义当前结果，长度和行数相同
            curRes.add(1); // 第一个数肯定是1
            // 后面当前结果集的当前结果就是前一个结果对应的当前坐标和下一个坐标之和（TAT...看不懂就算了)
            for (int j = 0; j < i - 1; j++) {
                if (lastRes != null) {
                    int lastResSecond = 0;
                    if ((j + 1) <= lastRes.size() - 1)
                        lastResSecond = lastRes.get(j + 1);
                    curRes.add(lastRes.get(j) + lastResSecond);
                }
            }
            result.add(curRes);
            lastRes = curRes;
        }
        return result;
    }
}
