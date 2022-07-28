package com.zlq.huawei;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: SimplePassword
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/12 9:29 上午
 */
/*
SRCGosgv1987
tsdh67481987
小写：97~122
 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0
 */
public class SimplePassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 2);
        map.put("def", 3);
        map.put("ghi", 4);
        map.put("jkl", 5);
        map.put("mno", 6);
        map.put("pqrs", 7);
        map.put("tuv", 8);
        map.put("wxyz", 9);
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c >= 'A' && c <= 'Y') {
                System.out.print((char) (c + 33));
            }
            if (c == 'Z'){
                System.out.print('a');
            }
            if (c >='a' && c <= 'z'){
                Set<String> keySet = map.keySet();
                String key = keySet.stream().filter(o -> o.contains(c.toString())).findAny().get();
                System.out.print(map.get(key));
            }
            if (c >= 48 && c <= 57){
                System.out.print(c);
            }
        }
    }
}
