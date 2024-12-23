package com.zlq.day200;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day200
 * @ClassName: Day195_ExamRoom
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/30 13:44
 */
/*
在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。

当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)

返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。



示例：

输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
输出：[null,0,9,4,2,null,5]
解释：
ExamRoom(10) -> null
seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
seat() -> 9，学生最后坐在 9 号座位上。
seat() -> 4，学生最后坐在 4 号座位上。
seat() -> 2，学生最后坐在 2 号座位上。
leave(4) -> null
seat() -> 5，学生最后坐在 5 号座位上。

 */
public class Day195_ExamRoom {
    public static void main(String[] args) {
        Day195_ExamRoom examRoom = new Day195_ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);

        examRoom.leave(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(7);
        System.out.println(examRoom.seat());
        examRoom.leave(3);
        System.out.println(examRoom.seat());
        examRoom.leave(3);
        System.out.println(examRoom.seat());

    }

    TreeSet<Integer> set = null;
    Integer seats = null;

    public Day195_ExamRoom(int n) {
        set = new TreeSet<>();
        seats = n;
    }

    // {1,0,0,0,1,0,0,0,0,1}
    public int seat() {
        // 最先来的考生必然坐在第一个位置
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        return 0;
    }


    public void leave(int p) {
        set.remove(p);
    }



    /*
    一个房间里有 n 个座位和 n 名学生，房间用一个数轴表示。
    给你一个长度为 n 的数组 seats ，其中 seats[i] 是第 i 个座位的位置。同时给你一个长度为 n 的数组 students ，其中 students[j] 是第 j 位学生的位置。
    你可以执行以下操作任意次：

    增加或者减少第 i 位学生的位置，每次变化量为 1 （也就是将第 i 位学生从位置 x 移动到 x + 1 或者 x - 1）
    请你返回使所有学生都有座位坐的 最少移动次数 ，并确保没有两位学生的座位相同。

    请注意，初始时有可能有多个座位或者多位学生在 同一 位置。

    示例 1：

    输入：seats = [3,1,5], students = [2,7,4]
    输出：4
    解释：学生移动方式如下：
    - 第一位学生从位置 2 移动到位置 1 ，移动 1 次。
    - 第二位学生从位置 7 移动到位置 5 ，移动 2 次。
    - 第三位学生从位置 4 移动到位置 3 ，移动 1 次。
    总共 1 + 2 + 1 = 4 次移动。
    示例 2：

    输入：seats = [4,1,5,9], students = [1,3,2,6]
    输出：7
    解释：学生移动方式如下：
    - 第一位学生不移动。
    - 第二位学生从位置 3 移动到位置 4 ，移动 1 次。
    - 第三位学生从位置 2 移动到位置 5 ，移动 3 次。
    - 第四位学生从位置 6 移动到位置 9 ，移动 3 次。
    总共 0 + 1 + 3 + 3 = 7 次移动。
    示例 3：

    输入：seats = [2,2,6,6], students = [1,3,2,6]
    输出：4
    解释：学生移动方式如下：
    - 第一位学生从位置 1 移动到位置 2 ，移动 1 次。
    - 第二位学生从位置 3 移动到位置 6 ，移动 3 次。
    - 第三位学生不移动。
    - 第四位学生不移动。
    总共 1 + 3 + 0 + 0 = 4 次移动。
     */
    /*
    输入：seats = [4,1,5,9], students = [1,3,2,6]
       seats = {1,4,5,9}
    students = {1,2,3,6}

    输入：seats = [2,2,6,6], students = [1,3,2,6]
     seats =    {2,2,6,6}
     students = {1,2,3,6}
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(students[i] - seats[i]);
        }
        return res;
    }


    /*
    给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。

    注意：

    如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
    s 包含至少一个出现两次的字母。


    示例 1：

    输入：s = "abccbaacz"
    输出："c"
    解释：
    字母 'a' 在下标 0 、5 和 6 处出现。
    字母 'b' 在下标 1 和 4 处出现。
    字母 'c' 在下标 2 、3 和 7 处出现。
    字母 'z' 在下标 8 处出现。
    字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
    示例 2：

    输入：s = "abcdd"
    输出："d"
    解释：
    只有字母 'd' 出现两次，所以返回 'd' 。
     */
    public char repeatedCharacter(String s) {
        int[] indexArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            indexArr[index]++;
            if (indexArr[index] == 2){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
