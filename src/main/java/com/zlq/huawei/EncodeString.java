package com.zlq.huawei;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.huawei
 * @ClassName: EncodeString
 * @description:
 * @author: LiQun
 * @CreateDate:2021/10/13 10:00 上午
 */
/*
有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。
下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。
如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。
现在，修改过的那个单词属于字母表的下面，如下所示：

A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

T R A I L B Z E S C D F G H J K M N O P Q U V W X Y

上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。
因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。

请实现下述接口，通过指定的密匙和明文得到密文。


本题有多组输入数据。

输入描述：
先输入key和要加密的字符串

输出描述：
返回加密后的字符串

示例1
输入：
nihao
ni
复制
输出：
le
 */
public class EncodeString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 设置正常的字母list
            List<Character> litterList = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                litterList.add((char) ('A' + i));
            }
            String str = scanner.nextLine().toUpperCase();
            // 设置编码后的list
            List<Character> codeList = new ArrayList<>();
            Set<Character> strSet = new HashSet<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                strSet.add(c);
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!codeList.contains(c)) {
                    codeList.add(c);
                }
            }
            int index = 0;
            while (codeList.size() < 26) {
                char c = (char) ('A' + index);
                if (!strSet.contains(c)) {
                    codeList.add(c);
                }
                index++;
            }

            String secretKey = scanner.nextLine();
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < secretKey.length(); i++) {
                char c = secretKey.charAt(i);
                if (c >= 'A' && c <= 'Z') result.append(codeList.get(c - 'A'));
                if (c == ' ') result.append(' ');
                if (c >= 'a' && c <= 'z') result.append((char) (codeList.get(c - 'a') + 32));

            }
        /*
        TRAILBLAZERS
        Attack AT DAWN
         */
            System.out.println(result);

        }
    }
}
