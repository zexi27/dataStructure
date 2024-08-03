package com.zlq.day260;

import java.math.BigDecimal;
import java.util.*;

/**
 * @description:
 * @author: ZhangLiqun
 * @CreateDate:2023/5/27 12:23
 */
/*
You are given a large sample of integers in the range [0, 255].
Since the sample is so large, it is represented by an array count where count[k] is the number of times that k appears in the sample.

Calculate the following statistics:

minimum:
The minimum element in the sample.
maximum:
The maximum element in the sample.
mean:
The average of the sample, calculated as the total sum of all elements divided by the total number of elements.
median:
If the sample has an odd number of elements, then the median is the middle element once the sample is sorted.
If the sample has an even number of elements, then the median is the average of the two middle elements once the sample is sorted.
mode: The number that appears the most in the sample. It is guaranteed to be unique.
Return the statistics of the sample as an array of floating-point numbers [minimum, maximum, mean, median, mode]. Answers within 10-5 of the actual answer will be accepted.



Example 1:

Input: count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
Output: [1.00000,3.00000,2.37500,2.50000,3.00000]
Explanation: The sample represented by count is [1,2,2,2,3,3,3,3].
The minimum and maximum are 1 and 3 respectively.
The mean is (1+2+2+2+3+3+3+3) / 8 = 19 / 8 = 2.375.
Since the size of the sample is even, the median is the average of the two middle elements 2 and 3, which is 2.5.
The mode is 3 as it appears the most in the sample.
Example 2:

Input: count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
Output: [1.00000,4.00000,2.18182,2.00000,1.00000]
Explanation: The sample represented by count is [1,1,1,1,2,2,2,3,3,4,4].
The minimum and maximum are 1 and 4 respectively.
The mean is (1+1+1+1+2+2+2+3+3+4+4) / 11 = 24 / 11 = 2.18181818... (for display purposes, the output shows the rounded number 2.18182).
Since the size of the sample is odd, the median is the middle element 2.
The mode is 1 as it appears the most in the sample.

 */
public class Day254_SampleStatics {
    public static void main(String[] args) {
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3510, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6718, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27870, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26256, 0, 0, 0, 0, 9586565, 0, 0, 0, 0, 0, 0, 0, 2333, 0, 0, 0, 0};
        System.out.println(Arrays.toString(sampleStats(count)));

    }

    public static double[] sampleStats(int[] count) {
        Map<Long, Long> map = new TreeMap<>(); // k - num  v - count of the num
        for (int i = 0; i < count.length; i++) {
            int num = count[i];
            if (num != 0) {
                map.put((long) i, (long) num);
            }
        }
        Double minimun = Double.MAX_VALUE;
        Double maxinum = Double.MIN_VALUE;
        Long sum = 0L;
        Long numCount = 0L;
        Double mode = 0D;
        Long maxValue = Long.MIN_VALUE;
        for (Long key : map.keySet()) {
            maxinum = Math.max(key, maxinum);
            minimun = Math.min(key, minimun);
            Long value = map.get(key);
            if (value > maxValue) {
                maxValue = value;
                mode = Double.valueOf(key);
            }
            numCount += value;
            sum += key * value;
        }
        double mean = sum.doubleValue() / numCount;
        // 求中位数
        double median = getMedian(map, numCount);
        return new double[]{minimun, maxinum, mean, median, mode};
    }

    private static double getMedian(Map<Long, Long> map, double numCount) {
        int midIndex;
        if (numCount % 2 != 0) {
            midIndex = (int) (numCount / 2 + 1);
            for (Long key : map.keySet()) {
                Long value = map.get(key);
                if (midIndex > value) midIndex -= value;
                else return key;
            }
        } else {
            midIndex = (int) (numCount / 2);
            Iterator<Long> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Long key = iterator.next();
                Long value = map.get(key);
                if (midIndex > value) midIndex -= value;
                else if (midIndex == value) {
                    return ((double) key + (double) iterator.next()) / 2;
                } else if (midIndex > 0) {
                    return key;
                }
            }
        }
        return 0;
    }


}
