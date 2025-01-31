package com.zlq.day320;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/12/23 19:13
 */

/*
在考场里，有 n 个座位排成一行，编号为 0 到 n - 1。

当学生进入考场后，他必须坐在离最近的人最远的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)

设计一个模拟所述考场的类。

实现 ExamRoom 类：

ExamRoom(int n) 用座位的数量 n 初始化考场对象。
int seat() 返回下一个学生将会入座的座位编号。
void leave(int p) 指定坐在座位 p 的学生将离开教室。保证座位 p 上会有一位学生。


示例 1：

输入：
["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"]
[[10], [], [], [], [], [4], []]
输出：
[null, 0, 9, 4, 2, null, 5]
解释：
ExamRoom examRoom = new ExamRoom(10);
examRoom.seat(); // 返回 0，房间里没有人，学生坐在 0 号座位。
examRoom.seat(); // 返回 9，学生最后坐在 9 号座位。
examRoom.seat(); // 返回 4，学生最后坐在 4 号座位。
examRoom.seat(); // 返回 2，学生最后坐在 2 号座位。
examRoom.leave(4);
examRoom.seat(); // 返回 5，学生最后坐在 5 号座位。

[0,1,2,3,4,5,6,7,8,9]
提示：

1 <= n <= 109
保证有学生正坐在座位 p 上。
seat 和 leave 最多被调用 104 次。
 */
public class Day311_ExamRoom {

	private static Day311_ExamRoom instance;
	public static void main(String[] args) {
//		Day311_ExamRoom examRoom = new Day311_ExamRoom(10);
//		System.out.println(examRoom.seat());
//		System.out.println(examRoom.seat());
//		System.out.println(examRoom.seat());
//		examRoom.leave(0);
//		examRoom.leave(4);
//		System.out.println(examRoom.seat());
		String[] methods = {"ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave","leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat","leave","leave","seat","seat","leave"};
		Integer[] params = {10,null,null,null,0,4,null,null,null,null,null,null,null,null,null,0,4,null,null,7,null,3,null,3,null,9,null,0,8,null,null,0,8,null,null,2};
		System.out.println(invokeBatch(methods, params));
	}

	public static List<Integer> invokeBatch(String[] methods,Integer[] params){
		List<Integer> resList = new ArrayList<>();
		for (int i = 0; i < methods.length; i++) {
			Integer res = invokeParam(methods[i], params[i]);
			resList.add(res);
		}
		return resList;
	}

	public static Integer invokeParam(String method,Integer param){
		if ("ExamRoom".equals(method)) {
			instance = new Day311_ExamRoom(param);
		}
		if ("seat".equals(method)) {
			return instance.seat();
		}
		if ("leave".equals(method)) {
			instance.leave(param);
			return null;
		}
		return null;
	}



	private static List<Integer> studentSeats;
	public static int roomCnt;

	public Day311_ExamRoom(int n) {
		studentSeats = new ArrayList<>();
		roomCnt = n;
	}

	public int seat() {
		if (studentSeats.size() == 0) {
			int seatIdx = 0;
			studentSeats.add(seatIdx);
			return seatIdx;
		}

		int resIdx = roomCnt - 1;
		int curIdx;
		int lastIdx = roomCnt - 1;
		int curGap = roomCnt - 1 - studentSeats.get(studentSeats.size() - 1);
		int maxGap = curGap;
		for (int i = studentSeats.size() - 2; i >= 0; i--) {
			curIdx = studentSeats.get(i);
			lastIdx = studentSeats.get(i + 1);
			curGap = lastIdx - curIdx;
			if (curGap / 2 >= maxGap / 2) {
				maxGap = curGap;
				if (!studentSeats.contains(Integer.valueOf(curIdx + curGap / 2))){
					resIdx = curIdx + curGap / 2;
				}
			}
		}
		curIdx = 0;
		lastIdx = studentSeats.get(0);
		curGap = lastIdx - curIdx;
		if (curGap >= maxGap / 2) {
			if (!studentSeats.contains(Integer.valueOf(0))){
				resIdx = 0;
			}
		}
		studentSeats.add(resIdx);
		studentSeats.sort(Comparator.naturalOrder());
		return resIdx;
	}

	public void leave(int p) {
		studentSeats.remove(Integer.valueOf(p));
	}

}
