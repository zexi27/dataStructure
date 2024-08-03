package com.zlq.day270;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2023/8/15 22:34
 */
/*
833. Find And Replace in String
You are given a 0-indexed string s that you must perform k replacement operations on.
The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.

To complete the ith replacement operation:

Check if the substring sources[i] occurs at index indices[i] in the original string s.
If it does not occur, do nothing.
Otherwise if it does occur, replace that substring with targets[i].
For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".

All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.

For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
Return the resulting string after performing all replacement operations on s.

A substring is a contiguous sequence of characters in a string.



Example 1:


Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
Output: "eeebffff"
Explanation:
"a" occurs at index 0 in s, so we replace it with "eee".
"cd" occurs at index 2 in s, so we replace it with "ffff".
Example 2:


Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation:
"ab" occurs at index 0 in s, so we replace it with "eee".
"ec" does not occur at index 2 in s, so we do nothing.


Constraints:

1 <= s.length <= 1000
k == indices.length == sources.length == targets.length
1 <= k <= 100
0 <= indexes[i] < s.length
1 <= sources[i].length, targets[i].length <= 50
s consists of only lowercase English letters.
sources[i] and targets[i] consist of only lowercase English letters.
 */
public class Day269_FindReplaceString {

    /*
    "vmokgggqzp"
indices =
[3,5,1]
sources =
["kg","ggq","mo"]
targets =
["s","so","bfr"]
     */
    public static void main(String[] args) {
        String s = "abcde";
        int[] indices = {2,2};
        String[] sources = {"cdef","bc"};
        String[] targets = {"f","fe"};
        System.out.println(findReplaceString(s, indices, sources, targets));
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // 将indices排序
        Map<Integer, List<String>> map = new TreeMap<>();
        int length = sources.length;
        for (int i = 0; i < length; i++) {
            int index = indices[i];
            if (map.get(index) == null){
                map.put(index,new ArrayList<>());
            }
            List<String> list = map.get(index);
            list.add(sources[i]);
            list.add(targets[i]);
            map.put(index,list);
        }

        String res = s;
        int disLocation = 0; //  错位
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            int index = entry.getKey();
            String source = entry.getValue().get(0);
            String target = entry.getValue().get(1);
            if (source.equals(s.substring(index, index + source.length()))) { // 判断满足可替换条件
                // 替换后，统计错位
                res = replace(res, source, target, index + disLocation);
                disLocation += (target.length() - source.length());

            }
        }
        return res;
    }

    public static String replace(String s, String source, String target, int index) {
        StringBuilder builder = new StringBuilder();
        builder.append(s.substring(0, index)).append(target).append(s.substring(index + source.length()));
        return builder.toString();
    }
}
