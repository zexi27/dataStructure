package com.zlq.day140;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day140
 * @ClassName: Day133_MyCalendar
 * @description:
 * @author: LiQun
 * @CreateDate:2022/7/19 10:05
 */
/*
实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。

MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
注意，这里的时间是半开区间，即 [start, end), 实数x 的范围为， start <= x < end。

当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。

每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。

请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

示例：

MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(50, 60); // returns true
MyCalendar.book(10, 40); // returns true
MyCalendar.book(5, 15); // returns false
MyCalendar.book(5, 10); // returns true
MyCalendar.book(25, 55); // returns true
解释：
前两个日程安排可以添加至日历中。
第三个日程安排会导致双重预订，但可以添加至日历中。
第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订。
 */
public class Day133_MyCalendar {
    public static void main(String[] args) {
        Day133_MyCalendar myCalendar = new Day133_MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(50, 60)); // returns true
        System.out.println(myCalendar.book(10, 40)); // returns true
        System.out.println(myCalendar.book(5, 15)); // returns false
        System.out.println(myCalendar.book(5, 10)); // returns true
        System.out.println(myCalendar.book(25, 55)); // returns true

    }

    private static List<int[]> list1  = new ArrayList<>();
    private static List<int[]> list2 = new ArrayList<>();

    public boolean book(int start, int end) {
        if (list1.isEmpty()){ // 如果list1为空直接放
            list1.add(new int[]{start,end});
        }else {  // 如果list1不空，依次和里面的每一个元素作对比
            for (int i = 0; i < list1.size(); i++) {
                int[] ele = list1.get(i);
                if (start > ele[0] && end < ele[1]){ // 全范围比list1中的某一个范围小，直接放在list2中
                    list2.add(new int[]{start,end});
                }else if (start < ele[0] && end > ele[1]) { // 全范围比list1中的某一个范围大，小的放在list2中
                    list2.add(new int[]{ele[0],ele[1]});
                    ele[0] = start;
                    ele[1] = end;
                }
                // 半范围冲突
                else if (start >= ele[0] && start <= ele[1] && end > ele[1]){
                    list2.add(new int[]{start,ele[1]});
                    ele[1] = end;
                }else if (start < ele[0] && end >= ele[0] && end <= ele[1]){
                    list2.add(new int[]{ele[0],end});
                    ele[0] = start;
                }
                else {
                    list1.add(new int[]{start,end});
                }
                break;
            }
        }
        // 判断list2中是否有冲突
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list2.size(); i++) {
            int[] ele = list2.get(i);
            for (int j = ele[0]; j <= ele[1]; j++){
                if (!set.contains(j)) set.add(j);
                else return false;
            }
        }
        return true;
    }
}
