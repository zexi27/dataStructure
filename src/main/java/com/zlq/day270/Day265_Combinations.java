package com.zlq.day270;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/8/1 10:25
 */
/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.


Constraints:

1 <= n <= 20
1 <= k <= n
 */
public class Day265_Combinations {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        combine(resList, new ArrayList<>(), 1, n, k);
        return resList;
    }

    public static void combine(List<List<Integer>> resList, ArrayList res, int start, int n, int k) {
        if (k == 0) {
            resList.add(new ArrayList<>(res));
            return;
        }

        for (int i = start; i <= n ; i++) {
            res.add(i);
            combine(resList, res, i + 1, n, k - 1);
            res.remove(res.size() - 1);
        }
    }
}
