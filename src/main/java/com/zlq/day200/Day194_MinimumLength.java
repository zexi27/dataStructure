package com.zlq.day200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day200
 * @ClassName: Day194_MinimumLength
 * @description:
 * @author: LiQun
 * @CreateDate:2022/12/28 13:37
 */
/*
给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：

选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
前缀和后缀在字符串中任意位置都不能有交集。
前缀和后缀包含的所有字符都要相同。
同时删除前缀和后缀。
请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。



示例 1：

输入：s = "ca"
输出：2
解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
示例 2：

输入：s = "cabaabac"
输出：0
解释：最优操作序列为：
- 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
- 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。
示例 3：

输入：s = "aabccabba"
输出：3
解释：最优操作序列为：
- 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
- 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。


提示：

1 <= s.length <= 105
s 只包含字符 'a'，'b' 和 'c' 。
 */
public class Day194_MinimumLength {
    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbbbbbbb";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            while (l <= r && s.charAt(l) == cl) {
                l++;
            }
            while (r >= l && s.charAt(r) == cr) {
                r--;
            }
        }
        return r - l + 1;
    }


    /*
    给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
    示例 1：

    输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
    输出：[3,2]
    解释：至少在两个数组中出现的所有值为：
    - 3 ，在全部三个数组中都出现过。
    - 2 ，在数组 nums1 和 nums2 中出现过。
    示例 2：

    输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
    输出：[2,3,1]
    解释：至少在两个数组中出现的所有值为：
    - 2 ，在数组 nums2 和 nums3 中出现过。
    - 3 ，在数组 nums1 和 nums2 中出现过。
    - 1 ，在数组 nums1 和 nums3 中出现过。
    示例 3：

    输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
    输出：[]
    解释：不存在至少在两个数组中出现的值。
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> resList= new ArrayList<>();
        int[] index = new int[101]; // index的坐标值为1~100
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set.contains(nums1[i])) {
                set.add(nums1[i]);
                index[nums1[i]]++;
            }
        }
         set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!set.contains(nums2[i])) {
                set.add(nums2[i]);
                index[nums2[i]]++;
            }
        }
        set = new HashSet<>();
        for (int i = 0; i < nums3.length; i++) {
            if (!set.contains(nums3[i])) {
                set.add(nums3[i]);
                index[nums3[i]]++;
            }
        }
        for (int i = 0; i < index.length; i++) {
            if (index[i] >= 2) resList.add(i);
        }
        return resList;
    }

}
