package com.zlq.day180;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day175_CountStudent
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/19 14:09
 */
/*
学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：

如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
否则，这名学生会放弃这个三明治并回到队列的尾部。
这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。

给你两个整数数组students 和sandwiches，其中sandwiches[i]是栈里面第i​​​​​​个三明治的类型（i = 0是栈的顶部），students[j]是初始队列里第j​​​​​​名学生对三明治的喜好（j = 0是队列的最开始位置）。请你返回无法吃午餐的学生数量。



示例 1：

输入：students = [1,1,0,0], sandwiches = [0,1,0,1]
输出：0
解释：
- 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,0,0,1]。
- 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,0,1,1]。
- 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [0,1,1]，三明治栈为 sandwiches = [1,0,1]。
- 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,1,0]。
- 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1,0]，三明治栈为 sandwiches = [0,1]。
- 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,1]。
- 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1]，三明治栈为 sandwiches = [1]。
- 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = []，三明治栈为 sandwiches = []。
所以所有学生都有三明治吃。
示例 2：

输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
输出：3
 */
public class Day175_CountStudent {
    /*
    students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
    [1,1,0,0,1] [0,0,0,1,1]
    [1,0,0,1,1] [0,0,0,1,1]
    [0,0,1,1,1] [0,0,0,1,1]
    [0,1,1,1] [0,0,1,1]
    [1,1,1] [0,1,1]
    -----------------------
    students = [0,1,0,0,1,0], sandwiches = [1,0,0,1,1,1]
    [0,0,1,0,0] [0,0,1,1,1]
    [1,0,0] [1,1,1]
    [0,0] [1,1]
    end
     */

    public static int countStudents(int[] students, int[] sandwiches) {
        int studentCount = students.length;
        int[] indexArr = new int[2];
        for (int i = 0; i < studentCount; i++) {
            indexArr[students[i]]++;
        }
        for (int i = 0; i < studentCount; i++) {
            if (indexArr[sandwiches[i]] > 0) indexArr[sandwiches[i]]--;
            else return studentCount - i;
        }
        return 0;
    }

    /*
    我们构建了一个包含 n 行(索引从 1 开始)的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。

    例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
    给定行数n和序数 k，返回第 n 行中第 k个字符。（k从索引 1 开始）


    示例 1:

    输入: n = 1, k = 1
    输出: 0
    解释: 第一行：0
    示例 2:

    输入: n = 2, k = 1
    输出: 0
    解释:
    第一行: 0
    第二行: 01
    示例 3:

    输入: n = 2, k = 2
    输出: 1
    解释:
    第一行: 0
    第二行: 01
     */
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcwex", "def"));

    }

    /*
    0
    01
    0110
    01101001
    0110100110010110
    01101001100101101001011001101001
     */

    public static int kthGrammar1(int n, int k) {
        int count = 0;
        while (k > 2) {
            int a = 0;
            int res = 2;
            while (res < k) {
                res = res * 2;
                a += 1;
            }
            k = k - (int) Math.pow(2, a);
            count += 1;
        }
        if (k == 1) {
            return count % 2 == 0 ? 0 : 1;
        } else {
            return count % 2 == 0 ? 1 : 0;
        }
    }

    public static String generate(int n) {
        StringBuilder res = new StringBuilder("0");
        for (int i = 0; i < n; i++) {
            int length = res.length();
            for (int j = 0; j < length; j++) {
                if (res.charAt(j) == '0') res.append("1");
                else res.append("0");
            }
        }
        return res.toString();
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int minLength = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minLength; i++) {
            res.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (word1.length() > word2.length()) res.append(word1.substring(minLength));
        else res.append(word2.substring(minLength));
        return res.toString();
    }
}
