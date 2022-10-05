package com.zlq.dynamic_plan;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.dynamic_plan
 * @ClassName: GenerateParentThesis
 * @description:
 * @author: LiQun
 * @CreateDate:2022/9/28 10:48
 */
public class GenerateParentThesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        if (n == 0) return resList;
        dfs("", n, n, resList);
        return resList;
    }

    /**
     * 功能描述: <br>
     * 〈dfs深度优先遍历〉
     *
     * @param curStr
     * @param left
     * @param right
     * @param list
     * @Author: Larry
     * @Date: 2022/9/28 15:30
     * @return: void
     */
    public static void dfs(String curStr, int left, int right, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(curStr);
            return;
        }
        if (left > right) return;
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, list);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, list);
        }
    }
}
