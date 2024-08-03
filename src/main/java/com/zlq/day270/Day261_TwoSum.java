package com.zlq.day270;

import java.util.*;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/7/8 12:28
 */
/*
167. Two Sum II - Input Array Is Sorted
中等
1.1K
相关企业
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solutio
 */
public class Day261_TwoSum {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 3, 4};
        int target = 0;
        System.out.println(Arrays.toString(twoSum2(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j >= 0; j--) {
                if (numbers[i] + numbers[j] < target) {
                    break;
                }
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int key = numbers[i];
            indexMap.putIfAbsent(key, new ArrayList<>());
            List<Integer> list = indexMap.get(key);
            list.add(i + 1);
            indexMap.put(key, list);
        }
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            if (indexMap.containsKey(target - numbers[i])) {
                List<Integer> list = indexMap.get(arr[i]);
                for (Integer j : list) {
                    if (j != i + 1) return new int[]{i + 1, j};

                }
            }
        }
        return null;
    }

    public static int[] twoSum3(int[] numbers, int target) {
        int l = 0, r = 1;
        while (true) {
            if (numbers[l] + numbers[r] < target) {
                l++;
                r++;
            } else if (numbers[l] + numbers[r] > target) {
                l--;
            }else {
                return new int[]{l + 1,r + 1};
            }
        }
    }
}
