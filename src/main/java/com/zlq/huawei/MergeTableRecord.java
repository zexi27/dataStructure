package com.zlq.huawei;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: MergeTableRecord
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/12 3:06 下午
 */
public class MergeTableRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < count; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
            }
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                System.out.println(next.getKey() + " " + next.getValue());
            }
        }
    }
}
