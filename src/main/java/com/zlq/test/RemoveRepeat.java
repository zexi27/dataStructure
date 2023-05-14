package com.zlq.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.test
 * @ClassName: RemoveRepeat
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/7 18:22
 */
public class RemoveRepeat {
    public static void main(String[] args) {
//        int range = 500;
//        System.out.println(getCountContainsTwo(range));
//        System.out.println(isContainsTwo(2));
//        for (int i = 0; i < range; i++) {
//            if (isContainsTwo(i)){
//                System.out.print(i + "\t");
//            }
//        }
//        int range = 1000000000;
//        System.out.println(getCountContainsTwo(range));
        Map<String,String> map = new HashMap<>();
        map.put(null,null);
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(map.get(next));
        }
    }

    // 2 12 20 22 32 42 ~ 92 ,102 112 120
    public static int[] removeRepeat(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    public static int getCountContainsTwo(int range) {
        return (int) LongStream.rangeClosed(1, range)
                .parallel()
                .filter(RemoveRepeat::isContainsTwo)
                .count();
    }



    public static boolean isContainsTwo(long num) {
        while (num > 0) {
            if (num % 10 == 2) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
