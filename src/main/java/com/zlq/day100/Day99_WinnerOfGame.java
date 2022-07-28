package com.zlq.day100;


import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day100
 * @ClassName: Day99_WinnerOfGame
 * @description:
 * @author: LiQun
 * @CreateDate:2022/3/22 10:25 上午
 */
/*
总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第 i 个颜色片段的颜色。

Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。

如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。
如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。
Alice 和 Bob 不能 从字符串两端删除颜色片段。
如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。
假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。

示例 1：

输入：colors = "AAABABB"
输出：true
解释：
AAABABB -> AABABB
Alice 先操作。
她删除从左数第二个 'A' ，这也是唯一一个相邻颜色片段都是 'A' 的 'A' 。

现在轮到 Bob 操作。
Bob 无法执行任何操作，因为没有相邻位置都是 'B' 的颜色片段 'B' 。
因此，Alice 获胜，返回 true 。
示例 2：

输入：colors = "AA"
输出：false
解释：
Alice 先操作。
只有 2 个 'A' 且它们都在字符串的两端，所以她无法执行任何操作。
因此，Bob 获胜，返回 false 。
示例 3：

输入：colors = "ABBBBBBBAAA"
输出：false
解释：
ABBBBBBBAAA -> ABBBBBBBAA
Alice 先操作。
她唯一的选择是删除从右数起第二个 'A' 。

ABBBBBBBAA -> ABBBBBBAA
接下来轮到 Bob 操作。
他有许多选择，他可以选择任何一个 'B' 删除。

然后轮到 Alice 操作，她无法删除任何片段。
所以 Bob 获胜，返回 false 。
 */
public class Day99_WinnerOfGame {
    public static void main(String[] args) {
        String colors = "AABBBBABABABAABBABBABBBBBBAABBABBABBABBBBBABAABBAABAAA";
        System.out.println(winnerOfGame2(colors));
        Day99_WinnerOfGame winnerOfGame = new Day99_WinnerOfGame();

    }

    public static boolean winnerOfGame(String colors) {
        Integer aIndex = null;
        Integer bIndex = null;
        int length = colors.length();
        for (int i = 1; i < length - 1; i++) {
            char c = colors.charAt(i);
            if (c == 'A' && c == colors.charAt(i - 1) && c == colors.charAt(i + 1)) {
                aIndex = i;
                break;
            }
        }
        for (int i = 1; i < length - 1; i++) {
            char c = colors.charAt(i);
            if (c == 'B' && c == colors.charAt(i - 1) && c == colors.charAt(i + 1)) {
                bIndex = i;
                break;
            }
        }
        if (aIndex != null && bIndex != null) {
            if (aIndex < bIndex) return true;
            else return false;
        }
        return aIndex != null ? true : false;
    }

    public static boolean winnerOfGame2(String colors) {
        LinkedList<Character> list = new LinkedList<>();
        int length = colors.length();
        for (int i = 0; i < length; i++) {
            list.add(colors.charAt(i));
        }
        while (removeNodeA(list)) {
            if (!removeNodeB(list)){
                return true;
            }
        }
        return false;
    }

    public static boolean removeNodeA(LinkedList list) {
        for (int i = 1; i < list.size() - 1; i++) {
            Character c = (Character) list.get(i);
            if (c == 'A' && c == list.get(i + 1) && list.get(i) == list.get(i - 1)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean removeNodeB(LinkedList list) {
        for (int i = 1; i < list.size() - 1; i++) {
            Character c = (Character) list.get(i);
            if (c == 'B' && c == list.get(i + 1) && list.get(i) == list.get(i - 1)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }
}
