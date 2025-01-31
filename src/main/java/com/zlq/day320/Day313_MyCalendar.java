package com.zlq.day320;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/1/2 21:36
 */
/*
729. My Calendar I
中等
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.


Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.


Constraints:

0 <= start < end <= 109
At most 1000 calls will be made to book.
 */
public class Day313_MyCalendar {

	public static void main(String[] args) {
		Day313_MyCalendar myCalendar = new Day313_MyCalendar();
//		[97,100],[33,51],[89,100],[83,100],[75,92],[76,95],[19,30],[53,63],[8,23],[18,37],[87,100],[83,100],[54,67],[35,48],[58,75],[70,89],[13,32],[44,63],[51,62],[2,15]
		System.out.println(myCalendar.book(97, 100));
		System.out.println(myCalendar.book(33, 51));
		System.out.println(myCalendar.book(89, 100));
		System.out.println(myCalendar.book(83, 100));
		System.out.println(myCalendar.book(75, 92));
		System.out.println(myCalendar.book(76, 95));
		System.out.println(myCalendar.book(19, 30));
		System.out.println(myCalendar.book(53, 63));
		System.out.println(myCalendar.book(8, 23));
		System.out.println(myCalendar.book(18, 37));
		System.out.println(myCalendar.book(87, 100));
		System.out.println(myCalendar.book(83, 100));
		System.out.println(myCalendar.book(54, 67));
		System.out.println(myCalendar.book(35, 48));
		System.out.println(myCalendar.book(70, 89));
		System.out.println(myCalendar.book(13, 32));
		System.out.println(myCalendar.book(44, 63));
		System.out.println(myCalendar.book(51, 62));
		System.out.println(myCalendar.book(2, 15));
	}

	private static TreeMap<Integer, Integer> treeMap;


	public Day313_MyCalendar() {
		treeMap = new TreeMap<>(Comparator.comparingInt(o -> o));
	}

	public boolean book(int startTime, int endTime) {
		if (treeMap.isEmpty()){
			treeMap.put(startTime, endTime);
			return true;
		}
		Integer left = treeMap.floorKey(startTime);
		Integer right = treeMap.ceilingKey(endTime);
		if ((left != null && treeMap.get(left) <= startTime) ||
				(right != null && treeMap.get(right) <= endTime)) {
			return false;
		}
		return true;

	}
}
