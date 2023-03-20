package com.zlq.day220;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day220
 * @ClassName: Day212_FindSolution
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/18 09:13
 */
/*
给你一个函数  f(x, y) 和一个目标结果 z，函数公式未知，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。满足条件的结果数对可以按任意顺序返回。

尽管函数的具体式子未知，但它是单调递增函数，也就是说：

f(x, y) < f(x + 1, y)
f(x, y) < f(x, y + 1)
函数接口定义如下：

interface CustomFunction {
public:
  // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
  int f(int x, int y);
};
你的解决方案将按如下规则进行评判：

判题程序有一个由 CustomFunction 的 9 种实现组成的列表，以及一种为特定的 z 生成所有有效数对的答案的方法。
判题程序接受两个输入：function_id（决定使用哪种实现测试你的代码）以及目标结果 z 。
判题程序将会调用你实现的 findSolution 并将你的结果与答案进行比较。
如果你的结果与答案相符，那么解决方案将被视作正确答案，即 Accepted 。
 */
public class Day212_FindSolution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> findSolution2(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            int l = 1, r = 1000;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (customfunction.f(i, mid) == z) {
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(mid);
                    res.add(list);
                }
                if (customfunction.f(i, mid) > z) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return res;
    }

}

class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) {
        return 0;
    }
}
