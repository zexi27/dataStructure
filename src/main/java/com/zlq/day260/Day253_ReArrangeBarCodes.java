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
//        int[] barcodes = {51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 51, 40, 83, 51, 83, 51, 83, 51, 83, 51, 83, 51, 83, 51, 83, 83, 51, 83, 83, 83, 51, 83, 83, 83, 51, 83};
        int[] barcodes = {1,1,2};
        System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        int length = barcodes.length;
        if (length == 0 || length == 1) return barcodes;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int barcode = barcodes[i];
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer value = map.get(key);
            priorityQueue.add(new int[]{key, value});
        }
        int[] resArr = new int[length];
        int index = 0;
        while (index < length) {
            int[] maxBarcode = priorityQueue.poll();
            int[] second = priorityQueue.poll();
            if (second == null) {
                for (int i = 0; i < maxBarcode[1]; i++) {
                    resArr[index++] = maxBarcode[0];
                }
                break;
            }
            resArr[index++] = maxBarcode[0];
            resArr[index++] = second[0];
            if (maxBarcode[1] - 1> 0) priorityQueue.offer(new int[]{maxBarcode[0], maxBarcode[1] - 1});
            if (second[1] - 1 > 0) priorityQueue.offer(new int[]{second[0], second[1] - 1});
        }
        return resArr;
    }
}
