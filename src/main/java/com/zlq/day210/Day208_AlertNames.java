package com.zlq.day210;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day208_AlertNames
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/7 10:11
 */
/*
力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。

给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。

使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。

请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。

请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。

示例 1：

输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
输出：["daniel"]
解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
示例 2：

输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
输出：["bob"]
解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
示例 3：

输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
输出：[]
示例 4：

输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"],
     keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
输出：["clare","leslie"]
 */
public class Day208_AlertNames {
    public static void main(String[] args) {
        String[] keyName = {"a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"};
        String[] keyTime = {"04:48", "23:53", "06:36", "07:45", "12:16", "00:52", "10:59", "17:16", "00:36", "01:26", "22:42"};
        System.out.println(alertNames(keyName, keyTime));
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        int length = keyName.length;
        for (int i = 0; i < length; i++) {
            String key = keyName[i];
            String timeStr = keyTime[i];
            // 将时间转换为数字
//            Integer time = Integer.valueOf(timeStr.replace(":", ""));
            Integer time = covertTime(timeStr);
            map.putIfAbsent(key, map.getOrDefault(key, new ArrayList<>()));
            map.get(key).add(time);
        }
        Iterator<String> iterator = map.keySet().iterator();
        List<String> alertList = new ArrayList<>();
        System.out.println(map);
        while (iterator.hasNext()) {
            String key = iterator.next();
            List<Integer> timeList = map.get(key);
            timeList = timeList.stream().sorted().collect(Collectors.toList());
            map.put(key, timeList);
            if (timeList.size() < 3) continue;
            if (needAlert(timeList)) {
                alertList.add(key);
            }
        }
        alertList.sort((o1, o2) -> o1.compareTo(o2));
        return alertList;
    }

    private static Integer covertTime(String timeStr) {
       return  ((timeStr.charAt(0) - '0') * 10 + (timeStr.charAt(1) - '0')) * 60
               +(timeStr.charAt(3) - '0') * 10 + timeStr.charAt(4) - '0';
    }

    private static boolean needAlert(List<Integer> timeList) {
        // 滑动窗口
        int l = 0, r = 2;
        while (r < timeList.size()) {
            if (Math.abs(timeList.get(r) - timeList.get(l)) <= 60) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
