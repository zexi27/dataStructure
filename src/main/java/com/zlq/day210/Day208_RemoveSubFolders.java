package com.zlq.day210;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day208_RemoveSubFolders
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/8 10:30
 */
/*
1233. 删除子文件夹
你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。

如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。

文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。

例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。


示例 1：

输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
输出：["/a","/c/d","/c/f"]
解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
示例 2：

输入：folder = ["/a","/a/b/c","/a/b/d"]
输出：["/a"]
解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
示例 3：

输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
输出: ["/a/b/c","/a/b/ca","/a/b/d"]


提示：

1 <= folder.length <= 4 * 104
2 <= folder[i].length <= 100
folder[i] 只包含小写字母和 '/'
folder[i] 总是以字符 '/' 起始
每个文件夹名都是 唯一 的
 */
public class Day208_RemoveSubFolders {
    public static void main(String[] args) {
        String[] folder = {"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(removeSubfolders2(folder));
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            int pre = res.get(res.size() - 1).length();
            if (!(pre < folder[i].length() && res.get(res.size() - 1).equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
                res.add(folder[i]);
            }
        }
        return res;
    }

    static Set<String> set = new HashSet<>();
    public static List<String> removeSubfolders2(String[] folder) {
        for (String s : folder) set.add(s);
        List<String> res = new ArrayList<>();
        for (String path : folder) {
            //判断每个路径的父目录是否存在,如果不存在则添加
            if (!containsParent(path)) res.add(path);
        }
        return res;
    }

    private static boolean containsParent(String path) {
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/'){
                // 将字符进行截取
                if (set.contains(path.substring(0,i))){
                    return true;
                }
            }
        }
        return false;
    }
}
