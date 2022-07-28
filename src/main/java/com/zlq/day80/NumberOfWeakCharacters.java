package com.zlq.day80;

import javax.xml.transform.Source;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day80
 * @ClassName: NumberOfWeakCharacters
 * @description:
 * @author: LiQun
 * @CreateDate:2022/1/28 9:35 上午
 */
/*
你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。
给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。

如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。

返回 弱角色 的数量。

示例 1：

输入：properties = [[5,5],[6,3],[3,6]]
输出：0
解释：不存在攻击和防御都严格高于其他角色的角色。
示例 2：

输入：properties = [[2,2],[3,3]]
输出：1
解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
示例 3：

输入：properties = [[1,5],[10,4],[4,3]]
输出：1
解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 */
public class NumberOfWeakCharacters {
    public static void main(String[] args) {
        int[][] properties = {{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}};
        System.out.println(numberOfWeakCharacters(properties));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        int ans = 0;
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });
        int maxDefense = -1; //保存当前位置之前的最大防御力
        for(int[] p : properties){
            if(maxDefense > p[1]){ //若当前防御力小，则为弱角色
                ans++;
            }else{
                maxDefense = p[1];
            }
        }
        return ans;
    }



   public static void print(int[][] properties){
       for (int i = 0; i < properties.length; i++) {
           System.out.print(Arrays.toString(properties[i]));
       }
   }

}
