package com.zlq.day260;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ProjectName:dataStructure
 * @Package:com.zlq.day260
 * @ClassName: ReArrangeBarCodes
 * @description:
 * @author: LiQun
 * @CreateDate:2023/5/14 14:54
 */
/*
1054. Distant Barcodes
中等

In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.



Example 1:

Input: barcodes = [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
Example 2:

Input: barcodes = [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,1,2,1,2]


Constraints:

1 <= barcodes.length <= 10000
1 <= barcodes[i] <= 10000
 */
public class Day253_ReArrangeBarCodes {
    public static void main(String[] args) {
        int[] barcodes = {1,1,1,1,2,2,3,3};
        System.out.println(rearrangeBarcodes(barcodes));
    }
    public static int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i],map.getOrDefault(map.get(barcodes[i]),0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer value = map.get(key);
            priorityQueue.add(new int[]{key,value});
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(Arrays.toString(priorityQueue.poll()));
        }
        return null;
    }
}
