package com.zlq.huawei;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: InvertScale
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/12 7:05 下午
 */
/*
写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。

输入描述：
输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。

输出描述：
输出该数值的十进制字符串。不同组的测试用例用\n隔开。

示例1
输入：
0xA
0xAA
复制
输出：
10
170
 */
public class InvertScale {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println(Integer.valueOf(str.substring(2), 16).toString());
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String str = sc.nextLine();
//            // 转二进制
//            String binarySystem = convertBinarySystem(str);
//            // 转换十进制
//            int res = convertDecimalism(binarySystem);
//            System.out.println(res);
//        }
//    }



    private static String convertBinarySystem(String str) {
        str = str.replace("x", "").toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 将每一个字符转换成二进制
            String string = invertCharToBinary(c);
            builder.append(string);
        }
        return builder.toString();
    }

    /**
     * 将每一个字符转换成二进制
     * @param c
     * @return
     */
    private static String invertCharToBinary(char c) {
        Map<Character,String> map = new HashMap();
        map.put('0',"0000");
        map.put('1',"0001");
        map.put('2',"0010");
        map.put('3',"0011");
        map.put('4',"0100");
        map.put('5',"0101");
        map.put('6',"0110");
        map.put('7',"0111");
        map.put('8',"1000");
        map.put('9',"1001");
        map.put('a',"1010");
        map.put('b',"1011");
        map.put('c',"1100");
        map.put('d',"1101");
        map.put('e',"1110");
        map.put('f',"1111");
        return map.get(c);
    }

    /**
     * 转十进制
     * @param binarySystem
     */
    private static int convertDecimalism(String binarySystem) {
        int res = 0;
        int length = binarySystem.length();
        for (int i = length - 1; i >= 0; i--) {
            int num = binarySystem.charAt(i) - '0';
            if (num == 1) res += Math.pow(2,length - 1 - i);
        }
        return res;
    }
}
