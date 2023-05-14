package com.zlq.day250;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day250
 * @ClassName: Day245_MinHeightShelves
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/23 14:22
 */
/*
1105. 填充书架
中等
给定一个数组 books ，其中 books[i] = [thicknessi, heighti] 表示第 i 本书的厚度和高度。你也会得到一个整数 shelfWidth 。

按顺序 将这些书摆放到总宽度为 shelfWidth 的书架上。

先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelfWidth ），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。

需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。

例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。

以这种方式布置书架，返回书架整体可能的最小高度。



示例 1：



输入：books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
输出：6
解释：
3 层书架的高度和为 1 + 3 + 2 = 6 。
第 2 本书不必放在第一层书架上。
示例 2:

输入: books = [[1,3],[2,4],[3,2]], shelfWidth = 6
输出: 4


提示：

1 <= books.length <= 1000
1 <= thicknessi <= shelfWidth <= 1000
1 <= heighti <= 1000
 */
public class Day245_MinHeightShelves {


    public static int minHeightShelves(int[][] books, int shelfWidth) {
        return dfs(books, shelfWidth, 0);
    }

    private static int dfs(int[][] books, int shelfWidth, int index) {
        if (index == books.length) return 0; // base case
        int width = 0;
        int height = 0;
        int minHeight = Integer.MAX_VALUE;
        for (int i = index; i < books.length; i++) {
            width += books[i][0];
            height = Math.max(height,books[i][1]);
            if (width > shelfWidth) break;
            minHeight = Math.min(minHeight,height + dfs(books,shelfWidth,i + 1));
        }
        return minHeight;
    }


    public static int minHeightShelves2(int[][] books, int shelfWidth) {
        int length = books.length;
        int[] memo = new int[length];
        return dfs2(books, shelfWidth, 0, memo);
    }


    private static int dfs2(int[][] books, int shelfWidth, int index, int[] memo) {
        if (index == books.length) return 0;  // base case 已经索引完所有的书籍，不需要再新增高度了，返回0
        if (memo[index] > 0) return memo[index];
        int width = 0;
        int height = 0;
        int minHeight = Integer.MAX_VALUE;
        for (int i = index; i < books.length; i++) {
            width += books[i][0];
            height = Math.max(height, books[i][1]);
            if (width > shelfWidth) break;  // 如果当前书宽度超过了书架宽度，停止放置
            minHeight = Math.min(minHeight, height + dfs2(books, shelfWidth, i + 1, memo));
        }
        memo[index] = minHeight;
        return minHeight;
    }



}
