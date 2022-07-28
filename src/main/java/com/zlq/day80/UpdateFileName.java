package com.zlq.day80;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: UpdateFileName
 * @description:
 * @author: LiQun
 * @CreateDate:2021/12/30 9:56 上午
 */
public class UpdateFileName {
    public static List<Character> OffendingCharactersList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        addOffendingCharacters();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要去除特殊字符的文件路径:");
        String floderPath = scanner.next();
        if (updateFileName(floderPath)) System.out.println("文件修改成功！");

    }


    public static boolean updateFileName(String floderPath) {

        File file = new File(floderPath);
        File[] files = file.listFiles();  // 获取文件夹下的所有文件
        if (null == files) {
            throw new RuntimeException("该文件夹下不存在文件或非法的文件路径!");
        }
        for (int i = 0; i < files.length; i++) {
            StringBuilder newFileNameBuilder = new StringBuilder();
            String fileName = files[i].getName();    // 获取文件名
            System.out.println("修改前：" + fileName);

            for (int j = 0; j < fileName.length(); j++) {
                char c = fileName.charAt(j);
                if (isEmojiCharacter(c) && !OffendingCharactersList.contains(c)) {
                    newFileNameBuilder.append(c);
                }
            }
            System.out.println("修改后：" + newFileNameBuilder);
            if (files[i].renameTo(new File(floderPath + newFileNameBuilder)) == false) {
                throw new RuntimeException("文件修改失败!");
            }
        }
        return true;
    }

    public static void addOffendingCharacters() {
        OffendingCharactersList.add('\'');
        OffendingCharactersList.add('/');
        OffendingCharactersList.add(':');
        OffendingCharactersList.add('：');
        OffendingCharactersList.add('*');
        OffendingCharactersList.add('?');
        OffendingCharactersList.add('<');
        OffendingCharactersList.add('>');
        OffendingCharactersList.add('|');
    }


    /**
     * 判断某个字符是不是表情
     *
     * @param codePoint
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

}
