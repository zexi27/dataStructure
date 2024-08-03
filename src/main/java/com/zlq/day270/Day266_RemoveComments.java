package com.zlq.day270;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/8/3 10:33
 */
/*
//722. 删除注释
 */
public class Day266_RemoveComments {

    public static void main(String[] args) {
//        String[] source ={"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
//        String[] source = {"a/*comment", "line", "more_comment*/b"};
        String[] source = {"a//*b//*c", "blank", "d/*/e*//f"};
        System.out.println(removeComments(source));
    }

    public static List<String> removeComments(String[] source) {
        List<String> resList = new ArrayList<>();
        int length = source.length;
        int index = 0;
        while (index < length) {
            String line = source[index];
            if (line.contains("//")) {
                line = line.startsWith("//") ? "" : line.substring(0, line.indexOf("//"));
            }
            if (line.contains("/*")) {
                if (line.contains("/*/")) line = line.replace("/*/", "/*");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(line.substring(0, line.indexOf("/*")));
                // 寻找结束符,结束符可能在本行，也可能在其他行，也不能没有结束符
                if (line.contains("*/")) { // 结束符在本行
                    stringBuilder.append(line.substring(line.indexOf("*/") + 2));
                } else {
                    while (index < length) {  // 向下找直到找到结束符位置
                        if (source[index].contains("*/")) {
                            stringBuilder.append(source[index].substring(source[index].indexOf("*/") + 2));
                            break;
                        }
                        index++;
                    }
                }
                String resStr = stringBuilder.toString();
                if (resStr.length() != 0 || resStr.replaceAll(" ", "").length() != 0) resList.add(resStr);
            }
            if (!line.contains("/")){
                resList.add(line);
            }
            index++;
        }
        return resList;
        /*/ declare members;/**/
    }
}
