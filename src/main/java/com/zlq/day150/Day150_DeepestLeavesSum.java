package com.zlq.day150;

import com.zlq.common.TreeNode;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day150
 * @ClassName: Day150
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/17 12:36
 */
/*
给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。

示例 1：


输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
示例 2：

输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：19
 */
public class Day150_DeepestLeavesSum {
    public static Object o1 = new Object();
    public static Object o2 = new Object();

    public static void main(String[] args) {
//        TreeNode root = buildTree();
//        Day150_DeepestLeavesSum deepestLeavesSum = new Day150_DeepestLeavesSum();
////        System.out.println(deepestLeavesSum.deepestLeavesSum(root));
//        System.out.println(isSubsequence1("aaaaaa", "bbaaaa"));
//        System.out.println(isHappy(2));
        new Thread(()->{
            synchronized (o1){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o2){

                }
            }
        },"thread1").start();


        new Thread(()->{
            synchronized (o2){
                synchronized (o1){

                }
            }
        },"thread2").start();

    }

    Integer sum = 0;
    int maxLevel = -1;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level > maxLevel) {
            maxLevel = level;
            sum = Integer.valueOf((String) node.val);
        } else if (level == maxLevel) {
            sum += Integer.valueOf((String) node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }


    public static TreeNode buildTree() {
        TreeNode nodeA = new TreeNode("9");
        TreeNode nodeB = new TreeNode("3");
        TreeNode nodeC = new TreeNode("2");
        TreeNode nodeD = new TreeNode("7");
        TreeNode nodeE = new TreeNode("4");
        TreeNode nodeF = new TreeNode("17");
        TreeNode nodeG = new TreeNode("9");
        TreeNode node1 = new TreeNode("8");
        TreeNode node2 = new TreeNode("12");

        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeC.right = nodeG;
        nodeD.left = node1;
        nodeD.right = node2;
        return nodeA;
    }


    /*
    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
    （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
    进阶：
    如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
    在这种情况下，你会怎样改变代码？
    示例 1：

    输入：s = "abc", t = "ahbgdc"
    输出：true
    示例 2：

    输入：s = "axc", t = "ahbgdc"
    输出：false
     */

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        List<Character> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (list.get(index) == c) {
                index++;
            }
            if (index == list.size()) return true;
        }
        return false;
    }

    public static boolean isSubsequence1(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int l = 0, r = 0;
        while (l < sLength && r < tLength) {
            if (t.charAt(r) == s.charAt(l)) {
                l++;
            }
            r++;
        }
        return l == sLength;
    }


    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    /*
    编写一个算法来判断一个数 n 是不是快乐数。

    「快乐数」定义为：

    对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
    如果这个过程 结果为1，那么这个数就是快乐数。
    如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

    示例 1：

    输入：n = 19
    输出：true
    解释：
    12 + 92 = 82 (2是平方)
    82 + 22 = 68 (2是平方)
    62 + 82 = 100 (2是平方)
    12 + 02 + 02 = 1 (2是平方)
    示例 2：

    输入：n = 2
    输出：false
     */
    public static boolean isHappy(int n) {
        int res = 0;
        Set<Integer> resSet = new HashSet<>();
        while (res != 1) {
            String stringN = String.valueOf(n);
            res = 0;
            for (int i = 0; i < stringN.length(); i++) {
                res += Math.pow((stringN.charAt(i) - '0'), 2);
            }
            n = res;
            if (!resSet.contains(res)) resSet.add(res);
            else return false;
        }
        return true;
    }

    /*
    给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。

    已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。

    请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。

    示例 1：

    输入：startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
    输出：1
    解释：一共有 3 名学生。
    第一名学生在时间 1 开始写作业，并于时间 3 完成作业，在时间 4 没有处于做作业的状态。
    第二名学生在时间 2 开始写作业，并于时间 2 完成作业，在时间 4 没有处于做作业的状态。
    第三名学生在时间 3 开始写作业，预计于时间 7 完成作业，这是是唯一一名在时间 4 时正在做作业的学生。
    示例 2：

    输入：startTime = [4], endTime = [4], queryTime = 4
    输出：1
    解释：在查询时间只有一名学生在做作业。
    示例 3：

    输入：startTime = [4], endTime = [4], queryTime = 5
    输出：0
    示例 4：

    输入：startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
    输出：0
    示例 5：

    输入：startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
    输出：5
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) if (queryTime >= startTime[i] && queryTime <= endTime[i]) res++;
        return res;
    }


    /*
    给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
    请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
    如果searchWord 是某一个单词的前缀，则返回句子sentence 中该单词所对应的下标（下标从 1 开始）。
    如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
    如果 searchWord 不是任何单词的前缀，则返回 -1 。
    字符串 s 的 前缀 是 s 的任何前导连续子字符串。

    示例 1：

    输入：sentence = "i love eating burger", searchWord = "burg"
    输出：4
    解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
    示例 2：

    输入：sentence = "this problem is an easy problem", searchWord = "pro"
    输出：2
    解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
    示例 3：

    输入：sentence = "i am tired", searchWord = "you"
    输出：-1
    解释："you" 不是句子中任何单词的前缀。
     */
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] strArr = sentence.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(searchWord) || strArr[i].startsWith(searchWord)) return i + 1;
        }
        return -1;
    }

}
