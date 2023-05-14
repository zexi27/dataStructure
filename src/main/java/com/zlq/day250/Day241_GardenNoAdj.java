package com.zlq.day250;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq
 * @ClassName: Day241_GardenNoAdj
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/15 11:13
 */
/*
1042. 不邻接植花
中等
有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。

另外，所有花园 最多 有 3 条路径可以进入或离开.

你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。

以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。

示例 1：

输入：n = 3, paths = [[1,2],[2,3],[3,1]]
输出：[1,2,3]
解释：
花园 1 和 2 花的种类不同。
花园 2 和 3 花的种类不同。
花园 3 和 1 花的种类不同。
因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
示例 2：

输入：n = 4, paths = [[1,2],[3,4]]
输出：[1,2,1,2]
示例 3：

输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
输出：[1,2,3,4]


提示：

1 <= n <= 104
0 <= paths.length <= 2 * 104
paths[i].length == 2
1 <= xi, yi <= n
xi != yi
每个花园 最多 有 3 条路径可以进入或离开
 */
public class Day241_GardenNoAdj {
    public static void main(String[] args) {
        int n = 8;
        int[][] paths = {{7, 4}, {3, 7}, {1, 5}, {5, 4}, {7, 1}, {3, 1}, {4, 3}, {6, 5}};
//        int n = 1;
//        int[][] paths = {};
        System.out.println(Arrays.toString(gardenNoAdj(n, paths)));
    }

    public static int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        // 生成map，key为花园标记，value为与它相斥的花园list数组
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < paths.length; i++) {
            map.putIfAbsent(paths[i][0], new ArrayList<>());
            map.putIfAbsent(paths[i][1], new ArrayList<>());
            map.get(paths[i][0]).add(paths[i][1]);
            map.get(paths[i][1]).add(paths[i][0]);
        }
        if (map.isEmpty()) {
            Arrays.fill(res, 1);
            return res;
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            List<Integer> list = map.get(key);
            int type = 0;
            type = chooseType(list, res);
            res[key - 1] = type;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) res[i] = 1;
        }
        return res;
    }

    private static int chooseType(List<Integer> list, int[] res) {
        for (int i = 1; i <= 4; i++) {
            boolean flag = true;
            for (int j = 0; j < list.size(); j++) {
                if (res[list.get(j) - 1] == i) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return 0;
    }


    public static int[] gardenNoAdj2(int n, int[][] paths) {
        int[] res = new int[n];
        // 生成map，key为花园标记，value为与它相斥的花园list数组
        Map<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < paths.length; i++) {
            map.putIfAbsent(paths[i][0], new HashSet<>());
            map.putIfAbsent(paths[i][1], new HashSet<>());
            map.get(paths[i][0]).add(paths[i][1]);
            map.get(paths[i][1]).add(paths[i][0]);
        }
        for (int i = 0; i < n; i++) {
            map.put(n,new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            map.get(paths[i][0]).add(paths[i][1]);
            map.get(paths[i][1]).add(paths[i][0]);
        }
        for (int i = 0; i < n; i++) {
            int[] typeArr = new int[5];
            Set<Integer> set = map.get(i + 1);
            if (set == null){
                res[i] = 1;
                continue;
            }
            for (Integer j : set) {
                if (res[j - 1] != 0) typeArr[res[j - 1]] = 1;
            }
            for (int j = 1; j < typeArr.length; j++) {
                if (typeArr[j] == 0){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}



