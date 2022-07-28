package com.zlq.day140;

import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day140
 * @ClassName: Day136_ArrayRankTransform
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/28 10:42
 */
/*
给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。

序号代表了一个元素有多大。序号编号的规则如下：

序号从 1 开始编号。
一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
每个数字的序号都应该尽可能地小。
示例 1：

输入：arr = [40,10,20,30]
输出：[4,1,2,3]
解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
示例 2：

输入：arr = [100,100,100]
输出：[1,1,1]
解释：所有元素有相同的序号。
示例 3：

输入：arr = [37,12,28,9,100,56,80,5,12]
输出：[5,3,4,2,8,6,7,1,3]
 */
public class Day136_ArrayRankTransform {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 2, 8, 6, 7, 1, 3};
        System.out.println(Arrays.toString(arrayRankTransform1(arr)));

    }

    public static int[] arrayRankTransform(int[] arr) {
        int length = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(arr[i]);
        }
        List<Integer> sortedDistinctList = list.stream().sorted().distinct().collect(Collectors.toList());
        int[] resArr = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < sortedDistinctList.size(); j++) {
                if (arr[i] == sortedDistinctList.get(j)) {
                    resArr[i] = j + 1;
                    break;
                }
            }
        }
        return resArr;
    }

    public static int[] arrayRankTransform1(int[] arr) {
        int length = arr.length;
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(clone[i])) map.put(clone[i], index++);
        }
        int[] resArr = new int[length];
        for (int i = 0; i < length; i++) {
            resArr[i] = map.get(arr[i]);
        }
        return resArr;
    }

}
